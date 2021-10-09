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
  <h1>Edit Book</h1>
  <form:form action="/books/${book.id }" method="post" modelAttribute="book">
  <input type="hidden" name="_method" value="put">
  <p>
  <form:label path="title">Title</form:label>
  <form:input path="title" />
  <form:errors path="title"/>
  </p>
  
  <p>
   <form:label path="description">Description</form:label>

  <form:input path="description" />
    <form:errors path="description"/>

  </p>
  
  <p>
   <form:label path="language">Language</form:label>

  <form:input path="language" />
    <form:errors path="language"/>
  </p>
  
  <p>
   <form:label path="numberOfPages">numberOfPages</form:label>
 
  <form:input path="numberOfPages" />
   <form:errors path="numberOfPages"/>
  </p>
  
  <input class="btn btn-primary" type="submit" value="Submit" />
  <a href="/books">Go back</a>
  </form:form>
</body>
</html>