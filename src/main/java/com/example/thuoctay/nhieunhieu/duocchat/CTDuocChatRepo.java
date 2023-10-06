package com.example.thuoctay.nhieunhieu.duocchat;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thuoctay.thuoc.ThuocEntity;

@Repository
public interface CTDuocChatRepo extends JpaRepository<CTDuocChatEntity, Integer>{
    public Set<CTDuocChatEntity> findByThuoc(ThuocEntity thuocEntity);
}
