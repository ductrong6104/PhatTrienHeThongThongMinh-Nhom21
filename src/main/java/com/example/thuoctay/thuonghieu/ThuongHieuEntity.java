package com.example.thuoctay.thuonghieu;

import java.util.Set;


import com.example.thuoctay.thuoc.ThuocEntity;

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

@Table(name = "thuong_hieu")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThuongHieuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_thuong_hieu", columnDefinition = "nvarchar(100)", unique = true, nullable = false)
    private String tenThuongHieu;

    @Column(name = "hinh_anh", columnDefinition = "nvarchar(255)", unique = true, nullable = false)
    private String hinhAnh;

    @OneToMany(mappedBy = "thuongHieu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ThuocEntity> thuocs;
}
