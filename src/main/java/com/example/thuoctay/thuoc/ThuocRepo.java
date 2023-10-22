package com.example.thuoctay.thuoc;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thuoctay.nhom.NhomEntity;
import com.example.thuoctay.thuonghieu.ThuongHieuEntity;


@Repository
public interface ThuocRepo extends JpaRepository<ThuocEntity, Integer>{
    Optional<ThuocEntity> findByTenThuoc(String ten);
    Set<ThuocEntity> findByNhom(NhomEntity nhomEntity);
    Set<ThuocEntity> findByThuongHieu(ThuongHieuEntity thuongHieuEntity);
    Set<ThuocEntity> findByThuongHieuAndNhom(ThuongHieuEntity thuongHieuEntity, NhomEntity nhomEntity);

}
