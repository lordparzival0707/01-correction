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

    public Parametre findByOperateurIdAndDifferenceId(Long operateurId, Long differenceId) {
        return repository.findByOperateur_IdAndDifference_Id(operateurId, differenceId);
    }

    public Parametre getParametreByDifferenceNote(Long matiereId, Long etudiantId) {

        Parametre parametre = new Parametre();

        Double differenceNote = noteService.getDifferenceNote(matiereId, etudiantId);
        Difference difference = differenceService.findByMatiereId(matiereId);

        if (differenceNote >= difference.getValeur()) {

            if (differenceNote.equals(difference.getValeur())) {
                parametre = findByOperateurIdAndDifferenceId(4L, difference.getId());
                if (parametre != null) {
                    return parametre;
                }
            } else {
                parametre = findByOperateurIdAndDifferenceId(3L, difference.getId());
                if (parametre == null) {
                    parametre = findByOperateurIdAndDifferenceId(4L, difference.getId());
                }
            }

        }

        if (differenceNote <= difference.getValeur()) {

            if (differenceNote.equals(difference.getValeur())) {
                parametre = findByOperateurIdAndDifferenceId(2L, difference.getId());
            } else {
                parametre = findByOperateurIdAndDifferenceId(1L, difference.getId());
                if (parametre == null) {
                    parametre = findByOperateurIdAndDifferenceId(2L, difference.getId());
                }
            }
        }

        // if (differenceNote.equals(difference.getValeur())) {
        // parametre = findByOperateurIdAndDifferenceId(3L, difference.getId());
        // }

        return parametre;
    }
}