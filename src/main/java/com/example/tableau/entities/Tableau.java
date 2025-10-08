package com.example.tableau.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Tableau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTableau;
    private String nomTableau;
    private Double prixTableau;


    private Date dateTableau;

    @ManyToOne
    private Artiste artiste;  // NOUVELLE LIGNE


    public Tableau() {
        super();
    }


    public Tableau(String nomTableau, Double prixTableau, Date dateTableau) {
        super();
        this.nomTableau = nomTableau;
        this.prixTableau = prixTableau;
        this.dateTableau = dateTableau;
    }

    // Getters et Setters
    public Long getIdTableau() {
        return idTableau;
    }

    public void setIdTableau(Long idTableau) {
        this.idTableau = idTableau;
    }

    public String getNomTableau() {
        return nomTableau;
    }

    public void setNomTableau(String nomTableau) {
        this.nomTableau = nomTableau;
    }

    public Double getPrixTableau() {
        return prixTableau;
    }

    public void setPrixTableau(Double prixTableau) {
        this.prixTableau = prixTableau;
    }

    public Date getDateTableau() {
        return dateTableau;
    }

    public void setDateTableau(Date dateTableau) {
        this.dateTableau = dateTableau;
    }
    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    @Override
    public String toString() {
        return "Tableau [idTableau=" + idTableau + ", nomTableau=" + nomTableau +
                ", prixTableau=" + prixTableau + ", dateTableau=" + dateTableau + "]";
    }



}