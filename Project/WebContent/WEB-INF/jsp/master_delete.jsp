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

<br>
<br>
<br>
<h1 class="syoppingtitle">Delete</h1>
<p class="syoppingtitle">本当に削除してよろしいですか？</p>
<br>
<div class="mastertable">
<table class="table">
  <thead>
    <tr>
      <th scope="col">商品画像</th>
      <th scope="col">商品名</th>
      <th scope="col">型番</th>
      <th scope="col">ショップ在庫</th>
      <th scope="col">販売価格</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><img src="${Itemdata.item_img}" alt="サンプル" class="master-top"></td>
      <td>${Itemdata.name}</td>
      <td>${Itemdata.item_num}</td>
      <td>${Itemdata.stocks}</td>
      <td>${Itemdata.price}円</td>
    </tr>
  </tbody>
</table>
</div>


<div class="p-3 mb-2 bg-white text-dark" >
<form class="login-form" action="MasterItemDelete" method="post">
	<div class="button_wrapper">
	<button type="submit" class="btn btn-secondary" >削除</button>
	<input type="hidden" value="${Itemdata.id}" class="form-control"  name="id">
	</div>
</form>
<div class="button_wrapper">
	<a type="button" class="btn btn-secondary"  href="Master">キャンセル</a>
</div>
</div>


</body>
</html>