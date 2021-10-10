
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
<body style="padding:150px;">
<div class="d-flex justify-content-between">
<div><h1>Welcome, <c:out value="${user.userName }"/></h1><br/>
<h5>Books from everyone's shelves:</h5>
</div>
<div>
<a href="/logout">Logout</a><br/>
<a href="/books/new">Add book to my shelf</a>
</div>
</div>

			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ books }" var="book">
						<tr>
							<td><c:out value="${ book.id }"/></td>
							<td><a href="/books/${ book.id }"><c:out value="${ book.title }"/></a></td>
							<td><c:out value="${ book.author }"/></td>
							<td><c:out value="${ book.postedBy.userName }"/></td>
							<td>	
									<form action="/books/${ book.id }/delete" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input class="btn btn-secondary" type="submit" value="Delete">
									</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

</body>
</html>