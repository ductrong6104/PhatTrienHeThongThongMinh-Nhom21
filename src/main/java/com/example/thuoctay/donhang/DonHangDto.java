package com.example.thuoctay.donhang;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonHangDto {
    private Integer id;
    private String soDienThoai;
    private String tenNguoiNhan;
    private String diaChi;
    private int trangThai;
    private Date thoiGian;
    private int idNguoiDung;
}
