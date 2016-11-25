<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Sign Up</title>
</head>
<body>
	<div class="container" align="center">
	<h3>Sign Up</h3>
	<c:if test="${not empty usernameError}">
		<h3 style="color:#ff0000">${usernameError}</h3>
	</c:if>
	<c:if test="${not empty passwordError}">
		<h3 style="color:#ff0000">${passwordError}</h3>
	</c:if>
	<c:if test="${not empty takenError}">
		<h3 style="color:#ff0000">${takenError}</h3>
	</c:if>
	<div class="container">
		<form action="Signup" method="post">
			<div class="form-group" style="width:30%">
			<input type="text" class="form-control" name="username" placeholder="Enter Username">
			<input type="password" class="form-control" name="password1" placeholder="Enter Password">
			<input type="password" class="form-control" name="password2" placeholder="Re-Type Password">
			<br/>
			<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
	</div>
</body>
</html>