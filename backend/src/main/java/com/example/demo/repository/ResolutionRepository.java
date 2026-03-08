package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Resolution;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
    
}
