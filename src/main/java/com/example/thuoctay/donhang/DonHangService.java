package com.example.thuoctay.donhang;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DonHangService {

    private final DonHangRepo donHangRepo;
    private final DonHangMapper donHangMapper;

    public DonHangDto create(DonHangDto dto) {
        DonHangEntity entity = donHangMapper.toEntity(dto);
        entity.setId(0);
        DonHangEntity result = donHangRepo.save(entity);
        return donHangMapper.toDto(result);
    }

    public DonHangDto edit(DonHangDto dto) {
        DonHangEntity entity = donHangRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = donHangMapper.toEntity(dto);
            donHangRepo.save(entity);
            return dto;
        }
        return null;
    }

    public DonHangDto delete(Integer donHangId) {
        DonHangEntity entity = donHangRepo.findById(donHangId).orElse(null);
        if (entity != null) {
            donHangRepo.delete(entity);
            return donHangMapper.toDto(entity);
        }
        return null;
    }

    public List<DonHangDto> getsByIdNguoiDung(Integer idNguoiDung) {
        if (idNguoiDung == null)
            return null;
        List<DonHangEntity> entitys = donHangRepo.findByIdNguoiDung(idNguoiDung);
        if (entitys != null) {
            List<DonHangDto> dtos = entitys.stream().map(donHangMapper::toDto).collect(Collectors.toList());
            return dtos;
        }
        return null;
    }

    public DonHangDto getById(Integer id) {
        DonHangEntity entity = donHangRepo.findById(id).orElse(null);
        if (entity != null) {
            return donHangMapper.toDto(entity);
        }
        return null;
    }

  public  List<DonHangDto> getAll() {
        List<DonHangEntity> entitys = donHangRepo.findAll();
        return entitys.stream().map(donHangMapper::toDto).collect(Collectors.toList());
    }

    public DonHangDto huyDon(Integer idDonHang) {
        DonHangEntity entity = donHangRepo.findById(idDonHang).orElse(null);
        if (entity != null) {
            entity.setTrangThai(-1);
            donHangRepo.save(entity);
            return donHangMapper.toDto(entity);
        }
        return null;
    }

    public DonHangDto daNhanHang(Integer idDonHang) {
        DonHangEntity entity = donHangRepo.findById(idDonHang).orElse(null);
        if (entity != null) {
            entity.setTrangThai(3);
            donHangRepo.save(entity);
            return donHangMapper.toDto(entity);
        }
        return null;
    }

    public DonHangDto duyetDonHang(Integer idDonHang) {
        DonHangEntity entity = donHangRepo.findById(idDonHang).orElse(null);
        if (entity != null) {
            entity.setTrangThai(1);
            donHangRepo.save(entity);
            return donHangMapper.toDto(entity);
        }
        return null;
    }

        public DonHangDto daGiaoDonHang(Integer idDonHang) {
        DonHangEntity entity = donHangRepo.findById(idDonHang).orElse(null);
        if (entity != null) {
            entity.setTrangThai(2);
            donHangRepo.save(entity);
            return donHangMapper.toDto(entity);
        }
        return null;
    }

}
