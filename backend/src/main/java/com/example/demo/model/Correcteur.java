package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_correcteurs")
public class Correcteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "correcteur")
    private List<Note> notes;

    public Correcteur(){}

    public Long getId(){ return id; }

    public String getNom(){ return nom; }

    public void setNom(String nom){ this.nom = nom; }

    public String getPrenom(){ return prenom; }

    public void setPrenom(String prenom){ this.prenom = prenom; }

    public List<Note> getNotes(){ return notes; }

    public void setNotes(List<Note> notes){ this.notes = notes; }
}