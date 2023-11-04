package com.example.thuoctay.nguoidung;






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

@Table(name = "nguoi_dung")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NguoiDungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sdt", columnDefinition = "varchar(10)" ,unique = true, nullable = false)
    private String soDienThoai;

    @Column(name = "mat_khau", columnDefinition = "varchar(10)" ,unique = true, nullable = false)
    private String matKhau;

    @Column(name = "ten_nguoi_dung", columnDefinition = "nvarchar(50)" , unique = false, nullable = false)
    private String tenNguoiDung;
        
}
