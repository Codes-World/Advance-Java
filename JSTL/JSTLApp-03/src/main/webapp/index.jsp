<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="hi-IN"/>
	
	<fmt:formatNumber var="number" value="4849383938"  type="currency"/>
	FormmattedNumber is :: ${number}<br><br>
	
	<jsp:useBean id="date" class="java.util.Date"/>
	<fmt:formatDate value="${date }" var="dt" type="both"/>
	FormattedDate is :: ${dt }<br><br>	
	
	
	<fmt:setBundle basename="in/codesworld/aman/properties/App_de_DE"/>
	<fmt:message  key="welcome.msg" var="msg1"/>
	<fmt:message  key="goodbye.msg" var="msg2"/>
	Message1 :: ${msg1}<br>
	Message2 :: ${msg2}<br>
</body>
</html>