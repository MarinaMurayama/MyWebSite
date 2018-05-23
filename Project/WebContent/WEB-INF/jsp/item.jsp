<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>item</title>
</head>
<body>
<div class="itemdetail">
<div class="card">
<form action="ItemAdd" method="POST">
  <div class="card-body">
    <h5 class="card-title">${itemDetail.name}</h5>
    <p class="card-text">${itemDetail.detail}</p>
    <p class="card-text">Price: ${itemDetail.price}円</p>
    <a class="btn btn-secondary btn-lg" href="InCart.html">
	&#x1F6D2;Add ShoppingCart
	</a>
  </div>
  <img class="card-img-bottom" src="${itemDetail.item_img}" alt="Card image cap">
  </form>
</div>
</div>



</body>
</html>