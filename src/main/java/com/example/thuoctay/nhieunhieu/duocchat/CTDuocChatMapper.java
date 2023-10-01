package com.example.thuoctay.nhieunhieu.duocchat;

import org.springframework.stereotype.Component;

import com.example.thuoctay.duocchat.DuocChatRepo;
import com.example.thuoctay.thuoc.ThuocRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTDuocChatMapper {
    
    private final ThuocRepo thuocRepo;
    private final DuocChatRepo duocChatRepo;

     public CTDuocChatDto toDto(CTDuocChatEntity entity){
        try {
            return CTDuocChatDto.builder()
            .id(entity.getId())
            .idDuocChat(entity.getDuocChat().getId())
            .idThuoc(entity.getThuoc().getId())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

    public CTDuocChatEntity toEntity(CTDuocChatDto dto){
        try {
            return CTDuocChatEntity.builder()
            .id(dto.getId())
            .duocChat(duocChatRepo.findById(dto.getIdDuocChat()).orElse(null))
            .thuoc(thuocRepo.findById(dto.getIdThuoc()).orElse(null))
            .build();
        } catch (Exception e) {
            return null;
        }
    }

}
