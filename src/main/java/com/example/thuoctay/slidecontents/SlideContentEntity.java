package com.example.thuoctay.slidecontents;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class SlideContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "hinh_anh", columnDefinition = "nvarchar(255)",  nullable = false)
    private String hinhAnh;
    @Column(name = "trang_thai",  nullable = false)
    private boolean trangThai;
}
