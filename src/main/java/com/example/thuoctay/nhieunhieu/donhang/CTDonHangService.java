package com.example.thuoctay.nhieunhieu.donhang;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.example.thuoctay.donhang.DonHangEntity;
import com.example.thuoctay.donhang.DonHangRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CTDonHangService {

    private final DonHangRepo donHangRepo;

    private final CTDonHangRepo ctDonHangRepo;
    private final CTDonHangMapper ctDonHangMapper;

    public Set<CTDonHangDto> getAll() {
        return ctDonHangRepo.findAll().stream().map(ctDonHangMapper::toDto).collect(Collectors.toSet());
    }

        public Set<CTDonHangDto> getByDonHang(Integer idDonHang){
        DonHangEntity donHangEntity = donHangRepo.findById(idDonHang).orElse(null);
        if(donHangEntity == null)
            return null;
        Set<CTDonHangEntity> ctDonHangEntities = ctDonHangRepo.findByDonHang(donHangEntity);
        Set<CTDonHangDto> ctDonHangDtos = ctDonHangEntities.stream().map(ctDonHangMapper::toDto).collect(Collectors.toSet());
        return ctDonHangDtos;
    }

    public CTDonHangDto create(CTDonHangDto dto) {
        CTDonHangEntity entity = ctDonHangMapper.toEntity(dto);
        entity.setId(0);
        ctDonHangRepo.save(entity);
        return dto;
    }

    public Set<CTDonHangDto> createAll(Set<CTDonHangDto> dtos) {
        List<CTDonHangEntity> entitys = dtos.stream().map(ctDonHangMapper::toEntity).collect(Collectors.toList());
        Set<CTDonHangEntity> entitys2 = new HashSet<>();
        for (int i = 0; i < entitys.size(); i++) {
            CTDonHangEntity entity = entitys.get(i);
            entity.setId(0);
            entitys2.add(entity);
        }
        ctDonHangRepo.saveAll(entitys2);
        dtos = entitys2.stream().map(ctDonHangMapper::toDto).collect(Collectors.toSet());
        return dtos;
    }
}
