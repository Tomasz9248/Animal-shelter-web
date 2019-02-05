<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 31.01.2019
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="style.css">
<head>
    <title>Schronisko Java - zarejestruj się</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>

<h1>Podaj dane aby założyć nowe konto:</h1>
<form action="RegisterServlet" method="post">
    <input type="text" name="username" placeholder="nazwa użytkownika" required><br>
    <input type="email" name="emailAddress" placeholder="adres e-mail" required><br>
    <input type="password" name="password" placeholder="hasło" required><br>
    <input type="submit" value="Zarejestruj się"/>
</form>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</body>
</html>
