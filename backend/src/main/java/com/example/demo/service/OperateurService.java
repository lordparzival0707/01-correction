package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Operateur;
import com.example.demo.repository.OperateurRepository;

@Service
public class OperateurService {

    @Autowired
    OperateurRepository repository;

    public Operateur save(Operateur operateur) {
        return repository.save(operateur);
    }

    public List<Operateur> findAll() {
        return repository.findAll();
    }

    public Operateur findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
