package com.example.thuoctay.nhom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhomDto {
    private Integer id;
    private String tenNhom;
}
