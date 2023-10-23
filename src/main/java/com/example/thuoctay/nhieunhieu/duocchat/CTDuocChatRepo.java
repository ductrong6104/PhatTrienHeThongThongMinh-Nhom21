package com.example.thuoctay.nhieunhieu.duocchat;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTDuocChatRepo extends JpaRepository<CTDuocChatEntity, Integer>{
    public Set<CTDuocChatEntity> findByIdThuoc(Integer idThuoc);
}
