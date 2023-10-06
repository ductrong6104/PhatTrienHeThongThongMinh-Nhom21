package com.example.thuoctay.nhieunhieu.giohang;

import org.springframework.stereotype.Component;

import com.example.thuoctay.thuoc.ThuocMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CTGioHangMapper2 {

    private final ThuocMapper thuocMapper;


    public CTGioHangDto2 toDto(CTGioHangEntity entity) {
        try {
            return CTGioHangDto2.builder()
                    .id(entity.getId())
                    .thuocDto(thuocMapper.toDto(entity.getThuoc()))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

}
