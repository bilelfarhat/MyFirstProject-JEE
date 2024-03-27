<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <h1>Ajout de Produit</h1>
    
    <% 
        // Check if the user is authenticated by checking if "login" attribute exists in session
        String login = (String) session.getAttribute("login");
        if (login != null && !login.isEmpty()) { 
    %>
        <!-- Display the form for adding a product -->
        <form action="./TraitementAjout" method="POST">
            <div>
                <label for="id">ID:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <div>
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" required>
            </div>
            <div>
                <label for="quantite">Quantité:</label>
                <input type="number" id="quantite" name="quantite" required>
            </div>
            <div>
                <button type="submit">Ajouter</button>
            </div>
        </form>
    <% } else { 
        // If user is not authenticated, redirect to index.jsp
        response.sendRedirect("./index.jsp");
    } %>


</body>
</html>