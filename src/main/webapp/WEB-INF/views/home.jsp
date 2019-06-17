<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>

<h1><s:message code="spitter.welcome"/></h1>

<a href="<c:url value="/spittles" />">Spittles</a>
<a href="<c:url value="/spitter/register"/>">Register</a>
