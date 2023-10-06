package com.example.thuoctay.nhieunhieu.giohang;

import com.example.thuoctay.giohang.GioHangEntity;
import com.example.thuoctay.thuoc.ThuocEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ct_gio_hang")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTGioHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_gio_hang", nullable = false)
    private GioHangEntity gioHang;

    @ManyToOne
    @JoinColumn(name = "id_thuoc", nullable = false)
    private ThuocEntity thuoc;
        
}
