<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Item Detail</title>
</head>
<body>
	<h3 align="center">Item Details</h3>
	<div class="container" align="center" style="background-color:#cceeff;">
		<div class="row">
			<strong>Name: </strong>
			${item.name}
		</div>
	</div><br/>
	<div class="container" align="center" style="background-color:#cceeff;">
		<div class="row">
			<strong>Price: </strong>$ ${item.price}<br/>
			<strong>Quantity: </strong>${item.quantity}
		</div>
	</div><br/>
	<div class="container" align="center" style="background-color:#cceeff;">
		<div class="row">
			<strong>Description: </strong>${item.description}
		</div>
	</div><br/>
</body>
</html>