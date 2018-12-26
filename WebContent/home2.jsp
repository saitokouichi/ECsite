<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style=Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Ravi+Prakash" rel="stylesheet">
<title>HOME画面</title>

<style type="text/css">

	body{
		width: 98%;
		margin: 0 auto;
	}

	#header{
		width: 100%;
		background-color: #232f3e;
	}

	#header img{
		margin: 5px;
	}

	#header ul{
 		float: right;
 	}

 	#header ul li{
 		float: left;
 		list-style: none;
 		color: white;
 		font-size: 14px;
 		font-weight:700;
 		line-height: 60px;
 		padding-right: 10px;
 	}

 	a:link{
 		color:white;
 	}

 	a:visited{
 		color:white;
 	}

	#wrapper{
		float: left;
		width:60%;
	}
	#main{
		width: 40%;
		float: right;
		text-align: center;
	}

	#text-center{
		display: inline-block;
		margin-top:15px;
		text-align: center;
	}

	.none{
		width:100px;
		height:100px;
		text-align:center;
		border-radius:100%;
		background-color:red;
	}

	#side01{
		width: 60%;
		float: left;

	}
	#side02{
		width: 40%;
		float: right;
	}
	#footer{
		clear: both;
		position: absolute;
		bottom:0px;
		width: 100%;
		height: 80px;
		background-color: #232f3e;
	}

 	.button{
 		display:inline-block;
 		margin:40px 60%;
 		cursor: pointer;
 		color: white;
 		background: #232f3e;
 		box-shadow: px 6pz 3px #666666;
 		border: 2px solid #232f3e;
 	}

 	.button:hover{
 		box-shadow: none;
 		color:#232f3e;
 		background: #ffffff;
 	}

	a.showf span.en{
		display:inline;
	}

	a.showf:hover span.en{
		display:none;
	}

	a.showf span.jp{
		display:none;
	}

	a.showf:hover span.jp{
		display:inline;
	}


</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
	$(document).ready(function(){
	$('.slider').bxSlider({
		auto:true,
		mode:'horizontal',
		speed:1000,
 		});
    });
</script>

</head>
<body>
	<header id="header">
		<a href='<s:url action="GoHomeAction"/>'><img src="mudai.png" height="65" width="auto"></a>
			<ul id="normal" class="dropmenu">
				<s:if test="#session.login_user_id==null">
					<li><a href='<s:url action="LoginAction"/>'>ログイン</a></li>
					<li><a href='<s:url action="UserCreateAction"/>'>新規登録</a></li>
				</s:if>
				<s:else>
					<li><a href='<s:url action="LogoutAction"/>' onclick='return confirm("ログアウトしてよろしいですか？")'>ログアウト</a></li>
					<li><a href='<s:url action="LetsMyPageAction"/>'>マイページ</a></li>
				</s:else>
					<li><a class="showf" href="#"><span class="en">お問い合わせ</span><span class="jp">実装予定なし</span></a></li>
					<li><a href='<s:url action="GoCartAction"/>'><img src="cart3.png" height="40" width="auto"></a></li>
			</ul>
	</header>

<div id="wrapper">
	<div id="main">
    	<div id="top">

		</div>


		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入" class="none"/>
			</s:form>
		</div>

		<div class="slider">
			<div><a href='<s:url action="HomeAction"/>'><img src="dogeza_man.png" width="500px" height="auto"></a></div>
			<div><a href='<s:url action="HomeAction"/>'><img src="dogeza_woman.png" width="500px" height="auto"></a></div>
			<div><a href='<s:url action="HomeAction"/>'><img src="dogeza_man.png" width="500px" height="auto"></a></div>
			<div><a href='<s:url action="HomeAction"/>'><img src="WebContent/pose_heart_hand_man.png" width="500px" height="auto"></a></div>
			<div><a href='<s:url action="HomeAction"/>'><img src="dogeza_woman.png" width="500px" height="auto"></a></div>
		</div>

	</div>

	<div id="side01">
		<s:if test="#session.login_user_id !=null">
		<img src="gazo.jpg" height="auto" width="100%" class="gazo">
		</s:if>
	</div>
</div>

<div id="side02">
		<s:if test="#session.login_user_id !=null">
		<img src="gazo.jpg" height="auto" width="100%" class="gazo">
		</s:if>
</div>

<footer id="footer">
	<s:form  action="AdminAction">
		<s:submit value="copyright © internous | 4each blog is the one which provides A to Z about programming." class="button"/>
	</s:form>
</footer>

</body>
</html>