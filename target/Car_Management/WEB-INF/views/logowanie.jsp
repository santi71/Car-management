<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: boryspetkov
  Date: 14.11.2018
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form:form method="post" modelAttribute="loginForm">
        <form:input path="login" placeholder="Login"/>
        <form:errors path="login"></form:errors>
        <form:password path="password"  placeholder="Password"/>
        <form:errors path="password"></form:errors>
        <input type="submit" value="Zaloguj"/>
    </form:form>
</div>
</body>
</html>
