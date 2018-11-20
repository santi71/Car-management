<%--
  Created by IntelliJ IDEA.
  User: boryspetkov
  Date: 15.11.2018
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Dodaj ogłoszenie</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<h2>Sprzedaj swój wóz!</h2>
<div class="ogloszenie">

<form:form method="post" modelAttribute="advert">
    Tytuł Ogłoszenia:<form:input path="title" placeholder="Tytuł"/><br>
    Opis ogłoszenia:<form:textarea path="description" placeholder="Opis"/><br>
    Data wygaśnięcia:<form:input path="expireDate" placeholder="Data wygaśnięcia"/><br>
    Marka:<form:input path="mark" placeholder="marka"/><br>
    Model:<form:input path="model" placeholder="model"/><br>
    Kolor:<form:input path="color" placeholder="kolor"/><br>
    Moc:<form:input path="power" placeholder="moc"/><br>
    Cena:<form:input path="price" placeholder="cena"/><br>
    Przebieg:<form:input path="distance" placeholder="przebieg"/><br>
    Rok produkcji:<form:input path="productionYear" placeholder="Rok produkcji"/><br>
    <form:errors path="*"/>
    <input type="submit" value="Dodaj ogłoszenie!">
</form:form>
</div>
</body>
</html>
