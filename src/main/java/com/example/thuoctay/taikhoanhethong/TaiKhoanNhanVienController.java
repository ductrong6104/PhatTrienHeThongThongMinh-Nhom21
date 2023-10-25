package com.example.thuoctay.taikhoanhethong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/taikhoannhanvien")
@RequiredArgsConstructor
@CrossOrigin
public class TaiKhoanNhanVienController {

    private final TaiKhoanNhanVienService service;

    @PostMapping("/dangnhap")
    public ResponseEntity<?> dangNhap(@RequestBody TaiKhoanDangNhapDto taiKhoanDangNhapDto ) {
        return ResponseEntity.ok().body(service.dangNhap(taiKhoanDangNhapDto.getTenDangNhap(), taiKhoanDangNhapDto.getMatKhau()));
    }

    @PostMapping("/taotaikhoan")
    public ResponseEntity<?> taoTaiKhoan(@RequestBody TaiKhoanNhanVienDto taiKhoanNhanVienDto ) {
        return ResponseEntity.ok().body(service.taoTaiKhoanNhanVien(taiKhoanNhanVienDto));
    }
}
