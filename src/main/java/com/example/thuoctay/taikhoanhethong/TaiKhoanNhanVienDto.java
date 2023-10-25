package com.example.thuoctay.taikhoanhethong;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaiKhoanNhanVienDto {
    private Integer id;
    private String tenDangNhap;
    private String tenNguoiDung;
    private String role;

}
