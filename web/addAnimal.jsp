<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Schronisko Java - dodaj/modyfikuj zwierzę</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/navbar.jspx"/>
<h2>Podaj dane zwierzęcia które chcesz dodać/zmodyfikować </h2>
<form action="DogServlet" method="post">
    <input type="text" placeholder="Imię" name="name">
    <br>
    <input type="text" placeholder="rasa" name="race"><br>
    <input type="number" placeholder="wiek" name="age"><br>
    <b>Czy potrafi aportować?</b><br>
    Tak <input type="radio" name="isFetching" value="tak"> Nie <input type="radio" name="isFetching" value="nie"><br>
    <b>Czy jest rasowy?</b><br>
    Tak<input type="radio" name="isPurebred" value="tak"> Nie <input type="radio" name="isPurebred" value="nie">
    <h3>Wybierz akcję:</h3>
    Dodaj: <input type="radio" name="option" value="add"><br>
    Modyfikuj: <input type="radio" name="option" value="update"><br>
    <input type="submit" name ="option"/>
    <%@ include file="WEB-INF/fragments/footer.jspx"%>
</form>
</body>
</html>