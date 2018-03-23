<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/Capstone/ResultsServlet" method = "post" class = "form">
	<table>	
		
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
	



</body>
</html>