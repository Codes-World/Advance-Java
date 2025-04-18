<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,in.codesworld.aman.beans.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>STUDENT RELATIONSHIP MANAGEMENT</h1>
	<c:import url="urlrelated.jsp">
		<c:param name="UI" value="THYMLEAF"/>
		<c:param name="FRAMEWORK" value="Spring and SpringBoot"/>
	</c:import>

	<br>
	<h1>STUDENT RELATIONSHIP MANAGEMENT</h1>
	<c:redirect url="urlrelated.jsp">
		<c:param name="UI" value="THYMLEAF"/>
		<c:param name="FRAMEWORK" value="Spring and SpringBoot"/>
	</c:redirect>	
</body>
</html>