package com.fullstack.backend.utils.RemplissageBdd;

import com.fullstack.backend.dto.BoutiqueDto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public interface ListBoutiques {
    String h = "\n" +
            "{\n" +
            "  \"lundi\": {\n" +
            "    \"matin\": {\"de\": \"08:00\", \"à\": \"12:00\"},\n" +
            "    \"après-midi\": {\"de\": \"14:00\", \"à\": \"18:00\"}\n" +
            " \n" +
            "  },\n" +
            "  \"mardi\": {\n" +
            "    \"matin\": {\"de\": \"08:00\", \"à\": \"12:00\"},\n" +
            "    \"après-midi\": {\"de\": \"14:00\", \"à\": \"18:00\"}\n" +
            "    },\n" +
            "  \"mercredi\": {\n" +
            "    \"matin\": {\"de\": \"08:00\", \"à\": \"12:00\"},\n" +
            "    \"après-midi\": {\"de\": \"14:00\", \"à\": \"18:00\"}\n" +
            "    },\n" +
            "  \"jeudi\": {\n" +
            "    \"matin\": {\"de\": \"08:00\", \"à\": \"12:00\"},\n" +
            "    \"après-midi\": {\"de\": \"14:00\", \"à\": \"18:00\"}\n" +
            "    },\n" +
            "  \"vendredi\": {\n" +
            "    \"matin\": {\"de\": \"08:00\", \"à\": \"12:00\"},\n" +
            "    \"après-midi\": {\"de\": \"14:00\", \"à\": \"18:00\"}\n" +
            "    },\n" +
            "  \"samedi\": {\n" +
            "    \"matin\": {\"de\": \"10:00\", \"à\": \"12:00\"},\n" +
            "    \"après-midi\": {\"de\": \"14:00\", \"à\": \"19:00\"}\n" +
            "    }\n" +
            "}";
    public List<BoutiqueDto> LIST_BOUTIQUES = Arrays.asList(
            new BoutiqueDto(null, null,"phone", "Vente de Téléphone",  new Date(), h, false, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Total Look", "Vente de Chaussures", new Date(), h, true, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Animalerie", "Vente animaux de compagnie et accessoirs pour les animaux  ", new Date(), "1234", true, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Youni", "Bricolage maison", new Date(), h, true, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Guao Jeux", "Vente de Jeux et Jouets", new Date(), h , true, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Fashion Style", "Vente de MONTRES", new Date(), h , true, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Zelfie Boutique", "Beauté et Parfum", new Date(), h, true, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Alexa Mode", "Vente de BIJOUX", new Date(), h, true, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Double Tendance", "Vente d'accessoires Voiture", new Date(), "passe", false, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Diana Boutique", "Vente de SACS", new Date(), h, false, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Global Informatique", "Matériel Informatique", new Date(), h, false, null, new ArrayList<>()),
            new BoutiqueDto(null, null,"Andro Fashion", "Vente de Vêtements ", new Date(), h, false, null, new ArrayList<>())
    );
}
