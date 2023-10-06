package com.example.thuoctay.giohang;






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

@Table(name = "gio_hang")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GioHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "so_dien_thoai", columnDefinition = "varchar(12)" ,unique = true, nullable = false)
    private String soDienThoai;
        
}
