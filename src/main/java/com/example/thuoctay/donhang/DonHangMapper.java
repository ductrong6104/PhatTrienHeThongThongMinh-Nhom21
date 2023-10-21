package com.example.thuoctay.donhang;


import org.springframework.stereotype.Component;

@Component
public class DonHangMapper {
         public DonHangDto toDto(DonHangEntity entity){
        return DonHangDto.builder()
        .id(entity.getId())
        .soDienThoai(entity.getSoDienThoai())
        .tenNguoiNhan(entity.getTenNguoiNhan())
        .diaChi(entity.getDiaChi())
        .trangThai(entity.getTrangThai())
        .thoiGian(entity.getThoiGian())
        .idNguoiDung(entity.getIdNguoiDung())
        .build();
    }

    public DonHangEntity toEntity(DonHangDto dto){
        return DonHangEntity.builder()
        .id(dto.getId())
        .soDienThoai(dto.getSoDienThoai())
        .tenNguoiNhan(dto.getTenNguoiNhan())
        .diaChi(dto.getDiaChi())
        .trangThai(dto.getTrangThai())
        .thoiGian(dto.getThoiGian())
        .idNguoiDung(dto.getIdNguoiDung())
        .build();
    }
}
