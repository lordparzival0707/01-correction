package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.NoteFinale;

public interface NoteFinaleRepository extends JpaRepository<NoteFinale, Long> {
    
}
