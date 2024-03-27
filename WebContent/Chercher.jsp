<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Chercher un Produit</h1>
    
    <% 
        // Vérifier si la session contient l'attribut "login"
        String login = (String) session.getAttribute("login");
        if (login != null && !login.isEmpty()) { 
    %>
        <!-- Afficher le formulaire de recherche -->
        <form action="./TraitementAjout" method="GET">
            <div>
                <label for="id">ID:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <div>
                <label for="quantite">Quantité à acheter:</label>
                <input type="number" id="quantite" name="quantite" required>
            </div>
            <div>
                <button type="submit">Chercher</button>
            </div>
        </form>
    <% } else { 
        // Si l'utilisateur n'est pas authentifié, rediriger vers index.jsp
        response.sendRedirect("./Index.jsp");
    } %>

</body>
</html>