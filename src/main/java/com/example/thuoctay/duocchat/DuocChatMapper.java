package com.example.thuoctay.duocchat;

import org.springframework.stereotype.Component;

@Component
public class DuocChatMapper {
         public DuocChatDto toDto(DuocChatEntity entity){
        return DuocChatDto.builder()
        .id(entity.getId())
        .tenDuocChat(entity.getTenDuocChat())
        .build();
    }

    public DuocChatEntity toEntity(DuocChatDto dto){
        return DuocChatEntity.builder()
        .id(dto.getId())
        .tenDuocChat(dto.getTenDuocChat())
        .build();
    }
}
