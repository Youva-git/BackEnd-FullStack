package com.fullstack.backend.service.impls;

import com.fullstack.backend.dto.CategorieDto;
import com.fullstack.backend.exception.EntityNotFoundException;
import com.fullstack.backend.exception.ErrorCodes;
import com.fullstack.backend.exception.InvalideEntityException;
import com.fullstack.backend.modele.Categorie;
import com.fullstack.backend.modele.Produit;
import com.fullstack.backend.repository.CategorieRepository;
import com.fullstack.backend.repository.ProduitRepository;
import com.fullstack.backend.service.CategorieService;
import com.fullstack.backend.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository vCategorieRepository;
    private final ProduitRepository vProduitRepository;

    public CategorieServiceImpl(CategorieRepository vCategorieRepository, ProduitRepository vProduitRepository) {
        this.vCategorieRepository = vCategorieRepository;
        this.vProduitRepository = vProduitRepository;
    }

    @Override
    public CategorieDto create(CategorieDto categorie) {
        List<String> errors = CategorieValidator.validate(categorie);
        if(errors.size() > 0){
            log.error("Categorie non valide !");
            throw new InvalideEntityException("La Categorie n'est pas valide !", ErrorCodes.PRODUIT_NOT_FOUND, errors);
        }
        return CategorieDto.fromEntity(vCategorieRepository.save(CategorieDto.toEntity(categorie)));
    }

    public List<CategorieDto> findByIdBoutique(Integer idBoutique){
        if(idBoutique == null){
            log.error("Id boutique null !");
            return null;
        }
        return vCategorieRepository.findByIdBoutique(idBoutique).stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategorieDto> read() {
        return vCategorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    public CategorieDto findById(Integer id){
        if(id == null){
            log.error("Categorie ID null !");
            return null;
        }
        Optional<Categorie> categorie = vCategorieRepository.findById(id);
        return Optional.of(CategorieDto.fromEntity(categorie.get()))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucune categorie porte l'ID = "+id+" dans la BDD",
                                ErrorCodes.CATEGORIE_NOT_FOND));
    }
    public CategorieDto findByNom(String nom){
        if(nom.isEmpty()){
            log.error("Code Categorie null !");
            return null;
        }
        Optional<Categorie> categorie = vCategorieRepository.findByNom(nom);
        return Optional.of(CategorieDto.fromEntity(categorie.get()))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucune Categorie porte le nom = "+nom+" dans la BDD",
                                ErrorCodes.CATEGORIE_NOT_FOND));
    }
    @Override
    public CategorieDto update(Integer id, CategorieDto categorie) {
        return CategorieDto.fromEntity(vCategorieRepository.findById(id)
                .map(c-> {
                    c.setNom(categorie.getNom());
                    c.setDescription(categorie.getDescription());
                    return vCategorieRepository.save(CategorieDto.toEntity(CategorieDto.fromEntity(c)));
                }).orElseThrow(() -> new RuntimeException("Categorie introvable !")));
    }

    @Override
    public String delete(Integer id) {
        vCategorieRepository.deleteById(id);
        return "Categorie supprim?? !";
    }

    @Override
    public String addCategorieToProduits(Integer idCategorie, Integer[] idProduits){
        Categorie vCategorie = CategorieDto.toEntity(findById(idCategorie));
        for(Integer idProduit : idProduits){
            Produit vProduit = vProduitRepository.findById(idProduit).get();
            if(vProduitRepository.findByIdProduitAndCategoriesIdCategorie(idProduit, idCategorie) == null){
                vProduit.getCategories().add(vCategorie);
            } else {
                log.warn("L'association existe d??j?? pour le produit "+ vProduit.getNom() +" !");
            }
        }
        return "Succ??s";
    }

    @Override
    public String addProduitToCategorie(Integer idCategorie, Integer idProduit){
        Categorie vCategorie = CategorieDto.toEntity(findById(idCategorie));
        Produit vProduit = vProduitRepository.findById(idProduit).get();
        vProduit.setIdBoutique(vCategorie.getIdBoutique());
        vCategorie.getProduits().add(vProduit);
        return "Produit ajout?? avec succ??s pour la boutique " + vCategorie.getNom() + " !";
    }
}
