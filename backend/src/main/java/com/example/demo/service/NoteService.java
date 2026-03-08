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

}
