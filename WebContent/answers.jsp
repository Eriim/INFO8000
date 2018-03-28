<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css"/>
<title>Change Readiness Results</title>
</head>
<body>
	<header>
		<div id ="headerTitles">
			<h1>Six S Partners</h1>
			<h4>Change Readiness Assessment and Organization Tool</h4>
			
			<ul class="menu-bar">
				 <li class="active"><a href="index.jsp">${username}</a></li>
			<c:choose>
		    	<c:when test="${Role.role =='Consultant' || Role.role == 'Admin'}">
				 <li ><a href="createAccount.jsp">Create</a></li>
				 </c:when>
			</c:choose>
				 <li><a href="login.jsp">Log-Out</a></li>
			</li>
			</ul>
		</div>
	</header>
	
	
	<div id="mainBody">
		<h2 class="title">Confirm your answers: </h2>
	
		<table class="answers">	
		<br><br><br>
		<c:forEach var="category" items="${requestScope.categoryList}">		
			<th><c:out value="${category.categoryText}"/></th>
			<th></th>
					<c:forEach items="${questionList}" var="question">
						<c:if test = "${question.categoryID == category.categoryID}">
							
							
									<tr>	
										<td><c:out value="${question.questionText}"/><td>
								<c:forEach items="${requestScope.questionAnswerList}" var="questionAnswer">
							
									<c:if test = "${questionAnswer.question.questionID == question.questionID}">
									
										<td><c:out value="${questionAnswer.answer.answerText}"/></td>
										</tr>
										
									</c:if>
											
							
								</c:forEach>
							
					
							
							
						</c:if>
				</c:forEach>
		</c:forEach>
				
		</table>
		
				<form action="GenerateResultsServlet" method = "post" class = "form">
					<input type = "submit" name = "save" value = "Save results" class="sixSBtn">
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