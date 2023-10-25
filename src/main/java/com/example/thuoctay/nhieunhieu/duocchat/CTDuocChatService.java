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

    public Set<CTDuocChatDto> capNhatCTDCByIdThuoc(Integer idThuoc, Set<CTDuocChatDto> dtos) {
        Set<CTDuocChatEntity> entitys = ctDuocChatRepo.findByIdThuoc(idThuoc);
        ctDuocChatRepo.deleteAll(entitys);
        Set<CTDuocChatEntity> entitys2 = dtos.stream().map(ctDuocChatMapper::toEntity).collect(Collectors.toSet());
        ctDuocChatRepo.saveAll(entitys2);
        return dtos;
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
