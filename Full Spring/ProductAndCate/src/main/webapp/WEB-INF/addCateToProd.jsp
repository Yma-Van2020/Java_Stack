
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
	

<div class="d-flex justify-content-around p-5">
	
	<div>
		<h1><c:out value="${product.name}" /></h1>
		Categories:

	<c:forEach items="${product.categories}" var="category">
		<li><c:out value="${category.name}" /></li>
	</c:forEach>
	</div>

	<div>
		Add Category:
		<form action="/products/${product.id}/addCategory" method="post">
			<select name="cateId" id="">
				<c:forEach items="${allCates}" var="cate">
					<option value="${cate.id}"><c:out value="${cate.name}"/></option>	
				</c:forEach>
			</select>
			<div><button class="btn btn-danger mt-3">Add Category</button></div>
		</form>
	</div>
</div>
	
</body>
</html>