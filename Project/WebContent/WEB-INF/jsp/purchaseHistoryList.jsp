<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>purchaseHistoryList&#x1F6D2;</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<br>
<br>
<br>
<h1 class="syoppingtitle" >購入履歴一覧</h1>
<br>
<br>
			<div class="card grey lighten-5">
				<div class="mastertable">
				<!-- 詳細 -->
				<table class="table">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">購入日時</th>
							<th scope="col">配送方法</th>
							<th scope="col">購入金額</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="buy" items="${buylist}" >
							<tr>
								<td ><a href="UserBuyDetail?id=${buy.id}" class="btn btn-secondary btn-lg">&#10057;</a></td>
								<td >${buy.buyDate}</td>
								<td>${buy.deliveryMethodName}</td>
								<td >${buy.totalPrice}円</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					<br>
					<br>
		<div class="right">
			<a  href="main">Back</a>
		</div>
					<br>
					<br>
				</div>
			</div>
</body>
</html>