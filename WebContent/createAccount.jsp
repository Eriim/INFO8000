<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Create Account</title>
</head>
<body>
	<header>
		<div id ="headerTitles">
			<h1>Six S Partners</h1>
			<h4>Change Readiness Assessment and Organization Tool</h4>
		</div>	
		<ul class="menu-bar">
		   	 <li ><a href="index.jsp">${username}</a></li>
			 <li class="active"><a href="createAccount.jsp">Create</a></li>
			 <li><a href="login.jsp">Log-Out</a></li>
		</ul>
	
	</header>
	
	<h1 class="title">Create Account</h1>
	<h2 class="error">${error}</h2>
	<form class = "form" action="CreateAccountServlet" method = "post">
	
		<label for = "username">Username</label>
		<input type="text" name = "username"><br>
		<label for = "password">Password</label>
		<input type="password" name = "password"><br>
		<label for = "confirmation">Confirm Password</label>
		<input type="password" name = "confirmation"><br>
		<label for = "email">Email</label>
		<input type="text" name = "email"><br>
		<label for = "phone">Phone Number</label>
		<input type="text" name = "phone">
		<label for = "firstN">First Name</label>
		<input type="text" name = "firstN"><br>
		<label for = "lastN">Last Name</label>
		<input type="text" name = "lastN"><br>
		<input type="radio" name="accountType" value="Client">Client
		<input type="radio" name="accountType" value="Consultant">Consultant
		<input type = "submit" name = "submit" value = "Add Account" class="sixSBtn">
	</form>

</body>
</html>