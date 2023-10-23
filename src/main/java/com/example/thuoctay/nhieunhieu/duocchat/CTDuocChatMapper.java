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
