package com.fullstack.backend.utils.RemplissageBdd;

import com.fullstack.backend.dto.AppUserDto;
import com.fullstack.backend.modele.AppRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ListUsers {

    public List<AppUserDto> LIST_ADMINS = Arrays.asList(
            new AppUserDto(null, "admin", "admin", "admin@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Bob", "Smith", "bob.smith@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Doe", "John", "john.doe@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>())
    );
    public List<AppUserDto> LIST_VENDEUR_LIVREUR= Arrays.asList(
            new AppUserDto(null, "Johnson", "Alice", "alice.bob@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Lee", "David", "david.lee@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Smith", "Emily", "emily.smith@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Johnson", "Michael", "michael.johnson@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Brown", "Samantha", "samantha.brown@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Davis", "Hannah", "hannah.davis@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Jones", "Adam", "adam.jones@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Taylor", "Olivia", "olivia.taylor@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Wilson", "William", "william.wilson@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>()),
            new AppUserDto(null, "Jones", "Natalie", "natalie.jones@gmail.com", "1234", "urlPhotos", new ArrayList<>(), new ArrayList<>())
    );
    public List<AppRole> LIST_ROLES = Arrays.asList(
            new AppRole(null,"ADMIN"),
            new AppRole(null,"VENDEUR_LIVREUR")
    );
}
