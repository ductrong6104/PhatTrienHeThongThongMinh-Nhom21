package com.example.thuoctay.thuoc;

import java.math.BigDecimal;
import org.hibernate.annotations.ColumnDefault;

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

@Table(name = "thuoc")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThuocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_thuoc", columnDefinition = "nvarchar(255)",  unique = true, nullable = false)
    private String tenThuoc;

    @Column(name = "hinh_anh", columnDefinition = "nvarchar(255)", nullable = true)
    private String hinhAnh;

    @Column(name = "cong_dung", columnDefinition = "text")
    private String congDung;

    @Column(name = "hd_su_dung", columnDefinition = "text")
    private String hdSuDung;

    @Column(name = "kinh_doanh")
    private boolean kinhDoanh;

    @Column(name = "gia")
    private BigDecimal gia;

    @Column(name = "tong", nullable = false)
    @ColumnDefault("0")
    private Integer tong;

    @Column(name = "da_ban" , nullable = false)
    @ColumnDefault("0")
    private Integer daBan;

    @Column(name = "id_nhom")
    private Integer idNhom;

    @Column(name = "id_thuong_hieu")
    private Integer idThuongHieu;
}
