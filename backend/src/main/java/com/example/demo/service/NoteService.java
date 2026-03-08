package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;

@Service
public class NoteService {

    @Autowired
    NoteRepository repository;

    public Note save(Note note) {
        return repository.save(note);
    }

    public List<Note> findAll() {
        return repository.findAll();
    }

    public Note findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Note> findByMatiereIdAndEtudiantId(Long matiereId, Long etudiantId) {
        return repository.findByMatiere_IdAndEtudiant_Id(matiereId, etudiantId);
    }

    public Double getDifferenceNote(Long matiereId, Long etudiantId) {

        Double differenceNote = 0.0;

        List<Note> notes = findByMatiereIdAndEtudiantId(matiereId, etudiantId);

        for (int i = 0; i < notes.size(); i++) {

            Note note = notes.get(i);

            for (int j = i + 1; j < notes.size(); j++) {
                Double difference = note.getValeur() - notes.get(j).getValeur();
                if (difference < 0) {
                    difference = difference * -1;
                }
                differenceNote += difference;
            }
        }

        return differenceNote;
    }
}
