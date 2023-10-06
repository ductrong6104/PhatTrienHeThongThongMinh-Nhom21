package com.example.thuoctay.nhieunhieu.giohang;

import com.example.thuoctay.thuoc.ThuocDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTGioHangDto2 {
    
    private Integer id;
    private ThuocDto thuocDto;

}
