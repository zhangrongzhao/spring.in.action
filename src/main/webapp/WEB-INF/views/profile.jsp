<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Your profile</h1>
    <c:out value="${spitter.userName}"></c:out><br/>
    <c:out value="${spitter.firstName}"></c:out>
    <c:out value="${spitter.lastName}"></c:out>
</body>
</html>
