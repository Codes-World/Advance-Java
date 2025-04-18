<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Working with Core Tag</h1>
	<%--PRINT TO CONSOLE --%>
	<c:out value="${param.user }" />
	<br>
	
	<c:set var="x" value="10" scope="request"/>
	<c:set var="y" value="20" scope="request"/>
	<c:set var="sum" value="${x+y}" scope="request"/>
	<h1>The result is ::<c:out value="${sum}"/></h1>
	<br>
	
	<h1>Removing the attribute from particular scope</h1>
	<c:remove var="sum" scope="request"/>
	<h1>The result is ::<c:out value="${sum}" default="3000"/></h1>
	<br>
	
	<h1>Working with conditional tags</h1>
	<c:set var="msg" value="Welcome to JSTL" scope="request"/>
	<c:if test="${empty param.user}">
		<c:out value="${msg}"/>MR/MRS/MISS <c:out value="${param.user }"/>
	</c:if>
	
	<hr>
	<h1>Working with Switch case</h1>
	<c:choose>
		<c:when test="${param.no gt 0 }">
			<h1>${param.no } is positive</h1>
		</c:when>
		<c:when test="${param.no lt 0 }">
			<h1>${param.no } is negative</h1>
		</c:when>
		<c:otherwise>
			<h1>${param.no } is zero</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>