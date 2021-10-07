<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>all books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="p-5">
   
   <h1>All the books</h1>
   <a href="/books/new">Create new book</a>
 <table  class="table table-dark">
 <thead>
 <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Language</th>
    <th>Number of Pages</th>
    <th>Actions</th>
 </tr>
		 </thead>
		 <tbody>
		 
		 <c:forEach var="book" items="${books}">
		 <tr>
		 <td> <c:out value=" ${book.id}"/></td>
		 <td> <a href="/books/${book.id}"><c:out value=" ${book.title}"/></a></td>
		 <td> <c:out value=" ${book.language}"/></td>
		 <td> <c:out value=" ${book.numberOfPages}"/></td>
		 <td> <a href="/books/${ book.id }/edit">Edit</a> | 

		<form action="/books/${book.id }/delete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input class="btn btn-secondary" type="submit" value="Delete" />
		
		</form>
		
</td>
		    
		</tr>
		 </c:forEach>
		 </tbody>
		 </table>
		   
		</body>
		</html>