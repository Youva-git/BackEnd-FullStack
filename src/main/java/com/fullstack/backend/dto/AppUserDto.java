package com.fullstack.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fullstack.backend.modele.AppRole;
import com.fullstack.backend.modele.AppUser;
import com.fullstack.backend.modele.Boutique;
import lombok.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String mdp;
    private String urlPhoto;
    private Collection<AppRole> appRoles = new ArrayList<>();
    private Collection<Boutique> boutiques = new ArrayList<>();

    public static AppUserDto fromEntity(AppUser user){
        if(user == null){
            return null;
        }
        return AppUserDto.builder()
                .id(user.getIdUser())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .email(user.getEmail())
                .mdp(user.getMdp())
                .urlPhoto(user.getUrlPhoto())
                .appRoles(user.getAppRoles())
                .boutiques(user.getBoutiques())
                .build();
    }

    public static AppUser toEntity(AppUserDto userDto){
        if(userDto == null){
            return null;
        }
        AppUser vUser = new AppUser();
        vUser.setIdUser(userDto.getId());
        vUser.setNom(userDto.getNom());
        vUser.setPrenom(userDto.getPrenom());
        vUser.setEmail(userDto.getEmail());
        vUser.setMdp(userDto.getMdp());
        vUser.setUrlPhoto(userDto.getUrlPhoto());
        vUser.setAppRoles(userDto.getAppRoles());
        vUser.setBoutiques(userDto.getBoutiques());
        return vUser;
    }
}
