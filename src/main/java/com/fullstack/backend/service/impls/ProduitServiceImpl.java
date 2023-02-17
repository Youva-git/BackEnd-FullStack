package com.fullstack.backend.service.impls;

import com.fullstack.backend.dto.CategorieDto;
import com.fullstack.backend.dto.ProduitDto;
import com.fullstack.backend.exception.EntityNotFoundException;
import com.fullstack.backend.modele.Categorie;
import com.fullstack.backend.modele.Produit;
import com.fullstack.backend.exception.ErrorCodes;
import com.fullstack.backend.exception.InvalideEntityException;
import com.fullstack.backend.repository.CategorieRepository;
import com.fullstack.backend.repository.ProduitRepository;
import com.fullstack.backend.service.ProduitService;
import com.fullstack.backend.validator.ProduitValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository vProduitRepository;
    private final CategorieRepository vCategorieRepository;

    public ProduitServiceImpl(ProduitRepository vProduitRepository, CategorieRepository vCategorieRepository) {
        this.vProduitRepository = vProduitRepository;
        this.vCategorieRepository = vCategorieRepository;
    }

    @Override
    public ProduitDto create(ProduitDto produit) {
        List<String> errors = ProduitValidator.validate(produit);
        if(errors.size() > 0){
            log.error("Produit non valide !", produit);
            throw new InvalideEntityException("Le Produit n'est pas valide !", ErrorCodes.PRODUIT_NOT_FOUND, errors);
        }
        return ProduitDto.fromEntity(vProduitRepository.save(ProduitDto.toEntity(produit)));
    }

    public ProduitDto findById(Integer id){
        if(id == null){
            log.error("Produit ID null !");
            return null;
        }
        Optional<Produit> produit = vProduitRepository.findById(id);
        return Optional.of(ProduitDto.fromEntity(produit.get()))
                .orElseThrow(() -> new EntityNotFoundException
                ("Aucun produit porte l'ID = "+id+" dans la BDD",
                        ErrorCodes.PRODUIT_NOT_FOUND));
    }
    public ProduitDto findByCodeProduit(String codeProduit){
        if(codeProduit.isEmpty()){
            log.error("Code produit null !");
            return null;
        }
        Optional<Produit> produit = vProduitRepository.findByCodeProduit(codeProduit);
        return Optional.of(ProduitDto.fromEntity(produit.get()))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucun produit porte le code = "+codeProduit+" dans la BDD",
                                ErrorCodes.PRODUIT_NOT_FOUND));
    }

    public ProduitDto findByNom(String nom){
        if(nom.isEmpty()){
            log.error("Code produit null !");
            return null;
        }
        Optional<Produit> produit = vProduitRepository.findByNom(nom);
        return Optional.of(ProduitDto.fromEntity(produit.get()))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucun produit porte le code = "+nom+" dans la BDD",
                                ErrorCodes.PRODUIT_NOT_FOUND));
    }

    public List<ProduitDto> findByIdBoutique(Integer idBoutique){
        return vProduitRepository.findByIdBoutique(idBoutique).stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduitDto> read() {
        return vProduitRepository.findAll().stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDto update(Integer id, ProduitDto produit) {
        return ProduitDto.fromEntity(vProduitRepository.findById(id)
                .map(p-> {
                    p.setNom(produit.getNom());
                    p.setDescription(produit.getDescription());
                    p.setDescription(produit.getDescriptionEN());
                    p.setPrix(produit.getPrix());
                    return vProduitRepository.save(ProduitDto.toEntity(ProduitDto.fromEntity(p)));
                })
                .orElseThrow(() -> new RuntimeException("Produit introvable !")));
    }

    @Override
    public String delete(Integer id) {
        if(id == null){
            log.error("Produit ID null !");
            return null;
        }
        vProduitRepository.deleteById(id);
        return "Produit supprimé !";
    }

    @Override
    public List<ProduitDto> filterProduits(Integer idBoutique, Integer idCategorie) {
        List<Produit> vProduits;
        if (idBoutique != null && idCategorie != null){
            vProduits = vProduitRepository.findByCategoriesIdCategorieAndIdBoutique(idCategorie, idBoutique);

        } else if (idCategorie != null){
            vProduits = vProduitRepository.findByCategoriesIdCategorie(idCategorie);
        } else if (idBoutique != null){
            vProduits = vProduitRepository.findByIdBoutique(idBoutique);
        }
        else
         vProduits = vProduitRepository.findAll();

        return vProduits.stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public String addCategoriesToProduit(Integer[] idCategories, Integer idProduit){
        Produit vProduit = vProduitRepository.findById(idProduit).get();
        for(Integer idCategorie : idCategories){
            Categorie vCategorie = vCategorieRepository.findById(idCategorie).get();
            if(vProduitRepository.findByIdProduitAndCategoriesIdCategorie(idProduit, idCategorie) == null){
                vProduit.getCategories().add(vCategorie);
                vProduitRepository.save(vProduit);
            } else {
                log.warn("L'association existe déjà pour la categorie "+ vCategorie.getNom() +" !");
            }
        }
        return "Succès";
    }
}
