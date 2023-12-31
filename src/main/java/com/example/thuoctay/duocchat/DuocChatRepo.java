package com.example.thuoctay.duocchat;


import java.util.List;
import java.util.Optional;

import com.example.thuoctay.nhom.NhomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuocChatRepo extends JpaRepository<DuocChatEntity, Integer>{
    Optional<DuocChatEntity> findByTenDuocChat(String tenDuocChat);
    Page<DuocChatEntity> findByTenDuocChatContaining(String ten, Pageable page);
}
