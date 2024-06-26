package com.eslam.RecipeManagementSystem.repository;

import com.eslam.RecipeManagementSystem.entity.Recipe;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    @Modifying
    @Query("UPDATE in SET instructions = :instructions WHERE recipe_id = :id")
    void updateInstructions(int id, String instructions);
}
