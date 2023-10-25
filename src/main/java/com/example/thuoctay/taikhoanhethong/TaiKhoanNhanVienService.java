package com.example.thuoctay.taikhoanhethong;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaiKhoanNhanVienService {
    private final TaiKhoanNhanVienRepo taiKhoanNhanVienRepo;
    private final TaiKhoanNhanVienMapper taiKhoanNhanVienMapper;

    public TaiKhoanNhanVienDto dangNhap(String tenDangNhap, String matKhau){
        return taiKhoanNhanVienMapper.toDto(taiKhoanNhanVienRepo.findByTenDangNhapAndMatKhau(tenDangNhap, matKhau));
    }

    public String getRoleByTenDangNhap(String tenDangNhap){
        TaiKhoanNhanVienEntity entity = taiKhoanNhanVienRepo.findByTenDangNhap(tenDangNhap);
        if(entity != null){
            return entity.getRole();
        }
        return null;
    }

    public TaiKhoanNhanVienDto getDtoByTenDangNhap(String tenDangNhap){
        TaiKhoanNhanVienEntity entity = taiKhoanNhanVienRepo.findByTenDangNhap(tenDangNhap);
        if(entity != null){
            return taiKhoanNhanVienMapper.toDto(entity);
        }
        return null;
    }


    public TaiKhoanNhanVienDto taoTaiKhoanNhanVien(TaiKhoanNhanVienDto dto){
        dto.setId(0);
        TaiKhoanNhanVienEntity entity = taiKhoanNhanVienMapper.toEntity(dto);
        try {
            taiKhoanNhanVienRepo.save(entity);
            return taiKhoanNhanVienMapper.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }

}
