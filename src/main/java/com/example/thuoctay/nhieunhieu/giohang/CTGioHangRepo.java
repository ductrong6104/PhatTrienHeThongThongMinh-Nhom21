package com.example.thuoctay.nhieunhieu.giohang;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTGioHangRepo extends JpaRepository<CTGioHangEntity, Integer>{
    public Set<CTGioHangEntity> findByIdNguoiDung(Integer idNguoiDung);
}
