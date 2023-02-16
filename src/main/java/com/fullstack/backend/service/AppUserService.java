package com.fullstack.backend.service;

import com.fullstack.backend.dto.ChangerMdpUserDto;
import com.fullstack.backend.dto.AppUserDto;
import com.fullstack.backend.exception.InvalidOperationException;
import com.fullstack.backend.modele.AppRole;

import java.security.Principal;
import java.util.List;

public interface AppUserService {
    AppUserDto addNewVendeur_Livreur(AppUserDto user);
    AppUserDto addNewAdmin(AppUserDto user);
    List<AppUserDto> read();
    AppUserDto findById(Integer id);
    AppUserDto findByEmail(String mail);
    AppUserDto update(Integer id, AppUserDto user);
    String delete(Integer id);
    AppUserDto ChangeMdp(ChangerMdpUserDto User) throws InvalidOperationException;
    String addRoleToUser(String email, String role);
    String changeRole(String email, String role);
    String addBoutiqueToUser(String email, Integer idBoutique);
    List<AppUserDto> pageUsers(int page, int size);
    List<AppUserDto> findByNom(String nom);
}