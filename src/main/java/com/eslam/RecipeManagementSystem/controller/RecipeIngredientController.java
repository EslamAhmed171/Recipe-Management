package com.eslam.RecipeManagementSystem.controller;

import com.eslam.RecipeManagementSystem.entity.Ingredient;
import com.eslam.RecipeManagementSystem.entity.Recipe;
import com.eslam.RecipeManagementSystem.entity.RecipeIngredient;
import com.eslam.RecipeManagementSystem.entity.RecipeWithIngredientsDTO;
import com.eslam.RecipeManagementSystem.repository.RecipeIngredientRepository;
import com.eslam.RecipeManagementSystem.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeIngredientController {
    @Autowired
    private RecipeIngredientService recipeIngredientService;

    // add an ingredient to a recipe
    @PostMapping("/recipes/{recipeId}/ingredients/{ingredientId}")
    public RecipeIngredient addIngredientToRecipe(@PathVariable int recipeId,
                                                  @PathVariable int ingredientId,
                                                  @RequestParam String quantity) {
        return recipeIngredientService.addIngredientToRecipe(recipeId, ingredientId, quantity);
    }

    // get all ingredients for a recipe
    @GetMapping("/recipes/{recipeId}/ingredients")
    public List<Ingredient> getIngredientFromRecipe(@PathVariable int recipeId) {
        return recipeIngredientService.getAllIngredientsFromRecipe(recipeId);
    }

    // get all recipes contain an ingredient
    @GetMapping("/ingredients/{ingredientId}/recipes")
    public List<Recipe> getAllRecipesContainIngredient(@PathVariable int ingredientId) {
        return recipeIngredientService.getAllRecipesContainIngredient(ingredientId);
    }

    // get all ingredients for a recipe with details
    @GetMapping("/recipes/{recipeId}/ingredients-with-details")
    public RecipeWithIngredientsDTO getAllIngredientsForRecipeWithDetails(@PathVariable int recipeId) {
        return recipeIngredientService.getAllIngredientsForRecipeWithDetails(recipeId);
    }

    // update quantity for a recipe ingredient
    @PutMapping("/recipes/{recipeId}/ingredients/{ingredientId}")
    public void updateQuantity(@PathVariable int recipeId,
                               @PathVariable int ingredientId,
                               @RequestParam String quantity) {
        recipeIngredientService.updateRecipeIngredient(recipeId, ingredientId, quantity);
    }
    //delete an ingredient from a recipe
    @DeleteMapping("/recipes/ingredients/{id}")
    public void deleteIngredientFromRecipe(@PathVariable int id) {
        recipeIngredientService.deleteIngredientFromRecipe(id);
    }
}
