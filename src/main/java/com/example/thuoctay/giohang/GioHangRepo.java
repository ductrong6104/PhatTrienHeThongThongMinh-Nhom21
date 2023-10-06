package com.example.thuoctay.giohang;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepo extends JpaRepository<GioHangEntity, Integer>{
    Optional<GioHangEntity> findBySoDienThoai(String soDienThoai);
}
