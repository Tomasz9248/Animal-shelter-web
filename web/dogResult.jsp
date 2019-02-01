<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tomek.data.Dog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<jsp:useBean id="dog" class="com.tomek.data.Dog" scope="request">
    <jsp:setProperty name="dog" property="*"/>
</jsp:useBean>

<link rel="stylesheet" type="text/css" href="style.css">
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Schronisko Java - wynik zapytania</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
W wyniku Twojego zapytania <c:out value="${operation}"/> otrzymano następujący wynik:
<p>Imię: <jsp:getProperty name="dog" property="name"/><br>
    Rasa: <jsp:getProperty name="dog" property="race"/><br>
    Wiek: <jsp:getProperty name="dog" property="age"/><br>
    Aportuje: <jsp:getProperty name="dog" property="isFetching"/><br>
    Rodowód: <jsp:getProperty name="dog" property="isPurebred"/></p>
<a href="index.jsp">Powrót do strony głównej</a> ||
<a href="addAnimal.jsp">Dodaj/usuń kolejne zwierzę</a>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</body>
</html>