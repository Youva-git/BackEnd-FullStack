package com.fullstack.backend.controller;

import com.fullstack.backend.dto.ProduitDto;
import com.fullstack.backend.dto.AppUserDto;
import com.fullstack.backend.modele.RoleUserFrom;
import com.fullstack.backend.service.AppUserService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import static com.fullstack.backend.utils.Constants.*;

@Api(ENDPOINT_USERS)
@RestController
@CrossOrigin("*")
@RequestMapping(ENDPOINT_USERS)
public class UserController {
    private final AppUserService vUserService;

    public UserController(AppUserService vUserService) {
        this.vUserService = vUserService;
    }

    @ApiOperation(value = "Ajouter un utilisateur avec comme role VENDEUR_LIVREUR.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur ajouté avec succès."),
            @ApiResponse(code = 400, message = "utilisateur non valide.")
    })
    @PostMapping(ENDPOINT_ADD_MANAGER)
    public AppUserDto addNewVendeur_Livreur(@RequestBody AppUserDto user){
        return vUserService.addNewVendeur_Livreur(user);
    }
    @ApiOperation(value = "Ajouter un utilisateur ADMIN.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur ajouté avec succès."),
            @ApiResponse(code = 400, message = "utilisateur non valide.")
    })
    @PostMapping(ENDPOINT_ADD_ADMIN)
    public AppUserDto addNewAdmin(@RequestBody AppUserDto user){
        return vUserService.addNewAdmin(user);
    }

    @ApiOperation(value = "Afficher tous les utilisateurs de la BDD.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des utilisateurs (Peut étre vide)."),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping()
    public List<AppUserDto> read(){
        return vUserService.read();
    }

    @ApiOperation(value = "Mettre à jour un utilisateur avec son ID.", responseContainer = "List<UserDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur mis à ajour avec succès."),
            @ApiResponse(code = 400, message = "utilisateur non valide.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/{id}")
    public AppUserDto update(@PathVariable Integer id, @RequestBody AppUserDto user){
        return vUserService.update(id, user);
    }

    @ApiOperation(value = "Supprimer un utilisateur avec son ID.", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur supprimé avec succès."),
            @ApiResponse(code = 404, message = "Cette utilisateur ne peut pas étre supprimé.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){return vUserService.delete(id);}

    @ApiOperation(value = "Rechercher un utilisateur avec son MAIL.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur trouvé dans la BDD."),
            @ApiResponse(code = 403, message = "Autorisations manquantes."),
            @ApiResponse(code = 404, message = "Aucun utilisateur n'a été trouvé dans la BDD.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(value = ENDPOINT_FIND_BY_EMAIL, produces = MediaType.APPLICATION_JSON_VALUE)
    AppUserDto findByEmail(@PathVariable String email){
        return vUserService.findByEmail(email);
    }

    @ApiOperation(value = "Rechercher un utilisateur avec son ID.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur trouvé dans la BDD."),
            @ApiResponse(code = 404, message = "Aucun utilisateur n'a été trouvé dans la BDD.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(value = ENDPOINT_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    AppUserDto findById(@PathVariable Integer id){
        return vUserService.findById(id);
    }

    @ApiOperation(value = "Ajouter un role a un utilisateur.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Role ajouté avec succés."),
            @ApiResponse(code = 404, message = "Aucun utilisateur/role n'a été trouvé dans la BDD.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(ENDPOINT_ADD_ROLE_TO_USER)
    public String addRoleToUser(@RequestBody RoleUserFrom roleUserFrom){
        return vUserService.addRoleToUser(roleUserFrom.getEmail(), roleUserFrom.getRoleName());
    }

    @ApiOperation(value = "Afficher tous les utilisateurs de la BDD avec pagination.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des utilisateurs (Peut étre vide)."),
    })
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(ENDPOINT_PAGE_USER)
    public List<AppUserDto> pageUsers(@RequestParam(name="page", defaultValue = "0") int page,
                                       @RequestParam(name="size", defaultValue = "6") int size){
        return vUserService.pageUsers(page, size);
    }

    @ApiOperation(value = "Consulter le profile de l'utilisateur courant.", response = ProduitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Profile Utilisateur."),
            @ApiResponse(code = 404, message = "Profile Indisponible.")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VENDEUR_LIVREUR')")
    @GetMapping(ENDPOINT_PROFILE_USER)
    public AppUserDto profileUser(Principal principal){
        return vUserService.findByEmail(principal.getName());
    }

}
