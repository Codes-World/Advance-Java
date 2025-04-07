<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landing Page</title>
</head>
<body>
	<b>Start of first.jsp</b>
	<br>
	<% float bAmount = 300.0f + (3000.0f * 0.03f); %>
	
	<jsp:forward page="second.jsp">
		<jsp:param value="JSP" name="bookName"/>
		<jsp:param value="<%=bAmount%>" name="amount"/>
	</jsp:forward>
	<br>
	<br>
	<b>End of first.jsp</b>
</body>
</html>