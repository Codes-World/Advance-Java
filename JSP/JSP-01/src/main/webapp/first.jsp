<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landing Page</title>
</head>
<body>
	<h1 style='color:red; text-align: center;'>
		FIRST JSP PAGE
	</h1>
	
	<%-- Scripting elements --%>
	<%
		pageContext.forward("second.jsp");
	%>
	
	<h1 style='color:green; text-align: center;'>
		FOOTER OF JSP PAGE
	</h1>
</body>
</html>