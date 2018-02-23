


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Six S Partners Client Portal</title>
</head>

<body>
	<span id="error" style="color:red;">${error}</span>
	<form action="LoginServlet" method = "post">
		<label for = "username">Username</label>
		<input type="text" name = "username">
		<label for = "password">Password</label>
		<input type="password" name = "password">
		<input type = "submit" name = "submit" value = "Log in">
	</form>

</body>
</html>