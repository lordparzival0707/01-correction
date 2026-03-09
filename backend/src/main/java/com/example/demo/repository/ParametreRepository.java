package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Parametre;

public interface ParametreRepository extends JpaRepository<Parametre, Long> {

    public Parametre findByOperateur_IdAndDifference_Id(Long operateurId, Long differenceId);
    
}
