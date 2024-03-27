<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
session=request.getSession();
String login=(String)session.getAttribute("login");
if (login ==null){
	

%>




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
<%    
} 
else {
	response.sendRedirect("./Menu.jsp");

	
}
%> 

</body>
</html>