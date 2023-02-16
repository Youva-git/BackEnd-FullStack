package com.fullstack.backend.utils.modeleEndPoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssociationProduitBotique {
    private Integer IdBoutique;
    private Integer IdProduit;
}
