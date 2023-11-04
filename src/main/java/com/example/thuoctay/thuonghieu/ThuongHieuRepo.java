package com.example.thuoctay.thuonghieu;

import java.util.List;
import java.util.Optional;

import com.example.thuoctay.thuoc.ThuocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThuongHieuRepo extends JpaRepository<ThuongHieuEntity, Integer>{
        Optional<ThuongHieuEntity> findByTenThuongHieu(String ten);
        List<ThuongHieuEntity> findByTenThuongHieuContaining(String ten);
}
