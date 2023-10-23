package com.example.thuoctay.thuoc;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuocRepo extends JpaRepository<ThuocEntity, Integer>{
    Optional<ThuocEntity> findByTenThuoc(String ten);
    Set<ThuocEntity> findByIdNhom(Integer idNhom);
    Set<ThuocEntity> findByIdThuongHieu(Integer idThuongHieu);
    Set<ThuocEntity> findByIdThuongHieuAndIdNhom(Integer idThuongHieu, Integer idNhom);

}
