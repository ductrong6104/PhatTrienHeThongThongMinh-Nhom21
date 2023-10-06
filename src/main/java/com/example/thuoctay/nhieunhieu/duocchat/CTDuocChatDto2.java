package com.example.thuoctay.nhieunhieu.duocchat;

import com.example.thuoctay.duocchat.DuocChatDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTDuocChatDto2 {
    
    private Integer id;
    private DuocChatDto duocChatDto;
    private float hamLuong;

}
