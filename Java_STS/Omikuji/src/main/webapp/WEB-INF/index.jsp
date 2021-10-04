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
 padding:25px;
 margin:15px
}
</style>
</head>
<body>

<h1>Send an Omikuji!</h1>

<div class="border">

<form class="form form-control" action="/submit" method="POST">
<label for="num">Pick any number from 5 - 25</label>
<input class="form-control type="number" name="number" id="num" min="5" max="25" step="1"></input>

<label for="cn">Enter the name of any city</label>
<input class="form-control type="text" name="cityName" id="cn"></input>

<label for="pn">Enter the name of any real person</label>
<input class="form-control type="text" name="personName" id="pn"></input>

<label for="e">Enter professional endeavor or hobby:</label>
<input class="form-control type="text" name="endeavorHobby" id="e"></input>

<label for="living">Enter any type of living thing</label>
<input class="form-control type="text" name="living" id="living"></input>

<label for="nice">Say something nice to someone:</label>
<input class="form-control type"text" name="nice" id="nice"></input>

<p>Send and show a friend</p>
<input class="btn btn-secondary" type="submit">
</form>
</div>
</body>
</html>