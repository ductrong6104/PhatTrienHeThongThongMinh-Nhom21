package com.example.thuoctay.nhom;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NhomService {

    private final NhomRepo nhomRepo;
    private final NhomMapper nhomMapper;

    public Set<NhomDto> getAll() {
        return nhomRepo.findAll().stream().map(nhomMapper::toDto).collect(Collectors.toSet());
    }

    public Set<NhomDto> getOnePage(int pageIndex, int number) {
        Set<NhomDto> set = nhomRepo.findAll(PageRequest.of(pageIndex, number)).stream()
                .map(nhomMapper::toDto)
                .collect(Collectors.toSet());
        return set;
    }

    public NhomDto create(NhomDto dto) {
        NhomEntity entity = nhomMapper.toEntity(dto);
        nhomRepo.save(entity);
        return dto;
    }

    public NhomDto edit(NhomDto dto) {
        NhomEntity entity = nhomRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = nhomMapper.toEntity(dto);
            nhomRepo.save(entity);
            return dto;
        }
        return null;
    }

    public NhomDto delete(Integer nhomId) {
        NhomEntity entity = nhomRepo.findById(nhomId).orElse(null);
        if (entity != null) {
            nhomRepo.delete(entity);
            return nhomMapper.toDto(entity);
        }
        return null;
    }

    public NhomDto getById(Integer id) {
        NhomEntity entity = nhomRepo.findById(id).orElse(null);
        if (entity != null) {
            return nhomMapper.toDto(entity);
        }
        return null;
    }

    public NhomDto getByTen(String ten) {
        NhomEntity entity = nhomRepo.findByTenNhom(ten).orElse(null);
        if (entity != null) {
            return nhomMapper.toDto(entity);
        }
        return null;
    }
}
