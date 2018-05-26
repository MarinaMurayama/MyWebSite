<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>buy&#x1F6D2;</title>
</head>
<body>
<br>
<br>
<br>
<h1 class="syoppingtitle" >購入確認 &#x1F6D2;</h1>
<br>
<br>

<div class="mastertable">
<table class="table">
  <thead>
    <tr>
      <th scope="col">商品画像</th>
      <th scope="col">商品名</th>
      <th scope="col">販売価格</th>
      <th scope="col">小計</th>
    </tr>
  </thead>
<tbody>
	<c:forEach var="item" items="${cart}" >
    <tr>
      <td><img src="${item.item_img}" alt="サンプル" class="master-top"></td>
      <td>${item.name}</td>
      <td>${item.price}円</td>
      <td></td>
    </tr>
	</c:forEach>
	<tr>
      <td></td>
      <td></td>
      <td>合計料金</td>
      <td>${bdb.TotalPrice}円</td>
    </tr>
    <tr>
      <td></td>
      <td>${bdb.DeliveryMethodName}</td>
      <td></td>
      <td>${bdb.DeliveryMethodPrice}円</td>
    </tr>
</tbody>
</table>
</div>
<br>
<br>
<p>※内容に変更がなければ購入ボタンを押して下さい。</p>


<form action="BuyResult" method="post">
	<a class="btn btn-secondary btn-lg btn-block"  href="Buyresult">購入　＞＞</a>
</form>






</body>
</html>