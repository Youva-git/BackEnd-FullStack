package com.fullstack.backend.controller;

import com.fullstack.backend.dto.CategorieDto;
import com.fullstack.backend.service.CategorieService;
import com.fullstack.backend.utils.modeleEndPoint.AssociationCategorieProduits;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.fullstack.backend.utils.Constants.*;

@Api(ENDPOINT_CATEGORIES)
@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping(ENDPOINT_CATEGORIES)
public class CategorieController {
    private final CategorieService vCategorieService;

    @ApiOperation(value = "Ajouter une catégorie.", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Catégorie ajoutée avec succès."),
            @ApiResponse(code = 400, message = "Catégorie non valide.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PostMapping()
    public CategorieDto create(@RequestBody CategorieDto categorie){
        return vCategorieService.create(categorie);
    }

    @ApiOperation(value = "Afficher toutes les categories de la BDD.", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des categories (Peut étre vide)."),
    })
    @GetMapping()
    public List<CategorieDto> read(){
        return vCategorieService.read();
    }

    @ApiOperation(value = "Mettre à jour une categorie avec son ID.", responseContainer = "List<CategorieDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorie mise à ajour avec succès."),
            @ApiResponse(code = 400, message = "Categorie non valide.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/{id}")
    public CategorieDto update(@PathVariable Integer id, @RequestBody CategorieDto categorie){
        return vCategorieService.update(id, categorie);
    }

    @ApiOperation(value = "Supprimer une categorie avec son ID.", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorie supprimée avec succès."),
            @ApiResponse(code = 404, message = "Cette categorie ne peut pas étre supprimée.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return vCategorieService.delete(id);
    }


    @ApiOperation(value = "Associer une catégorie à un ou plusieurs produits.", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succès."),
            @ApiResponse(code = 404, message = "Erreur.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PostMapping(ENDPOINT_ADD_CATEGORIE_PRODUITS)
    public String addCategorieToProduits(@RequestBody AssociationCategorieProduits IdCategoriesProduit){
        return vCategorieService.addCategorieToProduits(IdCategoriesProduit.getIdCategorie(), IdCategoriesProduit.getIdProduits());
    }

    @ApiOperation(value = "Rechercher une categorie avec son ID.", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorie trouvée dans la BDD."),
            @ApiResponse(code = 404, message = "Aucune categorie n'a été trouvée dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findById(@PathVariable Integer id){
        return vCategorieService.findById(id);
    }

    @ApiOperation(value = "Rechercher une categorie avec son NOM.", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorie trouvée dans la BDD."),
            @ApiResponse(code = 404, message = "Aucune categorie n'a été trouvée dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_NOM, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findByNom(@PathVariable String nom){
        return vCategorieService.findByNom(nom);
    }

    @ApiOperation(value = "Rechercher une categorie avec son IdBoutique.", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categorie trouvée dans la BDD."),
            @ApiResponse(code = 404, message = "Aucune categorie n'a été trouvée dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_ID_BOUTIQUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> findByIdBoutique(@PathVariable Integer idBoutique){
        return vCategorieService.findByIdBoutique(idBoutique);
    }

}
