package com.fullstack.backend.utils.RemplissageBdd;

import com.fullstack.backend.dto.ProduitDto;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
public interface ListsProduits {

    public final List<ProduitDto> LIST_PRODUITS_SAMSUNG = Arrays.asList(
            new ProduitDto(null, "Samsung Galaxy A13 ", "Téléphone Mobile 4G 64Go Noir, Carte SIM Non Incluse, Smartphone Android, Version FR",
                    "4G 64GB Mobile Phone Black, SIM Card Not Included, Android Smartphone, FR Version",
                    "P0001", new Date(), 160.88, "https://farm66.staticflickr.com/65535/52604647633_bd5e6cd47a_z.jpg",1,null),
            new ProduitDto(null, "SAMSUNG GALAXY M13 5G", "Téléphone mobile 4G 64GB, Carte SIM non incluse, Android, Version FR, light bleu", "4G 64GB mobile phone, SIM card not included, Android, FR version, light blue",
                    "P0002", new Date(), 360.88, "https://farm66.staticflickr.com/65535/52604142926_039442b6fe_z.jpg",1, null),
            new ProduitDto(null, "Samsung Galaxy A33 5G SM-A336B", "Téléphone mobile 16,3 cm (6.4) Double SIM Hybride Android 12 USB Type-C 6 Go 128 Go 5000 mAh Noir", "Mobile phone 16.3 cm (6.4) Dual SIM Hybrid Android 12 USB Type-C 6 GB 128 GB 5000 mAh Black",
                    "P0003", new Date(), 260.88, "https://farm66.staticflickr.com/65535/52604396849_f613f3cb16_z.jpg",1, null),
            new ProduitDto(null, "Samsung Galaxy Z Fold3", "Téléphone mobile 5G 256Go Noir, Carte SIM non incluse, smartphone Android, Version FR", "5G 256GB Black Mobile Phone, SIM Card Not Included, Android Smartphone, FR Version",
                    "P0004", new Date(), 1160.88, "https://farm66.staticflickr.com/65535/52604568710_ab982df3ac_z.jpg",1, null),
            new ProduitDto(null, "Samsung Galaxy SM-A226B 5G", " Téléphone mobile 16,8 cm (6.6) 4Go 64 Go 5000 mAh Violet [Version EU]", " 16.8cm (6.6) 4GB 64GB 5000mAh Purple Mobile Phone [EU Version]",
                    "P0005", new Date(), 269.88, "https://farm66.staticflickr.com/65535/52604591010_e88f39ba03_z.jpg",1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_HAWAII= Arrays.asList(
            new ProduitDto(null, "HUAWEI P50 Pocket ", "Smartphone 256GB, 8GB RAM, Dual Sim, Gold",
                    "256GB Smartphone, 8GB RAM, Dual Sim, Gold",
                    "P0006", new Date(), 1556.23, "https://farm66.staticflickr.com/65535/52604591995_d542044a56_z.jpg",1, null),
            new ProduitDto(null, "Huawei P30 Pro ", "Smartphone débloqué 4G (6,47 pouces 8/256 Go Double Nano SIM Android 9) Blanc nacré",
                    "4G Unlocked Smartphone (6.47 inch 8/256GB Dual Nano SIM Android 9) Pearl White",
                    "P0007", new Date(), 490.32, "https://farm66.staticflickr.com/65535/52603668567_59bf4381a4_z.jpg",1, null),
            new ProduitDto(null, "Black Shark 5 Pro 5G", " Smartphone 12+256Go, Écran 6,67 E-Sports OLED 144Hz, Snapdragon 8 Gen 1",  " 12+256GB Smartphone, 6.67 E-Sports OLED 144Hz Screen, Snapdragon 8 Gen 1",
                    "P0008", new Date(), 999.01, "https://farm66.staticflickr.com/65535/52603669052_48c8120606_z.jpg",1, null),
            new ProduitDto(null, "HUAWEI P50 Pro 5G", "Smartphone 256GB, 8GB RAM, Dual Sim, Cocoa Gold",
                    "256GB Smartphone, 8GB RAM, Dual Sim, Cocoa Gold",
                    "P0009", new Date(), 1098.25, "https://farm66.staticflickr.com/65535/52604169456_0f5a2ea234_z.jpg",1, null),
            new ProduitDto(null, "HUAWEI P50 Pro", "Smartphone, Design simplifié et géométrique, 8+256 GB, NFC, Écran True-Chroma 6,6, 120 Hz, Dual SIM", "Smartphone, Simplified and geometric design, 8+256 GB, NFC, True-Chroma 6.6 screen, 120 Hz, Dual SIM",
                    "P0010", new Date(), 843.99, "https://farm66.staticflickr.com/65535/52604594840_14ccab2a37_z.jpg",1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_CHAUSSEURS_HOMME= Arrays.asList(
            new ProduitDto(null, "Damyuan", "Homme Running Sport Chaussure Detente Fitness Sneakers Mesh Gym Outdoor Trail Elastique Tennis Training Jogging Walking Baskets Athlétique Chosure",
                    "Men Running Sport Shoe Relaxation Fitness Sneakers Mesh Gym Outdoor Trail Elastic Tennis Training Jogging Walking Trainers Athletic Chosure", "P0011", new Date(), 35.99, "https://farm66.staticflickr.com/65535/52604598160_d8bdb0dd95_z.jpg",2, null),
            new ProduitDto(null, "Sephilitone", "A136 Chaussures montantes tendance en toile pour homme", "A136 Men's Trendy Canvas High Top Shoes",
                    "P0012", new Date(), 44.99, "https://farm66.staticflickr.com/65535/52604681148_50c72af1d4_z.jpg",2, null),
            new ProduitDto(null, "Asics", "Gel-Cumulus 20, Chaussures de Running Homme", "Gel-Cumulus 20, Men's Running Shoes",
                    "P0013", new Date(), 25.99, "https://farm66.staticflickr.com/65535/52604428109_afe4de5b03_z.jpg",2, null),
            new ProduitDto(null, "Ebbico", "Bowling Chaussures Skidproof Sneakers Respirant pour Les Hommes",
                    "Bowling Shoes Skidproof Breathable Sneakers for Men",
                    "P0014", new Date(), 322.99, "https://farm66.staticflickr.com/65535/52604600085_b09968f4e4_z.jpg",2, null),
            new ProduitDto(null, "SALOMON", "Shoes Predict Soc2, Chaussures de Running Homme", "Shoes Predict Soc2, Men's Running Shoes",
                    "P0015", new Date(), 250.99, "https://farm66.staticflickr.com/65535/52603676622_49e224e04d_z.jpg",2, null)
    );
    public List<ProduitDto> LIST_PRODUIT_CHAUSSEURS_FEMME= Arrays.asList(
            new ProduitDto(null, "Elara", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, "https://farm66.staticflickr.com/65535/52604177581_eb1367203b_z.jpg",2, null),
            new ProduitDto(null, "PUMA", "Karmen L, Basket Femme", "Karmen L, Women's Sneakers",
                    "P0017", new Date(), 25.99, "https://farm66.staticflickr.com/65535/52604430769_ccd65196f5_z.jpg",2, null),
            new ProduitDto(null, "Elaras", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, "https://farm66.staticflickr.com/65535/52604177581_eb1367203b_z.jpg",2, null),
            new ProduitDto(null, "PUMAs", "Karmen L, Basket Femme", "Karmen L, Women's Sneakers",
                    "P0017", new Date(), 25.99, "https://farm66.staticflickr.com/65535/52604430769_ccd65196f5_z.jpg",2, null),
            new ProduitDto(null, "Fila", " Femme Disruptor Wmn Sneaker", "Woman Disruptor Wmn Sneaker",
                    "P0018", new Date(), 68.99, "https://farm66.staticflickr.com/65535/52603678522_d475920290_z.jpg",2, null),
            new ProduitDto(null, "HKR", "Basket Femme Respirantes Chaussures de Running Marche", "Basketball Woman Breathable Running Shoes Walking",
                    "P0019", new Date(), 78.99, "https://farm66.staticflickr.com/65535/52604685518_59b1b61a97_z.jpg",2, null),
            new ProduitDto(null, "Vans", "Ward Suede/Canvas, Baskets Femme, US Frauen", "Ward Suede/Canvas, Women's Sneakers, US Frauen",
                    "P0020", new Date(), 15.99, "https://farm66.staticflickr.com/65535/52604685978_3d0dc22cf6_z.jpg",2, null)

    );

    public List<ProduitDto> LIST_PRODUIT_ANIMAUX = Arrays.asList(
            new ProduitDto(null, "Chien", "Chien de compagnie", "pet dog",
                    "P0021", new Date(), 35.99, null,1, null),
            new ProduitDto(null, "chat", "chat de compagnie", "pet cat",
                    "P0022", new Date(), 44.99, null,1, null),
            new ProduitDto(null, "Canarie", "Oiseau domestique", "domestic bird",
                    "P0023", new Date(), 250.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_ACCESSOIRES_ANIMAUX = Arrays.asList(
            new ProduitDto(null, "Costumes de Noël pour Animaux", "MELLIEX 3 Pièces Costumes de Noël de Animaux de Compagnie Écharpe de Noël Chapeau de Père Noël Nœud Papillon",
                    "MELLIEX 3 Pieces Pet Christmas Costumes Christmas Scarf Santa Claus Hat Bow Tie", "P0024", new Date(), 13.99, "https://farm66.staticflickr.com/65535/52604687848_3761877de2_z.jpg",1, null),
            new ProduitDto(null, "BluePet", "Brosse Anti Poils Animaux | Rouleau Poils Animaux | Enlever Les Poils de Chat | Rouleau Chat Poil",
                    "Pet Hair Brush | Pet Hair Roller | Remove Cat Hair | Cat Hair Roller","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "XKISS Souffleur", "XKISS Souffleur pourchien4.5HP/3200WVitesse Continue et température réglable Sèche-Cheveux pour animaux",
                    "XKISS Dog Blower 4.5HP/3200W Continuous Speed ​​and Adjustable Temperature Pet Hair Dryer","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Noël Collier", "Noël Collier pour Animaux de Compagnie Écharpe réglable",
                    "Christmas Pet Collar Adjustable Scarf","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Nobby", "Nobby Lit Snuggle pour Petit Animal 30 x 26 cm ", "Nobby Snuggle Bed for Small Animal 30 x 26 cm",
                    "P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_BRICOLAGE_MAISON = Arrays.asList(
            new ProduitDto(null, "Meubles en bois", "Meubles en bois à fabriquer soi-même: Design, écologiques, faciles et économiques",
                    "Do-it-yourself wooden furniture: Design, ecological, easy and economical","P0024", new Date(), 13.99, null,1, null),
            new ProduitDto(null, "WiMas Gundam", "WiMas Gundam Modele Outils Fondamentaux Kit, Ensemble de Bricolage Hobby Building pour la Réparation et la Fixation de Modèles (25PCS)",
                    "WiMas Gundam Model Fundamental Tools Kit, Hobby Building DIY Set for Repairing and Fixing Models (25PCS)","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "OfficeTree Scalpel", "OfficeTree Scalpel de Découpe 16 Pièce - Cutter de Précision avec 3 Scalpels différents et 13 Lames de Rechange",
                    "OfficeTree 16 Piece Cutting Scalpel - Precision Cutter with 3 Different Scalpels and 13 Spare Blades","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "HSEAMALL 26PCS", "HSEAMALL 26PCS Outils de modélisme,Gundam Modeleur Basic Outils Craft Set,Bandai Hobby pour voiture modÈle assembler Kit",
                    "HSEAMALL 26PCS Modeling Tools,Gundam Modeler Basic Tools Craft Set,Bandai Hobby for Car Model Assemble Kit","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Boîte-cadeau", "Bricolage à la main Boîte-cadeau for boîte anniversaire bricolage Scrapbook Photo Album anniversaire cadeau",
                    "Handmade DIY Gift Box for Birthday Box DIY Scrapbook Photo Album Anniversary Gift", "P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_JEUX_VIDEO = Arrays.asList(
            new ProduitDto(null, "Elden Ring", "Future press Guide Officiel Jeu vidéo Elden Ring Les Tomes du Savoir : Volume 1 L'Entre-Terre - Version française",
                    "Future press Official Video Game Guide Elden Ring Tomes of Knowledge: Volume 1 Between Earth - French version","P0024", new Date(), 44.99, null,1, null),
            new ProduitDto(null, "Need for Speed", "Need for Speed Unbound PS5 | Jeu Vidéo | Français",
                    "Need for Speed ​​Unbound PS5 | Video Game | French","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "Donkey Kong Country", "Donkey Kong Country: Tropical Freeze Standard [video game]",
                    "Donkey Kong Country: Tropical Freeze Standard [video game]","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Dead Space", "Dead Space PS5 | Jeu Vidéo | Français",
                    "Dead Space PS5 | Video Game | French","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Minecraft", "Devenir le boss de Minecraft : le guide de jeu - Guide de jeux vidéo - Dès 8 ans",
                    "Becoming the boss of Minecraft: the game guide - Guide to video games - From 8 years old","P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_JOUETS = Arrays.asList(
            new ProduitDto(null, "ASTGMI", "ASTGMI Appareil Photo pour Enfants, 2.0 Pouces Enfant Appareil Photo Numérique, Mini Caméra Enfant Rechargeable",
                    "ASTGMI Kids Camera, 2.0 Inch Child Digital Camera, Mini Rechargeable Child Camera","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "Allhaha", "Allhaha Jeux Dinosaures - Jouet Sensoriel Montessori Motricité Fine Activités Éducatif Bébé - Cadeau Jouet Jeux Eveil Bebe",
                    "Allhaha Dinosaur Games - Montessori Sensory Toy Fine Motor Skills Educational Baby Activities - Gift Toy Baby Awakening Games","P0024", new Date(), 13.99, null,1, null),
            new ProduitDto(null, "Dinosaure", "Dinosaure Jouet Camion Jouet Enfant 3 4 5 Ans - Camion Dinosaure Transporteur Voiture Enfant Avec 12 Figurine",
                    "Dinosaur Toy Truck Kids Toy 3 4 5 Years Old - Kids Car Transporter Dinosaur Truck With 12 Figures","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Plumes pour Chats", "Jouets à Plumes pour Chats avec Cloche et Ventouse,Interactif Chatons Baguette,Jouet Chat Plume,Rétractable Canne",
                    "Feather Toys for Cats with Bell and Suction Cup, Interactive Kittens Wand, Cat Feather Toy, Retractable Cane","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Gemokrt", "Gemokrt Voiture de Jouet Robot Déformée, 2 en 1 Voiture Télécommandée Transformers, Voiture télécommandée ",
                    "Gemokrt Deformed Robot Toy Car, 2 in 1 Transformers Remote Control Car, Remote Control Car","P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_AUTOMATIQUE = Arrays.asList(
            new ProduitDto(null, "ASTGMI", "ASTGMI Appareil Photo pour Enfants, 2.0 Pouces Enfant Appareil Photo Numérique, Mini Caméra Enfant Rechargeable",
                    "ASTGMI Kids Camera, 2.0 Inch Child Digital Camera, Mini Rechargeable Child Camera","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "Allhaha", "Allhaha Jeux Dinosaures - Jouet Sensoriel Montessori Motricité Fine Activités Éducatif Bébé - Cadeau Jouet Jeux Eveil Bebe",
                    "Allhaha Dinosaur Games - Montessori Sensory Toy Fine Motor Skills Educational Baby Activities - Gift Toy Baby Awakening Games","P0024", new Date(), 13.99, null,1, null),
            new ProduitDto(null, "Dinosaure", "Dinosaure Jouet Camion Jouet Enfant 3 4 5 Ans - Camion Dinosaure Transporteur Voiture Enfant Avec 12 Figurine",
                    "Dinosaur Toy Truck Kids Toy 3 4 5 Years Old - Kids Car Transporter Dinosaur Truck With 12 Figures","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Plumes pour Chats", "Jouets à Plumes pour Chats avec Cloche et Ventouse,Interactif Chatons Baguette,Jouet Chat Plume,Rétractable Canne",
                    "Feather Toys for Cats with Bell and Suction Cup, Interactive Kittens Wand, Cat Feather Toy, Retractable Cane","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Gemokrt", "Gemokrt Voiture de Jouet Robot Déformée, 2 en 1 Voiture Télécommandée Transformers, Voiture télécommandée ",
                    "Gemokrt Deformed Robot Toy Car, 2 in 1 Transformers Remote Control Car, Remote Control Car","P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_MECANIQUE = Arrays.asList(
            new ProduitDto(null, "Elara", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "PUMA", "Karmen L, Basket Femme", "Karmen L, Women's Sneakers",
                    "P0017", new Date(), 25.99, null,2, null),
            new ProduitDto(null, "Elaras", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "Vans", "Ward Suede/Canvas, Baskets Femme, US Frauen", "Ward Suede/Canvas, Women's Sneakers, US Frauen",
                    "P0020", new Date(), 15.99, null,2, null)

    );
    public List<ProduitDto> LIST_PRODUIT_QUARTZ = Arrays.asList(
            new ProduitDto(null, "Costumes de Noël pour Animaux", "MELLIEX 3 Pièces Costumes de Noël de Animaux de Compagnie Écharpe de Noël Chapeau de Père Noël Nœud Papillon",
                    "MELLIEX 3 Pieces Pet Christmas Costumes Christmas Scarf Santa Claus Hat Bow Tie", "P0024", new Date(), 13.99, "https://farm66.staticflickr.com/65535/52604687848_3761877de2_z.jpg",1, null),
            new ProduitDto(null, "BluePet", "Brosse Anti Poils Animaux | Rouleau Poils Animaux | Enlever Les Poils de Chat | Rouleau Chat Poil",
                    "Pet Hair Brush | Pet Hair Roller | Remove Cat Hair | Cat Hair Roller","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "XKISS Souffleur", "XKISS Souffleur pourchien4.5HP/3200WVitesse Continue et température réglable Sèche-Cheveux pour animaux",
                    "XKISS Dog Blower 4.5HP/3200W Continuous Speed ​​and Adjustable Temperature Pet Hair Dryer","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Noël Collier", "Noël Collier pour Animaux de Compagnie Écharpe réglable",
                    "Christmas Pet Collar Adjustable Scarf","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Nobby", "Nobby Lit Snuggle pour Petit Animal 30 x 26 cm ", "Nobby Snuggle Bed for Small Animal 30 x 26 cm",
                    "P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_OR = Arrays.asList(
            new ProduitDto(null, "Elara", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "PUMA", "Karmen L, Basket Femme", "Karmen L, Women's Sneakers",
                    "P0017", new Date(), 25.99, null,2, null),
            new ProduitDto(null, "Elaras", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "Vans", "Ward Suede/Canvas, Baskets Femme, US Frauen", "Ward Suede/Canvas, Women's Sneakers, US Frauen",
                    "P0020", new Date(), 15.99, null,2, null)

    );
    public List<ProduitDto> LIST_PRODUIT_ARGENT = Arrays.asList(
            new ProduitDto(null, "Samsung Galaxy A13 ", "Téléphone Mobile 4G 64Go Noir, Carte SIM Non Incluse, Smartphone Android, Version FR",
                    "4G 64GB Mobile Phone Black, SIM Card Not Included, Android Smartphone, FR Version",
                    "P0001", new Date(), 160.88, null,1,null),
            new ProduitDto(null, "SAMSUNG GALAXY M13 5G", "Téléphone mobile 4G 64GB, Carte SIM non incluse, Android, Version FR, light bleu", "4G 64GB mobile phone, SIM card not included, Android, FR version, light blue",
                    "P0002", new Date(), 360.88, null,1, null),
            new ProduitDto(null, "Samsung Galaxy A33 5G SM-A336B", "Téléphone mobile 16,3 cm (6.4) Double SIM Hybride Android 12 USB Type-C 6 Go 128 Go 5000 mAh Noir", "Mobile phone 16.3 cm (6.4) Dual SIM Hybrid Android 12 USB Type-C 6 GB 128 GB 5000 mAh Black",
                    "P0003", new Date(), 260.88, null,1, null),
            new ProduitDto(null, "Samsung Galaxy Z Fold3", "Téléphone mobile 5G 256Go Noir, Carte SIM non incluse, smartphone Android, Version FR", "5G 256GB Black Mobile Phone, SIM Card Not Included, Android Smartphone, FR Version",
                    "P0004", new Date(), 1160.88, null,1, null),
            new ProduitDto(null, "Samsung Galaxy SM-A226B 5G", " Téléphone mobile 16,8 cm (6.6) 4Go 64 Go 5000 mAh Violet [Version EU]", " 16.8cm (6.6) 4GB 64GB 5000mAh Purple Mobile Phone [EU Version]",
                    "P0005", new Date(), 269.88, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_ACCESSOIRES = Arrays.asList(
            new ProduitDto(null, "Costumes de Noël pour Animaux", "MELLIEX 3 Pièces Costumes de Noël de Animaux de Compagnie Écharpe de Noël Chapeau de Père Noël Nœud Papillon",
                    "MELLIEX 3 Pieces Pet Christmas Costumes Christmas Scarf Santa Claus Hat Bow Tie", "P0024", new Date(), 13.99, "https://farm66.staticflickr.com/65535/52604687848_3761877de2_z.jpg",1, null),
            new ProduitDto(null, "BluePet", "Brosse Anti Poils Animaux | Rouleau Poils Animaux | Enlever Les Poils de Chat | Rouleau Chat Poil",
                    "Pet Hair Brush | Pet Hair Roller | Remove Cat Hair | Cat Hair Roller","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "XKISS Souffleur", "XKISS Souffleur pourchien4.5HP/3200WVitesse Continue et température réglable Sèche-Cheveux pour animaux",
                    "XKISS Dog Blower 4.5HP/3200W Continuous Speed ​​and Adjustable Temperature Pet Hair Dryer","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Noël Collier", "Noël Collier pour Animaux de Compagnie Écharpe réglable",
                    "Christmas Pet Collar Adjustable Scarf","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Nobby", "Nobby Lit Snuggle pour Petit Animal 30 x 26 cm ", "Nobby Snuggle Bed for Small Animal 30 x 26 cm",
                    "P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_CUIR = Arrays.asList(
            new ProduitDto(null, "Elden Ring", "Future press Guide Officiel Jeu vidéo Elden Ring Les Tomes du Savoir : Volume 1 L'Entre-Terre - Version française",
                    "Future press Official Video Game Guide Elden Ring Tomes of Knowledge: Volume 1 Between Earth - French version","P0024", new Date(), 44.99, null,1, null),
            new ProduitDto(null, "Need for Speed", "Need for Speed Unbound PS5 | Jeu Vidéo | Français",
                    "Need for Speed ​​Unbound PS5 | Video Game | French","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "Donkey Kong Country", "Donkey Kong Country: Tropical Freeze Standard [video game]",
                    "Donkey Kong Country: Tropical Freeze Standard [video game]","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Dead Space", "Dead Space PS5 | Jeu Vidéo | Français",
                    "Dead Space PS5 | Video Game | French","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Minecraft", "Devenir le boss de Minecraft : le guide de jeu - Guide de jeux vidéo - Dès 8 ans",
                    "Becoming the boss of Minecraft: the game guide - Guide to video games - From 8 years old","P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_SEMILI_CUIR= Arrays.asList(
            new ProduitDto(null, "Elara", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "PUMA", "Karmen L, Basket Femme", "Karmen L, Women's Sneakers",
                    "P0017", new Date(), 25.99, null,2, null),
            new ProduitDto(null, "Elaras", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "Vans", "Ward Suede/Canvas, Baskets Femme, US Frauen", "Ward Suede/Canvas, Women's Sneakers, US Frauen",
                    "P0020", new Date(), 15.99, null,2, null)

    );
    public List<ProduitDto> LIST_PRODUIT_ORDINATEURS_PORTABLE = Arrays.asList(
            new ProduitDto(null, "Costumes de Noël pour Animaux", "MELLIEX 3 Pièces Costumes de Noël de Animaux de Compagnie Écharpe de Noël Chapeau de Père Noël Nœud Papillon",
                    "MELLIEX 3 Pieces Pet Christmas Costumes Christmas Scarf Santa Claus Hat Bow Tie", "P0024", new Date(), 13.99, "https://farm66.staticflickr.com/65535/52604687848_3761877de2_z.jpg",1, null),
            new ProduitDto(null, "BluePet", "Brosse Anti Poils Animaux | Rouleau Poils Animaux | Enlever Les Poils de Chat | Rouleau Chat Poil",
                    "Pet Hair Brush | Pet Hair Roller | Remove Cat Hair | Cat Hair Roller","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "XKISS Souffleur", "XKISS Souffleur pourchien4.5HP/3200WVitesse Continue et température réglable Sèche-Cheveux pour animaux",
                    "XKISS Dog Blower 4.5HP/3200W Continuous Speed ​​and Adjustable Temperature Pet Hair Dryer","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Noël Collier", "Noël Collier pour Animaux de Compagnie Écharpe réglable",
                    "Christmas Pet Collar Adjustable Scarf","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Nobby", "Nobby Lit Snuggle pour Petit Animal 30 x 26 cm ", "Nobby Snuggle Bed for Small Animal 30 x 26 cm",
                    "P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_ACCESSOIRE_INFORMATIQUE = Arrays.asList(
            new ProduitDto(null, "Elara", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "PUMA", "Karmen L, Basket Femme", "Karmen L, Women's Sneakers",
                    "P0017", new Date(), 25.99, null,2, null),
            new ProduitDto(null, "Elaras", "Bottines Femme Bottes de Travail Chunkyrayan", "Women Ankle Boots Chunkyrayan Work Boots",
                    "P0016", new Date(), 33.99, null,2, null),
            new ProduitDto(null, "PUMAs", "Karmen L, Basket Femme", "Karmen L, Women's Sneakers",
                    "P0017", new Date(), 25.99, null,2, null),
            new ProduitDto(null, "Fila", " Femme Disruptor Wmn Sneaker", "Woman Disruptor Wmn Sneaker",
                    "P0018", new Date(), 68.99, null,2, null),
            new ProduitDto(null, "HKR", "Basket Femme Respirantes Chaussures de Running Marche", "Basketball Woman Breathable Running Shoes Walking",
                    "P0019", new Date(), 78.99, null,2, null),
            new ProduitDto(null, "Vans", "Ward Suede/Canvas, Baskets Femme, US Frauen", "Ward Suede/Canvas, Women's Sneakers, US Frauen",
                    "P0020", new Date(), 15.99, null,2, null)

    );
    public List<ProduitDto> LIST_PRODUIT_VETEMENTS_HOMME = Arrays.asList(
            new ProduitDto(null, "Costumes de Noël pour Animaux", "MELLIEX 3 Pièces Costumes de Noël de Animaux de Compagnie Écharpe de Noël Chapeau de Père Noël Nœud Papillon",
                    "MELLIEX 3 Pieces Pet Christmas Costumes Christmas Scarf Santa Claus Hat Bow Tie", "P0024", new Date(), 13.99, "https://farm66.staticflickr.com/65535/52604687848_3761877de2_z.jpg",1, null),
            new ProduitDto(null, "BluePet", "Brosse Anti Poils Animaux | Rouleau Poils Animaux | Enlever Les Poils de Chat | Rouleau Chat Poil",
                    "Pet Hair Brush | Pet Hair Roller | Remove Cat Hair | Cat Hair Roller","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "XKISS Souffleur", "XKISS Souffleur pourchien4.5HP/3200WVitesse Continue et température réglable Sèche-Cheveux pour animaux",
                    "XKISS Dog Blower 4.5HP/3200W Continuous Speed ​​and Adjustable Temperature Pet Hair Dryer","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Noël Collier", "Noël Collier pour Animaux de Compagnie Écharpe réglable",
                    "Christmas Pet Collar Adjustable Scarf","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Nobby", "Nobby Lit Snuggle pour Petit Animal 30 x 26 cm ", "Nobby Snuggle Bed for Small Animal 30 x 26 cm",
                    "P0028", new Date(), 15.99, null,1, null)
    );
    public List<ProduitDto> LIST_PRODUIT_VETEMENTS_FEMME = Arrays.asList(
            new ProduitDto(null, "Elden Ring", "Future press Guide Officiel Jeu vidéo Elden Ring Les Tomes du Savoir : Volume 1 L'Entre-Terre - Version française",
                    "Future press Official Video Game Guide Elden Ring Tomes of Knowledge: Volume 1 Between Earth - French version","P0024", new Date(), 44.99, null,1, null),
            new ProduitDto(null, "Need for Speed", "Need for Speed Unbound PS5 | Jeu Vidéo | Français",
                    "Need for Speed ​​Unbound PS5 | Video Game | French","P0025", new Date(), 25.99, null,1, null),
            new ProduitDto(null, "Donkey Kong Country", "Donkey Kong Country: Tropical Freeze Standard [video game]",
                    "Donkey Kong Country: Tropical Freeze Standard [video game]","P0026", new Date(), 19.99, null,1, null),
            new ProduitDto(null, "Dead Space", "Dead Space PS5 | Jeu Vidéo | Français",
                    "Dead Space PS5 | Video Game | French","P0027", new Date(), 36.99, null,1, null),
            new ProduitDto(null, "Minecraft", "Devenir le boss de Minecraft : le guide de jeu - Guide de jeux vidéo - Dès 8 ans",
                    "Becoming the boss of Minecraft: the game guide - Guide to video games - From 8 years old","P0028", new Date(), 15.99, null,1, null)
    );
}
