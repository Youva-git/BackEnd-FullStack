package com.fullstack.backend.repository;

import com.fullstack.backend.modele.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface BoutiqueRepository extends JpaRepository<Boutique, Integer> {
    Optional<Boutique> findByNom(String nom);
    List<Boutique> findByOrderByNom();
    List<Boutique> findByOrderByCreationData();
    @Query("SELECT b FROM Boutique b ORDER BY b.produits.size DESC")
    List<Boutique> findByOrderByProduits();

}
