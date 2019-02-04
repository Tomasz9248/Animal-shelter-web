<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 21.01.2019
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
    <title>Schronisko Java - błąd logowania</title>
</head>
<body>
<@include file="""/WEB-INF/fragments/navbar.jspx"%>
<h2>Podane dane do autoryzacji są błędne.</h2>
<a href="addAnimal.jsp">Spróbuj ponownie</a><br>
<a href="index.jsp">Wróc do strony głównej</a>
</body>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</html>
