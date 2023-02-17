package com.fullstack.backend.modele;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer idUser;
    @Column(length = 32)
    private String nom;
    @Column(length = 32)
    private String prenom;
    private String email;
    @JoinColumn(name = "mot_de_passe")
    private String mdp;
    @Column(name = "urlPhoto")
    private String urlPhoto;
    @OneToOne
    @JoinTable( name = "Users_Roles_Associations",
            joinColumns = @JoinColumn( name = "idUser" ),
            inverseJoinColumns = @JoinColumn( name = "idRole" ) )
    private AppRole appRoles;
    @OneToOne
    @JoinTable( name = "Users_boutique_Associations",
            joinColumns = @JoinColumn( name = "idUser" ),
            inverseJoinColumns = @JoinColumn( name = "idboutique" ) )
    private Boutique boutiques;
}
