package com.example.thuoctay.nhieunhieu.duocchat;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CTDuocChatService {

    private final CTDuocChatRepo ctDuocChatRepo;
    private final CTDuocChatMapper ctDuocChatMapper;

    public Set<CTDuocChatDto> getAll() {
        return ctDuocChatRepo.findAll().stream().map(ctDuocChatMapper::toDto).collect(Collectors.toSet());
    }

    public Set<CTDuocChatDto> getByIdThuoc(Integer idThuoc){
        Set<CTDuocChatEntity> ctDuocChatEntities = ctDuocChatRepo.findByIdThuoc(idThuoc);
        Set<CTDuocChatDto> ctDuocChatDtos =  ctDuocChatEntities.stream().map(ctDuocChatMapper::toDto).collect(Collectors.toSet());
        return ctDuocChatDtos;
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

    public CTDuocChatDto delete(Integer idDuocChat) {
        CTDuocChatEntity entity = ctDuocChatRepo.findById(idDuocChat).orElse(null);
        if (entity != null) {
            ctDuocChatRepo.delete(entity);
            return ctDuocChatMapper.toDto(entity);
        }
        return null;
    }
}
