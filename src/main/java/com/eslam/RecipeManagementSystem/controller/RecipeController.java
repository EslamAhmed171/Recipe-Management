package com.eslam.RecipeManagementSystem.controller;


import com.eslam.RecipeManagementSystem.entity.Recipe;
import com.eslam.RecipeManagementSystem.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    // Add recipe router
    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
    // Get recipe by id
    @GetMapping("/{id}")
    public Optional<Recipe> getRecipe(@PathVariable int id) {
        return recipeService.getRecipe(id);
    }
    // Get all recipes router
    @GetMapping
    public Iterable<Recipe> getRecipe() {
        return recipeService.getAllRecipes();
    }
    // Update recipe router
    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable int id, @RequestParam String instructions) {
        recipeService.updateRecipeInstructions(id, instructions);
    }
    // Delete recipe
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
    }

}
