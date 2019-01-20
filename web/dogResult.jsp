<%@ page import="com.tomek.data.Dog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% Dog dog = (Dog)request.getAttribute("dog"); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Schronisko Java - wynik zapytania</title>
</head>
<body>
<h1>Wynik zapytania <%= request.getAttribute("option") %></h1>
<p>W wyniku Twojego zapytania otrzymano następujacy wynik:</p>
<p>Imię: <%= dog.getName() %><br>
    Rasa: <%= dog.getAge()) %><br>
    Wiek: <%= dog.getRace() %><br>
    Aportuje:<%= dog.getIsFetching() %><br>
    Rodowód: <%= dog.getIsPurebred() %> </p>
<a href="index.jsp">Powrót do strony głównej</a> ||
<a href="addAnimal.jsp">Dodaj/usuń kolejne zwierzę</a>
</body>
</html>