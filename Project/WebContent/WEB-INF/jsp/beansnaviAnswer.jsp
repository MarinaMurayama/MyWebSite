<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<title>beansnavi診断結果</title>
</head>
<body>
<jsp:include page="/base/headder.jsp" />
<div class="jumbotron2">
<div id="target_point"></div>
<br>
<br>
<br>
<br>
<div class="text-white"><h1 class="syoppingtitle" >BEANS NAVI</h1></div>
<br>
<br>
<br>
<br>
</div>
<br>
<h2 class="syoppingtitle">あなたにぴったりの豆は</h2>
<br>
	<div class="col s12">
				<div class="maintable2">
							<table class="table">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col" ></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td ><img src="${itemList[0].item_img}" alt="サンプル" class="master-top"></td>
										<td><h3>${itemList[0].name}</h3>
											<p>${itemList[0].detail}</p>
											<p><a href="Item?item_id=${itemList[0].id}">商品ページ > </a></p>
										</td>
									</tr>

								</tbody>
								</table>
				</div>
	</div>
<br>
<br>
<br>
<h2 class="syoppingtitle">その他おすすめの豆は</h2>
<br>

<div class="col s12">
				<div class="maintable2">
							<table class="table">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col" ></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td ><img src="${itemList[1].item_img}" alt="サンプル" class="master-top"></td>
										<td><h3>${itemList[1].name}</h3>
											<p>${itemList[1].detail}</p>
											<p><a href="Item?item_id=${itemList[1].id}">商品ページ > </a></p>
										</td>
									</tr>
									<tr>
										<td ><img src="${itemList[2].item_img}" alt="サンプル" class="master-top"></td>
										<td><h3>${itemList[2].name}</h3>
											<p>${itemList[2].detail}</p>
											<p><a href="Item?item_id=${itemList[2].id}">商品ページ > </a></p>
										</td>
									</tr>
								</tbody>
								</table>
				</div>
	</div>


<br>
<br>
<br>
<div class="title">
			<a href="BeansNavi"><<　もう一度診断する </a>
	</div>

<br>
<br>
<div class="title">
			<a href="main"><<　TOPへ戻る </a>
	</div>

<br>
<br>
</body>
</html>