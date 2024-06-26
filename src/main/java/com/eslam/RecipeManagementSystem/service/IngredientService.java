package com.eslam.RecipeManagementSystem.service;

import com.eslam.RecipeManagementSystem.entity.Ingredient;
import com.eslam.RecipeManagementSystem.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;
    // Add ingredient
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
    // Get ingredient by id
    public Optional<Ingredient> getIngredient(int id) {
        return ingredientRepository.findById(id);
    }
    // Get all ingredients
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
    // Delete ingredient
    public void deleteIngredient(int id) {
        ingredientRepository.deleteById(id);
    }
}
