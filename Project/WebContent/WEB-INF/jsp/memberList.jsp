<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>memberList</title>
</head>
<body>

  <div class="jumbotron">
<br>
<br>
<br>
<div class="text-white"><h1 class="title">Member List</h1></div>

<div class="membertable">
<table class="table table-hover">
  <thead>
    <tr class="p-3 mb-2 bg-dark text-white">
      <th scope="col">Login ID</th>
      <th scope="col">Name</th>
      <th scope="col">Birthday</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="user" items="${userList}" >
    <tr class="p-3 mb-2 bg-light text-dark">
      	<td>${user.loginId}</td>
      	<td>${user.name}</td>
      	<td>${user.birthDate}</td>
      	<td>
      	  <div class="btn-group" role="group" aria-label="Basic example">
  		  <a class="btn btn-secondary" href="UserDetail?id=${user.id}">reference</a>
  	<c:if test="${(userInfo.loginId == 'admin')|| (userInfo.loginId == user.loginId)}">
  		  <a class="btn btn-secondary" href="Update?id=${user.id}">update</a></c:if>
    <c:if test="${userInfo.loginId =='admin'}">
  		  <a class="btn btn-secondary" href="Delete?id=${user.id}">delete</a></c:if>
		</div>
      	</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

	<div class="title">
			<a href="main">Back</a>
	</div>


</div>
</body>
</html>