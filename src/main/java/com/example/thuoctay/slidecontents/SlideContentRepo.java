package com.example.thuoctay.slidecontents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideContentRepo extends JpaRepository<SlideContentEntity, Integer>{

} 
