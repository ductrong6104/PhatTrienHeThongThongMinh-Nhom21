package com.example.thuoctay.thuoc;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuocRepo extends JpaRepository<ThuocEntity, Integer>{
    Optional<ThuocEntity> findByTenThuoc(String ten);
    Page<ThuocEntity> findByIdNhom(Integer idNhom, Pageable pageable);
    Page<ThuocEntity> findByIdThuongHieu(Integer idThuongHieu, Pageable pageable);
    Page<ThuocEntity> findByIdThuongHieuAndIdNhom(Integer idThuongHieu, Integer idNhom, Pageable pageable);

    Page<ThuocEntity> findByTenThuocContaining(String ten, Pageable pageable);
}
