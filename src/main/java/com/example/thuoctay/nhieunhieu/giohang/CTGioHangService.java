package com.example.thuoctay.nhieunhieu.giohang;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.thuoctay.giohang.GioHangEntity;
import com.example.thuoctay.giohang.GioHangRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CTGioHangService {

    private final CTGioHangRepo ctGioHangRepo;
    private final CTGioHangMapper ctGioHangMapper;
    private final CTGioHangMapper2 ctGioHangMapper2;

    private final GioHangRepo gioHangRepo;

    public Set<CTGioHangDto> getAll() {
        return ctGioHangRepo.findAll().stream().map(ctGioHangMapper::toDto).collect(Collectors.toSet());
    }

    public Set<CTGioHangDto2> getByThuoc(Integer idGioHang){
        GioHangEntity gioHangEntity = gioHangRepo.findById(idGioHang).orElse(null);
        if(gioHangEntity == null)
            return null;
        Set<CTGioHangEntity> ctGioHangEntities = ctGioHangRepo.findByGioHang(gioHangEntity);
        Set<CTGioHangDto2> ctGioHangDto2s =  ctGioHangEntities.stream().map(ctGioHangMapper2::toDto).collect(Collectors.toSet());
        return ctGioHangDto2s;
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

    public CTGioHangDto delete(Integer nhomId) {
        CTGioHangEntity entity = ctGioHangRepo.findById(nhomId).orElse(null);
        if (entity != null) {
            ctGioHangRepo.delete(entity);
            return ctGioHangMapper.toDto(entity);
        }
        return null;
    }
}
