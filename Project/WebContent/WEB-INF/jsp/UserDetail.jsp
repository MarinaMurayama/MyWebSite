<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>reference</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<div class="jumbotron">
<br>
<br>
<br>

<div class="text-white"><h1 class="title">reference</h1></div>

<div class="UserDetail">
 <div class="card" style="width: 18rem;">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Login ID : ${Userdata.loginId}</li>
    <li class="list-group-item">Name : ${Userdata.name}</li>
    <li class="list-group-item">登録日時 :${Userdata.createDate}</li>
    <li class="list-group-item">更新日時 :${Userdata.updateDate}</li>
    <li class="list-group-item">
		<a href="MemberList">Back</a>
	</li>
  </ul>
 </div>
</div>

</div>
</body>
</html>