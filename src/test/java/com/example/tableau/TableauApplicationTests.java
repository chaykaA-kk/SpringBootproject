package com.example.tableau;

import java.util.Date;
import java.util.List;

import com.example.tableau.entities.Artiste;
import com.example.tableau.repos.ArtisteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.tableau.entities.Tableau;
import com.example.tableau.repos.TableauRepository;
import com.example.tableau.service.TableauService;

@SpringBootTest
class TableauApplicationTests {

    @Autowired
    private TableauService tableauService;
    @Autowired
    private ArtisteRepository artisteRepository;
    @Autowired
    private TableauRepository tableauRepository;

    @Test
    public void testCreateTableau() {
        Tableau tab = new Tableau("La Nuit étoilée", 3500000.0, new Date());
        tableauService.saveTableau(tab);
        System.out.println("Tableau créé via Service : " + tab);

        Tableau tab2 = new Tableau("Mona Lisa", 5000000.0, new Date());
        tableauService.saveTableau(tab2);
        System.out.println("Tableau créé : " + tab2);
    }

    @Test
    public void testFindTableau() {
        Tableau t = tableauRepository.findById(1L).get();
        System.out.println(t);
    }

    @Test
    public void testUpdateTableau() {
        Tableau t = tableauRepository.findById(1L).get();
        t.setPrixTableau(4000000.0);
        tableauRepository.save(t);
        System.out.println("Tableau mis à jour : " + t);
    }

    @Test
    public void testDeleteTableau() {
        tableauRepository.deleteById(1L);
        System.out.println("Tableau supprimé");
    }

    @Test
    public void testListerTousTableaux() {
        List<Tableau> tableaux = tableauRepository.findAll();
        for (Tableau t : tableaux) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByNomTableau() {
        List<Tableau> tableaux = tableauRepository.findByNomTableau("Mona Lisa");
        for (Tableau t : tableaux) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByNomTableauContains() {
        List<Tableau> tableaux = tableauRepository.findByNomTableauContains("Nuit");
        for (Tableau t : tableaux) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByArtiste() {
        Artiste artiste = new Artiste();
        artiste.setIdArtiste(1L);
        List<Tableau> tableaux = tableauRepository.findByArtiste(artiste);
        for (Tableau t : tableaux) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByArtisteIdArtiste() {
        List<Tableau> tableaux = tableauRepository.findByArtisteIdArtiste(1L);
        for (Tableau t : tableaux) {
            System.out.println(t);
        }
    }

    @Test
    public void testFindByOrderByNomTableauAsc() {
        List<Tableau> tableaux = tableauRepository.findByOrderByNomTableauAsc();
        for (Tableau t : tableaux) {
            System.out.println(t);
        }
    }

    @Test
    public void testTrierTableauxNomsPrix() {
        List<Tableau> tableaux = tableauRepository.trierTableauxNomsPrix();
        for (Tableau t : tableaux) {
            System.out.println(t);
        }
    }

    @Test
    public void testCreerDonneesCompletes() {
        // Créer des artistes
        Artiste picasso = new Artiste();
        picasso.setNomArtiste("Pablo Picasso");
        picasso.setNationalite("Espagnol");
        artisteRepository.save(picasso);

        Artiste vanGogh = new Artiste();
        vanGogh.setNomArtiste("Vincent van Gogh");
        vanGogh.setNationalite("Néerlandais");
        artisteRepository.save(vanGogh);

        Artiste daVinci = new Artiste();
        daVinci.setNomArtiste("Leonardo da Vinci");
        daVinci.setNationalite("Italien");
        artisteRepository.save(daVinci);

        // Créer des tableaux
        Tableau t1 = new Tableau("La Nuit étoilée", 3500000.0, new Date());
        t1.setArtiste(vanGogh);
        tableauRepository.save(t1);

        Tableau t2 = new Tableau("Mona Lisa", 850000000.0, new Date());
        t2.setArtiste(daVinci);
        tableauRepository.save(t2);

        Tableau t3 = new Tableau("Guernica", 200000000.0, new Date());
        t3.setArtiste(picasso);
        tableauRepository.save(t3);

        System.out.println("Données créées avec succès !");
    }
}