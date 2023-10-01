package com.example.thuoctay.thuoc;

import java.math.BigDecimal;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;

import com.example.thuoctay.nhieunhieu.duocchat.CTDuocChatEntity;
import com.example.thuoctay.nhom.NhomEntity;
import com.example.thuoctay.thuonghieu.ThuongHieuEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "id_nhom")
    private NhomEntity nhom;

    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu")
    private ThuongHieuEntity thuongHieu;
    
    @OneToMany(mappedBy = "thuoc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CTDuocChatEntity> ctDuocChats;
}
