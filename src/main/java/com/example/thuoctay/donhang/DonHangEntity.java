package com.example.thuoctay.donhang;






import java.util.Date;

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

@Table(name = "don_hang")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sdt", columnDefinition = "varchar(10)" ,unique = true, nullable = false)
    private String soDienThoai;

    @Column(name = "ten_nguoi_nhan", columnDefinition = "nvarchar(50)" , unique = false, nullable = false)
    private String tenNguoiNhan;

    @Column(name = "dia_chi", columnDefinition = "nvarchar(255)" , unique = false, nullable = false)
    private String diaChi;

    @Column(name = "trang_thai", columnDefinition = "int" , unique = false, nullable = false)
    private int trangThai;
    
    @Column(name = "thoi_gian", columnDefinition = "datetime" , unique = false, nullable = false)
    private Date thoiGian;

    @Column(name = "id_nguoi_dung", columnDefinition = "int" , unique = false, nullable = false)
    private int idNguoiDung;
        
}
