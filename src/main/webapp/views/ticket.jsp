<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Ticket</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background: linear-gradient(to bottom, #673ab7, #2196f3);
    }

    .content {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 20px;
        border-radius: 5px;
    }

    h1 {
        text-align: center;
        color: #fff;
    }

    form {
        text-align: center;
    }

    label {
        display: block;
        margin-bottom: 10px;
        color: #333;
    }

    select, input[type="submit"] {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: none;
        margin-bottom: 15px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="content">
<%
List<String> Stops = (List<String>) request.getAttribute("Stop");
%>
    <h1 style="color: black;">Book Ticket</h1>
    <h1 style="color: black;">${mail}</h1>
    <form action="/user/book/${mail}" method="post" onsubmit="return validateForm()">
        <label for="from">From:</label>
        <select id="from" name="from" required>
            <option value="">Select From</option>
            <% for (String Stop : Stops) { %>
                <option value="<%= Stop %>"><%= Stop %></option>
            <% } %>
        </select>
        <br>
        <label for="to">To:</label>
        <select id="to" name="to"  required>
            <option value="">Select To</option>
            <% for (String Stop : Stops) { %>
                <option value="<%= Stop %>"><%= Stop %></option>
            <% } %>
        </select>
        <br>
        <input type="submit" value="Book">
    </form>
</div>

<%-- JavaScript to check if 'From' and 'To' are same --%>
<script>
    function validateForm() {
        var from = document.getElementById("from").value;
        var to = document.getElementById("to").value;
        if (from === to) {
            alert("From and To cannot be the same");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
