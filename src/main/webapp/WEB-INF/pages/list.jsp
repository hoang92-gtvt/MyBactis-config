<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/9/2021
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>c:forEach JSTL core tag example</title>
</head>

<body>
<h3>Duoi day se hien thi ten du lieu</h3>
<c:forEach items="${list}" var="map">
    <h3>${map.name}</h3>
    <h3>${map.name}</h3>
    <h3>${map.password}</h3>
</c:forEach>
</body>
</html>
