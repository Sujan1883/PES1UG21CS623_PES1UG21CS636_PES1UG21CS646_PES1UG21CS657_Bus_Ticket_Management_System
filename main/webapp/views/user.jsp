<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
<script>
    function redirectToLogin(userType, name) {
        var url = "/user/" + userType + "/" + encodeURIComponent(name);
        window.location.href = url;
    }
</script>
<style>
    /* CSS styling */
    body {
        font-family: Arial, sans-serif;
        
        background-image: url('https://etimg.etb2bimg.com/photo/108478664.cms');
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        height:800px;
        margin: 0;
        padding: 0;
        text-align: center; /* Center-align all text */
    }

    h1 {
        margin-top: 100px; /* Adjust the margin-top value for vertical centering */
        color: #333;
    }

    button {
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin: 5px;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <% String name = (String) request.getAttribute("mail"); %>
    <h1 style="color: white;">Welcome to the User Page</h1>
    <h1 style="color: white;"><%= name %></h1>
    <button onclick="redirectToLogin(1, '<%= name %>')">Book Ticket</button>
    <button onclick="redirectToLogin(2, '<%= name %>')">View My Tickets</button>
</body>
</html>
