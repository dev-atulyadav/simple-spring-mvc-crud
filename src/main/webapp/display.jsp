<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th colspan="2">Action</th>
		</tr>
			<c:forEach var="product" items="${products}">
		<tr>
				<td>${product.getId() }</td>
				<td>${product.getName() }</td>
				<td>${product.getColor() }</td>
				<td>${product.getPrice() }</td>
				<td><a href="delete?id=${product.getId() }"> delete </a></td>
				<td><a href="getProduct?id=${product.getId() }"> update </a></td>
		</tr>
			</c:forEach>
	</table>

</body>
</html>