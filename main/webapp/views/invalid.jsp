<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Verify Page</title>
    <style>
        /* CSS styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #d3f7d3; /* Light green background color */
            text-align: center; /* Center-align all text */
        }

        h2 {
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"] {
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 15px;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        h1 {
            margin-top: 20px;
            color: #333;
        }
    </style>
</head>
<body>
    <h2>Verify Page</h2>
    <form action="/view/invalid" method="post">
        <label for="id">Enter ID:</label>
        <input type="text" id="id" name="id" required><br><br>
        <button type="submit">Invalidate</button>
    </form>
    <h1>${msg}</h1>
</body>
</html>
