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
<div class="input-group">
  <input type="text" class="form-control">
  <span class="input-group-btn">
    <button class="btn btn-default" type="submit">SEARCH</button>
  </span>
</div>
<br>
</div>
<!-- 商品カテゴリＩＤでジャンルごとに表示できます フォームでpostに送信出来るように手を加える-->
<br>
<div class="syoppingtitle">
<div class="btn-group btn-group-toggle" data-toggle="buttons">
  <label class="btn btn-secondary active btn-lg">
    <input type="radio" name="options" id="option1" autocomplete="off" checked> BEANS
  </label>
  <label class="btn btn-secondary btn-lg">
    <input type="radio" name="options" id="option2" autocomplete="off"> GOODS
  </label>
  <label class="btn btn-secondary btn-lg">
    <input type="radio" name="options" id="option3" autocomplete="off"> ALL ITEMS
  </label>
</div>
</div>
<br>
<!-- 商品一覧 -->
<div class="maintable">
<c:forEach var="pro" items="${itemList}" >
 <div class="col-xs-9 form-inline">
		<div class="card" style="width: 18rem;">
			<a href="Item?item_id=${pro.id}">
  			<img class="card-img-top" src="${pro.item_img}"></a>
 		 	<div class="card-body">
   		 	<h5 class="card-title"><c:out value="${pro.name}"/></h5>
   		 	<p class="card-text"><c:out value="${pro.detail}"/></p>
   		 	<p><c:out value="${pro.price}"/>円</p>
 		 	</div>
		</div>
  </div>
  </c:forEach>
</div>





<div class="title">
	<a href="main">Back</a>
</div>

<h1 class="title"></h1>


</body>
</html>