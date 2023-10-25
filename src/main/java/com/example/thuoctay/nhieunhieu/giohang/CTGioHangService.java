package com.example.thuoctay.nhieunhieu.giohang;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CTGioHangService {

    private final CTGioHangRepo ctGioHangRepo;
    private final CTGioHangMapper ctGioHangMapper;

    public Set<CTGioHangDto> getAll() {
        return ctGioHangRepo.findAll().stream().map(ctGioHangMapper::toDto).collect(Collectors.toSet());
    }

    public Set<CTGioHangDto> getByIdNguoiDung(Integer idNguoiDung){
        Set<CTGioHangEntity> ctGioHangEntities = ctGioHangRepo.findByIdNguoiDung(idNguoiDung);
        Set<CTGioHangDto> ctGioHangDtos =  ctGioHangEntities.stream().map(ctGioHangMapper::toDto).collect(Collectors.toSet());
        return ctGioHangDtos;
    }

    public CTGioHangDto create(CTGioHangDto dto) {
        CTGioHangEntity entity = ctGioHangMapper.toEntity(dto);
        ctGioHangRepo.save(entity);
        return dto;
    }

    public Set<CTGioHangDto> createAll(Set<CTGioHangDto> dtos) {
        Set<CTGioHangEntity> entitys = dtos.stream().map(ctGioHangMapper::toEntity).collect(Collectors.toSet());
        ctGioHangRepo.saveAll(entitys);
        dtos = entitys.stream().map(ctGioHangMapper::toDto).collect(Collectors.toSet());
        return dtos;
    }

    public CTGioHangDto edit(CTGioHangDto dto) {
        CTGioHangEntity entity = ctGioHangRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = ctGioHangMapper.toEntity(dto);
            ctGioHangRepo.save(entity);
            return dto;
        }
        return null;
    }

    public CTGioHangDto delete(Integer idCTGioHang) {
        CTGioHangEntity entity = ctGioHangRepo.findById(idCTGioHang).orElse(null);
        if (entity != null) {
            ctGioHangRepo.delete(entity);
            return ctGioHangMapper.toDto(entity);
        }
        return null;
    }
}
