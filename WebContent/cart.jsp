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
<title>Cart画面</title>

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
		font-weight:700;
		color: #333;
		background: white;
		margin-bottom: 100px;
	}

	table{
		display:inline-block;
		text-align: center;
		margin:0 auto;
	}

	.box {
		border: 1px solid black;
		margin: 10px;
		padding: 10px;
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

	footer{
		left:0px;
		position: absolute;
		bottom:0px;
		width: 100%;
		height: 80px;
		background-color: #232f3e;
		clear: both;
	}

	footer ul li{
		float:right;
		padding:10px;
	}

	#text-center{
		clear:both;
		display: inline-block;
		text-align: center;
	}

	.button{
		display: inline-block;
    	width: auto;
    	border: 1px solid #9c7e31;
		border-top: 1px solid #a88734;
		border-bottom: 1px solid #846a29;
		border-radius: 3px;
		background: linear-gradient(to bottom, #f7dea1, #FF9900);
		box-shadow: 0 1px 0 #faecc8 inset;
		text-align: center;
		color: #111;
		font-size: 12px;
		line-height: 1;
		padding: 0.4em;
	}

	.button:hover{
		background: linear-gradient(to bottom, #f5d689, #eeba35);
	}

	.buy{
		display: inline-block;
    	width: auto;
    	border: 1px solid #9c7e31;
		border-top: 1px solid #a88734;
		border-bottom: 1px solid #846a29;
		border-radius: 3px;
		background: linear-gradient(to bottom, #f7dea1, #FF9900);
		box-shadow: 0 1px 0 #faecc8 inset;
		text-align: center;
		color: #111;
		font-size: 18px;
		line-height: 1;
		padding: 0.4em;
	}

	.buy:hover{
		 background: linear-gradient(to bottom, #f5d689, #eeba35);
	}

	.box {
		border: 5px solid #cc7eb1;
		margin:10px auto;
		border-radius:10px;
	}

	.box tr td{
		border-bottom:2px dotted #778899
	}

	.cartcount{
		color:#232f3e;
		font-size:2em;
		font-weight:700px;
		margin-top:-8px;
		margin-left:-35px;
		margin-right:-35px;
	}

	.bgimage {
		display: block;
		position: relative;
		z-index: 1;
	}
	.bgimage:after {
  		content: "";

		background-position: center;

		top: 0;
		left: 0;
		bottom: 0;
		right: 0;
		position: absolute;
		z-index: -1;
	}

</style>

</head>
<body>
<div class="bgimage">



	<div id="header">
		<a href='<s:url action="GoHomeAction"/>'><img src="mudai.png" height="65" width="auto"></a>
		<ul>
			<s:if test="#session.login_user_id==null">
			<li><a href='<s:url action="LoginAction"/>'>ログイン</a></li>
			<li><a href='<s:url action="UserCreateAction"/>'>新規登録</a></li>
			</s:if>
			<s:else>
			<li><a href='<s:url action="LogoutAction"/>' onclick='return confirm("ログアウトしてよろしいですか？")'>ログアウト</a></li>
			</s:else>
			<li><a href='<s:url action="LetsMyPageAction"/>'>お問い合わせ(未実装)</a></li>
			<li><a href='<s:url action="GoCartAction"/>'><img src="cart3.png" height="40" width="auto"></a></li>
			<li class="cartcount"><s:property value="session.cartList.size()" /></li>
		</ul>
	</div>

	<div id="main">
		<div id="top">
			<p>カート</p>
		</div>


		<h2><s:label value="カート合計金額 :"/><s:property value="#session.cartPrice"/>円</h2>


		<div>
		<div>
			<s:property value="#session.user_name"/>  さんのカート

			<s:form action="CartBuyAction">
					<s:submit class="buy" value="購入する" />
				</s:form>

			<s:if test="#session.cartList.size() == 0">
				<h3>ショッピングカートに商品はありません。</h3>
			</s:if>
			<s:else>

			<input type="hidden" name="stock" value="<s:property value="stock" />">

				<s:iterator value="#session.cartList">
				<s:form action="CartSelectDeleteAction">
				<table class="box">
<!-- 					<tr> -->
						<tr><td></td><td><s:property value="id2" /><input type="hidden" name="id2" value="<s:property value="id2" />"></td></tr>
						<tr><td>商品ID</td><td><s:property value="id" /><input type="hidden" name="id" value="<s:property value="id" />"></td></tr>
						<tr><td>商品名</td><td><s:property value="itemName"/><input type="hidden" name="puroductName" value="<s:property value="puroductName" />"></td></tr>
						<tr><td>値段</td><td><s:property value="totalPrice"/><span>円</span><input type="hidden" name="totalPrice" value="<s:property value="totalPrice" />"></td></tr>
						<tr><td>購入個数</td><td><s:property value="totalCount"/><span>個</span><input type="hidden" name="totalCount" value="<s:property value="totalCount" />"></td></tr>
						<tr><td>支払い方法</td><td><s:property value="payment"/><input type="hidden" name="payment" value="<s:property value="payment" />"></td></tr>
						<tr><td>カートに入れた日</td><td><s:property value="insert_date"/><input type="hidden" name="insert_date" value="<s:property value="insert_date" />"></td></tr>
						<tr><td><s:submit value="カートから外す" class="button"/></td></tr>
				</table>
				</s:form>
				</s:iterator>

				<s:form action="CartBuyAction">
					<s:submit class="buy" value="購入する" />
				</s:form>

				<%--変更点 --%>

<%-- <meta>の後に<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> --%>
<!-- ポップアップ要員 -->
<!-- onclick='return confirm("削除してよろしいですか？")' -->

			</s:else>

			<div id="text-right">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'><strong>こちら</strong></a></p>
				<p>再度購入する場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'   onclick='return confirm("ログアウトしてよろしいですか？")'>こちら</a></p>
			</div>

		</div>

	</div>

	<footer>
	<ul>
		<li><p><a href='<s:url action="GoHomeAction"/>'><strong>HOME</strong></a></p></li>
		<li><p><a href='<s:url action="HomeAction"/>'>購入</a></p></li>
		<li><p><a href='<s:url action="LogoutAction"/>'   onclick='return confirm("ログアウトしてよろしいですか？")'>ログアウト</a></p></li>
	</ul>
	</footer>

	</div>

</div>
</body>
</html>