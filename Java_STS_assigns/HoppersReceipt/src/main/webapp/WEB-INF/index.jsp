<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<h1>Customer Name: <c:out value="${name}" /></h1>
<h2>Item name: <c:out value="${ itemName }" /><br/>
Price: $<c:out value="${ price }" /><br/>
Description: <c:out value="${ description }" /><br/>
Vendor: <c:out value="${ vendor }" /><br/></h2>
<button class='btn btn-warning'>Hello</button>

<h1>Dojo Locations</h1>
<c:forEach var="oneDojo" items="${ dojosList }">
	<p>* <c:out value="${ oneDojo }" /></p>
</c:forEach>
</body>
</html>