<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Affichage des Produits</title>
    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function() {
            if (!localStorage.getItem('formSubmitted')) {
                localStorage.setItem('formSubmitted', 'true');
                document.getElementById('productForm').submit();
            }
        });
    </script>
</head>
<body>
    <h1>Liste des Produits</h1>
    <form action="./Affiche" method="GET" id="productForm">
        <input type="hidden" name="autoSubmit" value="true"/>
    

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Quantité</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td><c:out value="${product.id}" /></td>
                        <td><c:out value="${product.nom}" /></td>
                        <td><c:out value="${product.qte}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
    <c:if test="${empty productList}">
        <p>Aucun produit trouvé.</p>
    </c:if>
</body>
</html>
