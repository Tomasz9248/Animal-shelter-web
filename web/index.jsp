<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 18.01.2019
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witamy na stronie schroniska Java</title>
</head>
<body>
<header><img src="/res/dogBanner.jpg" width="100%"  alt=""></header>
<br><form action="addAnimal.jsp" method="post"><button>Dodaj zwierzę</button></form>
<form action="/ListServlet" method="post"><button>Pokaż listę zwierząt</button></form>
<form action="login.jsp" method="post"><button>Zaloguj się</button></form>

</body>
</html>
