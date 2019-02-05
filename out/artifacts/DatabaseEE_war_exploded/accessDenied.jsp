<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 05.02.2019
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schronisko Java - brak uprawnień</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<h2>Na koncie <c:out value="${sessionScope.username}"/> nie ma wystarczających uprawnień by uzyskać dostęp do zasobu.</h2>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</body>
</html>