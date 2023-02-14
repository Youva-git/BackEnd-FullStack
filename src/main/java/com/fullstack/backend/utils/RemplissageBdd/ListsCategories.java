package com.fullstack.backend.utils.RemplissageBdd;

import com.fullstack.backend.dto.CategorieDto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public interface ListsCategories {
    public List<CategorieDto> LIST_CATEGORIE_PHONE = Arrays.asList(
            new CategorieDto(null, "Samsung", "Téléphone portable Samsung", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Hawaii", "Téléphone portable Hawaii", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_TOTAL_LOOK = Arrays.asList(
            new CategorieDto(null, "Chaussurs Homme", "Choix multiples pour les chaussurs Homme", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Chaussurs Femme", "Choix multiples pour les chaussurs Femme", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_ANIMALERIE = Arrays.asList(
            new CategorieDto(null, "Animaux", "Animaux de compagnie", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Accessoirs", "Accessoirs Animaux", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_YOUNI = Arrays.asList(
            new CategorieDto(null, "Bricolage maison", "Accessoirs pour les bricolage à la maison", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_GUAO_JEUX = Arrays.asList(
            new CategorieDto(null, "Jeux vidéo", "Divers Jeux vidéo pour les enfants et les adults", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Jouets", "Divers Jouets pour enfants", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_FASHION_STYLE= Arrays.asList(
            new CategorieDto(null, "Automatique", "Montres avec mécanisme Automatique", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Mécanique", "Montres avec mécanisme Mécanique", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Quartz", "Montres avec mécanisme Quartz", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_ALEXA_MODE = Arrays.asList(
            new CategorieDto(null, "Or", "Bijoux en or", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Argent", "Bijoux en Argent", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_DOUBLE_TENDANCE = Arrays.asList(
            new CategorieDto(null, "Accessoires", "Divers accessoires pour Voiture", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_DIANA_BOUTIQUE = Arrays.asList(
            new CategorieDto(null, "Cuir", "Sacs en Cuir", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Simili cuir", "Sacs en Simili cuir", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_GLOBAL_INFORMATIQUE= Arrays.asList(
            new CategorieDto(null, "Ordinateurs Portable", "Bijoux en or", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Accessoirs Informatique", "Bijoux en Argent", new Date(), "1234", new ArrayList<>(), null)
    );
    public List<CategorieDto> LIST_CATEGORIE_ANDRO_FASHION= Arrays.asList(
            new CategorieDto(null, "Vêtements Homme", "Choix multiples des vêtements pour Homme", new Date(), "1234", new ArrayList<>(), null),
            new CategorieDto(null, "Vêtements Femme", "Choix multiples des vêtements pour Femme", new Date(), "1234", new ArrayList<>(), null)
    );

}
