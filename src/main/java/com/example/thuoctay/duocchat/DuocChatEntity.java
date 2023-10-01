package com.example.thuoctay.duocchat;



import java.util.Set;


import com.example.thuoctay.nhieunhieu.duocchat.CTDuocChatEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "duoc_chat")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DuocChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_duoc_chat", columnDefinition = "nvarchar(100)" ,unique = true, nullable = false)
    private String tenDuocChat;
        
    @OneToMany(mappedBy = "duocChat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CTDuocChatEntity> ctDuocChats;
}
