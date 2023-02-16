package com.fullstack.backend.utils.modeleEndPoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssociationCategoriesProduit {
    private Integer[] IdCategories;
    private Integer IdProduit;
}
