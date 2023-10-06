package com.example.thuoctay.giohang;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GioHangService {

    private final GioHangRepo gioHangRepo;
    private final GioHangMapper gioHangMapper;

    public Set<GioHangDto> getAll() {
        return gioHangRepo.findAll().stream().map(gioHangMapper::toDto).collect(Collectors.toSet());
    }

    public Set<GioHangDto> getOnePage(int pageIndex, int number) {
        Set<GioHangDto> set = gioHangRepo.findAll(PageRequest.of(pageIndex, number)).stream()
                .map(gioHangMapper::toDto)
                .collect(Collectors.toSet());
        return set;
    }

    public GioHangDto create(GioHangDto dto) {
        GioHangEntity entity = gioHangMapper.toEntity(dto);
        gioHangRepo.save(entity);
        return dto;
    }

    public GioHangDto edit(GioHangDto dto) {
        GioHangEntity entity = gioHangRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = gioHangMapper.toEntity(dto);
            gioHangRepo.save(entity);
            return dto;
        }
        return null;
    }

    public GioHangDto delete(Integer nhomId) {
        GioHangEntity entity = gioHangRepo.findById(nhomId).orElse(null);
        if (entity != null) {
            gioHangRepo.delete(entity);
            return gioHangMapper.toDto(entity);
        }
        return null;
    }

    public GioHangDto getBySoDienThoai(String soDienThoai) {
        GioHangEntity entity = gioHangRepo.findBySoDienThoai(soDienThoai).orElse(null);
        if (entity != null) {
            return gioHangMapper.toDto(entity);
        }
        return null;
    }

    public GioHangDto getById(Integer id) {
        GioHangEntity entity = gioHangRepo.findById(id).orElse(null);
        if (entity != null) {
            return gioHangMapper.toDto(entity);
        }
        return null;
    }
}
