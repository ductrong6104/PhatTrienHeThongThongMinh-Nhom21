package com.example.thuoctay.thuonghieu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThuongHieuDto {
    private Integer id;
    private String tenThuongHieu;
}
