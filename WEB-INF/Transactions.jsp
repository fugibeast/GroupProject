<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Transactions</title>
</head>
<body>
<div class="container" align="center">
	<h3>Transaction History</h3>
	<div class="container">
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Name</th><th>Quantity</th><th>Price(each)</th>
			</tr>
			<c:forEach items="${transactions}" var="item">
				<tr>
					<td><c:out value="${item.name}" escapeXml="true" /></td> <td>${item.quantity}</td> <td>${item.price}</td> 
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>