package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Parametre;

public interface ParametreRepository extends JpaRepository<Parametre, Long> {

    List<Parametre> findByMatiere_id(Long matiereId);
}
