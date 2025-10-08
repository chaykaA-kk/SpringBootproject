package com.example.tableau.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tableau.entities.Artiste;
import com.example.tableau.entities.Tableau;
import com.example.tableau.repos.TableauRepository;

@Service
public class TableauServiceImpl implements TableauService {

    @Autowired
    TableauRepository tableauRepository;

    @Override
    public Tableau saveTableau(Tableau t) {
        return tableauRepository.save(t);
    }

    @Override
    public Tableau updateTableau(Tableau t) {
        return tableauRepository.save(t);
    }

    @Override
    public void deleteTableau(Tableau t) {
        tableauRepository.delete(t);
    }

    @Override
    public void deleteTableauById(Long id) {
        tableauRepository.deleteById(id);
    }

    @Override
    public Tableau getTableau(Long id) {
        return tableauRepository.findById(id).get();
    }

    @Override
    public List<Tableau> getAllTableaux() {
        return tableauRepository.findAll();
    }

    @Override
    public List<Tableau> findByNomTableau(String nom) {
        return tableauRepository.findByNomTableau(nom);
    }

    @Override
    public List<Tableau> findByNomTableauContains(String nom) {
        return tableauRepository.findByNomTableauContains(nom);
    }

    @Override
    public List<Tableau> findByNomPrix(String nom, Double prix) {
        return tableauRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Tableau> findByArtiste(Artiste artiste) {
        return tableauRepository.findByArtiste(artiste);
    }

    @Override
    public List<Tableau> findByArtisteIdArtiste(Long id) {
        return tableauRepository.findByArtisteIdArtiste(id);
    }

    @Override
    public List<Tableau> findByOrderByNomTableauAsc() {
        return tableauRepository.findByOrderByNomTableauAsc();
    }

    @Override
    public List<Tableau> trierTableauxNomsPrix() {
        return tableauRepository.trierTableauxNomsPrix();
    }
}