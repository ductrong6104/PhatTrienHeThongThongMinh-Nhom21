package com.example.thuoctay.nhom;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NhomRepo extends JpaRepository<NhomEntity, Integer>{
        Optional<NhomEntity> findByTenNhom(String ten);
}
