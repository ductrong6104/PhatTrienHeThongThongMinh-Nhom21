package com.example.thuoctay.thuoc;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThuocRepo extends JpaRepository<ThuocEntity, Integer>{
    Optional<ThuocEntity> findByTenThuoc(String ten);
}
