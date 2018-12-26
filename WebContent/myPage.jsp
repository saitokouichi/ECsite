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
<title>MyPage画面</title>

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

	footer{
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

	.box {
		border: 5px solid #cc7eb1;
		margin:10px auto;
		border-radius:10px;
	}

	.box tr,.box th,.box td{
		border-bottom: 5px solid #cc7eb1;
	}

	.cartcount{
		color:#232f3e;
		font-size:20px;
		font-weight:200px;
		margin-top:-8px;
		margin-left:-35px;
		margin-right:-35px;
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
			<li><a href='<s:url action="GoCartAction"/>'><img src="cart3.png" height="40" width="auto"></a></li>
			<li class="cartcount"><s:property value="session.cartList.size()" /></li>
		</ul>
	</div>

	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>

		<div>
		<div>
			<s:property value="#session.user_name"/>  さんの購入履歴

			<s:if test="myPageList.size() == 0">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:else>




				<table class="box">
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>値段</th>
						<th>購入個数</th>
						<th>支払い方法</th>
						<th>購入日</th>
					</tr>


					<s:iterator value="myPageList">

					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="itemName"/></td>
						<td><s:property value="totalPrice"/><span>円</span></td>
						<td><s:property value="totalCount"/><span>個</span></td>
						<td><s:property value="payment"/></td>
						<td><s:property value="insert_date"/></td>
					</tr>

					</s:iterator>
				</table>


				<%--変更点 --%>
				<s:form action="DeleteAction">
					<s:submit value="削除" />
				</s:form>
				<%--変更点 --%>

			</s:else>

			<div id="text-right">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'><strong>こちら</strong></a></p>
				<p>再度購入する場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'   onclick='return confirm("ログアウトしてよろしいですか？")'>こちら</a></p>
			</div>

		</div>

	</div>

	<footer></footer>

	</div>

<!-- 	<div id="footer"> -->
<!-- 		<div id="pr"> -->
<!-- 		</div> -->
<!-- 	</div> -->

</body>
</html>