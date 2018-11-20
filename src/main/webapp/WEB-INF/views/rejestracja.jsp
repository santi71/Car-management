<%--
  Created by IntelliJ IDEA.
  User: boryspetkov
  Date: 14.11.2018
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>

<div>
    <form:form modelAttribute="regForm" method="post">
        Login: <form:input path="login"/><br/>
        <form:errors path="*"></form:errors>
        Email: <form:input path="email"/><br/>
        Hasło: <form:password path="password"/><br/>
        Potwierdź hasło: <form:password path="confirmedPassword"/><br/>
        Imię: <form:input path="firstName"/><br/>
        Nazwisko: <form:input path="lastName"/><br/>
        <input type="submit" value="Zarejestruj"/>
        <input type="reset" value="Wyczyść"/>
    </form:form>
</div>

</body>
</html>
