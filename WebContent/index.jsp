
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
			<h1>Six S Partners</h1>
			<h4>Change Readiness Assessment and Organization Tool</h4>
			
			<ul class="menu-bar">
				 <li class="active"><a href="index.jsp">${username}</a></li>
				 <li ><a href="createAccount.jsp">Create</a></li>
				 <li><a href="login.jsp">Log-Out</a></li>
			</li>
			</ul>
		</div>
	</header>
	
	
	<div class="mainBody">
	<h1>Six S Solutions Change Readiness Portal</h1>
	<h2>Welcome, ${username}</h2>
	
	<p>${message}</p>
	
	<form action ="SurveyServlet" method="post">
		<input type ="submit" value ="Take a Survey" class="sixSBtn"/>
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