package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Matiere;
import com.example.demo.repository.MatiereRepository;

@Service
public class MatiereService {

    @Autowired
    MatiereRepository repository;

    public Matiere save(Matiere matiere) {
        return repository.save(matiere);
    }

    public List<Matiere> findAll() {
        return repository.findAll();
    }

    public Matiere findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
