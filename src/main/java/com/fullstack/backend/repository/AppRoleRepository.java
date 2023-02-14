package com.fullstack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fullstack.backend.modele.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer>{
    AppRole findByRoleName(String roleName);
}
