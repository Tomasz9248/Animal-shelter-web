<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 21.01.2019
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
    <title>Schronisko Java - usuń zwierzę</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<form action="SearchDeleteServlet" method="post">
    <h2>Podaj imię zwierzęcia, które chcesz usunąć z bazy</h2>
    <input type="text" placeholder="Imię" name="name"><br>
    <input type="submit" name ="option" value="Usuń"/>
</form>
</body>
</html>
