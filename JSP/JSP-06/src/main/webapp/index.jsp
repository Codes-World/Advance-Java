<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, in.codesworld.aman.bean.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OPERATORS IN JSP</title>
</head>
<body>
	<h1>Working with Arrays</h1>
	<% 
		String names[] = {"sachin", "kholi", "dhoni", "dravid"};
		pageContext.setAttribute("name", names);//pageScope
	%>
	
	<h1>
		${name[0] }<br>
		${name['1'] }<br>
		${name["2"] }<br>
		${name[5] }<br>
	</h1>
	
	<hr>
	<h1>Working with ArrayList</h1>
	<% 
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("Aman");
		a1.add("Sahil");
		a1.add("Ranjan");
		a1.add("Amit");
		pageContext.setAttribute("stdName", a1);
		pageContext.setAttribute("index", 3);
	%>
	<h1>
		${stdName[0] }<br>
		${stdName["1"] }<br>
		${stdName['2'] }<br>
		${stdName[index] }<br>
	</h1>
	
	<% 
		ArrayList<Student> stdList= new ArrayList<Student>();
		pageContext.setAttribute("student", stdList);
	%>
	<h1>Student List :: ${empty student }</h1>
	<hr>
	<h1>EL versus null</h1>
	<h1>${10+null}</h1>
	<h1>${empty null }</h1>
	<h1>${!null }</h1>
</body>
</html>