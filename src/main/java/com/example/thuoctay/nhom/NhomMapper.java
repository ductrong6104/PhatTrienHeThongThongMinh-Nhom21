package com.example.thuoctay.nhom;

import org.springframework.stereotype.Component;

@Component
public class NhomMapper {
    public NhomDto toDto(NhomEntity entity) {
        return NhomDto.builder()
                .id(entity.getId())
                .tenNhom(entity.getTenNhom())
                .build();
    }

    public NhomEntity toEntity(NhomDto dto) {
        return NhomEntity.builder()
                .id(dto.getId())
                .tenNhom(dto.getTenNhom())
                .build();
    }
}
