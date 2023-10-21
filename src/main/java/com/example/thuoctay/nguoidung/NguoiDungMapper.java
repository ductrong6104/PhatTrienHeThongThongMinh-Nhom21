package com.example.thuoctay.nguoidung;

import org.springframework.stereotype.Component;

@Component
public class NguoiDungMapper {
         public NguoiDungDto toDto(NguoiDungEntity entity){
        return NguoiDungDto.builder()
        .id(entity.getId())
        .soDienThoai(entity.getSoDienThoai())
        .matKhau(entity.getMatKhau())
        .tenNguoiDung(entity.getTenNguoiDung())
        .build();
    }

    public NguoiDungEntity toEntity(NguoiDungDto dto){
        return NguoiDungEntity.builder()
        .id(dto.getId())
        .soDienThoai(dto.getSoDienThoai())
        .matKhau(dto.getMatKhau())
        .tenNguoiDung(dto.getTenNguoiDung())
        .build();
    }
}
