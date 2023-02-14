package com.fullstack.backend.modele;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Produit extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idProduit;
    @Column(name = "codeProduit", nullable = false)
    private String codeProduit;
    @Column(name = "prix", nullable = false)
    private Double prix;
    @Column(name = "idBoutique")
    private Integer idBoutique;
    @ManyToMany
    @JoinTable( name = "Produit_Categorie_Associations",
            joinColumns = @JoinColumn( name = "idProduit" ),
            inverseJoinColumns = @JoinColumn( name = "idCategorie" ) )
    private Collection<Categorie> categories = new ArrayList<>();
}
