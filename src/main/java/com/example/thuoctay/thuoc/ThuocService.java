package com.example.thuoctay.thuoc;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.thuoctay.nhom.NhomEntity;
import com.example.thuoctay.nhom.NhomRepo;
import com.example.thuoctay.thuonghieu.ThuongHieuEntity;
import com.example.thuoctay.thuonghieu.ThuongHieuRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThuocService {

    private final ThuocRepo thuocRepo;
    private final ThuongHieuRepo thuongHieuRepo;
    private final NhomRepo nhomRepo;

    private final ThuocMapper thuocMapper;

    public Set<ThuocDto> getAll() {
        return thuocRepo.findAll().stream().map(thuocMapper::toDto).collect(Collectors.toSet());
    }

    public Set<ThuocDto> getOnePage(int pageIndex, int number) {
        Set<ThuocDto> set = thuocRepo.findAll(PageRequest.of(pageIndex, number)).stream()
                .map(thuocMapper::toDto)
                .collect(Collectors.toSet());
        return set;
    }

    public ThuocDto getById(Integer id) {
        ThuocEntity entity = thuocRepo.findById(id).orElse(null);
        if (entity != null) {
            return thuocMapper.toDto(entity);
        }
        return null;
    }

    public Set<ThuocDto> getByThuongHieu(Integer idThuongHieu) {
        ThuongHieuEntity thuongHieuEntity = thuongHieuRepo.findById(idThuongHieu).orElse(null);
        if (thuongHieuEntity != null) {
            return thuocRepo.findByThuongHieu(thuongHieuEntity).stream().map(thuocMapper::toDto)
                    .collect(Collectors.toSet());
        }
        return null;
    }

    public Set<ThuocDto> getByNhom(Integer idNhom) {
        NhomEntity nhomEntity = nhomRepo.findById(idNhom).orElse(null);
        if (nhomEntity != null) {
            return thuocRepo.findByNhom(nhomEntity).stream().map(thuocMapper::toDto).collect(Collectors.toSet());
        }
        return null;
    }

    public Set<ThuocDto> getByThuongHieuVaNhom(Integer idThuongHieu, Integer idNhom) {
        NhomEntity nhomEntity = nhomRepo.findById(idNhom).orElse(null);
        ThuongHieuEntity thuongHieuEntity = thuongHieuRepo.findById(idThuongHieu).orElse(null);
        if (nhomEntity != null && thuongHieuEntity != null) {
            return thuocRepo.findByThuongHieuAndNhom(thuongHieuEntity, nhomEntity).stream().map(thuocMapper::toDto)
                    .collect(Collectors.toSet());
        } else if (thuongHieuEntity != null) {
            return thuocRepo.findByThuongHieu(thuongHieuEntity).stream().map(thuocMapper::toDto)
                    .collect(Collectors.toSet());
        } else if (nhomEntity != null) {
            return thuocRepo.findByNhom(nhomEntity).stream().map(thuocMapper::toDto).collect(Collectors.toSet());
        }
        return new HashSet<>();
    }

    public ThuocDto create(ThuocDto dto) {
        ThuocEntity entity = thuocMapper.toEntity(dto);
        entity = thuocRepo.save(entity);
        return thuocMapper.toDto(entity);
    }

    public ThuocDto edit(ThuocDto dto) {
        ThuocEntity entity = thuocRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = thuocMapper.toEntity(dto);
            thuocRepo.save(entity);
            return dto;
        }
        return null;
    }

    public ThuocDto editHinhAnh(Integer idThuoc, String hinhAnh) {
        System.out.println("SUA HINH ANH THUOC\n");
        ThuocEntity entity = thuocRepo.findById(idThuoc).orElse(null);
        if (entity != null) {
            entity.setHinhAnh(hinhAnh);
            thuocRepo.save(entity);
            return thuocMapper.toDto(entity);
        }
        return null;
    }

    public ThuocDto delete(Integer id) {
        ThuocEntity entity = thuocRepo.findById(id).orElse(null);
        if (entity != null) {
            thuocRepo.delete(entity);
            return thuocMapper.toDto(entity);
        }
        return null;
    }

    public ThuocDto getByTen(String ten) {
        ThuocEntity entity = thuocRepo.findByTenThuoc(ten).orElse(null);
        if (entity != null) {
            return thuocMapper.toDto(entity);
        }
        return null;
    }
}
