package com.eslam.RecipeManagementSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeWithIngredientsDTO {
    private int recipeId;
    private String title;
    private String instructions;
    private List<IngredientQuantityDTO> ingredients;
}

