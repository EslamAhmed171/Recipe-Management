package com.eslam.RecipeManagementSystem.service;

import com.eslam.RecipeManagementSystem.entity.Recipe;
import com.eslam.RecipeManagementSystem.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    // Add recipe
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    // Get recipe by id
    public Optional<Recipe> getRecipe(int id) {
        return recipeRepository.findById(id);
    }
    // Get all recipes
    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    // Update recipe by id
    public void updateRecipeInstructions(int id, String instructions) {
        recipeRepository.updateInstructions(id, instructions);
    }
    // Delete recipe
    public void deleteRecipe(int id) {
        recipeRepository.deleteById(id);
    }
}
