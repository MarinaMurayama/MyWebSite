<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>SIGN UP</title>
</head>
<body>
<div class="jumbotron">
<div class="dateform">

<form class="p-3 mb-2 bg-white text-dark" action="Signup" method="post">
	<h1 class="title" >SIGN UP</h1>
	${errMsg1}
	${errMsg2}
  	<div class="form-group row">
    		<label for="inputLoginID" class="col-sm-2 col-form-label" >ログインID</label>
    		<div class="col-sm-10">
      		<input type="text" class="form-control" name="loginId" required>
    		</div>
 	</div>
 	<div class="form-group row">
    	<label for="inputPassword" class="col-sm-2 col-form-label" >氏名</label>
    	<div class="col-sm-10">
      	<input type="text" class="form-control" name="name" required>
    	</div>
  	</div>
  	<div class="form-group row">
    	<label for="inputPassword" class="col-sm-2 col-form-label">生年月日</label>
    	<div class="col-sm-10">
   		<input type="date" class="form-control" max="9999-12-31"  name="birth_date" placeholder="入力例 → 20181010 (2001年04月01日生まれ)" required>
    	</div>
    </div>
  	<div class="form-group row">
    	<label for="inputPassword" class="col-sm-2 col-form-label" >郵便番号</label>
    	<div class="col-sm-10">
    	<input type="text" name="zip11" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');"  placeholder="半角数字7桁" required>
    </div>
  	</div>
    <div class="form-group row">
    	<label for="inputPassword" class="col-sm-2 col-form-label" >都道府県 + 以降の住所</label>
    	<div class="col-sm-10">
    	<input type="text" class="form-control" name="addr11" size="60"  required>
    	</div>
  	</div>
    <div class="form-group row">
    	<label for="inputPassword" class="col-sm-2 col-form-label"  >パスワード</label>
    	<div class="col-sm-10">
      	<input type="password" name="password" class="form-control" required>
   		</div>
  	</div>
  	<div class="form-group row">
    	<label for="inputPassword" class="col-sm-2 col-form-label"  >パスワード(確認)</label>
    	<div class="col-sm-10">
      	<input type="password" name="passwordcheck" class="form-control" id="inputPassword" required>
    	</div>
  	</div>

	<div class="button_wrapper">
		<button class="btn btn-secondary btn-lg" type="submit">OK</button>
	</div>
	<div class="link">
		<a href="main">Back</a>
	</div>
</form>
</div>
</div>

</body>
</html>