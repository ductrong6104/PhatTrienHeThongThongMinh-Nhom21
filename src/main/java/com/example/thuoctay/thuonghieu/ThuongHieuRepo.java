package com.example.thuoctay.thuonghieu;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThuongHieuRepo extends JpaRepository<ThuongHieuEntity, Integer>{
        Optional<ThuongHieuEntity> findByTenThuongHieu(String ten);

}
