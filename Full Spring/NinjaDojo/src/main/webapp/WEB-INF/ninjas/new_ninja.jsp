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
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="main">
			<h2>New Ninja</h2>
			<form:form action="/ninja/create" method="post" modelAttribute="ninja">
				<div class="form-group">
					<form:label path="dojo">Dojo:</form:label>
					<form:select path="dojo">
						<c:forEach items="${allDojos }" var="dojo">
							<form:option value="${dojo.id }" label="${dojo.name }" />
						</c:forEach>
					</form:select>

					<form:errors path="dojo" class="text-danger"/>
				</div>
				
				<div class="form-group">
					<form:label path="firstName">First Name:</form:label>
					<form:input type="text" path="firstName" />
					<form:errors path="firstName" class="text-danger"/>
				</div>
			
				<div class="form-group">
					<form:label path="lastName">Last Name:</form:label>
					<form:input type="text" path="lastName" />
					<form:errors path="lastName" class="text-danger" />
				</div>
				
				<div class="form-group">
					<form:label path="age">Age:</form:label>
					<form:input type="number" path="age" min="0" value="0"/>
					<form:errors path="age" class="text-danger" />
				</div>
				<button class="btn btn-success">Add a Ninja</button>
			</form:form>
		</div>
	</div>
</body>
</html>