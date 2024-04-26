<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css?v=1">
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://i.imgur.com/ahhhka1.png');
            background-size: 100% 100%; /* Set background size to cover entire body */
            background-repeat: no-repeat;
            height:800px;
            margin: 0;
            padding: 0;
        }

        .login-container {
            background-color: rgba(255, 255, 255, 0.8);
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .login-container h2 {
            text-align: center;
        }

        .input-group {
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            margin-bottom: 5px;
        }

        .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-bottom: 6px;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2 class="test-style">Login</h2>
        <form action="/user/login/${flag}" method="post">
            <div class="input-group">
                <label for="email">Username:</label>
                <input type="text" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
        </form>
        <% boolean flag = (boolean) request.getAttribute("flag"); %>
        <% if (flag) { %>
            <form action="/signup" >
                <button type="submit">Sign Up</button>
            </form>
        <% } %>
    </div>
</body>
</html>
