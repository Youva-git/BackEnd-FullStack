package com.fullstack.backend.controller;

import com.fullstack.backend.dto.BoutiqueDto;
import com.fullstack.backend.dto.ProduitDto;
import com.fullstack.backend.modele.Boutique;
import com.fullstack.backend.service.BoutiqueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static com.fullstack.backend.utils.Constants.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


@Api(ENDPOINT_BOUTIQUTS)
@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping(ENDPOINT_BOUTIQUTS)
public class BoutiqueController {
    private final BoutiqueService vBoutiqueService;

    @ApiOperation(value = "Ajouter une boutique.", response = BoutiqueDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Boutique ajoutée avec succès."),
            @ApiResponse(code = 400, message = "Boutique non valide.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BoutiqueDto create(@RequestBody BoutiqueDto boutique){
        return vBoutiqueService.create(boutique);
    }


    @ApiOperation(value = "Afficher toutes les boutiques de la BDD.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des boutiques (Peut étre vide)."),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Boutique> read(@RequestParam(required = false) String sort,
                               @RequestParam(required = false) String conge,
                               @RequestParam(required = false) String dateAfter,
                               @RequestParam(required = false) String dateBefore) throws ParseException {
        return vBoutiqueService.filterBoutiques(sort, conge, dateAfter, dateBefore);
    }

    @ApiOperation(value = "Mettre à jour une boutique avec son ID.", responseContainer = "List<BoutiqueDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Boutique mise à ajour avec succès."),
            @ApiResponse(code = 400, message = "Boutique non valide.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BoutiqueDto update(@PathVariable Integer id, @RequestBody BoutiqueDto boutique){
        return vBoutiqueService.update(id, boutique);
    }

    @ApiOperation(value = "Supprimer une boutique avec son ID.", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Boutique supprimée avec succès."),
            @ApiResponse(code = 404, message = "Cette boutique ne peut pas étre supprimée.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return vBoutiqueService.delete(id);
    }

    @ApiOperation(value = "Rechercher un boutique avec son ID.", response = BoutiqueDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Boutique trouvée dans la BDD."),
            @ApiResponse(code = 404, message = "Aucun boutique n'a été trouvée dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    BoutiqueDto findById(@PathVariable Integer id){
        return vBoutiqueService.findById(id);
    }

    @ApiOperation(value = "Rechercher une boutique avec son NOM.", response = BoutiqueDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Boutique trouvée dans la BDD."),
            @ApiResponse(code = 404, message = "Aucune boutique n'a été trouvée dans la BDD.")
    })
    @GetMapping(value = ENDPOINT_FIND_BY_NOM, produces = MediaType.APPLICATION_JSON_VALUE)
    BoutiqueDto findByNom(@PathVariable String nom){
        return vBoutiqueService.findByNom(nom);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(ENDPOINT_ADD_USER_TO_BOUTIQUE)
    public String addUserToBoutique(@RequestBody String emailUser, @RequestBody Integer idBoutique){
        return vBoutiqueService.addUserToBoutique(emailUser, idBoutique);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PostMapping(ENDPOINT_ADD_CATEGORIE_TO_BOUTIQUE)
    public String addCategorieToBoutique(@RequestBody Integer idBoutique, @RequestBody Integer idCategorie){
        return vBoutiqueService.addCategorieToBoutique(idBoutique, idCategorie);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @PostMapping(ENDPOINT_ADD_PRODUIT_TO_BOUTIQUE)
    public String addProduitToBoutique(@RequestBody Integer idBoutique, @RequestBody Integer idProduit){
        return vBoutiqueService.addProduitToBoutique(idBoutique, idProduit);
    }

}
