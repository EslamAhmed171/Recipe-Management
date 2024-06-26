package com.eslam.RecipeManagementSystem.repository;

import com.eslam.RecipeManagementSystem.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

}
