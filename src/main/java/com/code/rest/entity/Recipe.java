package com.code.rest.entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="RECIPE")

public class Recipe {
@Id
@Column(name="ID")
private Long id; 
@Column(name="title")
private String title;
private List<String> ingredients; 
private String instructions;
private int cookingTime;
private String difficultyLevel; private double
averageRating;
// Constructors, getters, and setters
//public Recipe(Long id, String title, List<String> ingredients, String instructions, int cookingTime,
//		String difficultyLevel, double averageRating) {
//	super();
//	this.id = id;
//	this.title = title;
//	this.ingredients = ingredients;
//	this.instructions = instructions;
//	this.cookingTime = cookingTime;
//	this.difficultyLevel = difficultyLevel;
//	this.averageRating = averageRating;
//}
public Recipe() {
}
public Recipe(Long id, String title, List<String> ingredients, String instructions, int cookingTime,
		String difficultyLevel, double averageRating) {
	super();
	this.id = id;
	this.title = title;
	this.ingredients = ingredients;
	this.instructions = instructions;
	this.cookingTime = cookingTime;
	this.difficultyLevel = difficultyLevel;
	this.averageRating = averageRating;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<String> getIngredients() {
	return ingredients;
}
public void setIngredients(List<String> ingredients) {
	this.ingredients = ingredients;
}
public String getInstructions() {
	return instructions;
}
public void setInstructions(String instructions) {
	this.instructions = instructions;
}
public int getCookingTime() {
	return cookingTime;
}
public void setCookingTime(int cookingTime) {
	this.cookingTime = cookingTime;
}
public String getDifficultyLevel() {
	return difficultyLevel;
}
public void setDifficultyLevel(String difficultyLevel) {
	this.difficultyLevel = difficultyLevel;
}
public double getAverageRating() {
	return averageRating;
}
public void setAverageRating(double averageRating) {
	this.averageRating = averageRating;
}
@Override
public String toString() {
	return "Recipe [id=" + id + ", title=" + title + ", ingredients=" + ingredients + ", instructions=" + instructions
			+ ", cookingTime=" + cookingTime + ", difficultyLevel=" + difficultyLevel + ", averageRating="
			+ averageRating + "]";
}

}