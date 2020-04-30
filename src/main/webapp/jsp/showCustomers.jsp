<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Customers hey</title>
</head>
<body>

	<h2>List of Customers</h2>
	<table>
		<c:forEach items="${customers}" var="customer">
			<th>
				<h2>${customer.cId}</h2>
				<h2>${customer.cName}</h2>
			</th>

			<tr>
				<th>Order Id</th>
				<th>Quantity</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>
			
			
			<c:forEach items="${customer.orders}" var="order">
				<tr>
					<td>${order.oId}</td>
					<td>${order.qty}</td>
					<td>${order.prod.pId}</td>
					<td>${order.prod.pDesc}</td>
				</tr>

			</c:forEach>
		</c:forEach>
		
	</table>
	
	<tr>
		<td><a href="/index.html">Home</a></td>
		<td><a href="/showProducts.html">Add Products</a></td>
		<td><a href="/showProducts.html">List Products</a></td>
		<td><a href="/showOrders.html">List Orders</a></td>
	</tr>
</body>
</html>