package com.fullstack.backend.dto;

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
public class CategorieDto {
    private Integer id;
    private String nom;
    private String description;
    private Date creationData;
    private String codeCategorie;
    private Collection<Produit> produits = new ArrayList<>();
    private Integer idBoutique;


    public static CategorieDto fromEntity(Categorie categorie){
        if(categorie == null){
            return null;
        }
        return CategorieDto.builder()
                .id(categorie.getIdCategorie())
                .nom(categorie.getNom())
                .description(categorie.getDescription())
                .creationData(categorie.getCreationData())
                .idBoutique(categorie.getIdBoutique())
                .produits(categorie.getProduits())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto){
        if(categorieDto == null){
            return null;
        }
        Categorie vCategorie = new Categorie();
        vCategorie.setIdCategorie(categorieDto.getId());
        vCategorie.setNom(categorieDto.getNom());
        vCategorie.setDescription(categorieDto.getDescription());
        vCategorie.setCreationData(categorieDto.getCreationData());
        vCategorie.setIdBoutique(categorieDto.getIdBoutique());
        vCategorie.setProduits(categorieDto.getProduits());
        return vCategorie;
    }
}
