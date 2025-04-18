<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UI Page</title>
</head>
<body>
	<h1>UserName is ::${param.name }</h1>
	<c:catch var="e">
		<% int age = Integer.parseInt(request.getParameter("age")); %>
		<h1>Age is :: ${param.age }</h1>
	</c:catch>
	
	<c:if test="${e ne null }">
		<h1>OOPs.....Exception raised ::</h1> <h1><c:out value='${e}' /></h1>
	</c:if>
	<h1>Height is :: ${param.height}</h1>
</body>
</html>