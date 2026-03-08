package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Parametre;
import com.example.demo.repository.ParametreRepository;

@Service
public class ParametreService {

    @Autowired
    ParametreRepository repository;

    public Parametre save(Parametre parametre) {
        return repository.save(parametre);
    }

    public List<Parametre> findAll() {
        return repository.findAll();
    }

    public Parametre findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}