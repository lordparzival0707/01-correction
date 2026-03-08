package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Difference;
import com.example.demo.model.Parametre;
import com.example.demo.repository.ParametreRepository;

@Service
public class ParametreService {

    @Autowired
    ParametreRepository repository;

    @Autowired
    NoteService noteService;

    @Autowired
    DifferenceService differenceService;

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

    public Parametre findByOperateurId(Long operateurId) {
        return repository.findByOperateur_Id(operateurId);
    }

    public Parametre getParametreByDifferenceNote(Long matiereId, Long etudiantId) {

        Parametre parametre = new Parametre();

        Double differenceNote = noteService.getDifferenceNote(matiereId, etudiantId);
        Difference difference = differenceService.findByMatiereId(matiereId);

        if (differenceNote > difference.getValeur()) {
            parametre = findByOperateurId(1L);
        }

        if (differenceNote < difference.getValeur()) {
            parametre = findByOperateurId(2L);
        }

        if (differenceNote == difference.getValeur()) {
            parametre = findByOperateurId(3L);
        }

        return parametre;
    }
}