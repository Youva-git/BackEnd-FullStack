package com.fullstack.backend.utils.RemplissageBdd;

import com.fullstack.backend.dto.AppUserDto;
import com.fullstack.backend.modele.AppRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ListUsers {

    public List<AppUserDto> LIST_ADMINS = Arrays.asList(
            new AppUserDto(null, "admin1", "admin1", "admin1@gmail", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "admin2", "admin2", "admin2@gmail", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>())
    );
    public List<AppUserDto> LIST_VENDEUR_LIVREUR= Arrays.asList(
            new AppUserDto(null, "manager1", "manager1", "manager1@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager2", "manager2", "manager2@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager3", "manager3", "manager3@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager4", "manager4", "manager4@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager5", "manager5", "manager5@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager6", "manager6", "manager6@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager7", "manager7", "manager7@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager8", "manager8", "manager8@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager9", "manager9", "manager9@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "manager10", "manager10", "manager10@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>())
    );
    public List<AppRole> LIST_ROLES = Arrays.asList(
            new AppRole(null,"ADMIN"),
            new AppRole(null,"VENDEUR_LIVREUR")
    );
}
