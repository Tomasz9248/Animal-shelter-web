<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 18.01.2019
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schronisko Java - zaloguj się</title>
</head>
<body>
<h2>Podaj swoje dane logowania:</h2><br>
<form action="/LoginServlet" method="post">
   Twoja unikatowa nazwa użytkownika:<br> <input type="text" placeholder="login" name="username"><br>
   Twoje hasło:<br> <input type="password" placeholder="password" name="password"><br><br>
    <input type="submit" value="Zaloguj"/>
</form>
</body>
</html>
