package com.example.thuoctay.taikhoanhethong;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaiKhoanNhanVienMapper {
    

     public TaiKhoanNhanVienDto toDto(TaiKhoanNhanVienEntity entity){
        try {
            return TaiKhoanNhanVienDto.builder()
            .id(entity.getId())
            .tenDangNhap(entity.getTenDangNhap())
            .tenNguoiDung(entity.getTenNguoiDung())
            .role(entity.getRole())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

    public TaiKhoanNhanVienEntity toEntity(TaiKhoanNhanVienDto dto){
        try {
            return TaiKhoanNhanVienEntity.builder()
            .id(dto.getId())
            .tenDangNhap(dto.getTenDangNhap())
            .tenNguoiDung(dto.getTenNguoiDung())
            .role(dto.getRole())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

}
