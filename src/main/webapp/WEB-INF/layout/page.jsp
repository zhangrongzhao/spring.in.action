<%@ taglib  uri="http://www.springframework.org/tags"  prefix="s"%>
<%@ taglib  uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="resources/style.css"/>"/>
</head>
<body>
    <div id="header">
        <t:insertAttribute name="header"/>
    </div>
    <div id="content">
        <t:inertAttribute name="body"/>
    </div>
    <div id="footer">
        <t:inertAttribute name="footer"/>
    </div>
</body>
</html>
