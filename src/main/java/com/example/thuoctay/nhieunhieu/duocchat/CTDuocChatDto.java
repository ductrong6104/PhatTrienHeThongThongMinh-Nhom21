package com.example.thuoctay.nhieunhieu.duocchat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CTDuocChatDto {
    
    private Integer id;
    private Integer idDuocChat;
    private Integer idThuoc;
    private String hamLuong;

}
