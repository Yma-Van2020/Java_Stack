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
    <title>show</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="p-5">
   <h1>${ book.title}</h1>
   <p>
   Description: ${ book.description}<br/>
   Language: ${book.language }<br/>
   Number of pages: ${ book.numberOfPages }
   </p>
   
		<form action="/books/${book.id }/delete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input class="btn btn-secondary" type="submit" value="Delete" />
		
		</form>
		  <a href="/books">Go back</a>
</body>
</html>