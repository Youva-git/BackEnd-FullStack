package com.fullstack.backend.service;

import com.fullstack.backend.dto.AppUserDto;
import com.fullstack.backend.dto.BoutiqueDto;
import com.fullstack.backend.modele.Boutique;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface BoutiqueService {
    BoutiqueDto  create(BoutiqueDto boutique);
    List<BoutiqueDto> read();
    BoutiqueDto findById(Integer id);
    BoutiqueDto findByNom(String nom);
    BoutiqueDto update(Integer id, BoutiqueDto boutique);
    String delete(Integer id);
    String addUserToBoutique(String emailUser, Integer idBoutique);
    List<BoutiqueDto> pageBoutique(int page, int size);
    String addProduitToBoutique(Integer idBoutique, Integer idProduit);
    List<Boutique> filterBoutiques(String sort, String conge, String dateAfter, String dateBefore) throws ParseException;
}
