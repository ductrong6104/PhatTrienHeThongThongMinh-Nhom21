package com.example.thuoctay.nhieunhieu.donhang;

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

@Table(name = "ct_don_hang", 
    uniqueConstraints = {
                @UniqueConstraint(columnNames = "id_don_hang"),
                @UniqueConstraint(columnNames = "id_thuoc")
        })
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTDonHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_don_hang", nullable = false)
    private Integer idDonHang;

    @Column(name = "id_thuoc", nullable = false)
    private Integer idThuoc;

    @Column(name = "so_luong", nullable = false)
    private int soLuong;

}
