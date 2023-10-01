package com.example.thuoctay.nhieunhieu.duocchat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTDuocChatRepo extends JpaRepository<CTDuocChatEntity, Integer>{
    
}
