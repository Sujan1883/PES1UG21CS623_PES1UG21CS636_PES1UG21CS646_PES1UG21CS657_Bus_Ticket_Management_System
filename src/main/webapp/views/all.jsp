<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.code.rest.entity.Ticket" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tickets</title>
<style>
    body {
        background-color: beige; /* Choose your desired background color */
    }
    
    .ticket-details {
        text-align: center;
    }
    
    .green-background {
        background-color: lightgreen;
    }
    
    .red-background {
        background-color: red;
    }
</style>
</head>
<body>
<h2>Tickets for ${mail}</h2>
<%
    List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets"); // Declare tickets variable and retrieve it from the request
    for (Ticket ticket : tickets) {
        String backgroundClass = ticket.getStatus() ? "green-background" : "red-background";
%>
    <div class="ticket-details <%= backgroundClass %>">
        <p>Stop Name: <%= ticket.getSt_name() %></p>
        <p>Destination Name: <%= ticket.getDt_name() %></p>
        <p>Amount: <%= ticket.getAmount() %></p>
        <hr>
    </div>
<% } %>
</body>
</html>
