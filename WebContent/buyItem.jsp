<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style=Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BuyItem画面</title>
<script>
	function goBuyItem2Action(){
		document.getElementById("form").action="BuyItem2Action";
	}
</script>

<style type="text/css">

	html {
		min-height: 100%;
		position: relative;
	}

	body{

		margin: 0 auto;
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
		margin:30px auto;
		border:1px solid #333;
		text-align:center;
	}

	.top{
		position: absolute;
		width: 100px;
		height:80px;
		float: left;
		padding: 0px 0px 30px 5px;
	}

	.main{
		clear:both;
	}

	.main-container{
		width: 60%;
		margin: 0 auto;
		margin-top: 10px;
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

	.box {
		border: 5px solid #cc7eb1;
		margin:10px auto;
		border-radius:10px;
	}

	.box tr td{
		border-bottom:2px dotted #778899
	}

	.button{
		display: inline-block;
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
		cursor:pointer;
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
		font-size: 1em;
		line-height: 1;
		padding: 0.4em;
	}

	.buy:hover{
		 background: linear-gradient(to bottom, #f5d689, #eeba35);
		 cursor:pointer;
	}

 	.down{
 		clear:both;
 		display:inline-block;
 		border:#cc7eb1;
 		margin:0 auto;
 		text-align:center;
 	}

	.cartcount{
		color:#232f3e;
		font-size:20px;
		font-weight:700px;
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
			<li><a href='<s:url action="GoMyPageAction"/>'>マイページ</a>
			</s:else>
			<li><a href='<s:url action="LetsMyPageAction"/>'>お問い合わせ(未実装)</a></li>
			<li><a href='<s:url action="GoCartAction"/>'><img src="cart3.png" height="40" width="auto"></a></li>
			<li class="cartcount"><s:property value="session.cartList.size()" /></li>
		</ul>
	</div>



	<div class="main">
		<div id="top">
			<p>BuyItem</p>
		</div>

			<s:iterator value="itemInfoList">
			<s:form action="CartAction" id="form">
				<input type="hidden" name="id" value="<s:property value="id" />">

				<s:if test="itemInfoList.size() == 0">
					<p>購入できる商品がありません。</p>
				</s:if>

				<s:else>

					<s:if test="Emessage != null">
						<s:property value="Emessage"/>
					</s:if>

					<table class="box">
						<tr>
							<td><span>商品名：</span></td>
							<td><s:property value="puroductName" />
							<input type="hidden" name="puroductName" value="<s:property value="puroductName" />"></td>

						</tr>

						<tr>
							<td><span>値段：</span></td>
							<td><s:property value="nedan" /><span>円</span>
								<input type="hidden" name="nedan" value="<s:property value="nedan" />">
							</td>
						</tr>

						<tr>
							<td><span>数量：</span></td>
<%-- 							<td><select name="count"> --%>
<!-- 									<option value="1" selected="selected">1</option> -->
<!-- 									<option value="2">2</option> -->
<!-- 									<option value="3">3</option> -->
<!-- 									<option value="4">4</option> -->
<!-- 									<option value="5">5</option> -->
<%-- 								</select> --%>
<!-- 								<input type="hidden" name="stock" value="count"> -->
<!-- 							</td> -->

							<td>
								<s:if test="stock == 0">
									<p>現在在庫がありません。<br>入荷までお待ちください。</p>
									<img src="dogeza_man.png" class="dogeza" height="40px" width="40px"><img src="dogeza_woman.png" class="dogeza" height="40px" width="40px"><img src="dogeza_man.png" class="dogeza" height="40px" width="40px"><img src="dogeza_woman.png" class="dogeza" height="40px" width="40px"><img src="dogeza_man.png" class="dogeza" height="40px" width="40px">
								</s:if>
								<s:else>
								<span>在庫数：</span><s:property value="stock"/><span>個</span><br>
								<select name="count">
									<%
									int itemStock = Integer.parseInt(request.getAttribute("stock").toString());
									for(int i=1;i<=itemStock;i++){%>
									<option value="<%=i %>"><%=i %></option>
									<%} %>
								</select>
								</s:else>
								<input type="hidden" name="stock" value="<s:property value="stock" />">

							</td>
						</tr>

						<tr>
							<s:if test="stock == 0">
								<p></p>
							</s:if>
							<s:else>
							<td><span>支払い方法：</span></td>
							<td><input type="radio" name="pay" value="1" checked="checked">現金払い
								<input type="radio" name="pay" value="2">クレジットカード</td>
							</s:else>
						</tr>

						<tr>
							<s:if test="stock == 0">
								<p></p>
							</s:if>
							<s:else>
							<td><s:submit value="今すぐ購入" class="buy" onClick="goBuyItem2Action(this);"/></td>
							<td><s:submit value="カートに入れる" class="buy"/></td>
							</s:else>
						</tr>

					</table>

				</s:else>

			</s:form>
			</s:iterator>

			<div class="down">
				<p>
					前画面に戻るには<a href='<s:url action="GoHomeAction"/>'>こちら</a>
				</p>
			</div>

		</div>

	<footer></footer>



</body>


</html>