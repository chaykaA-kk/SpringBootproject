package com.example.tableau.service;

import java.util.List;

import com.example.tableau.entities.Artiste;
import com.example.tableau.entities.Tableau;

public interface TableauService {
    Tableau saveTableau(Tableau t);
    Tableau updateTableau(Tableau t);
    void deleteTableau(Tableau t);
    void deleteTableauById(Long id);
    Tableau getTableau(Long id);
    List<Tableau> getAllTableaux();
    List<Tableau> findByNomTableau(String nom);
    List<Tableau> findByNomTableauContains(String nom);
    List<Tableau> findByNomPrix(String nom, Double prix);
    List<Tableau> findByArtiste(Artiste artiste);
    List<Tableau> findByArtisteIdArtiste(Long id);
    List<Tableau> findByOrderByNomTableauAsc();
    List<Tableau> trierTableauxNomsPrix();

}