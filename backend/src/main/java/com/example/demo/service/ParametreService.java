package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Parametre;
import com.example.demo.repository.ParametreRepository;

@Service
public class ParametreService {

    @Autowired
    ParametreRepository repository;

    @Autowired
    NoteService noteService;

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

    public List<Parametre> findByMatiereId(Long matiereId) {
        return repository.findByMatiere_id(matiereId);
    }

    public List<Parametre> getParametresPotentiels(Long matiereId, Long etudiantId) {

        List<Parametre> parametresPotentiels = new ArrayList<>();

        List<Parametre> parametres = findByMatiereId(matiereId);
        Double difference = noteService.getDifferenceNote(matiereId, etudiantId);

        for (Parametre parametre : parametres) {

            String operateur = parametre.getOperateur().getLibelle();
            Double seuil = parametre.getSeuil();

            if (operateur.equals("<")) {
                if (difference < seuil) {
                    parametresPotentiels.add(parametre);
                }
            }

            if (operateur.equals("<=")) {
                if (difference <= seuil) {
                    parametresPotentiels.add(parametre);
                }
            }

            if (operateur.equals(">")) {
                if (difference > seuil) {
                    parametresPotentiels.add(parametre);
                }
            }

            if (operateur.equals(">=")) {
                if (difference >= seuil) {
                    parametresPotentiels.add(parametre);
                }
            }
        }

        return parametresPotentiels;
    }

    // public Parametre getParametreByDifferenceNote(Long matiereId, Long
    // etudiantId) {

    // Parametre parametre = new Parametre();

    // Double differenceNote = noteService.getDifferenceNote(matiereId, etudiantId);
    // Difference difference = differenceService.findByMatiereId(matiereId);

    // if (differenceNote >= difference.getValeur()) {

    // if (differenceNote.equals(difference.getValeur())) {
    // parametre = findByOperateurIdAndDifferenceId(4L, difference.getId());
    // if (parametre != null) {
    // return parametre;
    // }
    // } else {
    // parametre = findByOperateurIdAndDifferenceId(3L, difference.getId());
    // if (parametre == null) {
    // parametre = findByOperateurIdAndDifferenceId(4L, difference.getId());
    // }
    // }

    // }

    // if (differenceNote <= difference.getValeur()) {

    // if (differenceNote.equals(difference.getValeur())) {
    // parametre = findByOperateurIdAndDifferenceId(2L, difference.getId());
    // } else {
    // parametre = findByOperateurIdAndDifferenceId(1L, difference.getId());
    // if (parametre == null) {
    // parametre = findByOperateurIdAndDifferenceId(2L, difference.getId());
    // }
    // }
    // }

    // // if (differenceNote.equals(difference.getValeur())) {
    // // parametre = findByOperateurIdAndDifferenceId(3L, difference.getId());
    // // }

    // return parametre;
    // }
}