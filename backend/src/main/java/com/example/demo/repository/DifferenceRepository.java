package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Difference;

public interface DifferenceRepository extends JpaRepository<Difference, Long> {
    
}
