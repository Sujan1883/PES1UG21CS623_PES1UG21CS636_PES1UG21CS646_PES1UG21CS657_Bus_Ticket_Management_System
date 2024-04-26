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
        width: 100%;
        height: 100vh;
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-image: url('https://gumlet.assettype.com/swarajya/2021-12/b3ba5199-ea26-4eda-afd7-918075c4cd5c/electric_buses_in_bengaluru.jpg?w=1200&auto=format%2Ccompress&ogImage=true');
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        background-color: cyan; /* Cyan background color */
        display: flex;
        justify-content: center;
        align-items: flex-start;
        text-align: center; /* Center-align all text */
    }

    #homeBody{
        margin-top: 20px; /* Adjust the margin to position the box from the top */
        width:500px;
        height:200px;
        background-color: white;
        border-radius: 50px;
    }

    h1 {
        color: #333;
    }

    button {
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin: 5px;
    }

    /* User button style */
    button.user-button {
        background-color: #4CAF50; /* Green color for user button */
        color: white;
    }

    /* Admin button style */
    button.admin-button {
        background-color: #FFA500; /* Orange color for admin button */
        color: white;
    }

    button:hover {
        opacity: 0.8; /* Reduced opacity on hover */
    }
</style>
<script>
    function redirectToLogin(userType) {
        var url = "/login/" + userType;
        window.location.href = url;
    }
</script>
</head>
<body>
    <div id="homeBody">
        <h1>Welcome to the Home Page</h1>
        <button class="user-button" onclick="redirectToLogin(1)">User</button>
        <button class="admin-button" onclick="redirectToLogin(0)">Admin</button>
    </div>
</body>
</html>
