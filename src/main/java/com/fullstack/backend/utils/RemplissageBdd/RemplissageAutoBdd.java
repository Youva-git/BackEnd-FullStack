package com.fullstack.backend.utils.RemplissageBdd;
import com.fullstack.backend.dto.AppUserDto;
import com.fullstack.backend.dto.BoutiqueDto;
import com.fullstack.backend.dto.CategorieDto;
import com.fullstack.backend.dto.ProduitDto;
import com.fullstack.backend.modele.AppRole;
import com.fullstack.backend.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;
import java.util.List;

import static com.fullstack.backend.utils.RemplissageBdd.ListUsers.*;
import static com.fullstack.backend.utils.RemplissageBdd.ListBoutiques.*;
import static com.fullstack.backend.utils.RemplissageBdd.ListsCategories.*;
import static com.fullstack.backend.utils.RemplissageBdd.ListsProduits.*;

@Configuration
public class RemplissageAutoBdd {
    private final AppUserService vAppUserService;
    private final BoutiqueService vBoutiqueService;
    private final CategorieService vCategorieService;
    private final ProduitService vProduitService;
    private final RoleService vRoleService;

    public RemplissageAutoBdd(AppUserService vAppUserService, BoutiqueService vBoutiqueService,
                              CategorieService vCategorieService, ProduitService vProduitService, RoleService vRoleService) {
        this.vAppUserService = vAppUserService;
        this.vBoutiqueService = vBoutiqueService;
        this.vCategorieService = vCategorieService;
        this.vProduitService = vProduitService;
        this.vRoleService = vRoleService;
    }
    @Bean
    public void FillingUpBdd(){
        FillingUpBoutique();
        FillingUpCategories();
        FillingUpProduits();
        FillingUpUsers();
    }
    public void FillingUpBoutique(){
        for(BoutiqueDto b:LIST_BOUTIQUES){vBoutiqueService.create(b);}
    }
    public void FillingUpCategories(){
        List<String> vListNomBoutiques = Arrays.asList("phone", "Total Look", "Animalerie",
                "Youni", "Guao Jeux", "Fashion Style", "Zelfie Boutique", "Alexa Mode",
                "Double Tendance", "Diana Boutique", "Global Informatique", "Andro Fashion"
        );
        List<List<CategorieDto>> vListsCategories = Arrays.asList(LIST_CATEGORIE_PHONE, LIST_CATEGORIE_TOTAL_LOOK,
                LIST_CATEGORIE_ANIMALERIE, LIST_CATEGORIE_YOUNI, LIST_CATEGORIE_GUAO_JEUX,
                LIST_CATEGORIE_FASHION_STYLE, LIST_CATEGORIE_ALEXA_MODE, LIST_CATEGORIE_DOUBLE_TENDANCE,
                LIST_CATEGORIE_DIANA_BOUTIQUE, LIST_CATEGORIE_GLOBAL_INFORMATIQUE, LIST_CATEGORIE_ANDRO_FASHION
        );
        for(int i = 0; i < vListsCategories.size(); ++i){
            FillingUpCategorie(vListsCategories.get(i), vListNomBoutiques.get(i));
        }
    }
    public void FillingUpProduits(){
        List<List<ProduitDto>> vListsProduits= Arrays.asList(LIST_PRODUITS_SAMSUNG, LIST_PRODUIT_HAWAII,
                LIST_PRODUIT_CHAUSSEURS_HOMME, LIST_PRODUIT_CHAUSSEURS_FEMME, LIST_PRODUIT_ANIMAUX,
                LIST_PRODUIT_ACCESSOIRES_ANIMAUX, LIST_PRODUIT_BRICOLAGE_MAISON, LIST_PRODUIT_JEUX_VIDEO,
                LIST_PRODUIT_JOUETS, LIST_PRODUIT_AUTOMATIQUE, LIST_PRODUIT_MECANIQUE, LIST_PRODUIT_QUARTZ,
                LIST_PRODUIT_OR, LIST_PRODUIT_ARGENT, LIST_PRODUIT_ACCESSOIRES, LIST_PRODUIT_CUIR,
                LIST_PRODUIT_SEMILI_CUIR, LIST_PRODUIT_ORDINATEURS_PORTABLE, LIST_PRODUIT_ACCESSOIRE_INFORMATIQUE,
                LIST_PRODUIT_VETEMENTS_HOMME, LIST_PRODUIT_VETEMENTS_FEMME
        );
        List<String> vListNomBoutiquesPourProduit = Arrays.asList(
                "phone", "phone", "Total Look", "Total Look", "Animalerie", "Animalerie", "Youni", "Guao Jeux",
                "Guao Jeux", "Fashion Style", "Fashion Style", "Fashion Style", "Alexa Mode", "Alexa Mode",
                "Double Tendance", "Diana Boutique", "Diana Boutique", "Global Informatique", "Global Informatique",
                "Andro Fashion", "Andro Fashion"
        );
        List<String> vListsNomCategories = Arrays.asList(
                "Samsung", "Hawaii", "Chaussurs Homme", "Chaussurs Femme", "Animaux", "Accessoirs", "Bricolage maison",
                "Jeux vidéo", "Jouets", "Automatique", "Mécanique", "Quartz", "Or", "Argent", "Accessoires",
                "Cuir", "Simili cuir", "Ordinateurs Portable", "Accessoirs Informatique", "Vêtements Homme",
                "Vêtements Femme"
        );
        for(int i = 0; i < vListsProduits.size(); ++i){
            FillingUpProduit(vListsProduits.get(i), vListNomBoutiquesPourProduit.get(i), vListsNomCategories.get(i));
        }
    }
    private void FillingUpCategorie(List<CategorieDto> listCategories, String nomBoutique){
        for(CategorieDto c:listCategories){
            CategorieDto ct = vCategorieService.create(c);
            vBoutiqueService.addCategorieToBoutique(
                    vBoutiqueService.findByNom(nomBoutique).getId(),
                    ct.getId()
            );
        }
    }
    private void FillingUpProduit(List<ProduitDto> listProduits, String nomBoutique, String nomCategorie){
        for(ProduitDto p:listProduits){
            ProduitDto pr = vProduitService.create(p);
            vCategorieService.addProduitToCategorie(
                    vCategorieService.findByNom(nomCategorie).getId(),
                    pr.getId()
            );
            vBoutiqueService.addProduitToBoutique(
                    vBoutiqueService.findByNom(nomBoutique).getId(),
                    pr.getId()
            );
        }
    }
    public void FillingUpUsers(){
        for(AppRole r:LIST_ROLES){
            vRoleService.addNewRole(r);
        }
        for(AppUserDto u:LIST_ADMINS){
            vAppUserService.addNewAdmin(u);
        }
        for(AppUserDto u:LIST_VENDEUR_LIVREUR){
            vAppUserService.addNewVendeur_Livreur(u);
        }
        AddBoutiquesToUsers();
    }
    private void AddBoutiquesToUsers(){
        vAppUserService.addBoutiqueToUser("alice.bob@gmail.com", 1);
        vAppUserService.addBoutiqueToUser("david.lee@gmail.com", 2);
        vAppUserService.addBoutiqueToUser("emily.smith@gmail.com", 5);
        vAppUserService.addBoutiqueToUser("michael.johnson@gmail.com", 9);
        vAppUserService.addBoutiqueToUser("samantha.brown@gmail.com", 11);

        vBoutiqueService.addUserToBoutique("alice.bob@gmail.com", 1);
        vBoutiqueService.addUserToBoutique("alice.bob@gmail.com", 3);
        vBoutiqueService.addUserToBoutique("alice.bob@gmail.com", 4);

        vBoutiqueService.addUserToBoutique("david.lee@gmail.com", 2);
        vBoutiqueService.addUserToBoutique("david.lee@gmail.com", 6);
        vBoutiqueService.addUserToBoutique("david.lee@gmail.com", 8);

        vBoutiqueService.addUserToBoutique("emily.smith@gmail.com", 5);
        vBoutiqueService.addUserToBoutique("emily.smith@gmail.com", 7);

        vBoutiqueService.addUserToBoutique("michael.johnson@gmail.com", 9);
        vBoutiqueService.addUserToBoutique("michael.johnson@gmail.com", 10);

        vBoutiqueService.addUserToBoutique("samantha.brown@gmail.com", 11);
        vBoutiqueService.addUserToBoutique("samantha.brown@gmail.com", 12);
    }
}
