package com.fullstack.backend.repository;

import com.fullstack.backend.modele.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByEmail(String email);
    List<AppUser> findByNom(String email);
}
