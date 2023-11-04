package com.example.thuoctay.nhom;

import org.hibernate.annotations.Nationalized;

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

@Table(name = "nhom")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NhomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_nhom", columnDefinition = "nvarchar(100)", unique = true, nullable = false)
    private String tenNhom;

}
