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

<table>	
		
	<c:forEach var="category" items="${requestScope.categoryList}">		
		<tr><h3><c:out value="${category.categoryText}"/></h3></tr>
				<c:forEach items="${questionList}" var="question">
					<c:if test = "${question.categoryID == category.categoryID}">
						<tr><p><c:out value="${question.questionText}"/></p></tr>
							<c:forEach items="${requestScope.questionAnswerList}" var="questionAnswer">
								<c:if test = "${questionAnswer.question.questionID == question.questionID}">
								<tr><p><c:out value="${questionAnswer.answer.answerText}"/></p> </tr>
								</c:if>
								
						</c:forEach>
						
						
					</c:if>
				</c:forEach>
	</c:forEach>
			
	</table>

</body>
</html>