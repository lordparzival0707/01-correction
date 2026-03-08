package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByMatiere_IdAndEtudiant_Id(Long matiereId, Long etudiantId);

}