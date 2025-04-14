<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<h1>USERNAME IS :: ${initParam.username }</h1><br>
	<h1>PASSWORD IS :: ${initParam.password }</h1><br>
	<h1>EMAILID IS :: ${initParam.emailId }</h1>
	
	<hr>
	<b>Working with Pagecontext Object</b>
	<h1>PageContext Object details :: ${pageContext}</h1>
	<h1>Session Id :: ${pageContext.session.id }</h1>
	<h1>Request Method type is :: ${pageContext.request.method }</h1>
	<h1>HeaderName is :: ${header }</h1>
</body>
</html>