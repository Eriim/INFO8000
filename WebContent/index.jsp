
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<header>
	<div id ="headerTitles">
		<h1>Six S Partners</h1>
		<h4>Change Readiness Assessment and Organization Tool</h4>
	</div>	
		<ul class="menu-bar">
			 <li class="active"><a href="index.jsp">${username}</a></li>
			 <li ><a href="createAccount.jsp">Create</a></li>
			 <li><a href="login.jsp">Log-Out</a></li>
		</li>
		</ul>
	
	</header>
	
	<h1>Six S Solutions Change Readiness Portal</h1>
	<h2>Welcome, ${username}</h2>
	
	<p>${message}</p>
	
	<form action ="SurveyServlet" method="post">
		<input type ="submit" value ="Take a Survey"/>
	</form>	
	
</body>
</html>