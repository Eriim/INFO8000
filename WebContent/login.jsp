
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
		<h1 class="title">Log In</h1>
		
		<form action="LoginServlet" method = "post" class = "form">
		<span id="error" style="color:red;">${error}</span>
		<span> ${message}</span>
			<label for = "username">Username:</label>
			<input type="text" name = "username">
			<label for = "password">Password:</label>
			<input type="password" name = "password">
			<input type = "submit" name = "submit" value = "Log in" class="sixSBtn">
			<p id="forgotPass"><a href="forgotPassword.jsp">Forgot Your Password?</a></p>
		</form>
		
		
		
		
		
	</div>
		
	<footer>
	
	<div class="address">
	<h3>Contact Us</h3>
	<p>Phone: 1-866-579-7497<br>Fax: 1-888-240-4866<br>Email: info@sixspartners.com<br>Website: www.sixspartners.com</p>
	</div>
	<div class="address">
	<p><br><br><br>&copy; Six S Partners</p>
	</div>
	</footer>

</body>
</html>