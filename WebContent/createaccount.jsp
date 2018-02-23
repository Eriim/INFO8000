<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create </title>
</head>
<body>
	<form action="CreateAccountServlet" method = "post">
		<label for = "username">Username</label>
		<input type="text" name = "username"><br>
		<label for = "password">Password</label>
		<input type="password" name = "password"><br>
		<label for = "confirmation">Confirm Password</label>
		<input type="password" name = "confirmation"><br>
		<label for = "email">Email</label>
		<input type="email" name = "email"><br>
		<label for = "phone">Phone Number</label>
		<input type="text" name = "phone">
		<label for = "firstN">First Name</label>
		<input type="text" name = "firstN"><br>
		<label for = "lastN">Last Name</label>
		<input type="text" name = "lastN"><br>
		<input type = "submit" name = "submit" value = "Sign up">
	</form>

</body>
</html>