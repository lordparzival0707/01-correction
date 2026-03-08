package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Correcteur;

public interface CorrecteurRepository extends JpaRepository<Correcteur, Long> {
    
}
