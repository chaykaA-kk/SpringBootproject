package com.example.tableau.repos;

import java.util.List;

import com.example.tableau.entities.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.tableau.entities.Tableau;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path = "rest")
public interface TableauRepository extends JpaRepository<Tableau, Long> {

    // Recherche exacte par nom
    List<Tableau> findByNomTableau(String nom);

    // Recherche avec "contains" (cherche si le nom contient le texte)
    List<Tableau> findByNomTableauContains(String nom);

    @Query("select t from Tableau t where t.nomTableau like %:nom and t.prixTableau > :prix")
    List<Tableau> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    // Recherche par objet Artiste
    @Query("select t from Tableau t where t.artiste = ?1")
    List<Tableau> findByArtiste(Artiste artiste);

    // Recherche par ID de l'artiste
    List<Tableau> findByArtisteIdArtiste(Long id);

    // Tri ascendant par nom
    List<Tableau> findByOrderByNomTableauAsc();

    // Tri par nom ASC et prix DESC
    @Query("select t from Tableau t order by t.nomTableau ASC, t.prixTableau DESC")
    List<Tableau> trierTableauxNomsPrix();




}