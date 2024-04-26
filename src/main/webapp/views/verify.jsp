<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Verify Page</title>
    <style>
        body {
            background-color: green;
            text-align: center;
        }
        h1, h2, label {
            text-align: center;
        }
    </style>
</head>
<body>
    <h2>Verify Page</h2>
    <form action="/view/verify" method="post">
    <label for="id">Enter ID:</label>
    <input type="text" id="id" name="id" required><br><br>
    <button type="submit">Verify</button>
    
    <h1>${msg}</h1>
</form>
</body>
</html>
