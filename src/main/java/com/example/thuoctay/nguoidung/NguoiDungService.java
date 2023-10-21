package com.example.thuoctay.nguoidung;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NguoiDungService {

    private final NguoiDungRepo nguoiDungRepo;
    private final NguoiDungMapper nguoiDungMapper;

    // public Set<NguoiDungDto> getAll() {
    //     return nguoiDungRepo.findAll().stream().map(nguoiDungMapper::toDto).collect(Collectors.toSet());
    // }

    // public Set<NguoiDungDto> getOnePage(int pageIndex, int number) {
    //     Set<NguoiDungDto> set = nguoiDungRepo.findAll(PageRequest.of(pageIndex, number)).stream()
    //             .map(nguoiDungMapper::toDto)
    //             .collect(Collectors.toSet());
    //     return set;
    // }

    public NguoiDungDto create(NguoiDungDto dto) {
        NguoiDungEntity entity = nguoiDungMapper.toEntity(dto);
        nguoiDungRepo.save(entity);
        return dto;
    }

    public NguoiDungDto edit(NguoiDungDto dto) {
        NguoiDungEntity entity = nguoiDungRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = nguoiDungMapper.toEntity(dto);
            nguoiDungRepo.save(entity);
            return dto;
        }
        return null;
    }

    public NguoiDungDto delete(Integer nhomId) {
        NguoiDungEntity entity = nguoiDungRepo.findById(nhomId).orElse(null);
        if (entity != null) {
            nguoiDungRepo.delete(entity);
            return nguoiDungMapper.toDto(entity);
        }
        return null;
    }

    public NguoiDungDto getBySoDienThoai(String soDienThoai) {
        NguoiDungEntity entity = nguoiDungRepo.findBySoDienThoai(soDienThoai).orElse(null);
        if (entity != null) {
            return nguoiDungMapper.toDto(entity);
        }
        return null;
    }

    public NguoiDungDto getById(Integer id) {
        NguoiDungEntity entity = nguoiDungRepo.findById(id).orElse(null);
        if (entity != null) {
            return nguoiDungMapper.toDto(entity);
        }
        return null;
    }
}
