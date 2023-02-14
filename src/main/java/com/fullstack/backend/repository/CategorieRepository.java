package com.fullstack.backend.repository;

import com.fullstack.backend.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findByNom(String nom);
    Optional<Categorie> findByIdBoutique(Integer idBoutique);
    Categorie findByIdCategorie(Integer idCategorie);

}
