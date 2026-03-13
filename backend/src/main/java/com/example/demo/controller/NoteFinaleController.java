package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MatiereService;
import com.example.demo.service.NoteFinaleService;
import com.example.demo.service.NoteService;

import java.util.*;

import com.example.demo.dto.NoteFinaleDto;
import com.example.demo.model.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/notes-finales")
public class NoteFinaleController {

    @Autowired
    private NoteFinaleService noteFinaleService;

    @Autowired
    private NoteService noteService;

    @GetMapping
    public NoteFinaleDto getNoteFinale(@RequestParam Long matiereId, @RequestParam Long etudiantId) {

        NoteFinale noteFinale = noteFinaleService.getNoteFinale(matiereId,
                etudiantId);

        NoteFinaleDto noteFinaleDto = new NoteFinaleDto();
        noteFinaleDto.setMatiereId(matiereId);
        noteFinaleDto.setMatiere(noteFinale.getMatiere().getNom());
        noteFinaleDto.setEtudiantId(noteFinale.getEtudiant().getId());
        noteFinaleDto.setEtudiant(noteFinale.getEtudiant().getNom());
        noteFinaleDto.setValeur(noteFinale.getValeur());
        noteFinaleDto.setResolution(noteFinale.getParametre().getResolution().getLibelle());

        Double difference = noteService.getDifferenceNote(matiereId, etudiantId);
        noteFinaleDto.setDifference(difference);

        return noteFinaleDto;

    }
}
