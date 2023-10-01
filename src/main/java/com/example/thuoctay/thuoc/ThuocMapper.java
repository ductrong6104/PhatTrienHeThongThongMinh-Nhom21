package com.example.thuoctay.thuoc;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.thuoctay.nhieunhieu.duocchat.CTDuocChatDto;
import com.example.thuoctay.nhieunhieu.duocchat.CTDuocChatEntity;
import com.example.thuoctay.nhieunhieu.duocchat.CTDuocChatMapper;
import com.example.thuoctay.nhom.NhomEntity;
import com.example.thuoctay.nhom.NhomMapper;
import com.example.thuoctay.thuonghieu.ThuongHieuEntity;
import com.example.thuoctay.thuonghieu.ThuongHieuMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ThuocMapper {

    private final NhomMapper nhomMapper;
    private final ThuongHieuMapper thuongHieuMapper;
    private final CTDuocChatMapper ctDuocChatMapper;

    public ThuocDto toDto(ThuocEntity entity) {

        Set<CTDuocChatDto> ctDuocChatDtos = null;

        if (entity.getCtDuocChats() != null) {
            ctDuocChatDtos = entity.getCtDuocChats()
                    .stream().map(ctdc -> ctDuocChatMapper.toDto(ctdc))
                    .collect(Collectors.toSet());
        }

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
                .nhomdDto(nhomMapper.toDto(entity.getNhom()))
                .thuongHieudDto(thuongHieuMapper.toDto(entity.getThuongHieu()))
                .ctDuocChatDtos(ctDuocChatDtos)
                .build();
    }

    public ThuocEntity toEntity(ThuocDto thuocDto) {

        NhomEntity nhomEntity = nhomMapper.toEntity(thuocDto.getNhomdDto());
        ThuongHieuEntity thuongHieuEntity = thuongHieuMapper.toEntity(thuocDto.getThuongHieudDto());
        Set<CTDuocChatEntity> ctDuocChatEntities = null;
        if (thuocDto.getCtDuocChatDtos() != null) {
            ctDuocChatEntities = thuocDto.getCtDuocChatDtos().stream().map(ctDuocChatMapper::toEntity)
                    .collect(Collectors.toSet());
        }

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
                .nhom(nhomEntity)
                .thuongHieu(thuongHieuEntity)
                .ctDuocChats(ctDuocChatEntities)
                .build();
    }
}