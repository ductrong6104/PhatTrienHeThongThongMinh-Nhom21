package com.example.thuoctay.nguoidung;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepo extends JpaRepository<NguoiDungEntity, Integer>{
    Optional<NguoiDungEntity> findBySoDienThoai(String soDienThoai);
    Optional<NguoiDungEntity> findBySoDienThoaiAndMatKhau(String soDienThoai, String matKhau);

}
