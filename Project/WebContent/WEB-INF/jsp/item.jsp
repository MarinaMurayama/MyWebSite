<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="js/jquery-3.3.1.min.js" charset="UTF-8"></script>
<script src="js/popper.min.js" charset="UTF-8"></script>
<script src="js/bootstrap.min.js" charset="UTF-8"></script>
<title>item</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<br>
<div class="itemdetail">
<div class="card">
   <form action="ItemAdd" method="POST">
		<div class="form-group row">
		<input type="hidden" value="${itemDetail.id}" name="id">
		</div>
  		<div class="card-body">
    	<h5 class="card-title">${itemDetail.name}</h5>
    	<p class="card-text">${itemDetail.detail}</p>
    	<p class="card-text">Price: ${itemDetail.price}円</p>
	<select name="count">
			<option data-num="1" value="1" selected>1個</option>
			<option data-num="2" value="2">2個</option>
			<option data-num="3" value="3">3個</option>
			<option data-num="4" value="4">4個</option>
			<option data-num="5" value="5">5個</option>
	</select>
    	<button class="btn btn-secondary" type="submit">
			&#x1F6D2;Add ShoppingCart
		</button>
  		</div>
  		<img class="card-img-bottom" src="${itemDetail.item_img}" alt="Card image cap">
   </form>
</div>
</div>
    <div class="syoppingtitle">
			<a href="Onlineshop_top">ONLINESHOP TOPへ戻る</a>
	</div>
<br>
</body>
</html>