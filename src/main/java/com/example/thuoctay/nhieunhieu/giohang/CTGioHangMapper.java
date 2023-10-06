package com.example.thuoctay.nhieunhieu.giohang;

import org.springframework.stereotype.Component;

import com.example.thuoctay.thuoc.ThuocRepo;
import com.example.thuoctay.giohang.GioHangRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTGioHangMapper {
    
    private final ThuocRepo thuocRepo;
    private final  GioHangRepo gioHangRepo;

     public CTGioHangDto toDto(CTGioHangEntity entity){
        try {
            return CTGioHangDto.builder()
            .id(entity.getId())
            .idGioHang(entity.getGioHang().getId())
            .idThuoc(entity.getThuoc().getId())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

    public CTGioHangEntity toEntity(CTGioHangDto dto){
        try {
            return CTGioHangEntity.builder()
            .id(dto.getId())
            .gioHang(gioHangRepo.findById(dto.getIdGioHang()).orElse(null))
            .thuoc(thuocRepo.findById(dto.getIdThuoc()).orElse(null))
            .build();
        } catch (Exception e) {
            return null;
        }
    }

}
