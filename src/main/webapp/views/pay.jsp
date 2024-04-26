<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: cyan; /* Set background color to cyan */
        text-align: center; /* Center-align all text */
        margin: 0;
        padding: 0;
    }

    form {
        margin-top: 50px; /* Add margin to the top for spacing */
    }

    h2 {
        margin-bottom: 20px; /* Add margin at the bottom of h2 for spacing */
    }

    p {
        margin-bottom: 10px; /* Add margin at the bottom of each paragraph for spacing */
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
        background-color: #ce01cb;
    }
</style>
</head>
<body>
<form action="/user/paid/${mail}/${fare}" method="post">
    <h2>Payment Details</h2>
    <p>From: ${from}</p>
    <p>To: ${to}</p>
    <p>Fare: ${fare}</p>
    
    <!-- Add hidden input fields for 'from' and 'to' -->
    <input type="hidden" name="from" value="${from}">
    <input type="hidden" name="to" value="${to}">
    
    <button type="submit">Make Payment</button>
</form>

<form action="/user/1/${mail}">
    <button type="submit">Cancel</button>
</form>
</body>
</html>
