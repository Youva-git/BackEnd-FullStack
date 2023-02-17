package com.fullstack.backend.service.impls;

import com.fullstack.backend.dto.ChangerMdpUserDto;
import com.fullstack.backend.dto.AppUserDto;
import com.fullstack.backend.exception.EntityNotFoundException;
import com.fullstack.backend.exception.ErrorCodes;
import com.fullstack.backend.exception.InvalidOperationException;
import com.fullstack.backend.modele.AppRole;
import com.fullstack.backend.modele.AppUser;
import com.fullstack.backend.modele.Boutique;
import com.fullstack.backend.repository.AppRoleRepository;
import com.fullstack.backend.repository.AppUserRepository;
import com.fullstack.backend.repository.BoutiqueRepository;
import com.fullstack.backend.service.AppUserService;
import com.fullstack.backend.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.fullstack.backend.utils.Constants.ROLE_ADMIN;
import static com.fullstack.backend.utils.Constants.ROLE_VENDEUR_LIVREUR;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository vUserRepository;
    private final PasswordEncoder vPasswordEncoder;
    private final BoutiqueRepository vBoutiqueRepository;
    private final AppRoleRepository vRoleRepository;

    public AppUserServiceImpl(AppUserRepository vUserRepository, PasswordEncoder vPasswordEncoder,
                              BoutiqueRepository vBoutiqueRepository, AppRoleRepository vRoleRepository) {
        this.vUserRepository = vUserRepository;
        this.vPasswordEncoder = vPasswordEncoder;
        this.vBoutiqueRepository = vBoutiqueRepository;
        this.vRoleRepository = vRoleRepository;
    }

    private AppUserDto newAbstractUser(AppUserDto user, String role) {
        UserValidator.validate(user);
        user.setMdp(vPasswordEncoder.encode(user.getMdp()));
        AppUserDto.fromEntity(vUserRepository.save(AppUserDto.toEntity(user)));
        addRoleToUser(user.getEmail(), role);
        return user;
    }

    @Override
    public AppUserDto addNewVendeur_Livreur(AppUserDto user) {
        return newAbstractUser(user, ROLE_VENDEUR_LIVREUR);

    }
    @Override
    public AppUserDto addNewAdmin(AppUserDto user) {
        return newAbstractUser(user, ROLE_ADMIN);

    }

    @Override
    public List<AppUserDto> read() {
        return vUserRepository.findAll().stream()
                .map(AppUserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDto findById(Integer id){
        if(id == null){
            log.error("ID utilisateur null !");
            return null;
        }
        Optional<AppUser> user = vUserRepository.findById(id);
        return Optional.of(AppUserDto.fromEntity(user.get()))
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucun utilisateur porte l'ID = "+id+" dans la BDD",
                                ErrorCodes.PRODUIT_NOT_FOUND));
    }
    @Override
    public AppUserDto findByEmail(String email){
        if(email == null){
            log.error("Utilisateur mail null !");
            return null;
        }
        AppUserDto vUser = AppUserDto.fromEntity(vUserRepository.findByEmail(email).get());
        if(vUser == null){
            log.warn("Aucun utilisateur n'a été trouvé !");
            throw new EntityNotFoundException("Aucun utlisateur sélectionner !", ErrorCodes.USER_NOT_FOUND);
        }
        return vUser;
    }

    @Override
    public AppUserDto update(Integer id, AppUserDto user) {
        return AppUserDto.fromEntity(vUserRepository.findById(id)
                .map(u-> {
                    u.setNom(user.getNom());
                    u.setPrenom(user.getPrenom());
                    u.setEmail(user.getEmail());
                    return vUserRepository.save(AppUserDto.toEntity(AppUserDto.fromEntity(u)));
                }).orElseThrow(() -> new RuntimeException("Utilisateur introvable !")));
    }

    @Override
    public String delete(Integer id) {
        vUserRepository.deleteById(id);
        return "Utilisateur supprimé !";
    }

    @Override
    public AppUserDto ChangeMdp(ChangerMdpUserDto userMpd) throws InvalidOperationException {
        UserValidator.validateChangeMdp(userMpd);
        AppUser vUser = vUserRepository.findByEmail(userMpd.getEmail()).get();
        vUser.setMdp(userMpd.getMdp());
        return AppUserDto.fromEntity(
                vUserRepository.save(vUser)
        );
    }

    @Override
    public List<AppUserDto> pageUsers(int page, int size){
        return vUserRepository.findAll(PageRequest.of(page, size)).getContent().stream()
                .map(AppUserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public String addRoleToUser(String email, String role) {
        AppUser vAppUser = AppUserDto.toEntity(findByEmail(email));
        AppRole vAppRole = vRoleRepository.findByRoleName(role);
        if(vAppRole == null){
            log.warn("Role introuvable !");
            throw new EntityNotFoundException("Role introuvable !", ErrorCodes.ROLE_NOT_FOUND);
        }
        vAppUser.setAppRoles(vAppRole);
        return "Role ajouter avec succés !";
    }
    @Override
    public String changeRole(String email, String role) {
        AppUser vAppUser = AppUserDto.toEntity(findByEmail(email));
        AppRole vAppRole = vRoleRepository.findByRoleName(role);
        if(vAppRole == null){
            log.warn("Role introuvable !");
            throw new EntityNotFoundException("Role introuvable !", ErrorCodes.ROLE_NOT_FOUND);
        }
        vAppUser.setAppRoles(vAppRole);
        vUserRepository.save(vAppUser);
        return "Role mis à jour avec succés !";
    }

    @Override
    public String addBoutiqueToUser(String email, Integer idBoutique){
        AppUser vAppUser = AppUserDto.toEntity(findByEmail(email));
        Boutique vBoutique = vBoutiqueRepository.findById(idBoutique).get();
        vAppUser.setBoutiques(vBoutique);
        return "Boutique ajouter avec succés pour l'utilisateur " + vAppUser.getNom() + " !";
    }

    @Override
    public List<AppUserDto> findByNom(String nom){
        if(nom == null){
            log.error("Nom d'utilisateur null !");
            return null;
        }
        List<AppUserDto> vUser =  vUserRepository.findByNom(nom).stream()
                .map(AppUserDto::fromEntity)
                .collect(Collectors.toList());
        if(nom == null){
            log.warn("Aucun utilisateur n'a été trouvé !");
            throw new EntityNotFoundException("Aucun utlisateur sélectionner !", ErrorCodes.USER_NOT_FOUND);
        }
        return vUser;    }

}
