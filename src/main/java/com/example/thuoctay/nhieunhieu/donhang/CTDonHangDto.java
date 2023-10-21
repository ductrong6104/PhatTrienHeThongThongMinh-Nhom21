package com.example.thuoctay.nhieunhieu.donhang;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTDonHangDto {
    
    private Integer id;
    private Integer idDonHang;
    private Integer idThuoc;
    private int soLuong;

}
