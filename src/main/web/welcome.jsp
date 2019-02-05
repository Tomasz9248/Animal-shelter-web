<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 31.01.2019
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Schronisko Java - Witamy!</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>

<h2>Witaj wśród zarejestrowanych członków Schroniska Java <c:out value="${username}"/>  </h2>
<%@ include file="WEB-INF/fragments/footer.jspx"%>
</body>
</html>
