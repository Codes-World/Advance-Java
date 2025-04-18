<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, in.codesworld.aman.beans.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UI Page</title>
</head>
<body>
	<br>
	<table border='1' align='center' width='200'>
		<caption>Tables</caption>
		<c:forEach var='i' begin="1" end="10" step="1">
			<tr align="center">
				<td>2*${i}=</td>
				<td>${2*i}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
	<% 
		String[] names = {"sachin", "kholi", "dhoni", "dravid"};
		pageContext.setAttribute("stdNames", names);
	%>
	
	<h1>WORKING WITH FOREACH TO PERFORM READ OPEARTION ON ARRAY</h1>
	<c:forEach var = "names" items = "${stdNames}">
		<h1><c:out value="${names}"/></h1><br>
	</c:forEach>
	
	<br>
	<% 
		ArrayList<Student> stdList= new ArrayList<Student>();
		stdList.add(new Student("10","sachin",55,"MI"));
		stdList.add(new Student("18","kholi",35,"RCB"));
		stdList.add(new Student("7","dhoni",42,"CSK"));
		stdList.add(new Student("45","rohit",37,"MI"));
		pageContext.setAttribute("studentList", stdList);
	%>
	<h1>WORKING WITH FOREACH TO PERFORM READ OPEARTION ON ARRAY</h1>
	<c:choose>
		<c:when test="${!empty studentList and studentList ne null }">
			<table border='1' align="center">
				<caption>STUDENT DATA</caption>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AGE</th>
					<th>ADDRESS</th>
				</tr>
				
				<c:forEach var="student" items="${studentList }">
					<h1>${student}</h1>
					<tr>
						<td>${student.sid }</td>
						<td>${student.sname }</td>
						<td>${student.sage }</td>
						<td>${student.saddress }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style='color:red; text-align:center'>No records to display</h1>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	
	<h1>Working with ForTokens for Printing purpose</h1>
	<c:set var="data" value="Hello, hi, How are u?" scope="request"/>
	<c:forTokens items="${data }" delims="," var="msg">
		<h1>${msg }</h1>
	</c:forTokens>
</body>
</html>