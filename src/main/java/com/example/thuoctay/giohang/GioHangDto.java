package com.example.thuoctay.giohang;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GioHangDto {
    private Integer id;
    private String soDienThoai;

}
