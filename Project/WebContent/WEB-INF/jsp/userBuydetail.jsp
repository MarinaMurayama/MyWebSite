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
<h1 class="syoppingtitle" >購入履歴詳細</h1>
<br>
<br>
			<div class="col s12">
				<div class="card grey lighten-5">
				<div class="mastertable">
							<!-- 詳細 -->
							<table class="table">
								<thead>
									<tr>
										<th scope="col">商品画像</th>
										<th scope="col">商品名</th>
										<th scope="col">金額</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="item" items="${historyList}" >
									<tr>
										<td ><img src="${item.item_img}" alt="サンプル" class="master-top"></td>
										<td >${item.name}</td>
										<td>${item.price}円</td>
									</tr>
								 </c:forEach>
								</tbody>
							</table>
							<table class="table">
							<thead>
								<tr>
									<th scope="col">購入日時</th>
									<th scope="col">配送方法</th>
									<th scope="col">金額</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${hBdb.buyDate}</td>
									<td>${hBdb.deliveryMethodName}</td>
									<td>${hBdb.deliveryMethodPrice}円</td>
								</tr>
							</tbody>
						</table>
				</div>
<br>
<strong class="right" >合計料金：${hBdb.deliveryMethodPrice + hBdb.totalPrice}円</strong>
<br>
<br>
		<form class="right" action="BuyResult" method="post">
			<a href="PurchaseHistoryList">BACK</a>
		</form>
<br>
<br>
<br>
<br>
</div>
</div>

</body>
</html>