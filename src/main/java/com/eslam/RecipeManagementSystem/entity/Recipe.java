package com.eslam.RecipeManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("recipes")
public class Recipe {
    @Id
    private Integer recipeId;
    private String title;
    private String instructions;
//    private List<RecipeIngredient> ingredients;
}
