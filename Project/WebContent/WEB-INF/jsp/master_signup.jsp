<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<br>
<br>
<br>
<h1 class="syoppingtitle" >新規作成</h1>
	${errMsg1}
	${errMsg2}
	${errMsg3}
<br>

<div class="masterStable">
<form class="p-3 mb-2 bg-white text-dark" action="MasterSignup" method="post">
  <div class="form-group row">
    <label for="inputLoginID" class="col-sm-2 col-form-label">商品画像</label>
    <div class="col-sm-10">
      <input type="file" class="form-control" name="pic" required>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">商品名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" required>
    </div>
  </div>
   <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">商品説明</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="detail" required>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">商品カテゴリ</label>
    <div class="btn-group" data-toggle="buttons" >
		<label class="btn btn-default active">
		<input type="radio" id="roast1" name="category" value="1" autocomplete="off" required/>コーヒー豆</label>
		<label class="btn btn-default">
		<input type="radio" id="roast2" name="category" value="2" autocomplete="off" />その他</label>
      </div>
    </div>
    <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">コーヒー豆の場合はジャンルを選択して下さい</label>
    <div class="btn-group" data-toggle="buttons" >
		<label class="btn btn-default active">
		<input type="radio"  name="taste" value="A" autocomplete="off" />濃いめ</label>
		<label class="btn btn-default">
		<input type="radio"  name="taste" value="B" autocomplete="off" />標準</label>
		<label class="btn btn-default active">
		<input type="radio"  name="taste" value="C" autocomplete="off" />香りが良い</label>
      </div>
    </div>
 <div class="form-group row">
    <label for="inputLoginID" class="col-sm-2 col-form-label">型番</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="itemnum" required>
    </div>
  </div>
    <div class="form-group row">
    <label for="inputLoginID" class="col-sm-2 col-form-label">ショップ在庫</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="stocks" required>
    </div>
  </div>
    <div class="form-group row">
    <label for="inputLoginID" class="col-sm-2 col-form-label">販売価格</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="price" required>
    </div>
  </div>
<div class="syoppingtitle">
<div class="button_wrapper">
	<button class="btn btn-outline-secondary btn-lg" type="submit">新規登録</button>
</div>
</div>
<div class="link">
<a href="Master">戻る</a>
</div>
</form>
</div>


</body>
</html>