<%--
  Created by IntelliJ IDEA.
  User: boryspetkov
  Date: 14.11.2018
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>

    <title>Strona Główna</title>
</head>
<body>
<div id="container">
    <div id="logo">
        MotoHandel!
    </div>


<div id="menu">
    <div class="option"> <a href="/registration">Zarejestruj się</a> </div>
    <div class="option"> <a href="/login">Zaloguj się</a> </div>
    <div class="option"> <a href="/adverts"> Spis ogłoszeń</a> </div>
    <div class="option"> <a>O stronie</a> </div>
    <div class="option"> <a href="https://www.blasty.pl/upload/images/large/2018/04/kurla-pjoter-nie-dziala_2018-04-18_11-59-00.jpg">Części samochodowe</a></div>
    <div class="option"> <a href="/adverts/add-advert">Dodaj ogłoszenie</a></div>
    <div style="clear: both"></div>

</div>
    <div id="topbar">
        <div id="topbarL">
            <img class="obrazek" src="/img/samochodzik.jpg" width="138px" height="138px"/>
        </div>
        <div id="topbarR">
        Zamieszczaj swoje ogłoszenia! <br> Chcesz kupić, lub sprzedać swój samochód? U nas zrobisz to bez problemu.
        Sprzedaż samochodu nigdy nie była tak prosta i szybka! Ogłoszenia z całej Polski, klienci z całego świata.
        Jeżeli odwiedziłeś tą stronę, na pewno znajdziesz coś dla siebie!
        Oto MotoHandel!
        </div>
        <div style="clear: both"> </div>
    </div>

    <div id="sidebar">
        <div class="optionL"> <a href="/registration">Zarejestruj się</a> </div>
        <div class="optionL"> <a href="/login">Zaloguj się</a> </div>
        <div class="optionL"> <a href="oferty.jsp"> Spis ogłoszeń</a> </div>
        <div class="optionL"> <a>O stronie</a> </div>
        <div class="optionL"> <a>Części samochodowe</a></div>
        <div class="optionL"> <a>Dodaj ogłoszenie</a> </div>
    </div>

    <div id="content">

    </div>

    <c:if test="${not empty loggedUser}">
        <div>
            <p>${loggedUser}</p>
            <p>Zalogowany użytkownik: + [${loggedUser.id}] ${loggedUser.login}</p>

    </c:if>
</div>
</div>


<div id="footer"><p>Najlepszy portal handlowy w internecie!</p></div>

</div>
</body>
</html>
