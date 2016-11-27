<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Shopping Cart</title>
</head>
<body>
	<div class="container" align="center">
		<h3>Shopping Cart</h3>
		<c:choose>
			<c:when test="${empty shoppingCart}">
				<div class="jumbotron">
				<h3 class="text-center" style="color:#ffa366"> Your Shopping Cart Is Empty</h3>
				</div>
			</c:when>
			<c:otherwise>
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<th>Item</th> <th>Quantity</th> <th>Total</th> <th>Action</th>
					</tr>
					<c:forEach items="${shoppingCart}" var="item">
						<tr>
							<td><a href="ItemDetail?id=${item.id}"><c:out value="${item.name}" escapeXml="true" /></a> <td>${item.quantity}</td> <td>${item.total}</td> 
							<td>
								<form class="form-inline" action="ShoppingCart" method="post">
								<input type="hidden" name="id" value="${item.id}">
								<input class="btn btn-danger" type="submit" value="Remove">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
				<span>Total Amount: ${overallTotal}</span><br/>
				<a href="Checkout"><button class="btn btn-success">Check Out</button></a>
			</c:otherwise>
		</c:choose>
		<a href="Store"><button class="btn btn-primary">Back to Store</button></a>
	</div>
</body>
</html>