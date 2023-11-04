package com.example.thuoctay.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.thuoctay.nguoidung.NguoiDungDto;
import com.example.thuoctay.nguoidung.NguoiDungService;
import com.example.thuoctay.taikhoanhethong.TaiKhoanNhanVienDto;
import com.example.thuoctay.taikhoanhethong.TaiKhoanNhanVienService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Auth {

    private final NguoiDungService nguoiDungService;
    private final TaiKhoanNhanVienService taiKhoanNhanVienService;

    public String getTokenFromHttpRequest(HttpServletRequest httpServletRequest){
        return (String)httpServletRequest.getHeader("token");
    }

    public NguoiDungDto getNguoiDungFromRequest(HttpServletRequest httpServletRequest){
        String token = (String)httpServletRequest.getHeader("token");
        if(token == null){
            return null;
        }
        String sdt = StringEncryption.decode(token);
        NguoiDungDto nguoiDungDto = nguoiDungService.getBySoDienThoai(sdt);
        return nguoiDungDto;
    }

        public TaiKhoanNhanVienDto getNhanVienFromRequest(HttpServletRequest httpServletRequest){
        String token = (String)httpServletRequest.getHeader("token");
        if(token == null){
            return null;
        }
        String tenDangNhap = StringEncryption.decode(token);
        System.out.println("\n\n\n\n\nTen dang nhap: " + tenDangNhap + "\n\n\n\n\n");
        TaiKhoanNhanVienDto taiKhoanNhanVienDto = taiKhoanNhanVienService.getDtoByTenDangNhap(tenDangNhap);
        return taiKhoanNhanVienDto;
    }
}
