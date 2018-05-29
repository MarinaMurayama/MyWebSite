<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="common.css">
<title>BEANS NAVI</title>
</head>
<body>

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
<h2 class="syoppingtitle">優先順位の高い項目をクリックしてください。</h2>
<br>
<form name="frm" method="post" action="BeansNavi">
				<div class="syoppingtitle">
				<dl class="switch">
					<dd>
						<h3>1. フレーバーの種類</h3>
						<div class="btn-group" data-toggle="buttons" >
							<label class="btn btn-default active">
							  <input type="radio" name="roast" value="1" autocomplete="off" />フローラル系</label>
							<label class="btn btn-default">
							  <input type="radio" name="roast" value="2" autocomplete="off" />フルーツ系</label>
							<label class="btn btn-default">
							  <input type="radio" name="roast" value="3" autocomplete="off" />チョコレート系</label>
						</div>
						<p><a href="#flavor">フレーバーの種類とは？</a></p>
					</dd>
					<dd>
						<h3>2. 酸味の強弱</h3>
						<div class="btn-group" data-toggle="buttons" >
						  <label class="btn btn-default active">
							<input type="radio" name="flavor" value="3"  /> 弱</label>
						  <label class="btn btn-default active">
							<input type="radio" name="flavor" value="2" /> 中</label>
						  <label class="btn btn-default active">
							<input type="radio" name="flavor" value="1" /> 強</label>
						</div>
						<p><a href="#sour">酸味の強弱とは？</a></p>
					</dd>
					<dd>
						<h3>3. 苦味の強弱</h3>
						<div class="btn-group" data-toggle="buttons" >
						 <label class="btn btn-default active">
							<input type="radio"" name="kind" value="1" /> 弱め</label>
						 <label class="btn btn-default active">
							<input type="radio" name="kind" value="2" /> 中</label>
						 <label class="btn btn-default active">
							<input type="radio" name="kind" value="3" /> 強め</label>
						</div>
						<p><a href="#bitter">苦味の強弱とは？</a></p>
					</dd>
					<dd>
						<h3>4. ボディ感</h3>
					<div class="btn-group" data-toggle="buttons" >
					 <label class="btn btn-default active">
							<input type="radio"  name="taste" value="1" /> 軽め</label>
					 <label class="btn btn-default active">
							<input type="radio" name="taste" value="2" /> 中</label>
					<label class="btn btn-default active">
							<input type="radio" name="taste" value="3" /> 重め</label>
						</div>
						<p><a href="#body">ボディ感とは？</a></p>
					</dd>
				</dl>
				</div>
<br>
<br>
				<div class="syoppingtitle">
				<div class="btn_area">
					<input type="reset" value="やりなおす" onclick="dispClear();" class="btn btn-secondary btn-lg" />
					<input type="submit" value="結果を見る" class="btn btn-secondary btn-lg"/>
									<!--  とりあえず変更↑value="結果を見る" onclick="dispResult();" -->
				</div>
				</div>
			</form>
			<br>
			<div class="syoppingtitle">
			<a href="main">Back</a>
			</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<div class="center">
			<div class="p-3 mb-2 bg-dark text-white">
			<h4 id="flavor" class="headline">フレーバーの種類とは？</h4></div>
			<p>フレーバーとは、舌の奥から喉にかけて感じられる味と香りの総称です。
フローラル系は花のような風味のあるコーヒー。
フルーツ系はフルーティな、チョコレート系はチョコレートのような風味のあるコーヒーを指します。
好みの風味を選択してみてください。</p>
			<p class="pagetop"><a href="#target_point">ページトップへ</a></p>
<br>
<br>
<br>
<br>
		    <div class="p-3 mb-2 bg-dark text-white">
			<h4 id="sour" class="headline">酸味の強弱とは？</h4></div>
			<p>酸味の強さを表しています。
スペシャルティコーヒーの酸味は、フルーツに例えられるような爽やかな酸味です。
酸味の"量"には差があり、豆の産地や焙煎度合いによって異なります。
好みの酸味具合をお選びください。</p>
			<p class="pagetop"><a href="#target_point">ページトップへ</a></p>
<br>
<br>
<br>
<br>
			<div class="p-3 mb-2 bg-dark text-white">
			<h4 id="bitter" class="headline">苦味の強弱とは？</h4></div>
			<p>苦味の強さを表しています。
一般的に、焙煎度合いが深くなるほど苦味が強くなります。
しっかりとした苦味が好きな方は「強め」を、
あまり苦味が得意でない方は「弱め」を選択してください。</p>
			<p class="pagetop"><a href="#target_point">ページトップへ</a></p>
<br>
<br>
<br>
<br>
			<div class="p-3 mb-2 bg-dark text-white">
			<h4 id="body" class="headline">ボディ感とは？</h4></div>
			<p>ここでのボディ感とは、液体の重さを表しています。
厚みのあるリッチなコーヒーは「重め」。
すっきりとしたコーヒーは「軽め」となっています。</p>
			<p class="pagetop"><a href="#target_point">ページトップへ</a></p>
<br>
<br>
<br>
<br>
<br>
</div>
</body>
</html>