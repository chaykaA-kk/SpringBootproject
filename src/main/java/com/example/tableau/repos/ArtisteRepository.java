package com.example.tableau.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tableau.entities.Artiste;

public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
}