package com.example.thuoctay.nhom;

import java.util.List;
import java.util.Optional;

import com.example.thuoctay.thuoc.ThuocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NhomRepo extends JpaRepository<NhomEntity, Integer>{
        Optional<NhomEntity> findByTenNhom(String ten);

        List<NhomEntity> findByTenNhomContaining(String ten);
}
