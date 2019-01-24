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
    <title>Schronisko Java - zaloguj się do panelu zarządzania</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<h2>Podaj swoje dane logowania by uzyskać uprawnienia administratora:</h2>
<form action="j_security_check" method="post">
   Twoja unikatowa nazwa użytkownika:<br> <input type="text" placeholder="login" name="j_username"><br>
   Twoje hasło:<br> <input type="password" placeholder="password" name="j_password"><br><br>
    <input type="submit" value="Zaloguj"/>
</form>
</body>
</html>
