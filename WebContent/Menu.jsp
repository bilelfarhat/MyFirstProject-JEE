<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
    <h1>Welcome to the Menu Page</h1>
    <p>This is your menu content.</p>
    

        <!-- Display links only if user is authenticated -->
        <ul>
            <li><a href="./Ajout.jsp">Ajout</a></li>
            <li><a href="./Chercher.jsp">Chercher</a></li>
             <li><a href="./Affiche.jsp">Affiche</a></li>
        </ul>
        <!-- Add a logout link or button -->
        <a href="./Logout">Logout</a>
</body>
</html>
