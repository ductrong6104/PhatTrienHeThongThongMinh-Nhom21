package com.example.thuoctay.donhang;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DonHangRepo extends JpaRepository<DonHangEntity, Integer>{
    List<DonHangEntity> findByIdNguoiDung(Integer idNguoiDung);
}
