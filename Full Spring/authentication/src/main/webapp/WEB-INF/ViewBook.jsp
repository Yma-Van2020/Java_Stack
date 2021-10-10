
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
<body style="padding:150px">

<div class="d-flex justify-content-between">
<h1><c:out value="${ book.title }"/></h1>
<a href="/home">back to the shelves</a>
</div>
<h3><c:out value="${ book.postedBy.userName }"/> read <c:out value="${ book.title}"/> by <c:out value="${ book.author}"/><br/>
<br/>
Here are <c:out value="${book.postedBy.userName }"/>'s thoughts:
<br/>
<hr/>

<c:out value="${ book.thoughts }"/>

<hr/>
<br/>
</h3>

<a href="/books/${book.id}/edit">Edit</a>
</body>
</html>