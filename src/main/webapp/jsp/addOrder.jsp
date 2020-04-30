<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New Product!</h1>
	<form:form modelAttribute="Order">
		<table>
			<tr>
				<td>Customer:</td>
				<td><form:select path="cust" items="${customerList}" /></td>
				<td><form:errors path="cust"></form:errors></td>
			</tr>
			
			<tr>
				<td>Product:</td>
				<td><form:select path="prod" items="${productList}" /></td>
				<td><form:errors path="prod"></form:errors></td>
			</tr>
			
			<tr>
				<td>Quantity:</td>
				<td><form:input path="qty" /></td>
				<td><form:errors path="qty"></form:errors></td>
			</tr>
			

			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

	<a href="index.html">Home</a>
	<a href="showOrders.html">List Orders</a>
	<a href="showProducts.html">List Products</a>
</body>
</html>