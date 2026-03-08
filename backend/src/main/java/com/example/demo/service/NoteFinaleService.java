package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.NoteFinale;
import com.example.demo.repository.NoteFinaleRepository;

@Service
public class NoteFinaleService {

    @Autowired
    NoteFinaleRepository repository;

    public NoteFinale save(NoteFinale noteFinale) {
        return repository.save(noteFinale);
    }

    public List<NoteFinale> findAll() {
        return repository.findAll();
    }

    public NoteFinale findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
