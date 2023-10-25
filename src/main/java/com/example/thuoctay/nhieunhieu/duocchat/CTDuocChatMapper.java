package com.example.thuoctay.nhieunhieu.duocchat;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTDuocChatMapper {

     public CTDuocChatDto toDto(CTDuocChatEntity entity){
        try {
            return CTDuocChatDto.builder()
            .id(entity.getId())
            .idDuocChat(entity.getIdDuocChat())
            .idThuoc(entity.getIdThuoc())
            .hamLuong(entity.getHamLuong())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

    public CTDuocChatEntity toEntity(CTDuocChatDto dto){
        try {
            return CTDuocChatEntity.builder()
            .id(dto.getId())
            .idDuocChat(dto.getIdDuocChat())
            .idThuoc(dto.getIdThuoc())
            .hamLuong(dto.getHamLuong())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

}
