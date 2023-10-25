package com.example.thuoctay.nhieunhieu.duocchat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ct_duoc_chat", 
    uniqueConstraints = {
                @UniqueConstraint(columnNames = "id_duoc_chat"),
                @UniqueConstraint(columnNames = "id_thuoc")
        })
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTDuocChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_duoc_chat", nullable = false)
    private Integer idDuocChat;

    @Column(name = "id_thuoc", nullable = false)
    private Integer idThuoc;

    @Column(name = "ham_luong", nullable = true)
    private float hamLuong;

}
