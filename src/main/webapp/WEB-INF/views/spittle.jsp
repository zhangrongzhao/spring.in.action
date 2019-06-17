<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="spittleView">
        <div class="spittleMessage"><c:out value="${spittle.message}"></c:out></div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}"></c:out></span>
        </div>
    </div>
</body>
</html>
