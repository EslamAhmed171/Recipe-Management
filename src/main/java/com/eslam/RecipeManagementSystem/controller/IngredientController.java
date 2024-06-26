package com.eslam.RecipeManagementSystem.controller;

import com.eslam.RecipeManagementSystem.entity.Ingredient;
import com.eslam.RecipeManagementSystem.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @PostMapping
    public Ingredient addRecipe(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }
    // Get ingredient by id
    @GetMapping("/{id}")
    public Optional<Ingredient> getIngredient(@PathVariable int id) {
        return ingredientService.getIngredient(id);
    }
    // Get all ingredients router
    @GetMapping
    public Iterable<Ingredient> getIngredients() {
        return ingredientService.getAllIngredients();
    }
    // Delete ingredient
    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable int id) {
        ingredientService.deleteIngredient(id);
    }
}
