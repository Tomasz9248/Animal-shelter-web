<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tomek.data.Dog" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Schronisko Java - lista zwierząt</title>
</head>
<body>
<h2>Lista zwierząt przebywających w schronisku:</h2>
<table style="width:100%" border="1">
    <tr>
        <th>Imię</th>
        <th>Rasa</th>
        <th>Wiek</th>
        <th>Aportuje</th>
        <th>Rodowód</th>

    </tr>
    <%
        List<Dog> animalList = (List<Dog>)request.getAttribute("animalList");
        if(animalList != null)
            for(Dog animal : animalList) {
    %>
    <tr>
        <td><%= animal.getName() %></td>
        <td><%= animal.getRace() %></td>
        <td><%= animal.getAge() %></td>
        <td><%= animal.getIsFetching() %></td>
        <td><%= animal.getIsPurebred() %></td>
    </tr>
    <%
            }
    %>
</table>
</body>
</html>