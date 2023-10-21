package com.example.thuoctay.nhieunhieu.giohang;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.thuoctay.nguoidung.NguoiDungEntity;
import com.example.thuoctay.nguoidung.NguoiDungRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CTGioHangService {

    private final CTGioHangRepo ctGioHangRepo;
    private final CTGioHangMapper ctGioHangMapper;
    private final CTGioHangMapper2 ctGioHangMapper2;

    private final NguoiDungRepo nguoiDungRepo;

    public Set<CTGioHangDto> getAll() {
        return ctGioHangRepo.findAll().stream().map(ctGioHangMapper::toDto).collect(Collectors.toSet());
    }

    public Set<CTGioHangDto2> getByGioHang(Integer idGioHang){
        NguoiDungEntity gioHangEntity = nguoiDungRepo.findById(idGioHang).orElse(null);
        if(gioHangEntity == null)
            return null;
        Set<CTGioHangEntity> ctGioHangEntities = ctGioHangRepo.findByNguoiDung(gioHangEntity);
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
