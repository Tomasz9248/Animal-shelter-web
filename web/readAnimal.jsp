<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Schronisko Java - wyszukaj zwierzę</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<h2>Podaj imię zwierzęcia by zobaczyć informacje </h2>
<form action="SearchDeleteServlet" method="post">
    <input type="text" placeholder="Imię" name="name">
    <br>
    <input type="submit" name ="option" value="Szukaj">
</form>
</body>
</html>