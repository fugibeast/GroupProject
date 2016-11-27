<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<c:if test="${not empty editError}">
			<h3 style="color:#ff000">${editError}</h3>
		</c:if>
		<form class="form-horizontal" action="Edit" method="post">
			<div class="form-group">
			<label>Name:</label>
			<input class="form-control" type="text" name="name" value="${editItem.name}">
			</div>
			<div class="form-group">
			<label>Price:</label>
			<input class="form-control" type="text" name="price" value="${editItem.price}">
			</div>
			<div class="form-group">
			<label>Quantity:</label>
			<input class="form-control" type="number" name="quantity" value="${editItem.quantity}">
			</div>
			<div class="form-group">
			<label>Description:</label>
			<input class="form-control" type="text" name="description" value="${editItem.description}">
			</div>
			<input type="hidden"  name="id" value="${editItem.id}">
			<button type="submit" class="btn btn-success">Save</button>
			<a href="Inventory"><button class="btn btn-danger">Cancel</button></a>
		</form>
	</div>
</body>
</html>