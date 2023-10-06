package com.example.thuoctay.nhieunhieu.duocchat;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.thuoctay.thuoc.ThuocEntity;
import com.example.thuoctay.thuoc.ThuocRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CTDuocChatService {

    private final CTDuocChatRepo ctDuocChatRepo;
    private final CTDuocChatMapper ctDuocChatMapper;
    private final CTDuocChatMapper2 ctDuocChatMapper2;

    private final ThuocRepo thuocRepo;

    public Set<CTDuocChatDto> getAll() {
        return ctDuocChatRepo.findAll().stream().map(ctDuocChatMapper::toDto).collect(Collectors.toSet());
    }

    public Set<CTDuocChatDto2> getByThuoc(Integer idThuoc){
        ThuocEntity thuocEntity = thuocRepo.findById(idThuoc).orElse(null);
        if(thuocEntity == null)
            return null;
        Set<CTDuocChatEntity> ctDuocChatEntities = ctDuocChatRepo.findByThuoc(thuocEntity);
        Set<CTDuocChatDto2> ctDuocChatDto2s =  ctDuocChatEntities.stream().map(ctDuocChatMapper2::toDto).collect(Collectors.toSet());
        return ctDuocChatDto2s;
    }

    public CTDuocChatDto create(CTDuocChatDto dto) {
        CTDuocChatEntity entity = ctDuocChatMapper.toEntity(dto);
        ctDuocChatRepo.save(entity);
        return dto;
    }

    public Set<CTDuocChatDto> createAll(Set<CTDuocChatDto> dtos) {
        Set<CTDuocChatEntity> entitys = dtos.stream().map(ctDuocChatMapper::toEntity).collect(Collectors.toSet());
        ctDuocChatRepo.saveAll(entitys);
        dtos = entitys.stream().map(ctDuocChatMapper::toDto).collect(Collectors.toSet());
        return dtos;
    }

    public CTDuocChatDto edit(CTDuocChatDto dto) {
        CTDuocChatEntity entity = ctDuocChatRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = ctDuocChatMapper.toEntity(dto);
            ctDuocChatRepo.save(entity);
            return dto;
        }
        return null;
    }

    public CTDuocChatDto delete(Integer nhomId) {
        CTDuocChatEntity entity = ctDuocChatRepo.findById(nhomId).orElse(null);
        if (entity != null) {
            ctDuocChatRepo.delete(entity);
            return ctDuocChatMapper.toDto(entity);
        }
        return null;
    }
}
