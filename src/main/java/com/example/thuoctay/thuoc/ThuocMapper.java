package com.example.thuoctay.thuoc;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ThuocMapper {

    public ThuocDto toDto(ThuocEntity entity) {
        return ThuocDto.builder()
                .id(entity.getId())
                .tenThuoc(entity.getTenThuoc())
                .congDung(entity.getCongDung())
                .hdSuDung(entity.getHdSuDung())
                .hinhAnh(entity.getHinhAnh())
                .kinhDoanh(entity.isKinhDoanh())
                .gia(entity.getGia())
                .tong(entity.getTong())
                .daBan(entity.getDaBan())
                .idNhom(entity.getIdNhom())
                .idThuongHieu(entity.getIdThuongHieu())
                .build();
    }

    public ThuocEntity toEntity(ThuocDto thuocDto) {
        return ThuocEntity.builder()
                .id(thuocDto.getId())
                .tenThuoc(thuocDto.getTenThuoc())
                .congDung(thuocDto.getCongDung())
                .hdSuDung(thuocDto.getHdSuDung())
                .hinhAnh(thuocDto.getHinhAnh())
                .kinhDoanh(thuocDto.isKinhDoanh())
                .gia(thuocDto.getGia())
                .tong(thuocDto.getTong())
                .daBan(thuocDto.getDaBan())
                .idNhom(thuocDto.getIdNhom())
                .idThuongHieu(thuocDto.getIdThuongHieu())
                .build();
    }
}
