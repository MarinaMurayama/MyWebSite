<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>Delete</title>
</head>
<body>
<div class="jumbotron">

<br>
<br>
<br>

<div class="deleteform">
<div class="p-3 mb-2 bg-white text-dark" >
<br>
<h1 class="title">Delete</h1>
<br>
<p class="text">ログインID:${Userdata.loginId}</p>
<p class="text">本当に削除してよろしいですか？</p>
<br>
<form class="login-form" action="Delete" method="post">
	<div class="button_wrapper">
	<button type="submit" class="btn btn-secondary" onclick="location.href='memberList.html'">OK</button>
	<input type="hidden" value="${Userdata.id}" class="form-control"  name="id">
	</div>
</form>
<div class="button_wrapper">
	<a type="button" class="btn btn-secondary"  href="MemberList">cancel</a>
	</div>
</div>
</div>

</div>
</body>
</html>