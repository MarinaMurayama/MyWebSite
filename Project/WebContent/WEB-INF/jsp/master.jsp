<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<title>master&#x1f527;</title>
</head>
<body>
<br>
<br>
<br>
<h1 class="syoppingtitle" >商品一覧(3件)</h1>
<br>
        <div class="syoppingtitle">
		<div class="col s12 form-inline">
			<div class="col s6 center-align">
					<a href="MasterSignup" class="btn btn-outline-secondary btn-lg">新規作成</a>
				</div>
		</div>
<br>
<!-- 商品名の部分一致で検索できるようにする　フォームでpostに送信出来るように手を加える-->
		 <div class="syoppingtitle">
		 <form class="login-form" action="Master" method="post">
				<div class="input-group">
  					<input type="text" class="form-control" name="word">
  					<span class="input-group-btn">
   				 	<button class="btn btn-default" type="submit">SEARCH</button>
  					</span>
				</div>
	 	</form>
		</div>
	</div>
<br>
<br>
<!-- 商品リスト -->
<div class="mastertable">
<table class="table">
  <thead>
    <tr>
      <th scope="col">商品画像</th>
      <th scope="col">商品名</th>
      <th scope="col">型番</th>
      <th scope="col">ショップ在庫</th>
      <th scope="col">販売価格</th>
      <th scope="col">処理</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="item" items="${itemList}" >
    <tr>
      <td><img src="${item.item_img}" alt="サンプル" class="master-top"></td>
      <td>${item.name}</td>
      <td>${item.item_num}</td>
      <td>${item.stocks}</td>
      <td>${item.price}円</td>
      <td>
      	<div class="btn-group" role="group" aria-label="Basic example">
  			<a type="button" class="btn btn-outline-secondary" href="MasterEdit?id=${item.id}">編集</a>
  			<a type="button" class="btn btn-outline-secondary" href="MasterPreview?id=${item.id}">プレビュー</a>
  			<a type="button" class="btn btn-outline-secondary" href="MasterItemDelete?id=${item.id}">削除</a>
		</div>
      </td>
    </tr>
</c:forEach>
  </tbody>
</table>
</div>
<br>
			<div class="syoppingtitle">
			<a href="main">Back</a>
			</div>
<br>

</body>
</html>