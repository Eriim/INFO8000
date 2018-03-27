
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="style.css" />

<title>Six S Partners Client Portal</title>

</head>

<body>
	<header>
	
		<h1>Six S Partners</h1>
		<h4>Change Readiness Assessment and Organization Tool</h4>
	
	</header>


	
	
	
	<div id="mainBody">
		<h1 class="title">Confirm Email to Reset Password</h1>
		
		<form action="ResetPasswordServlet" method = "post" class = "form">
		<span id="error" style="color:red;">${error}</span>
		<label for = "username">Username:</label>
			<input type="text" name = "username">	
			<label for = "email">Confirm Email:</label>
			<input type="text" name = "email">		
			<input type = "submit" name = "submit" value = "Confirm" class="sixSBtn">
		</form>
		
		
		
		
		
	</div>

</body>
</html>