package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepository;

@Service
public class EtudiantService {

    @Autowired
    EtudiantRepository repository;

    public Etudiant save(Etudiant etudiant) {
        return repository.save(etudiant);
    }

    public List<Etudiant> findAll() {
        return repository.findAll();
    }

    public Etudiant findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
