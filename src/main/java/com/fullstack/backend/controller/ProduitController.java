package com.fullstack.backend.controller;

import com.fullstack.backend.dto.CategorieDto;
import com.fullstack.backend.dto.ProduitDto;
import com.fullstack.backend.service.ProduitService;
import com.fullstack.backend.utils.modeleEndPoint.AssociationCategoriesProduit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static com.fullstack.backend.utils.Constants.*;
import java.util.List;

@Api(ENDPOINT_PRODUITS)
@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping(ENDPOINT_PRODUITS)
public class ProduitController {

    private final ProduitService vProduitService;

    @ApiOperation(value = "Ajouter un produit.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produit ajouté avec succès."),
            @ApiResponse(code = 400, message = "Produit non valide.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProduitDto create(@RequestBody ProduitDto produit){
        return vProduitService.create(produit);
    }

    @ApiOperation(value = "Afficher tous les produit de la BDD.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des produits (Peut étre vide)."),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProduitDto> read(@RequestParam(required = false) Integer idBoutique,
                                 @RequestParam(required = false) Integer idCategorie){
        return vProduitService.filterProduits(idBoutique, idCategorie);
    }

    @ApiOperation(value = "Mettre à jour un produit avec son ID.", responseContainer = "List<ProduitDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produit mis à ajour avec succès."),
            @ApiResponse(code = 400, message = "Produit non valide.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProduitDto update(@PathVariable Integer id, @RequestBody ProduitDto produit){
        return vProduitService.update(id, produit);
    }

    @ApiOperation(value = "Supprimer un produit avec son ID.", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produit supprimé avec succès."),
            @ApiResponse(code = 404, message = "Ce produit ne peut pas étre supprimé.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Integer id){
        return vProduitService.delete(id);
    }


    @ApiOperation(value = "Rechercher un produit avec son ID.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produit trouvé dans la BDD."),
            @ApiResponse(code = 404, message = "Aucun produit n'a été trouvé dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto findById(@PathVariable Integer id){
        return vProduitService.findById(id);
    }

    @ApiOperation(value = "Rechercher un produit avec son CODE.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produit trouvé dans la BDD."),
            @ApiResponse(code = 404, message = "Aucun produit n'a été trouvé dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_CODE_PRODUIT, produces = MediaType.APPLICATION_JSON_VALUE)
    ProduitDto findByCodeProduit(@PathVariable String codeProduit){
        return vProduitService.findByCodeProduit(codeProduit);
    }

    @ApiOperation(value = "Rechercher un produit avec son CODE.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produit trouvé dans la BDD."),
            @ApiResponse(code = 404, message = "Aucun produit n'a été trouvé dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_ID_BOUTIQUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProduitDto> findByIdBoutique(@PathVariable Integer idBoutique){
        return vProduitService.findByIdBoutique(idBoutique);
    }

    @ApiOperation(value = "Rechercher un produit avec son NOM.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produit trouvé dans la BDD."),
            @ApiResponse(code = 404, message = "Aucun produit n'a été trouvé dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_NOM, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProduitDto findByNom(@PathVariable String nom){
        return vProduitService.findByCodeProduit(nom);
    }

    @ApiOperation(value = "Associer une ou plusieurs catégories à un produit.", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succès."),
            @ApiResponse(code = 404, message = "Erreur.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PostMapping(ENDPOINT_ADD_CATEGORIES_PRODUIT)
    public String addCategoriesToProduit(@RequestBody AssociationCategoriesProduit idCateoriesProduit){
        return vProduitService.addCategoriesToProduit(idCateoriesProduit.getIdCategories(), idCateoriesProduit.getIdProduit());
    }
}
