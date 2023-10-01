package com.example.thuoctay.duocchat;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuocChatRepo extends JpaRepository<DuocChatEntity, Integer>{
    Optional<DuocChatEntity> findByTenDuocChat(String tenDuocChat);
}
