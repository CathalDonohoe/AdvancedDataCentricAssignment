<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Orders hey</title>
</head>
<body>

	<h2>List of Orders</h2>
	<table>
		<c:forEach items="${orders}" var="order">
			<th>
				<h2>${order.oId}</h2>
			</th>

			<tr>
				<th>Quantity</th>
				<th>Order Date</th>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>

			<tr>
				<td>${order.qty}</td>
				<td>${order.orderDate}</td>
				<td>${order.cust.cId}</td>
				<td>${order.cust.cName}</td>
				<td>${order.prod.pId}</td>
				<td>${order.prod.pDesc}</td>
			</tr>
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