package com.example.thuoctay.thuonghieu;

import org.springframework.stereotype.Component;

@Component
public class ThuongHieuMapper {
         public ThuongHieuDto toDto(ThuongHieuEntity entity){
        return ThuongHieuDto.builder()
        .id(entity.getId())
        .tenThuongHieu(entity.getTenThuongHieu())
        .hinhAnh(entity.getHinhAnh())
        .build();
    }

    public ThuongHieuEntity toEntity(ThuongHieuDto dto){
        return ThuongHieuEntity.builder()
        .id(dto.getId())
        .tenThuongHieu(dto.getTenThuongHieu())
        .hinhAnh(dto.getHinhAnh())
        .build();
    }
}
