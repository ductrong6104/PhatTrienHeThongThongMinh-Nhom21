package com.example.thuoctay.nhieunhieu.giohang;

import org.springframework.stereotype.Component;

import com.example.thuoctay.nguoidung.NguoiDungRepo;
import com.example.thuoctay.thuoc.ThuocRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTGioHangMapper {
    
    private final ThuocRepo thuocRepo;
    private final  NguoiDungRepo gioHangRepo;

     public CTGioHangDto toDto(CTGioHangEntity entity){
        try {
            return CTGioHangDto.builder()
            .id(entity.getId())
            .idNguoiDung(entity.getNguoiDung().getId())
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
            .nguoiDung(gioHangRepo.findById(dto.getIdNguoiDung()).orElse(null))
            .thuoc(thuocRepo.findById(dto.getIdThuoc()).orElse(null))
            .build();
        } catch (Exception e) {
            return null;
        }
    }

}
