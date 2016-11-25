<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Log In</title>
</head>
<body>
	<div class="container" align="center">
	<h3>Log In</h3>
	<c:if test="${not empty loginError}">
		<h3 style="color:#ff0000">${loginError}</h3>
	</c:if>
	<div class="container">
		<form action="Login" method="post">
			<div class="form-group" style="width:30%">
			<input type="text" class="form-control" name="username" placeholder="Enter Username" value="${username}">
			<input type="password" class="form-control" name="password" placeholder="Enter Password">
			<br/>
			<button type="submit" class="btn btn-success">Log In</button>
			</div>
		</form>
	</div>
	<br/>
	<h4>If you don't have an account you can <a href="Signup">SignUp</a></h4>
	</div>
</body>
</html>