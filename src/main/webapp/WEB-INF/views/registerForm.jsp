<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Title</title>
    <style>
        span.error{
            color:red;
        }
        div.error{
            background-color:#ffcccc;
            border:2px solid red;
        }
    </style>
</head>
<body>
    <h1>Register</h1>
    <sf:form method="POST" commandName="spitter">
        <sf:errors path="*" element="div" cssClass="errors"></sf:errors>
        <sf:label path="firstname" cssErrorClass="error">First Name</sf:label>:<sf:input path="firstName"/><sf:errors path="firstName"/><br/>
        <sf:label path="lastName"  cssErrorClass="error">Last Name</sf:label>:<sf:input path="lastName"/><sf:errors path="lastName"/><br/>
        <sf:label path="email"  cssErrorClass="error">Email</sf:label>:<sf:input path="email"/><sf:errors path="email"/><br/>
        <sf:label path="userName"  cssErrorClass="error">UserName</sf:label>:<sf:input path="userName"/><sf:errors path="userName"/><br/>
        <sf:label path="errorName"  cssErrorClass="error">Password</sf:label>:<sf:password path="password"/><sf:errors path="password"/><br/>
        <input type="submit" value="Register"/><br/>
    </sf:form>
</body>
</html>
