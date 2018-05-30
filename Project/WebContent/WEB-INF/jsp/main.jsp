<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<script src="js/jquery-3.3.1.min.js" charset="UTF-8"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script src="js/bootstrap.min.js" charset="UTF-8"></script>
<title>main</title>

</head>
<body>
<jsp:include page="/base/headder.jsp" />
<br>
<br>
<br>
<!-- スライドで画像を動かす。online shopﾘﾝｸつきの画像 -->
<div class="maintable">
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <a href="Onlineshop_top"><img class="d-block w-100" src="picture/goods4.PNG"></a>
      <div class="carousel-caption">
      	<br>
        <h1>＼お父さんいつもありがとう！／</h1>
        <p>父の日ギフト承ります&#9834;　感謝のきもちを伝えてみませんか？</p>
      </div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="picture/img14.PNG">
      <div class="carousel-caption">
        <h1>＼暑い日に最高の一杯&#9834;／</h1>
        <p>毎年ご好評をいただいているアイスコーヒー&#9834; 今年も始まりました！</p>
      </div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="picture/img10.PNG">
       <div class="carousel-caption">
        <h1>＼ONLINE SHOP／</h1>
        <p>新商品が入荷しました。</p>
      </div>
    </div>
  </div>
  <a class="left carousel-control" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
<br>
<br>
<br>
<!-- ちょっとしたコーヒーコラム(///TODO///記事の内容は最後あたりで作成) -->
<h2 class="syoppingtitle">TOPICS</h2>
	<div class="col s12">
				<div class="maintable2">
						<table class="table">
								<thead>
									<tr>
										<th scope="col"></th>
										<th scope="col" ></th>
										<th scope="col" ></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td ><img src="picture/father1.PNG" alt="サンプル" class="master-top"></td>
										<td >【 お父さんいつもありがとう！ 】
											<p>もうすぐ父の日ですね &#9834;  父の日はいつもどんな過ごし方をされていますか？</p>
											<p><a href="Topics?id=1">つづきを読む >></a></p>
										</td>
									</tr>
									<tr>
										<td ><img src="picture/img7.PNG" alt="サンプル" class="master-top"></td>
										<td><p>【 気軽に外カフェを楽しみたい 】</p>
											<p>野外で飲むコーヒーは特別な味 &#9834; コーヒー好きな皆さまがアウトドアで愛用されるMY COFFEE ITEMを拝見させていただきました。</p>
											<p><a href="Topics?id=2">つづきを読む >></a></p>
										</td>
									</tr>
									<tr>
										<td ><img src="picture/img12.PNG" alt="サンプル" class="master-top"></td>
										<td >【 ペットとコーヒーの時間 vol.1 】
											<p>お客様に、大切なペット達と一緒に過ごすコーヒー時間を取材させていただきました。</p>
											<p><a href="Topics?id=3">つづきを読む >></a></p>
										</td>
									</tr>
								</tbody>
							</table>
				 	</div>
		</div>
<br>
<br>
<br>
<!-- BEANS NAVI診断のリンクとか、ゆくゆくはスクールの案内とか -->
<h2 class="syoppingtitle">SERVICE</h2>
<br>
<div class="maintable">
<div class="col-xs-9 form-inline">
		<div class="card" style="width: 18rem;">
			<a href="###.html">
  			<img class="card-img-top" src="picture/imq5.PNG"></a>
 		 	<div class="card-body">
   		 	<h5 class="card-title">Coffee School</h5>
 		 	</div>
		</div>

		<div class="card" style="width: 18rem;">
			<a href="BeansNavi">
  			<img class="card-img-top" src="picture/img13.PNG"></a>
 		 	<div class="card-body">
   		 	<h5 class="card-title">BEANS NAVI</h5>
 		 	</div>
		</div>

		<div class="card" style="width: 18rem;">
			<a href="Onlineshop_top">
  			<img class="card-img-top" src="picture/img10.PNG"></a>
 		 	<div class="card-body">
   		 	<h5 class="card-title">ONLINE SHOP</h5>
 		 	</div>
		</div>
  </div>
 </div>
<br>
<br>
<br>
<br>
<!-- お店のINFO(///TODO///店の名前.住所.電話番号.徒歩何分.グーグル地図を入れる -->
<h2 class="syoppingtitle">SHOP LOCATION</h2>
<br>
<div class="col s12">
				<div class="maintable2">
							<table class="table">
								<thead>
									<tr>
										<th scope="col"name="data"></th>
										<th scope="col" name="gazou"></th>
										<th scope="col" name="google"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><h3>MURAYAMA COFFEE</h3>
											<p>〒123-1111 千葉県千葉市鎌取1212</p>
											<p>鎌取駅：徒歩10分(OPEN 10:00-19:00)</p>
										</td>
										<td ><img src="picture/shop.PNG" alt="サンプル" class="master-top"></td>
										<td ><div class="ggmap"><iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3245.6883301995886!2d140.1753045!3d35.5613988!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60229a043b386f31%3A0x603a6a540df6e6b5!2z44KG44G_772e44KL6Y6M5Y-W44K344On44OU44Oz44Kw44K744Oz44K_44O8!5e0!3m2!1sja!2sjp!4v1526301379417" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe></div></td>
									</tr>
								</tbody>
								</table>
					</div>
</div>
<br>
<br>
<br>
<br>
</body>
</html>