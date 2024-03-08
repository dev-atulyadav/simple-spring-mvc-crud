<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Update Form</h3>
	<form:form action="update" modelAttribute="product">
		<label for="id">id:</label>
		<form:input type="number" path="id" id="id" placeholder="enter id" />
		<br>
		<label for="name">name:</label>
		<form:input type="text" path="name" id="name" placeholder="enter name" />
		<br>
		<label for="price">price:</label>
		<form:input type="text" path="price" id="price"
			placeholder="enter price" />
		<br>
		<label for="color">color:</label>
		<form:input type="text" path="color" id="color"
			placeholder="enter color" />
		<br>
		<button type="submit">Update</button>
	</form:form>
</body>
</html>