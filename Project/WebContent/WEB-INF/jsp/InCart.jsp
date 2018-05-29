<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<title>Cart&#x1F6D2;</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<br>
${cartMessage}
<br>
<h1 class="syoppingtitle" >カート内の中身(3点) &#x1F6D2;</h1>
<br>
<br>
<form action="ItemDelete" method="post" class="shoppingcart">
	 <c:forEach var="item" items="${cart}" >
		<div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="${item.item_img}">
 		 	<div class="card-body">
   		 	<h5 class="card-title">${item.name}</h5>
   		 	<p class="card-text">${item.detail}</p>
   		 	<p>${item.price}円</p>
   		 	<input type="checkbox"  name="delete_item_id_list" value="${item.id}" /><label >削除</label>
 		 	</div>
		</div>
	</c:forEach>
  			<div class="syoppingtitle">
				<div class="col-xs-9 form-inline">
						<div class="col s6 center-align">
							<button class="btn btn-secondary btn-lg" type="submit" name="action">
								<i class="material-icons right">&#10004;　削除</i>
							</button>
						</div>
						<div class="col s6 center-align">
							<a  class="btn btn-secondary btn-lg" href="BuyCheck">
							<i class="material-icons right" >購入手続きへ 　＞</i>
							</a>
						</div>
				</div>
				</div>

			</form>
<br>
<br>
<div class="syoppingtitle">
	<a href="main">TOPへ戻る</a>
</div>
<div class="syoppingtitle">
	<a href="Onlineshop_top">ONLINE SHOPへ戻る</a>
</div>


</body>
</html>