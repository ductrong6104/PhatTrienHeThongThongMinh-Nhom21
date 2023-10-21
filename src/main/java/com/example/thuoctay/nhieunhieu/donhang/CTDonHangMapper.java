package com.example.thuoctay.nhieunhieu.donhang;


import org.springframework.stereotype.Component;
import com.example.thuoctay.thuoc.ThuocRepo;
import com.example.thuoctay.donhang.DonHangRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTDonHangMapper {
    
    private final ThuocRepo thuocRepo;
    private final DonHangRepo DonHangRepo;

     public CTDonHangDto toDto(CTDonHangEntity entity){
        try {
            return CTDonHangDto.builder()
            .id(entity.getId())
            .idDonHang(entity.getDonHang().getId())
            .idThuoc(entity.getThuoc().getId())
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
            .donHang(DonHangRepo.findById(dto.getIdDonHang()).orElse(null))
            .thuoc(thuocRepo.findById(dto.getIdThuoc()).orElse(null))
            .soLuong(dto.getSoLuong())
            .build();
        } catch (Exception e) {
            return null;
        }
    }

}
