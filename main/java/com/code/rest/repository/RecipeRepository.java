package com.code.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.rest.entity.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
