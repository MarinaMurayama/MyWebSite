<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<title>master&#x1f527;</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<br>
<br>
<br>
<h1 class="syoppingtitle" >情報編集</h1>
${errMsg1}
${errMsg2}
${errMsg3}
<br>
<div class="masterStable">
	<form class="p-3 mb-2 bg-white text-dark" action="MasterEdit" enctype="multipart/form-data" method="post">
			<div class="form-group row">
				<input type="hidden" value="${Itemdata.id}" name="id">
			</div>
  			<div class="form-group row">
    			<label for="inputLoginID" class="col-sm-2 col-form-label" >商品画像　　※内容に変更がある場合のみ入力して下さい</label>
    				<div class="col-sm-10">
      					<input type="file" class="form-control" name="pic">
    				</div>
  			</div>
  			<div class="form-group row">
    			<label for="inputPassword" class="col-sm-2 col-form-label">商品名</label>
    				<div class="col-sm-10">
      					<input type="text" value="${Itemdata.name}" class="form-control" name="name" required>
    				</div>
  			</div>
   			<div class="form-group row">
    			<label for="inputPassword" class="col-sm-2 col-form-label">商品説明</label>
    				<div class="col-sm-10">
      					<input type="text" value="${Itemdata.detail}" class="form-control" name="detail" required>
    				</div>
  			</div>
  			<div class="form-group row">
    			<label for="inputPassword" class="col-sm-2 col-form-label">商品カテゴリ</label>
    				<div class="btn-group" data-toggle="buttons" >
   	    			<!--条件分岐 コーヒー豆 -->
 						<c:choose>
							<c:when test="${Itemdata.category_id == '1'}">
								<label class="btn btn-default active">
								<input type="radio" id="roast1" name="category" value="1" checked />コーヒー豆</label>
								<label class="btn btn-default active">
								<input type="radio" id="roast2" name="category" value="2" />その他</label></c:when>
						<c:otherwise>
								<label class="btn btn-default active">
								<input type="radio" id="roast1" name="category" value="1" />コーヒー豆</label>
								<label class="btn btn-default">
								<input type="radio" id="roast2" name="category" value="2" checked/>その他</label></c:otherwise>
						</c:choose>
      				</div>
    		</div>
 		<div class="form-group row">
    		<label for="inputPassword" class="col-sm-2 col-form-label">コーヒー豆のジャンル</label>
    			<div class="btn-group" data-toggle="buttons" >
 				<!--条件分岐 taste -->
				<c:choose>
					<c:when test="${Itemdata.taste_num == 'A'}">
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="A" checked/>濃いめ</label>
						<label class="btn btn-default">
						<input type="radio"  name="taste" value="B" />標準</label>
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="C" />香りが良い</label></c:when>
					<c:when test="${Itemdata.taste_num == 'B'}">
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="A" />濃いめ</label>
						<label class="btn btn-default">
						<input type="radio"  name="taste" value="B" checked/>標準</label>
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="C" />香りが良い</label></c:when>
					<c:when test="${Itemdata.taste_num == 'C'}">
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="A" />濃いめ</label>
						<label class="btn btn-default">
						<input type="radio"  name="taste" value="B" />標準</label>
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="C" checked/>香りが良い</label></c:when>
					<c:when test="${Itemdata.taste_num == null}">
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="A" />濃いめ</label>
						<label class="btn btn-default">
						<input type="radio"  name="taste" value="B" />標準</label>
						<label class="btn btn-default active">
						<input type="radio"  name="taste" value="C" />香りが良い</label></c:when>
				</c:choose>
      			</div>
		</div>
 			<div class="form-group row">
    			<label for="inputLoginID" class="col-sm-2 col-form-label">型番</label>
    			<div class="col-sm-10">
      			<input type="text" class="form-control" name="itemnum" placeholder="内容に変更がある場合のみ入力して下さい">
    			</div>
  			</div>
   			<div class="form-group row">
    			<label for="inputLoginID" class="col-sm-2 col-form-label">ショップ在庫</label>
    			<div class="col-sm-10">
      			<input type="number" value="${Itemdata.stocks}" class="form-control" name="stocks" required>
    			</div>
  			</div>
    			<div class="form-group row">
    			<label for="inputLoginID" class="col-sm-2 col-form-label">販売価格</label>
    			<div class="col-sm-10">
      			<input type="number" value="${Itemdata.price}" class="form-control" name="price" required>
    			</div>
  			</div>
	<div class="syoppingtitle">
		<div class="button_wrapper">
			<button class="btn btn-outline-secondary btn-lg" type="submit">情報更新</button>
		</div>
	</div>
	<div class="link">
		<a href="Master">戻る</a>
	</div>
</form>
</div>
</body>
</html>