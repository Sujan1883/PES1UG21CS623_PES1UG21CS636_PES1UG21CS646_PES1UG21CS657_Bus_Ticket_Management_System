<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Recipe</title>
</head>
<body>
    <h1>Add Recipe</h1>
    <form action="/recipe" method="post">
        <label>Title:</label><br>
        <input type="text" name="title" required><br>
        
        <label>Ingredients (comma separated):</label><br>
        <input type="text" name="ingredients" required><br>
        
        <label>Instructions:</label><br>
        <textarea name="instructions" rows="4" cols="50" required></textarea><br>
        
        <label>Cooking Time (minutes):</label><br>
        <input type="number" name="cookingTime" required><br>
        
        <label>Difficulty Level:</label><br>
        <select name="difficultyLevel">
            <option value="Easy">Easy</option>
            <option value="Medium">Medium</option>
            <option value="Hard">Hard</option>
        </select><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
