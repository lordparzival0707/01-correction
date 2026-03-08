package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "t_differences")
public class Difference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="matiere_id")
    @JsonBackReference
    private Matiere matiere;

    private BigDecimal valeur;

    @OneToMany(mappedBy="difference")
    @JsonManagedReference
    private List<Parametre> parametres;

    public Difference(){}

    public Long getId(){ return id; }

    public Matiere getMatiere(){ return matiere; }

    public void setMatiere(Matiere matiere){ this.matiere = matiere; }

    public BigDecimal getValeur(){ return valeur; }

    public void setValeur(BigDecimal valeur){ this.valeur = valeur; }

    public List<Parametre> getParametres(){ return parametres; }

    public void setParametres(List<Parametre> parametres){ this.parametres = parametres; }
}
