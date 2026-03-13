package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "t_matieres")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private BigDecimal coefficient;

    @OneToMany(mappedBy = "matiere")
    private List<Note> notes;

    @OneToMany(mappedBy = "matiere")
    private List<NoteFinale> notesFinales;

    public Matiere(){}

    public Long getId(){ return id; }

    public String getNom(){ return nom; }

    public void setNom(String nom){ this.nom = nom; }

    public BigDecimal getCoefficient(){ return coefficient; }

    public void setCoefficient(BigDecimal coefficient){ this.coefficient = coefficient; }

    public List<Note> getNotes(){ return notes; }

    public void setNotes(List<Note> notes){ this.notes = notes; }

    public List<NoteFinale> getNotesFinales(){ return notesFinales; }

    public void setNotesFinales(List<NoteFinale> notesFinales){ this.notesFinales = notesFinales; }
}
