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
	<h1 align="center">Inventory <small>Management</small></h1>
	<div class="container">
		<h2>Store Inventory <small><a href="Add">[Add Item]</a></small></h2>
		
		<div class="fluid">
		<form class="form-inline" action ="Inventory" method="get">
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
		
		<c:choose>
			<c:when test="${empty inventory}">
				<div class="jumbotron">
				<h3 class="text-center" style="color:#ffa366"> Yikes! There are no items to display</h3>
				</div>
			</c:when>
			<c:otherwise>
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<th>Item</th> <th>Quantity</th> <th>Price(each)</th> <th>Action</th>
					</tr>
					<c:forEach items="${inventory}" var="item">
						<tr>
							<td><a href="ItemDetail?id=${item.id}"><c:out value="${item.name}" escapeXml="true" /></a></td> <td>${item.quantity}</td> <td>${item.price}</td> 
							<td>
								<a href="Remove?id=${item.id}"><button class="btn btn-danger">Remove</button></a>
								<a href="Edit?id=${item.id}"><button class="btn btn-primary">Edit</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>