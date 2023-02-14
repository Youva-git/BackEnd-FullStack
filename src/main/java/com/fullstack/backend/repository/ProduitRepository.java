package com.fullstack.backend.repository;

import com.fullstack.backend.modele.Categorie;
import com.fullstack.backend.modele.Produit;
import com.fullstack.backend.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    Optional<Produit> findByCodeProduit(String codeProduit);
    Optional<Produit> findByNom(String nom);
    List<Produit> findByIdBoutique(Integer idBoutique);
    List<Produit> findByCategoriesIdCategorie(Integer idCategorie);
    List<Produit> findByCategoriesIdCategorieAndIdBoutique(Integer idCategorie, Integer idBoutique);
}
