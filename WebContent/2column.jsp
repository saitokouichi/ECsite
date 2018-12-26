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
<title>2column</title>
<style type="text/css">

.head{
	width:100px;
	height:50px;
	background-color:navy;
}

.head img{
	width:80px;
	height:40px;
	margin:5px 10px 5px;;
}

header{
	width:100%;
	height:100px;
	background-color:blue;
}

header ul{
	float:right;
	psdding:0px;
	margin:0px;
}

header ul li{
	froat:left;
	display:inline-block;
	line-height:100px;
	margin:0 auto;
	list-style:none;
	color:white;
}

.main-container{
	clear:bothl;
	width:100%;
	height:2000px;
}

.main{
	float:left;
	width:69%;
	height:100%;
	background-color:red;
}

.up{
	width:98%;
	height:1000px;
	margin:10px;
	background-color:white;
}

.button{
	width:50px;
	height:50px;
	border-radius:100%;
	background-color:red;
}

.down{
	width:98%;
	height:900px;
	margin:10px;
	background-color:white;
	}

.side{
	float:right;
	width:29%;
	height:100%;
	background-color:green;
}

.abc{
	clear:both;
	width:90%;
	height:700px;
	margin:20px;
	background-color:white;
}

.abc ul{
	margin:10px;
	padding:10px;
}

.def{
	width:80%;
	height:200px;
	margin:20px;
	background-color:white;
}

.def ul{
	margin:10px;
	padding:10px;
}

footer{
	clear:both;
	width:100%;
	height:100px;
	background-color:black;
}

/* .twitter-timeline{ */
/* 	height:300px; */
/* 	width:80px; */
/* } */

</style>
</head>
<body>
<div class="head"><img src="gazo.jpg"/></div>
<header>
	<ul>
		<li>123</li>
		<li>456</li>
		<li>789</li>
	</ul>
</header>
<div class="main-container">
	<div class="main">
		<div class="up">
			<input type="button" name="button" class="button"/>
			<input type="file"/>
			<iframe width="56" height="32" src="https://www.youtube.com/embed/IC-wDpwzEt4" ></iframe>
		</div>
		<div class="down"></div>
	</div>
	<div class="side">
		<div class="abc">
			<ul>
				<li><a>1</a></li>
				<li><a>2</a></li>
				<li><a>3</a></li>
			</ul>

			<a class="twitter-timeline"  width="300px" height="600px" href="https://twitter.com/TwitterDev/timelines/539487832448843776?ref_src=twsrc%5Etfw"></a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
		</div>

		<div class="def">
			<ul>
				<li>1</li>
				<li>2</li>
				<li>3</li>
			</ul>
		</div>

	</div>
</div>
<footer>
</footer>
</body>
</html>