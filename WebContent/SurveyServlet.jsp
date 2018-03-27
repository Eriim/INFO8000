
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Change Readiness Survey</title>
</head>
<body>
	<header>
		<div id ="headerTitles">
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
	<form action="/Capstone/ResultsServlet" method = "post" class = "form">
	<table>	
	<div id="mainBody">
	<h2>Change Readiness Survey</h2>
	<p>Answer honestly for best results</p>
		<c:forEach var="category" items="${requestScope.categoryList}">		
			<tr><h3><c:out value="${category.categoryText}"/></h3></tr>
					<c:forEach items="${questionList}" var="question">
						<c:if test = "${question.categoryID == category.categoryID}">
							<tr><p><c:out value="${question.questionText}"/></p></tr>
							<tr>
							<label for="${question.categoryID}${question.questionID}1">Yes</label>
							<input type="radio" name="${question.questionID}" value="Yes" id="${question.categoryID}${question.questionID}1"/>
							<label for="${question.categoryID}${question.questionID}2" >No</label>
							<input type="radio" name="${question.questionID}" value="No" id="${question.categoryID}${question.questionID}2"/>
							<label for="${question.categoryID}${question.questionID}3" >Somewhat</label>
							<input type="radio" name="${question.questionID}" value="Somewhat" id="${question.categoryID}${question.questionID}3"/>
							</tr>
							
						</c:if>
					</c:forEach>
		</c:forEach>
		<tr><br><input type="submit" value="Submit Survey"></tr>			
		</table>
		
		</form>
	</div>



</body>
</html>