package com.eslam.RecipeManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(
		{"com.eslam.RecipeManagementSystem.service",
		"com.eslam.RecipeManagementSystem.repository",
		"com.eslam.RecipeManagementSystem.entity",
		"com.eslam.RecipeManagementSystem.controller"})
public class RecipeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeManagementSystemApplication.class, args);
	}

}
