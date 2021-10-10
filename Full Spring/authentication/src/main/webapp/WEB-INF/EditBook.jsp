
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

<h1>Change your Entry</h1>
<a href="/home">back to the shelves</a>

	<form:form action="/books/${book.id}/update" method="put" modelAttribute="book" class="form-control">

		<p>
		 	<form:hidden path="postedBy" value="${book.postedBy.id}"/>
			<form:label path="title">Title:</form:label>
			<form:input  path="title" />
			<form:errors path="title" class="text-danger"/>
		</p>
 

		<p>
			<form:label path="author">Author:</form:label>
			<form:input path="author" />
			<form:errors path="author" class="text-danger"/>
		</p>	
			
		
		<p>
			<form:label path="thoughts">My thoughts:</form:label>
			<form:input path="thoughts" />
			<form:errors path="thoughts" class="text-danger"/>
			
		</p>	
		
			<input class="btn btn-primary" type="submit" value="Submit" />
			
	</form:form>
</body>
</html>