package com.example.thuoctay.nhieunhieu.donhang;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTDonHangMapper {
    

     public CTDonHangDto toDto(CTDonHangEntity entity){
        try {
            return CTDonHangDto.builder()
            .id(entity.getId())
            .idDonHang(entity.getIdDonHang())
            .idThuoc(entity.getIdThuoc())
            .soLuong(entity.getSoLuong())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

    public CTDonHangEntity toEntity(CTDonHangDto dto){
        try {
            return CTDonHangEntity.builder()
            .id(dto.getId())
            .idDonHang(dto.getIdDonHang())
            .idThuoc(dto.getIdThuoc())
            .soLuong(dto.getSoLuong())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

}
