package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "t_notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="etudiant_id")
    @JsonBackReference
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name="correcteur_id")
    @JsonBackReference
    private Correcteur correcteur;

    @ManyToOne
    @JoinColumn(name="matiere_id")
    @JsonBackReference
    private Matiere matiere;

    private Double valeur;

    public Note(){}

    public Long getId(){ return id; }

    public Etudiant getEtudiant(){ return etudiant; }

    public void setEtudiant(Etudiant etudiant){ this.etudiant = etudiant; }

    public Correcteur getCorrecteur(){ return correcteur; }

    public void setCorrecteur(Correcteur correcteur){ this.correcteur = correcteur; }

    public Matiere getMatiere(){ return matiere; }

    public void setMatiere(Matiere matiere){ this.matiere = matiere; }

    public Double getValeur(){ return valeur; }

    public void setValeur(Double valeur){ this.valeur = valeur; }
}
