package com.example.thuoctay.nhieunhieu.duocchat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTDuocChatDto {
    
    private Integer id;
    private Integer idDuocChat;
    private Integer idThuoc;
    private float hamLuong;

}
