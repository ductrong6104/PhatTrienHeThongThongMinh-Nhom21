package com.example.thuoctay.nguoidung;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NguoiDungDto {
    private Integer id;
    private String soDienThoai;
    private String matKhau;
    private String tenNguoiDung;
}
