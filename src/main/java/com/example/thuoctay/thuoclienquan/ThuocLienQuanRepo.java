package com.example.thuoctay.thuoclienquan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuocLienQuanRepo extends JpaRepository<ThuocLienQuanEntity, Integer> {
    
}
