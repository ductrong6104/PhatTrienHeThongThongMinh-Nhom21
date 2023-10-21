package com.example.thuoctay.nhieunhieu.donhang;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thuoctay.donhang.DonHangEntity;

@Repository
public interface CTDonHangRepo extends JpaRepository<CTDonHangEntity, Integer>{
    public Set<CTDonHangEntity> findByDonHang(DonHangEntity donHangEntity);
}
