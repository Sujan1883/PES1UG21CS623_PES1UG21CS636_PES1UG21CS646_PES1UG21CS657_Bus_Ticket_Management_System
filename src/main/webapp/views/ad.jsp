<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        /* CSS styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #23d0d0; /* Light neon background color */
            text-align: center; /* Center-align all text */
        }

        h1 {
            color: #333;
        }

        .verify-button {
            padding: 10px 20px;
            background-color: #4caf50; /* Green color for verify button */
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }

        .invalidate-button {
            padding: 10px 20px;
            background-color: #f44336; /* Red color for invalidate button */
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }

        button:hover {
            opacity: 0.8; /* Reduced opacity on hover */
        }
    </style>
    <script>
        function redirectToLogin(userType) {
            var url = "/view/" + userType;
            window.location.href = url;
        }
    </script>
</head>
<body>
    <h1>Welcome to the Admin Page</h1>
    
    <button class="verify-button" onclick="redirectToLogin(4)">Verify ticket</button>
    <button class="invalidate-button" onclick="redirectToLogin(5)">Invalidate ticket</button>
    
</body>
</html>
