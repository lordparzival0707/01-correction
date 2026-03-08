package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Difference;
import com.example.demo.repository.DifferenceRepository;

@Service
public class DifferenceService {

    @Autowired
    DifferenceRepository repository;

    public Difference save(Difference difference) {
        return repository.save(difference);
    }

    public List<Difference> findAll() {
        return repository.findAll();
    }

    public Difference findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}