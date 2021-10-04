<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
<h1>Fruit Store</h1>

<table class="table table-dark table-striped table-hover">

<thead>
	<tr>
	<td>Name</td>
	<td>Price</td>
	</tr>
</thead>

<tbody>
<c:forEach var="fruit" items="${ fruits }">
 <tr>
   <td><c:out value="${fruit.name}"/></td>
   <td><c:out value="${fruit.price }"/></td>
 </tr>
</c:forEach>
</tbody>
</table>

</body>
</html>