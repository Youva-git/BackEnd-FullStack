package com.fullstack.backend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fullstack.backend.modele.Boutique;
import com.fullstack.backend.modele.Categorie;
import com.fullstack.backend.modele.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoutiqueDto {
    private Integer id;
    private String user;
    private String nom;
    private String description;
    private Date creationData;
    private String horaire;
    private Boolean conge;
    private Integer idUser;
    private Collection<Categorie> categories = new ArrayList<>();
    private Collection<Produit> produits = new ArrayList<>();
    public static BoutiqueDto fromEntity(Boutique boutique){
        if(boutique == null){
            return null;
        }
        return BoutiqueDto.builder()
                .id(boutique.getIdBoutique())
                .nom(boutique.getNom())
                .description(boutique.getDescription())
                .creationData(boutique.getCreationData())
                .horaire(boutique.getHoraire())
                .conge(boutique.getConge())
                .categories(boutique.getCategories())
                .produits(boutique.getProduits())
                .user(boutique.getUser())
                .idUser(boutique.getIdUser())
                .build();
    }

    public static Boutique toEntity(BoutiqueDto boutiqueDto){
        if(boutiqueDto == null){
            return null;
        }
        Boutique vBoutique = new Boutique();
        vBoutique.setIdBoutique(boutiqueDto.getId());
        vBoutique.setNom(boutiqueDto.getNom());
        vBoutique.setDescription(boutiqueDto.getDescription());
        vBoutique.setCreationData(boutiqueDto.getCreationData());
        vBoutique.setHoraire(boutiqueDto.getHoraire());
        vBoutique.setConge(boutiqueDto.getConge());
        vBoutique.setCategories(boutiqueDto.getCategories());
        vBoutique.setProduits(boutiqueDto.getProduits());
        vBoutique.setUser(boutiqueDto.getUser());
        vBoutique.setIdUser(boutiqueDto.getIdUser());
        return vBoutique;
    }
}
