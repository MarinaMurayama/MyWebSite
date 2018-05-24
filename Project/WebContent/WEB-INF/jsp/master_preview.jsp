<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<title>master</title>
</head>
<body>

<div class="itemdetail">
<div class="card">
<form action="ItemAdd" method="POST">
  <div class="card-body">
    <h5 class="card-title">${Itemdata.name}</h5>
    <p class="card-text">${Itemdata.detail}</p>
    <p class="card-text">Price: ${Itemdata.price}円</p>
    <p class="btn btn-secondary btn-lg" >
	&#x1F6D2;Add ShoppingCart
	</p>
  </div>
  <img class="card-img-bottom" src="${Itemdata.item_img}" alt="Card image cap">
  </form>
</div>
</div>
<div class="link">
<a href="Master">戻る</a>
</div>
</body>
</html>