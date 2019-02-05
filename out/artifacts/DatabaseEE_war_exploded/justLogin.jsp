<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 18.01.2019
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
    <title>Schronisko Java - zaloguj się</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<h2>Podaj swoje dane logowania:</h2>
<form action="/LoginServlet" method="post">
    Twoja unikatowa nazwa użytkownika:<br> <input type="text" placeholder="login" name="username"><br>
    Twoje hasło:<br> <input type="password" placeholder="password" name="password"><br><br>
    <input type="submit" value="Zaloguj"/>
</form>
<h3> Nie masz jeszcze konta?<a href="register.jsp">Zarejestruj się!</a> </h3>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</body>
</html>
