<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
.border{
 border:1px black solid;
 width:200px;
 padding:15px;
 margin:15px;
 background-color:cornflowerblue;
}
</style>
</head>
<body>
<h1>Here's your Omikuji</h1>
  <div class="border">
    <p>In <c:out value="${ number }" /> years, you will live in
    <c:out value="${ cityName }"/> with <c:out value="${ personName }" />  as your
    roommate, <c:out value="${ endeavorHobby }"/> for a living. The next
    time you see a <c:out value="${ living }" />, you will have good luck.
    Also, <c:out value="nice" /></p>
    
    <a href="/omikuji">Go Back</a>
    
  </div>
</body>
</html>