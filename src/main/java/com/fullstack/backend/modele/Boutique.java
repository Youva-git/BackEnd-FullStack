package com.fullstack.backend.modele;

import lombok.*;


import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Boutique extends AbstractEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idBoutique;
    @Column(columnDefinition = "TEXT")
    private String horaire;
    private Boolean conge;
    @Column(name = "user")
    private String user;
    @Column(name = "idUser")
    private Integer idUser;
    @OneToMany
    @JoinTable( name = "Boutique_CategorieAssociations",
            joinColumns = @JoinColumn( name = "idBoutique" ),
            inverseJoinColumns = @JoinColumn( name = "idCategorie" ) )
    private Collection<Categorie> categories = new ArrayList<>();
    @OneToMany
    @JoinTable( name = "Boutique_Produit_Associations",
            joinColumns = @JoinColumn( name = "idBoutique" ),
            inverseJoinColumns = @JoinColumn( name = "idProduit" ) )
    private Collection<Produit> produits = new ArrayList<>();

}
