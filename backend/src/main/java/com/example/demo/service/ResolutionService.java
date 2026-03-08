package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Resolution;
import com.example.demo.repository.ResolutionRepository;

@Service
public class ResolutionService {

    @Autowired
    ResolutionRepository repository;

    public Resolution save(Resolution resolution) {
        return repository.save(resolution);
    }

    public List<Resolution> findAll() {
        return repository.findAll();
    }

    public Resolution findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}