package com.example.demo.service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Note;
import com.example.demo.model.NoteFinale;
import com.example.demo.model.Parametre;
import com.example.demo.repository.NoteFinaleRepository;

@Service
public class NoteFinaleService {

    @Autowired
    NoteFinaleRepository repository;

    @Autowired
    NoteService noteService;

    @Autowired
    ParametreService parametreService;

    @Autowired
    MatiereService matiereService;

    @Autowired
    EtudiantService etudiantService;

    public NoteFinale save(NoteFinale noteFinale) {
        return repository.save(noteFinale);
    }

    public List<NoteFinale> findAll() {
        return repository.findAll();
    }

    public NoteFinale findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public NoteFinale getNoteFinale(Long matiereId, Long etudiantId) {

        NoteFinale noteFinale = new NoteFinale();

        Parametre parametre = parametreService.getParametre(matiereId, etudiantId);
        List<Note> notes = noteService.findByMatiereIdAndEtudiantId(matiereId, etudiantId);

        Double noteValeur = 0.0;
        DoubleSummaryStatistics stats = notes.stream().mapToDouble(Note::getValeur).summaryStatistics();

        String resolutionLibelle = parametre.getResolution().getLibelle();

        if (resolutionLibelle.equals("plus_petit")) {
            noteValeur = stats.getMin();
        }
        if (resolutionLibelle.equals("plus_grand")) {
            noteValeur = stats.getMax();
        }
        if (resolutionLibelle.equals("moyenne")) {
            noteValeur = stats.getAverage();
        }

        noteFinale.setValeur(noteValeur);
        noteFinale.setMatiere(matiereService.findById(matiereId));
        noteFinale.setEtudiant(etudiantService.findById(etudiantId));
        noteFinale.setParametre(parametre);

        return noteFinale;
    }
}
