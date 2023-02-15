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
public class ProduitDto {
    private Integer id;
    private String nom;
    private String description;
    private String descriptionEN;
    private String codeProduit;
    private Date creationData;
    private Double prix;
    private String urlPhoto;
    private Integer idBoutique;
    private Collection<Categorie> categories = new ArrayList<>();

    public static ProduitDto fromEntity(Produit produit){
        if(produit == null){
            return null;
        }
        return ProduitDto.builder()
                .id(produit.getIdProduit())
                .nom(produit.getNom())
                .description(produit.getDescription())
                .descriptionEN(produit.getDescriptionEN())
                .codeProduit(produit.getCodeProduit())
                .prix(produit.getPrix())
                .idBoutique(produit.getIdBoutique())
                .categories(produit.getCategories())
                .urlPhoto(produit.getUrlPhoto())
                .build();
    }

    public static Produit toEntity(ProduitDto produitDto){
        if(produitDto == null){
            return null;
        }
        Produit vProduit = new Produit();
        vProduit.setIdProduit(produitDto.getId());
        vProduit.setNom(produitDto.getNom());
        vProduit.setDescription(produitDto.getDescription());
        vProduit.setDescriptionEN(produitDto.getDescriptionEN());
        vProduit.setCodeProduit(produitDto.getCodeProduit());
        vProduit.setCreationData(produitDto.getCreationData());
        vProduit.setPrix(produitDto.getPrix());
        vProduit.setIdBoutique(produitDto.getIdBoutique());
        vProduit.setCategories(produitDto.getCategories());
        vProduit.setUrlPhoto(produitDto.getUrlPhoto());
        return vProduit;
    }
}
