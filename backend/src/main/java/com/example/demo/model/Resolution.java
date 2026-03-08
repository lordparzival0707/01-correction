package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "t_resolutions")
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "resolution")
    @JsonManagedReference
    private List<Parametre> parametres;

    public Resolution(){}

    public Long getId(){ return id; }

    public String getLibelle(){ return libelle; }

    public void setLibelle(String libelle){ this.libelle = libelle; }

    public List<Parametre> getParametres(){ return parametres; }

    public void setParametres(List<Parametre> parametres){ this.parametres = parametres; }
}