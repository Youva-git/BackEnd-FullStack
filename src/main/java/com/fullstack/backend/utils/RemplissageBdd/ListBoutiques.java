package com.fullstack.backend.utils.RemplissageBdd;

import com.fullstack.backend.dto.BoutiqueDto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public interface ListBoutiques {
    public List<BoutiqueDto> LIST_BOUTIQUES = Arrays.asList(
            new BoutiqueDto(null, null,"phone", "Vente de Téléphone", new Date(), "passe", false, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Total Look", "Vente de Chaussures", new Date(), "1234", true, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Animalerie", "Vente animaux de compagnie et accessoirs pour les animaux  ", new Date(), "1234", true, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Youni", "Bricolage maison", new Date(), "1234", true, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Guao Jeux", "Vente de Jeux et Jouets", new Date(), "passe", true, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Fashion Style", "Vente de MONTRES", new Date(), "passe", true, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Zelfie Boutique", "Beauté et Parfum", new Date(), "passe", true, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Alexa Mode", "Vente de BIJOUX", new Date(), "passe", true, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Double Tendance", "Vente d'accessoires Voiture", new Date(), "passe", false, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Diana Boutique", "Vente de SACS", new Date(), "passe", false, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Global Informatique", "Matériel Informatique", new Date(), "passe", false, new ArrayList<>(), new ArrayList<>()),
            new BoutiqueDto(null, null,"Andro Fashion", "Vente de Vêtements ", new Date(), "passe", false, new ArrayList<>(), new ArrayList<>())
    );
}
