<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>update</title>
</head>
<body>
<div class="jumbotron">
<br>
<br>
<br>
<div class="dateform">
<form class="p-3 mb-2 bg-white text-dark" action="Update" method="post">
	<h1 class="title" >UP DATE</h1>
	${errMsg1}
  		<div class="form-group row">
    		<label for="staticLoginID" class="col-sm-2 col-form-label">ログインID</label>
    		<div class="col-sm-10">
      		<input type="hidden" value="${Userdata.loginId}" readonly class="form-control-plaintext" id="staticEmail" name="loginId" required>
    		</div>
  		</div>
  		<div class="form-group row">
    		<label for="inputPassword" class="col-sm-2 col-form-label">氏名</label>
    		<div class="col-sm-10">
      		<input type="text" value="${Userdata.name}" class="form-control" name="name" required>
    		</div>
  		</div>
  		<div class="form-group row">
    		<label for="inputPassword" class="col-sm-2 col-form-label">生年月日</label>
    		<div class="col-sm-10">
   			<input type="date" value="${Userdata.birthDate}" class="form-control" max="9999-12-31" name="birth_date" required>
    		</div>
    	</div>
    	<div class="form-group row">
    		<label for="inputPassword" class="col-sm-2 col-form-label">住所(郵便番号7桁・以降の住所)</label>
    		<div class="col-sm-10">
     		<input type="text" value="${Userdata.address}" class="form-control" name="address" required>
    		</div>
  		</div>
   		<div class="form-group row">
    		<label for="inputPassword" class="col-sm-2 col-form-label">パスワード</label>
    		<div class="col-sm-10">
      		<input type="password" class="form-control" name="password">
    		</div>
  		</div>
  		<div class="form-group row">
    		<label for="inputPassword" class="col-sm-2 col-form-label">パスワード(確認)</label>
    		<div class="col-sm-10">
      		<input type="password" class="form-control" name="passwordCheck">
    		</div>
  		</div>
	<div class="button_wrapper">
	  <button type="submit" class="btn btn-secondary btn-lg">OK</button>
	</div>
<div class="link">
<a href="MemberList">Back</a>
</div>

</form>
</div>

</div>
</body>
</html>