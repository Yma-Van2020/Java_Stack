
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
    <title></title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

<div class="container">
		<div class="header d-flex justify-content-between align-items-center">
	
			<a href="/dojos/new">Add a Dojo</a>
			<a href="/ninjas/new">Add a Ninja</a>
		</div>
		<div class="main">
			<h1>${dojo.name } Location Ninjas</h1>
			<table class="table">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
				
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ dojo.ninjas }" var="ninja">
						<tr>
							<td><c:out value="${ ninja.firstName }" /></td>
							<td><c:out value="${ ninja.lastName }" /></td>
							<td><c:out value="${ ninja.age }" /></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>