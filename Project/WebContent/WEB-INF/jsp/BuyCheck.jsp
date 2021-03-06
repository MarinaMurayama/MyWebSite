<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="js/jquery-3.3.1.min.js" charset="UTF-8"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script src="js/popper.min.js" charset="UTF-8"></script>
<script src="js/bootstrap.min.js" charset="UTF-8"></script>
<title>Cart</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<br>
<br>
<h1 class="syoppingtitle" >購入手続き &#x1F6D2;</h1>
<br>
	<div class="syoppingtitle">
		<a href="Cart">前の画面に戻る</a>
	</div>
<br>
<!-- 商品リスト -->
<div class="mastertable">
	<table class="table">
  		<thead>
    		<tr>
      		<th scope="col">商品画像</th>
      		<th scope="col">商品名</th>
      		<th scope="col">数量</th>
      		<th scope="col">単価</th>
    		</tr>
  		</thead>
		<tbody>
			<c:forEach var="item" items="${cart}" >
    			<tr>
      			<td><img src="${item.item_img}" alt="サンプル" class="master-top"></td>
      			<td>${item.name}</td>
      			<td>${item.count}個</td>
      			<td>${item.price}円</td>
    			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<br>
<!-- 配送方法を選択 -->
<h3 class="syoppingtitle" >配送方法を選択して下さい</h3>
<form action="BuyCheck" method="post">
	<div class="syoppingtitle">
 		<div class="btn-group">
  		<button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   		配送方法
  		</button>
  		<div class="dropdown-menu dropdown-menu-right">
    	<button class="dropdown-item" type="submit" value="1" name="delivery_id">通常配送</button>
    	<button class="dropdown-item" type="submit" value="2" name="delivery_id">日時指定配送</button>
    	<button class="dropdown-item" type="submit" value="3" name="delivery_id">特別配送</button>
  		</div>
		</div>
	</div>
</form>
<br>
<br>
</body>
</html>