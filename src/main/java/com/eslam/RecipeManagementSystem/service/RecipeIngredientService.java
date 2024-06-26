package com.eslam.RecipeManagementSystem.service;

import com.eslam.RecipeManagementSystem.entity.*;
import com.eslam.RecipeManagementSystem.repository.IngredientRepository;
import com.eslam.RecipeManagementSystem.repository.RecipeIngredientRepository;
import com.eslam.RecipeManagementSystem.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeIngredientService{
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    // Add an ingredient for a recipe
    public RecipeIngredient addIngredientToRecipe(int recipeId, int ingredientId, String quantity) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        RecipeIngredient recipeIngredientTemp = recipeIngredientRepository.findByRecipeIdAndIngredientId(AggregateReference.to(recipeId), AggregateReference.to(ingredientId));
        if (recipeIngredientTemp != null) {
            throw new RuntimeException("Those ingredients exist in this recipe already");
        }
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipeId(AggregateReference.to(recipeId));
        recipeIngredient.setIngredientId(AggregateReference.to(ingredientId));
        recipeIngredient.setQuantity(quantity);
        recipeIngredientRepository.save(recipeIngredient);
        return recipeIngredient;
    }

    // get all ingredients for a recipe
    public List<Ingredient> getAllIngredientsFromRecipe(int recipeId){
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByRecipeId(AggregateReference.to(recipeId));
        List<Integer> ingredientIds = recipeIngredients.stream()
                .map(recipeIngredient -> recipeIngredient.getIngredientId().getId())
                .collect(Collectors.toList());

        return (List<Ingredient>) ingredientRepository.findAllById(ingredientIds);
    }

    // get all recipes contain an ingredient
    public List<Recipe> getAllRecipesContainIngredient(int ingredientId){
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByIngredientId(AggregateReference.to(ingredientId));
        List<Integer> recipeIds = recipeIngredients.stream()
                .map(recipeIngredient -> recipeIngredient.getRecipeId().getId())
                .toList();
        return (List<Recipe>) recipeRepository.findAllById(recipeIds);
    }

    // get all ingredient for a recipe with details
    public RecipeWithIngredientsDTO getAllIngredientsForRecipeWithDetails(int recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByRecipeId(AggregateReference.to(recipeId));

        List<IngredientQuantityDTO> ingredients = recipeIngredients.stream()
                .map(ri -> {
                    Integer ingredientId = ri.getIngredientId().getId();
                    Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() -> new RuntimeException("Ingredient not found"));
                    return new IngredientQuantityDTO(ingredient.getName(), ri.getQuantity());
                })
                .collect(Collectors.toList());

        return new RecipeWithIngredientsDTO(recipe.getRecipeId(), recipe.getTitle(), recipe.getInstructions(), ingredients);
    }

    // update an ingredient quantity in recipe
    public void updateRecipeIngredient(int recipeId, int ingredientId, String quantity) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        RecipeIngredient recipeIngredient = recipeIngredientRepository.findByRecipeIdAndIngredientId(AggregateReference.to(recipeId), AggregateReference.to(ingredientId));
        if (recipeIngredient == null) {
            throw new RuntimeException("This ingredient in this recipe does not exist");
        }
        recipeIngredientRepository.updateQuantity(recipeId, ingredientId, quantity);
    }

    // delete an ingredient from a recipe
    public void deleteIngredientFromRecipe(int id) {
        recipeIngredientRepository.deleteById(id);
    }
}
