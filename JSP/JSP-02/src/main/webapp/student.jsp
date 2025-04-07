<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landing Page</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Working with JSP Bean
		Tags</h1>

	<jsp:useBean id="student" class="in.codesworld.aman.beans.Student" scope="page">
		<jsp:setProperty property="*" name="student"/>
	</jsp:useBean>

	<table border='1' align='center'>
		<thead>
			<tr>
				<th>NAME</th>
				<th>AGE</th>
				<th>ADDRESS</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><jsp:getProperty property="name" name="student" /></td>
				<td><jsp:getProperty property="age" name="student" /></td>
				<td><jsp:getProperty property="address" name="student" /></td>
			</tr>
		</tbody>
	</table>
</body>
</html>