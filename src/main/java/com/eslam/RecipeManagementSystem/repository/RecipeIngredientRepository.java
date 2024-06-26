package com.eslam.RecipeManagementSystem.repository;

import com.eslam.RecipeManagementSystem.entity.Ingredient;
import com.eslam.RecipeManagementSystem.entity.Recipe;
import com.eslam.RecipeManagementSystem.entity.RecipeIngredient;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {
    List<RecipeIngredient> findByRecipeId(AggregateReference<Recipe, Integer> recipeId);
    List<RecipeIngredient> findByIngredientId(AggregateReference<Ingredient, Integer> ingredientId);
    RecipeIngredient findByRecipeIdAndIngredientId(AggregateReference<Recipe, Integer> recipeId, AggregateReference<Ingredient, Integer> ingredientId);

    @Modifying
    @Query("UPDATE RecipeIngredients SET quantity = :quantity " +
            "WHERE recipe_id = :recipeId AND ingredient_id = :ingredientId")
    void updateQuantity(int recipeId, int ingredientId, String quantity);
}
