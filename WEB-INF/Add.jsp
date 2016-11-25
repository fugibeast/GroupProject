<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Add Item to inventory</title>
</head>
<body>
	<div class="container" align="center">
	<h3>Add Item Info</h3>
		<c:if test="${not empty addError}">
			<h3 style="color:#ff0000">${addError}</h3>
		</c:if>
		<div class="form-group">
		<form action="Add" method="get">
		<input class="form-control" type="text" name="name" placeholder="Enter the name of the item"></br>
		<input class="form-control" type="text" name="description" placeholder="Enter a description of the item"></br>
		<input class="form-control" type="number" name="quantity" placeholder="Enter the quanity"></br>
		<input class="form-control" type="text" name="price" placeholder="Enter the price for each"></br>
		<button type="submit" class="btn btn-success">Add Item</button>
		</form>
		</div>
	</div>
</body>
</html>