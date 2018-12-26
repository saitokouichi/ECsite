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
<title>RECOUNT画面</title>

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
		height: 500px;
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

</style>
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>

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
			<p>RECOUNT</p>
		</div>

		<div>
		<s:form>
		<input type="hidden" name="last" value="<s:property value="last"/>">

				<tr>
					<td>商品ID</td>
					<td><s:property value="id"/>
						<input type="hidden" name="id" value="<s:property value="id" />">
					</td>

				</tr>

				<tr>
					<td>商品名</td>
					<td><s:property value="puroductName"/>
					<input type="hidden" name="puroductName" value="<s:property value="puroductName" />"></td>
				</tr>

				<tr>
					<td>値段</td>
					<td><s:property value="nedan"/><span>円</span>
					<input type="hidden" name="nedan" value="<s:property value="nedan" />"></td>
				</tr>

				<tr>
					<td>購入個数</td>
					<td><select name="count">
						<%
						int itemStock = Integer.parseInt(request.getAttribute("stock").toString());
						for(int i=1;i<=itemStock;i++){%>
						<option value="<%=i %>"><%=i %></option>
						<%} %>
						</select>
						<span>在庫数：</span><s:property value="stock"/><span>個</span>
						<input type="hidden" name="stock" value="<s:property value="stock" />"></td>
				</tr>

				<tr>
					<td>支払い方法</td>
					<td><s:property value="payment"/>
					<input type="hidden" name="payment" value="<s:property value="payment" />"></td>
				</tr>

				<tr>
					<td><br></td>
				</tr>

				<tr>
					<td><input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>
					<td><input type="button" value="購入" onclick="submitAction('BuyItemAction')"/></td>
				</tr>

		</s:form>
		</div>

		<input type="button" value="HOMEへ" onclick="submitAction('GoHomeAction')"/>

		<div>
			<div>
				<p>HOME画面に戻るには<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページに戻るには<a href='<s:url action="GoMyPageAction"/>'>こちら</a>
			</div>
		</div>

	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>