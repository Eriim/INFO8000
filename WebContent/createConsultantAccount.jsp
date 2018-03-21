<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Consultant Account</title>
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
			</li>
			</ul>
	
	</header>
		<h1 class="title">Create Consultant Account: ${name}</h1>
	<h2 class="error">${error}</h2>
	
	<form class = "form" action="CreateConsultantServlet" method = "post">
		
		
		<label for = "workPhone">Work Phone</label>
		<input type="text" name = "workPhone"><br>
		<label for = "isAdmin">Admin </label>
		<input type="radio" name = "isAdmin" value="IsAdmin">Yes<br>
		
		<input type = "submit" name = "submit" value = "Save Consultant" class="sixSBtn">
	</form>

</body>
</html>