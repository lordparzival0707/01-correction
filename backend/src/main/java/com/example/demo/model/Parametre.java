package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "t_parametres")
public class Parametre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="difference_id")
    @JsonBackReference
    private Difference difference;

    @ManyToOne
    @JoinColumn(name="operateur_id")
    @JsonBackReference
    private Operateur operateur;

    @ManyToOne
    @JoinColumn(name="resolution_id")
    @JsonBackReference
    private Resolution resolution;

    public Parametre(){}

    public Long getId(){ return id; }

    public Difference getDifference(){ return difference; }

    public void setDifference(Difference difference){ this.difference = difference; }

    public Operateur getOperateur(){ return operateur; }

    public void setOperateur(Operateur operateur){ this.operateur = operateur; }

    public Resolution getResolution(){ return resolution; }

    public void setResolution(Resolution resolution){ this.resolution = resolution; }
}