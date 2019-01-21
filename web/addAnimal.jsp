<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Strona główna</title>
</head>
<body>
<h1>Podaj dane zwierzęcia: </h1>
<form action="DogServlet" method="post">
    <input type="text" placeholder="Imię" name="name">
    <br>
    <input type="text" placeholder="rasa" name="race">
    <br>
    <input type="number" placeholder="wiek" name="age">
    <br> <b>Czy potrafi aportować?</b>
    <br>Tak <input type="radio" name="isFetching" value="tak"> Nie <input type="radio" name="isFetching" value="nie">
    <br> <b>Czy jest rasowy?</b>
    <br>Tak<input type="radio" name="isPurebred" value="tak"> Nie <input type="radio" name="isPurebred" value="nie">
    <br><h2>Wybierz akcję:</h2>
    Szukaj: <input type="radio" name="option" value="search"><br>
    Dodaj: <input type="radio" name="option" value="add"><br>
    Modyfikuj: <input type="radio" name="option" value="update"><br>
    Usuń: <input type="radio" name="option" value="delete"><br>
    <br>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>