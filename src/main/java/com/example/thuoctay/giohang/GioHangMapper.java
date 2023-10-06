package com.example.thuoctay.giohang;

import org.springframework.stereotype.Component;

@Component
public class GioHangMapper {
         public GioHangDto toDto(GioHangEntity entity){
        return GioHangDto.builder()
        .id(entity.getId())
        .soDienThoai(entity.getSoDienThoai())
        .build();
    }

    public GioHangEntity toEntity(GioHangDto dto){
        return GioHangEntity.builder()
        .id(dto.getId())
        .soDienThoai(dto.getSoDienThoai())
        .build();
    }
}
