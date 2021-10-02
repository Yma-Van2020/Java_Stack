<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>

<h1>Customer Name: <c:out value="${name}" /></h1>
<h2>Item name: <c:out value="${ itemName }" /><br/>
Price: $<c:out value="${ price }" /><br/>
Description: <c:out value="${ description }" /><br/>
Vendor: <c:out value="${ vendor }" /><br/></h2>

</body>
</html>