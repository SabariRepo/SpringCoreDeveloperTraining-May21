<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	
   <br> <br>
  
	<center>
	 <h1>Search Your Account Details:</h1>
	<form action="/SkillUpBank/skillup/search" method="post">
	Enter Account Id: <input type="text" name="accid"/>  <br> <br>
	<input type="submit" value="Search"/>
	</form>
	<h1 style="color:red">${err}</h1> <br>
	Search Results: <br>
	${ acc.accountId} | ${acc.accountName } | ${acc.accountBalance }
	</center>
</body>
</html>