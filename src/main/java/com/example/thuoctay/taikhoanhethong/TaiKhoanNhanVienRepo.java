package com.example.thuoctay.taikhoanhethong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanNhanVienRepo extends JpaRepository<TaiKhoanNhanVienEntity, Integer> {
    TaiKhoanNhanVienEntity findByTenDangNhap(String tenDangNhap);
    TaiKhoanNhanVienEntity findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
}
