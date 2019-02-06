<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tomek.data.Dog" %>
<link rel="stylesheet" type="text/css" href="style.css">
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Schronisko Java - lista zwierząt</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<h2>Lista zwierząt przebywających w schronisku:</h2>
<table class="zebra-table">
    <tr>
        <th>Imię</th>
        <th>Rasa</th>
        <th>Wiek</th>
        <th>Aportuje</th>
        <th>Rodowód</th>
    </tr>
    <tr>
        <c:forEach items="${animalList}" var="animal">
        <td><c:out value="${animal.name}"/></td>
        <td><c:out value="${animal.race}"/></td>
        <td><c:out value="${animal.age}"/></td>
        <td><c:out value="${animal.isFetching}"/></td>
        <td><c:out value="${animal.isPurebred}"/></td>
            <td><form method="Post" action="/delete-status">
                <input type="hidden" name="name" value=<c:out value="${animal.name}"/> />
                <button name="option" value="Usuń" type="submit">Adoptuj</button>
            </form></td>
    </tr>
    </c:forEach>
</table>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</body>
</html>