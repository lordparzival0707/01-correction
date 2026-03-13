package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MatiereService;
import com.example.demo.service.NoteFinaleService;

import java.util.*;
import com.example.demo.model.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/notes-finales")
public class NoteFinaleController {

    @Autowired
    private NoteFinaleService noteFinaleService;

    @GetMapping
    public NoteFinale getNoteFinale(@RequestParam Long matiereId, @RequestParam Long etudiantId) {

        // NoteFinale noteFinale = noteFinaleService.getNoteFinale(matiereId,
        // etudiantId);
        return new NoteFinale();

    }
}
