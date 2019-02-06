<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Schronisko Java - wyszukaj zwierzę</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<h2>Podaj imię zwierzęcia by zobaczyć informacje </h2>
<form action="/search-status" method="post">
    <input type="text" placeholder="Imię" name="name">
    <br>
    <input type="submit" name ="option" value="Szukaj"/>
</form>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</body>
</html>