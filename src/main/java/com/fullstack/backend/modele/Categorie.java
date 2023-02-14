package com.fullstack.backend.modele;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Categorie extends AbstractEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idCategorie;
    @Column(name = "idBoutique")
    private Integer idBoutique;
    @ManyToMany
    @JoinTable( name = "Categorie_Produit_Associations",
            joinColumns = @JoinColumn( name = "idCategorie" ),
            inverseJoinColumns = @JoinColumn( name = "idProduit" ) )
    private Collection<Produit> produits = new ArrayList<>();
}
