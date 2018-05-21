<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>LOGIN</title>

</head>
<body>
<div class="jumbotron2">
<br>
<br>
<br>
<br>
<br>

<div class="dateform">
<c:if test="${errMsg != null}" >
	 <div class="alert alert-danger" role="alert">
	  ${errMsg}
	 </div>
   </c:if>
<form class="p-3 mb-2 bg-white text-dark" action="login" method="post">
<h1 class="title">LOGIN</h1>
  <div class="form-group">
    <label for="Login ID"></label>
    <input type="text" class="form-control" id="Login ID" name="loginId"  placeholder="Login ID">
  </div>
  <div class="form-group">
    <label for="Password"></label>
    <input type="password" class="form-control" id="Password" name="password" placeholder="Password">
  </div>
<div class="button_wrapper">
   <button class="btn btn-secondary btn-lg" type="submit">Login</button>
</div>
</form>
</div>
<br>
<br>
<br>
<br>
<br>
</div>
</body>
</html>