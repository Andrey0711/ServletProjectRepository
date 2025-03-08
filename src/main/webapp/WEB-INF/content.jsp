<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2025
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty requestScope.tickets}">
        <p>Не пустая</p>
    </c:if>
    <span>Content. Контент</span>
    <p>Ticket: ${requestScope.ticket}</p>
    <p>Все билеты:</p>
    <ul>
        <c:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toLowerCase(ticket)}</li>
        </c:forEach>
    </ul>
</body>
</html>
