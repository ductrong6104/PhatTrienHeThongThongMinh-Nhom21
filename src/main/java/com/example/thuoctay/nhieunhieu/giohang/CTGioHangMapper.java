package com.example.thuoctay.nhieunhieu.giohang;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTGioHangMapper {
    
     public CTGioHangDto toDto(CTGioHangEntity entity){
        try {
            return CTGioHangDto.builder()
            .id(entity.getId())
            .idNguoiDung(entity.getIdNguoiDung())
            .idThuoc(entity.getIdThuoc())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

    public CTGioHangEntity toEntity(CTGioHangDto dto){
        return CTGioHangEntity.builder()
            .id(dto.getId())
            .idNguoiDung(dto.getIdNguoiDung())
            .idThuoc(dto.getIdThuoc())
            .build();
    }

}
