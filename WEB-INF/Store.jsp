<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Tubular Store</title>
</head>
<body>
	<h1 align="center">Hello, <small>${user}</small></h1>
	<div class="container">
		<h2>Store Inventory <small><a href="Add">[Add Item]</a></small></h2>
		<div class="fluid">
		<form class="form-inline" action ="Store" method="get">
			<div class="input-group">
				<span class="input-group-btn">
					<button class='btn btn-primary btn-lg' type='submit'>
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</span>
			</div>

			<div class="input-group">
				<input type='text' class='form-control' name='query' placeholder='Search for an item'>
			</div>
		</form>
		</div>
		<br/>
		
		<c:if test="${not empty quantityError}">
			<h3 style="color:#ff0000">${quantityError}</h3>
		</c:if>
		<c:choose>
			<c:when test="${empty inventory}">
				<div class="jumbotron">
				<h3 class="text-center" style="color:#ffa366"> Yikes! There are no items to display</h3>
				</div>
			</c:when>
			<c:otherwise>
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<th>Item</th><th>Description</th><th>Quantity</th><th>Price(each)</th> <th>Action</th>
					</tr>
					<c:forEach items="${inventory}" var="item">
						<tr>
							<td><c:out value="${item.name}" escapeXml="true" /></td> <td><c:out value="${item.description}" escapeXml="true" /></td> <td>${item.quantity}</td> <td>${item.price}</td> 
							<td>
								<form class="form-inline" style="width:inherit" action="Add" method="post">
								<input type="hidden" name="max" value="${item.quantity}">
								<input type="hidden" name="id" value="${item.id}">
								<input type="number" class="form-control" name="quantity" placeholder="Enter Quantity" min="1" max="${item.quantity}">
								<input class="btn btn-primary" type="submit" value="Add to Cart">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="container">
		<h2>Your Shopping Cart  <small><a href="Transactions">[View Transactions]</a></small></h2>
		<c:if test="${not empty cartError}">
			<h3 style="color:#ff0000">${cartError}</h3>
		</c:if>
		<c:choose>
			<c:when test="${empty cart}">
				<div class="jumbotron">
				<h3 class="text-center" style="color:#ffa366">Shopping cart is empty</h3>
				</div>
			</c:when>
			<c:otherwise>
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<th>Item</th><th>Description</th><th>Quantity</th><th>Price(each)</th> <th>Action</th>
					</tr>
					<c:forEach items="${cart}" var="item">
						<tr>
							<td><c:out value="${item.name}" escapeXml="true" /></td> <td><c:out value="${item.description}" escapeXml="true" /></td> <td>${item.quantity}</td> <td>${item.price}</td> 
							<td>
								<a href="Remove?id=${item.id}">Remove</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div align="right">
					<form action="Remove" method="post" class="form-inline">
						<input type="hidden" name="inventory" value="${inventory}">
						<button type="submit" class="btn btn-primary">Proceed to Checkout</button>
					</form>
				</div>
			</c:otherwise>
		</c:choose>
			
		<div align="center">
			<form action="Store" method="post">
			<button type="submit" class="btn btn-success">Log Out</button>
			</form>
		</div>
	</div>
</body>
</html>