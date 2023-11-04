package com.example.thuoctay.thuoclienquan;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "thuoc_lien_quan")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThuocLienQuanEntity {

    @Id
    private int thuoc_dx;
    private int thuoc_lq1;
    private int thuoc_lq2;
    private int thuoc_lq3;
    private int thuoc_lq4;
    private int thuoc_lq5;
    private int thuoc_lq6;
    private int thuoc_lq7;
    private int thuoc_lq8;
    private int thuoc_lq9;
    private int thuoc_lq10;

}
