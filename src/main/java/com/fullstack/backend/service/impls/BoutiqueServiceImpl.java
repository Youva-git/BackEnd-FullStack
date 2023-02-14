package com.fullstack.backend.service.impls;

import com.fullstack.backend.dto.BoutiqueDto;
import com.fullstack.backend.exception.EntityNotFoundException;
import com.fullstack.backend.exception.ErrorCodes;
import com.fullstack.backend.exception.InvalideEntityException;
import com.fullstack.backend.modele.AppUser;
import com.fullstack.backend.modele.Boutique;
import com.fullstack.backend.modele.Categorie;
import com.fullstack.backend.modele.Produit;
import com.fullstack.backend.repository.AppUserRepository;
import com.fullstack.backend.repository.BoutiqueRepository;
import com.fullstack.backend.repository.CategorieRepository;
import com.fullstack.backend.repository.ProduitRepository;
import com.fullstack.backend.service.BoutiqueService;
import com.fullstack.backend.validator.BoutiqueValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class BoutiqueServiceImpl implements BoutiqueService {

    private final BoutiqueRepository vBoutiqueRepository;
    private final CategorieRepository vCategorieRepository;
    private final ProduitRepository vProduitRepository;

    private final AppUserRepository vUserRepository;

    public BoutiqueServiceImpl(BoutiqueRepository vBoutiqueRepository, CategorieRepository vCategorieRepository,
                               ProduitRepository vProduitRepository, AppUserRepository vUserRepository) {
        this.vBoutiqueRepository = vBoutiqueRepository;
        this.vCategorieRepository = vCategorieRepository;
        this.vProduitRepository = vProduitRepository;
        this.vUserRepository = vUserRepository;
    }

    @Override
    public BoutiqueDto create(BoutiqueDto boutique) {
        List<String> errors = BoutiqueValidator.validate(boutique);
        if(errors.size() > 0){
            log.error("Boutique non valide !", boutique);
            throw new InvalideEntityException("La Boutique n'est pas valide !", ErrorCodes.PRODUIT_NOT_FOUND, errors);
        }
        return BoutiqueDto.fromEntity(vBoutiqueRepository.save(BoutiqueDto.toEntity(boutique)));
    }

    @Override
    public List<BoutiqueDto> read() {
        return vBoutiqueRepository.findAll().stream()
                .map(BoutiqueDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BoutiqueDto findById(Integer id){
        if(id == null){
            log.error("Boutique ID null !");
            return null;
        }
        Optional<Boutique> boutique = vBoutiqueRepository.findById(id);
        return Optional.of(BoutiqueDto.fromEntity(boutique.get()))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucune Boutique porte l'ID = "+id+" dans la BDD",
                                ErrorCodes.BOUTIQUE_NOT_FOUND));
    }

    @Override
    public BoutiqueDto findByNom(String nom){
        if(nom.isEmpty()){
            log.error("Nom de la Boutique null !");
            return null;
        }
        Optional<Boutique> boutique = vBoutiqueRepository.findByNom(nom);
        return Optional.of(BoutiqueDto.fromEntity(boutique.get()))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucune Boutique porte le nom = "+nom+" dans la BDD",
                                ErrorCodes.BOUTIQUE_NOT_FOUND));
    }

    @Override
    public BoutiqueDto update(Integer id, BoutiqueDto boutique) {
        return BoutiqueDto.fromEntity(vBoutiqueRepository.findById(id)
                .map(b-> {
                    b.setNom(boutique.getNom());
                    b.setDescription(boutique.getDescription());
                    b.setHoraire(boutique.getHoraire());
                    b.setConge(boutique.getConge());
                    return vBoutiqueRepository.save(BoutiqueDto.toEntity(BoutiqueDto.fromEntity(b)));
                }).orElseThrow(() -> new RuntimeException("Boutique introvable !")));
    }

    @Override
    public String delete(Integer id) {
        vBoutiqueRepository.deleteById(id);
        return "Boutique supprimé !";
    }
    @Override
    public String addUserToBoutique(String emailUser, Integer idBoutique){
        Boutique vBoutique = BoutiqueDto.toEntity(findById(idBoutique));
        AppUser vUser = vUserRepository.findByEmail(emailUser).get();
        vBoutique.setUser(vUser.getPrenom()+" "+vUser.getNom());
        vBoutiqueRepository.save(vBoutique);
        return "Utilisateur ajouté avec succés pour la boutique " + vBoutique.getNom() + " !";
    }

    @Override
    public String addCategorieToBoutique(Integer idBoutique, Integer idCategorie){
        Boutique vBoutique = BoutiqueDto.toEntity(findById(idBoutique));
        Categorie vCategorie = vCategorieRepository.findById(idCategorie).get();
        vCategorie.setIdBoutique(vBoutique.getIdBoutique());
        vBoutique.getCategories().add(vCategorie);
        return "Categorie ajoutée avec succés pour la boutique " + vBoutique.getNom() + " !";
    }

    @Override
    public String addProduitToBoutique(Integer idBoutique, Integer idProduit){
        Boutique vBoutique = BoutiqueDto.toEntity(findById(idBoutique));
        Produit vProduit = vProduitRepository.findById(idProduit).get();
        vProduit.setIdBoutique(vBoutique.getIdBoutique());
        vBoutique.getProduits().add(vProduit);
        return "Produit ajouté avec succés pour la boutique " + vBoutique.getNom() + " !";
    }

    @Override
    public List<Boutique> filterBoutiques(String sort, String conge, String dateAfter, String dateBefore) throws ParseException {
        List<Boutique> vBoutiques;
        if(StringUtils.hasLength(sort)){
            vBoutiques = sortBoutiques(sort);
        }else {
            vBoutiques = vBoutiqueRepository.findAll();
        }
        if(StringUtils.hasLength(conge)){
            if(conge.equals("true")){
                vBoutiques =  vBoutiques.stream().filter(b -> b.getConge().equals(true)).collect(Collectors.toList());
            }
            if(conge.equals("false")){
                vBoutiques =  vBoutiques.stream().filter(b -> b.getConge().equals(false)).collect(Collectors.toList());
            }
        }
        if(StringUtils.hasLength(dateAfter)){
            vBoutiques =  vBoutiques.stream().filter(b -> {
                try {
                    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                            DateFormat.SHORT,
                            DateFormat.SHORT);
                    String date = shortDateFormat.format(b.getCreationData());
                    return new SimpleDateFormat("dd/MM/yyyy").parse(date)
                            .after(new SimpleDateFormat("dd/MM/yyyy").parse(dateAfter));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }
        if(StringUtils.hasLength(dateBefore)){
            vBoutiques =  vBoutiques.stream().filter(b -> {
                try {
                    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                            DateFormat.SHORT,
                            DateFormat.SHORT);
                    String date = shortDateFormat.format(b.getCreationData());
                    return new SimpleDateFormat("dd/MM/yyyy").parse(date)
                            .before(new SimpleDateFormat("dd/MM/yyyy").parse(dateBefore));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }
        return vBoutiques;
    }

    private List<Boutique> sortBoutiques(String sort){
        List<Boutique> vBoutiques;
        if(sort.equals("nom")){
            vBoutiques = vBoutiqueRepository.findByOrderByNom();
        } else if(sort.equals("creationDate")){
            vBoutiques = vBoutiqueRepository.findByOrderByCreationData();
        } else if(sort.equals("nbProduits")){
            vBoutiques = vBoutiqueRepository.findByOrderByProduits();
        } else {
            vBoutiques = vBoutiqueRepository.findAll();
        }
        return vBoutiques;
    }
}
