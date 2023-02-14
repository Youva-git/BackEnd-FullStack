package com.fullstack.backend.service;

import com.fullstack.backend.modele.AppRole;

import java.util.List;

public interface RoleService {
    AppRole addNewRole(AppRole appRole);

    List<AppRole> listRoles();

    AppRole findByNom(String nomRole);

}