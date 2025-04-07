<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM PAGE</title>
</head>
<body>
	<h1 style="color: cyan; text-align: center">Enter student details
	</h1>
	<form action="./student.jsp">
		<table align="center">
			<tr>
				<th>NAME</th>
				<td><input type='text' name='name' /></td>
			</tr>
			<tr>
				<th>AGE</th>
				<td><input type='number' name='age' /></td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td><input type='text' name='address' /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type='submit' value='register' /></td>
			</tr>
		</table>
	</form>
</body>
</html>