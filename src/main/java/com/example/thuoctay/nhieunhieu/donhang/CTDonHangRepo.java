package com.example.thuoctay.nhieunhieu.donhang;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTDonHangRepo extends JpaRepository<CTDonHangEntity, Integer>{
    public Set<CTDonHangEntity> findByIdDonHang(Integer idDonHang);
}
