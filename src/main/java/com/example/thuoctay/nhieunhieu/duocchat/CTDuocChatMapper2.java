package com.example.thuoctay.nhieunhieu.duocchat;

import org.springframework.stereotype.Component;

import com.example.thuoctay.duocchat.DuocChatMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTDuocChatMapper2 {

    private final DuocChatMapper duocChatMapper;


    public CTDuocChatDto2 toDto(CTDuocChatEntity entity) {
        try {
            return CTDuocChatDto2.builder()
                    .id(entity.getId())
                    .duocChatDto(duocChatMapper.toDto(entity.getDuocChat()))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

}
