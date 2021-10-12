
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>add product</title>
    <!-- for Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

<h1>New Product</h1>


	<form:form action="/products/create" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name" />
			<form:errors path="name" class="text-danger"/>
		</p>
  			

		<p>
			<form:label path="description">Description:</form:label>
			<form:input type="text" path="description" />
			<form:errors path="description" class="text-danger"/>
		</p>	
			
		
		<p>
			<form:label path="price">Price:</form:label>
			<form:input type="text" path="price" />
			<form:errors path="price" class="text-danger"/>
			
		</p>	
		
			<button class="btn btn-success">Create</button>
			
	</form:form>
</body>
</html>