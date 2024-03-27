<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>

<body>

<c:if test="${empty sessionScope.login}">
    <h2>Connexion</h2>
    <form action="./Connexion" method="GET">
        <div>
            <label for="login">Login :</label>
            <input type="text" name="login" required>
        </div>
        <div>
            <label for="password">Mot de passe :</label>
            <input type="password" name="password" required>
        </div>
        <div>
            <button type="submit">Se connecter</button>
        </div>
    </form>
</c:if>

<c:if test="${not empty sessionScope.login}">
    <c:redirect url="./Menu.jsp"/>
</c:if>

</body>
</html>
