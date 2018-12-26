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
<title>deleteconfirm画面</title>

<style type="text/css">

	html {
		min-height: 100%;
		position: relative;
	}

	body{
		margin: 0;
		padding: 0;
		line-height: 1.6;
		letter-spacing: 1px;
		font-family: Verdana, Hevetica, sans-serif;
		font-size: 12px;
		color: #333;
		background: #fff;
		margin-bottom: 100px;
	}

	table{
		text-align: center;
		margin:0 auto;
	}


	#header{
		width: 100%;
		height: 80px;
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
		font-color: white;
		font-size: 10px;
		line-height: 60px;
		padding-right: 10px;
	}


	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}

	.top{
		position: absolute;
		width: 100px;
		height:80px;
		float: left;
		padding: 0px 0px 30px 5px;
	}

	#main{
		width: 100%;
		text-align: center;
	}

	#footer{
		left:0px;
		bottom:0px;
		width: 100%;
		height: 80px;
		background-color: #232f3e;
		clear: both;
		position: absolute;
		bottom:0px;
	}

	#text-center{
		display: inline-block;
		text-align: center;
	}

	.box {
		border: 1px solid black;
		margin:10px auto;
	}

	.button{
		display: inline-block;
		border-radius: 5%;
		cursur: pointer;
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

	.aaa {
		position: relative;
		z-index: 2;
		border: 2px solid #333;
		color: #fff;
		line-height: 50px;
		-webkit-perspective: 300px;
		perspective: 300px;
		-webkit-transform-style: preserve-3d;
		transform-style: preserve-3d;
}
.aaa:hover {
color: #333;
}
.aaa::after {
top: 0;
left: 0;
width: 100%;
height: 100%;
background: #333;
-webkit-transform-origin: center bottom;
transform-origin: center bottom;
-webkit-transform: rotateX(0);
transform: rotateX(0);
}
.aaa:hover::after {
-webkit-transform: rotateX(-180deg);
transform: rotateX(-180deg);
}

</style>

</head>
<body>
	<div id="header">
		<a href='<s:url action="GoHomeAction"/>'><img src="mudai.png" height="65" width="auto"></a>
		<ul>
			<s:if test="#session.login_user_id==null">
			<li><a href='<s:url action="LoginAction"/>'>ログイン</a></li>
			<li><a href='<s:url action="UserCreateAction"/>'>新規登録</a></li>
			</s:if>
			<s:else>
			<li><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</s:else>
			<li><a href='<s:url action="LetsMyPageAction"/>'>お問い合わせ(未実装)</a></li>
			<li><a href='<s:url action="GoCartAction"/>'><img src="cart2.png" height="40" width="auto"></a></li>
		</ul>
	</div>

	<div id="main">
		<div id="top">
			<p>DeleteConfirm</p>
		</div>

<%--mypage.jspとほとんど同じ --%>

		<div>

		<s:property value="#session.user_name"/> さん
			<p>以下の情報を削除しますか。</p>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>購入個数</th>
						<th>支払い方法</th>
						<th>購入日</th>
					</tr>

					<s:iterator value="myPageList">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><s:property value="totalPrice"/><span>円</span></td>
						<td><s:property value="totalCount"/><span>個</span></td>
						<td><s:property value="payment"/></td>
						<td><s:property value="insert_date"/></td>
					</tr>
					</s:iterator>
				</table>


				<%--変更点 --%>
				<s:form action="MyPageAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="削除" method="delete" class="aaa"/>
				</s:form>
				<%--変更点 --%>



			<s:form action="GoMyPageAction">
				<s:submit value="戻る"/>
			</s:form>


	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

	</div>

</body>
</html>