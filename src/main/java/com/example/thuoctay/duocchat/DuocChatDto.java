package com.example.thuoctay.duocchat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DuocChatDto {
    private Integer id;
    private String tenDuocChat;

}
