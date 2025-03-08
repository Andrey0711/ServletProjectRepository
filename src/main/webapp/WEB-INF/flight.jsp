<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.03.2025
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty requestScope.flights}">
        <p>Список полетов не пустой</p>
    </c:if>
    <c:if test="${requestScope.flight.isPresent()}">
        <p>Текущий полет:</p>
        <p>${requestScope.flight}</p>
    </c:if>
    <br>
    <p>Все полеты:</p>
    <ul>
        <c:forEach var="flight" items="${requestScope.flights}">
            <li>${fn:toLowerCase(flight)}</li>
        </c:forEach>
    </ul>
</body>
</html>
