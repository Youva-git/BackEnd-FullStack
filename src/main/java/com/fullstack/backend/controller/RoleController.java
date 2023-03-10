package com.fullstack.backend.controller;

import com.fullstack.backend.modele.AppRole;
import com.fullstack.backend.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fullstack.backend.utils.Constants.ENDPOINT_ROLE;
import static com.fullstack.backend.utils.Constants.ENDPOINT_ADD_NEW_ROLE;
import static com.fullstack.backend.utils.Constants.ENDPOINT_FIND_BY_NOM;


@Api(ENDPOINT_ROLE)
@RestController
@CrossOrigin("*")
@RequestMapping(ENDPOINT_ROLE)
public class RoleController {
    private final RoleService vRoleService;
    public RoleController(RoleService vRoleService) {
        this.vRoleService = vRoleService;
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(ENDPOINT_ADD_NEW_ROLE)
    public AppRole addNewRole(@RequestBody AppRole appRole){
        return vRoleService.addNewRole(appRole);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(ENDPOINT_FIND_BY_NOM)
    public AppRole findByNom(@RequestBody String roleName){
        return vRoleService.findByNom(roleName);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping()
    public List<AppRole> read(@RequestBody AppRole appRole){
        return vRoleService.listRoles();
    }
}
