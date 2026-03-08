package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Correcteur;
import com.example.demo.repository.CorrecteurRepository;

@Service
public class CorrecteurService {

    @Autowired
    CorrecteurRepository repository;

    public Correcteur save(Correcteur correcteur) {
        return repository.save(correcteur);
    }

    public List<Correcteur> findAll() {
        return repository.findAll();
    }

    public Correcteur findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}