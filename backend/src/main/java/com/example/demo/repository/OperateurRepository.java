package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Operateur;

public interface OperateurRepository extends JpaRepository<Operateur, Long> {
    
}