package com.example.thuoctay.nhieunhieu.giohang;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTGioHangDto {
    
    private Integer id;
    private Integer idGioHang;
    private Integer idThuoc;

}
