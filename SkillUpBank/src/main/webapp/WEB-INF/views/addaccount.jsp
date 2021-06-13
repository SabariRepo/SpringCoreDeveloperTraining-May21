<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring-form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<center>
	
	<h1>Add Your Account Details!</h1>
	
	<spring-form:form action="addaccount" method="post" modelAttribute="acc">
	
	Account Id: <spring-form:input path="accountId"/> <br>
	
	Account Holder Name: <spring-form:input path="accountName"/> <br>
	
	Account Balance: <spring-form:input path="accountBalance"/> <br>
	
	<input type="submit" value="Add Account"/> <!-- ordinary Submit Button -->
	
	</spring-form:form>
	
	
	</center>
</body>
</html>