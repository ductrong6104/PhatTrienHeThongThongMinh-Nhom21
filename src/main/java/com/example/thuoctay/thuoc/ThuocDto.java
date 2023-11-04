package com.example.thuoctay.thuoc;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThuocDto {
    private Integer id;
    private String tenThuoc;
    private String hinhAnh;
    private String congDung;
    private String hdSuDung;
    private boolean kinhDoanh;
    private BigDecimal gia;
    private Integer tong;
    private Integer daBan;
    private Integer idNhom;
    private Integer idThuongHieu;
}
