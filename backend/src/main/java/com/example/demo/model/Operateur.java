package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_operateurs")
public class Operateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "operateur")
    private List<Parametre> parametres;

    public Operateur(){}

    public Long getId(){ return id; }

    public String getLibelle(){ return libelle; }

    public void setLibelle(String libelle){ this.libelle = libelle; }

    public List<Parametre> getParametres(){ return parametres; }

    public void setParametres(List<Parametre> parametres){ this.parametres = parametres; }
}