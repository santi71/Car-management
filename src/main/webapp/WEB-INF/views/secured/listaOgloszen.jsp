<%--
  Created by IntelliJ IDEA.
  User: boryspetkov
  Date: 16.11.2018
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Ogłoszenia</h2>
<ul>
    <c:forEach items="${adverts}" var="adv">
        <li>${adv.title}
            <span>${adv.content}</span>
        </li>
    </c:forEach>
</ul>
</body>
</html>
