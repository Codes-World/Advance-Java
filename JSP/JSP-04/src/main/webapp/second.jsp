<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landing Page</title>
</head>
<body>
	<b>second.jsp</b><br>
	<%= new java.util.Date() %><br>
	BookName is :: <%= request.getParameter("bookName") %>
	BookPrice is :: <%= request.getParameter("amount") %>
</body>
</html>