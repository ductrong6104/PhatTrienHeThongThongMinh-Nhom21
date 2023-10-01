package com.example.thuoctay.thuoc;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.thuoctay.nhieunhieu.duocchat.CTDuocChatDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThuocService {

    private final ThuocRepo thuocRepo;
    private final ThuocMapper thuocMapper;

    public Set<ThuocDto> getAll() {
        return thuocRepo.findAll().stream().map(thuocMapper::toDto).collect(Collectors.toSet());
    }

    public Set<ThuocDto> getOnePage(int pageIndex, int number) {
        Set<ThuocDto> set = thuocRepo.findAll(PageRequest.of(pageIndex, number)).stream()
                .map(thuocMapper::toDto)
                .collect(Collectors.toSet());
        return set;
    }

    public ThuocDto create(ThuocDto dto) {
        ThuocEntity entity = thuocMapper.toEntity(dto);
        entity = thuocRepo.save(entity);
        return thuocMapper.toDto(entity);
    }

    public ThuocDto edit(ThuocDto dto) {
        ThuocEntity entity = thuocRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = thuocMapper.toEntity(dto);
            thuocRepo.save(entity);
            return dto;
        }
        return null;
    }

    public ThuocDto editHinhAnh(Integer idThuoc, String hinhAnh) {
        System.out.println("SUA HINH ANH THUOC\n");
        ThuocEntity entity = thuocRepo.findById(idThuoc).orElse(null);
        if (entity != null) {
            entity.setHinhAnh(hinhAnh);
            thuocRepo.save(entity);
            return thuocMapper.toDto(entity);
        }
        return null;
    }

    public ThuocDto delete(Integer id) {
        ThuocEntity entity = thuocRepo.findById(id).orElse(null);
        if (entity != null) {
            thuocRepo.delete(entity);
            return thuocMapper.toDto(entity);
        }
        return null;
    }

    public ThuocDto getByTen(String ten) {
        ThuocEntity entity = thuocRepo.findByTenThuoc(ten).orElse(null);
        if (entity != null) {
            return thuocMapper.toDto(entity);
        }
        return null;
    }
}
