<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<title>onlineshop_top</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<div class="jumbotron2">
<br>
<br>
<br>
<br>
<div class="text-white"><h1 class="syoppingtitle" >ONLINE SHOP</h1></div>
<br>
<br>
<br>
<br>
<!-- 商品名の部分一致で検索できるようにする　フォームでpostに送信出来るように手を加える-->
 <form class="login-form" action="Onlineshop_top" method="post">
	<div class="input-group">
  	<input type="text" class="form-control"  name="word">
  	<span class="input-group-btn">
    <button class="btn btn-default" type="submit">SEARCH</button>
  	</span>
	</div>
</form>
<br>
</div>
<br>
<!-- 商品カテゴリＩＤでジャンルごとに表示できます フォームでpostに送信出来るように手を加える-->
<div class="syoppingtitle">
 <form class="login-form" action="Onlineshop_category" method="post">
	<div class="btn-group btn-group-toggle" data-toggle="buttons">
    	<button type="submit" name="id" id="option1" value="1" class="btn btn-secondary btn-lg"> BEANS</button>
    	<button type="submit" name="id" id="option2" value="2" class="btn btn-secondary btn-lg"> GOODS</button>
    	<button type="submit" name="id" id="option3" value="3" class="btn btn-secondary btn-lg"> ALL ITEMS</button>
	</div>
</form>
</div>
<!-- 商品一覧 -->
<br>
<div class="maintable">
 <div class="form-inline">
<c:forEach var="pro" items="${itemList}" >

		<div class="card" style="width: 18rem; height: 35rem;">
			<a href="Item?item_id=${pro.id}">
  			<img class="card-img-top" src="${pro.item_img}"></a>
 		 	<div class="card-body">
   		 	<h5 class="card-title"><c:out value="${pro.name}"/></h5>
   		 	<p class="card-text"><c:out value="${pro.detail}"/></p>
   		 	<p><c:out value="${pro.price}"/>円</p>
 		 	</div>
		</div>

  </c:forEach>
    </div>
</div>
<br>
<br>
<div  class="syoppingtitle">
	<a href="main">TOPへ戻る</a>
</div>
<br>
<br>
<br>
</body>
</html>