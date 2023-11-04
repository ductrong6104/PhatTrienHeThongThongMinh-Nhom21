package com.example.thuoctay.thuonghieu;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.thuoctay.thuoc.ThuocDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThuongHieuService {

    private final ThuongHieuRepo thuongHieuRepo;
    private final ThuongHieuMapper thuongHieuMapper;

    public Set<ThuongHieuDto> getAll() {
        return thuongHieuRepo.findAll().stream().map(thuongHieuMapper::toDto).collect(Collectors.toSet());
    }

    public Set<ThuongHieuDto> getOnePage(int pageIndex, int number) {
        Set<ThuongHieuDto> set = thuongHieuRepo.findAll(PageRequest.of(pageIndex, number)).stream()
                .map(thuongHieuMapper::toDto)
                .collect(Collectors.toSet());
        return set;
    }

    public ThuongHieuDto create(ThuongHieuDto dto) {
        ThuongHieuEntity entity = thuongHieuMapper.toEntity(dto);
        thuongHieuRepo.save(entity);
        return dto;
    }

    public ThuongHieuDto edit(ThuongHieuDto dto) {
        ThuongHieuEntity entity = thuongHieuRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = thuongHieuMapper.toEntity(dto);
            thuongHieuRepo.save(entity);
            return dto;
        }
        return null;
    }

    public ThuongHieuDto delete(Integer nhomId) {
        ThuongHieuEntity entity = thuongHieuRepo.findById(nhomId).orElse(null);
        if (entity != null) {
            thuongHieuRepo.delete(entity);
            return thuongHieuMapper.toDto(entity);
        }
        return null;
    }

    public ThuongHieuDto getById(Integer id) {
        ThuongHieuEntity entity = thuongHieuRepo.findById(id).orElse(null);
        if (entity != null) {
            return thuongHieuMapper.toDto(entity);
        }
        return null;
    }

    public ThuongHieuDto getByTen(String ten) {
        ThuongHieuEntity entity = thuongHieuRepo.findByTenThuongHieu(ten).orElse(null);
        if (entity != null) {
            return thuongHieuMapper.toDto(entity);
        }
        return null;
    }

    public List<ThuongHieuDto> findByTenThuongHieuContaining(String ten){
        List<ThuongHieuDto> set = thuongHieuRepo.findByTenThuongHieuContaining(ten).stream().map(thuongHieuMapper::toDto)
                .collect(Collectors.toList());
        return set;
    }
}
