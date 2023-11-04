package com.example.thuoctay.taikhoanhethong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thuoctay.anotation.Role;
import com.example.thuoctay.utils.StringEncryption;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/taikhoannhanvien")
@RequiredArgsConstructor
@CrossOrigin
public class TaiKhoanNhanVienController {

    private final TaiKhoanNhanVienService service;

    @PostMapping("/dangnhap")
    public ResponseEntity<?> dangNhap(@RequestBody TaiKhoanDangNhapDto taiKhoanDangNhapDto ) {
        TaiKhoanNhanVienDto dto = service.dangNhap(taiKhoanDangNhapDto.getTenDangNhap(), taiKhoanDangNhapDto.getMatKhau());
        if(dto == null){
            return ResponseEntity.badRequest().body("Đăng nhập thất bại");
        }
        String token = StringEncryption.encode(dto.getTenDangNhap());
        dto.setToken(token);
        return ResponseEntity.ok().body(dto);
    }

    @Role({"ADMIN"})
    @PostMapping("/taotaikhoan")
    public ResponseEntity<?> taoTaiKhoan(@RequestBody TaiKhoanNhanVienDto taiKhoanNhanVienDto ) {
        return ResponseEntity.ok().body(service.taoTaiKhoanNhanVien(taiKhoanNhanVienDto));
    }
}
