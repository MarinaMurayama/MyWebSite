<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  	<a class="navbar-brand" href="main">// ENJOY COFFEE LIFE //</a>
  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
 	</button>
<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
  <div class="navbar-nav">
      	<a class="nav-item nav-link" href="Onlineshop_top">ONLINE SHOP</a>
  <c:if test="${userInfo.loginId == null}">
      	<a class="nav-item nav-link" href="login">LOGIN</a></c:if>
  <c:if test="${userInfo.loginId != null}">
      	<a class="nav-item nav-link" href="Logout">LOGOUT</a></c:if>
  <c:if test="${userInfo.loginId != null}">
        <a class="nav-item nav-link" href="PurchaseHistoryList">USER BUY DATA</a></c:if>
  <c:if test="${userInfo.loginId == null}">
       	<a class="nav-item nav-link" href="Signup">SIGNUP</a></c:if>
  <c:if test="${userInfo.loginId != null}">
        <a class="nav-item nav-link" href="MemberList">MEMBER</a></c:if>
  <c:if test="${userInfo.loginId == 'admin'}">
        <a class="nav-item nav-link" href="Master">master</a></c:if>
      	<a class="nav-item nav-link disabled" href="Cart">&#x1F6D2;</a>
  </div>
</div>
</nav>
</body>
</html>