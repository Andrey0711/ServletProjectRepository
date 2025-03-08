<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.03.2025
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Create ticket</title>
</head>
<body>
<form method="POST" action="/create">
    <label for="name">Введите имя:
        <input type="text" name="name" id="name">
    </label>
    <br>
    <label for="email">Введите емаил:
        <input type="text" name="email" id="email">
    </label>
    <br>
    <label for="birthday">Введите год рождения:
        <input type="date" name="birthday" id="birthday">
    </label>
    <br>
    <label for="password">Пароль:
        <input type="password" name="password" id="password">
    </label>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select>
    <br>
    <c:forEach var="gender" items="${requestScope.gender}">
        <label for="${gender}">
            <input type="radio" name="gender"  value="${gender}" id="${gender}"> ${gender}
        </label>
    </c:forEach>
    <input type="submit" value="Submit">
</form>
</body>
</html>
