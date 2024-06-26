package com.eslam.RecipeManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("RecipeIngredients")
public class RecipeIngredient {
    @Id
    private Integer id;
    @Column("recipe_id")
    private AggregateReference<Recipe, Integer> recipeId;
    @Column("ingredient_id")
    private AggregateReference<Ingredient, Integer> ingredientId;
    private String quantity;
}