<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Products hey</title>
</head>
<body>
	
	<h2>List of Products</h2>
	<table>
		<tr>
            <th>Product Id</th>
            <th>Description</th>
            <th>Stock in Quantity</th>
        </tr>
		<c:forEach items="${products}" var="product">
			<tr><td>${product.pId}</td>
                <td>${product.pDesc}</td>
                <td>${product.qtyInStock}</td>
            </tr>
		</c:forEach>
	</table>
	
	<tr>
		<td><a href="/index.html">Home</a></td>
		<td><a href="/addProduct.html">Add Products</a></td>
		<td><a href="/showProducts.html">List Products</a></td>
		<td><a href="/showOrders.html">List Orders</a></td>
	</tr>

</body>
</html>