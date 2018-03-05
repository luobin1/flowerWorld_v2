<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
	String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员在线咨询页面</title>
<meta name="keywords"
	content="free template, contact, floral shop, ecommerce, online store" />
<meta name="description"
	content="Floral Shop, Contact Form, Location Maps, Addresses, free template for ecommerce websites." />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/flowerWorld_v2/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" href="css/orman.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<style>
#content1 {
	border: 1px solid gray;
	width: 100%;
	height: 400px;
	overflow-y: scroll;
}
</style>
<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/style.css" />
<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/shopping-mall-index.css" />
<script type="text/javascript" src="/flowerWorld_v2/js2/jquery.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhonglin.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhongling2.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
<script type="text/javascript" src="js/flowerPages.js"></script>
<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}

</script>


</head>

<body>
	<!-- 台头 -->
	<div class="zl-header">
		<div class="zl-hd w1200">
			<p class="hd-p1 f-l">
				<a>您好，欢迎来到我的花花世界</a>
			</p>
			<p class="hd-p2 f-r">
				<a href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">${user.u_nname }</a><span>|</span>
				<a href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">修改个人信息</a><span>|</span>
				<a href="/flowerWorld_v2/logOut.do">退出</a>
			</p>
			<div style="clear: both;"></div>
		</div>
	</div>

	<div id="templatemo_wrapper_sp">
		<div id="templatemo_header_wsp">
			<div id="templatemo_header" class="header_subpage">
				<div id="site_title">
					<a href="#">花花世界</a>
				</div>
				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="/flowerWorld_v2/flower/loadAdminIndex.do"
							class="selected">首页</a></li>
						<li><a
							href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">个人信息</a></li>
						<li><a href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a>
							<ul>
								<li><a href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a></li>
								<li><a href="/flowerWorld_v2/flowerType/type.do">鲜花分类管理</a></li>
							</ul></li>
						<li><a
							href="/flowerWorld_v2/userAdmin/roleIDs.do">用户管理</a></li>
						<li><a href="/flowerWorld_v2/adminContact.jsp"
							target="_blank">在线系统</a></li>
						<li><a href="/flowerWorld_v2/faqsAdmin.jsp">帮助中心设置</a></li>
					</ul>
					<div id="templatemo_search">
						<form action="#" method="get">
							<input type="text" value="Site Search" name="keyword"
								id="keyword" title="keyword" onfocus="clearText(this)"
								onblur="clearText(this)" class="txt_field" /> <input
								type="submit" name="Search" value="" alt="Search"
								id="searchbutton" title="Search" class="sub_btn" />
						</form>
					</div>
					<br style="clear: left" />
				</div>
				<a href="#" title="#/" class="site_repeat" target="_blank"><img
					src="images/top_repeat.png" title="#/" /></a>
				<!-- end of templatemo_menu -->

			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		<div id="templatemo_main_wrapper">
			<div id="templatemo_main">
				<div id="sidebar" class="left">
					<div class="sidebar_box"></div>
					<div class="sidebar_box"></div>
				</div>

				<div id="content" class="right">
					<h2>在线咨询系统</h2>
					<p>与客户在线交流</p>
					<div class="cleaner h20"></div>
					<div class="col col13">
						<h4>在线客户列表</h4>
						<div id="online-list">
							<ol id="online-ul">

							</ol>
						</div>
					</div>
					<div class="col col23 no_margin_right">
						<h4 id="title"></h4>
						<div id="content1"></div>

					</div>
					<div class="cleaner h40"></div>
					<div id="contact_form">
						<form name="contact">
							<script>
	    var t=0;
		var path = '<%=basePath%>';
		var uid='<%=session.getId()%>';
		if(uid==-1){
			location.href="<%=basePath2%>";
								}
								var from = "manage";
								var fromName = "manage";
								var to = "";

								var websocket;
								if ('WebSocket' in window) {
									websocket = new WebSocket("ws://" + path
											+ "/ws.do?uid=" + uid);
								} else if ('MozWebSocket' in window) {
									websocket = new MozWebSocket("ws://" + path
											+ "/ws.do" + uid);
								} else {
									websocket = new SockJS("http://" + path
											+ "/ws/sockjs.do" + uid);
								}
								websocket.onopen = function(event) {
									console.log("WebSocket:已连接");
									console.log(event);
								};
								websocket.onmessage = function(event) {
									var data = JSON.parse(event.data);
									console.log("WebSocket:收到一条消息", data);
									var textCss = data.from == -1 ? "sfmsg_text"
											: "fmsg_text";
									if (data.id == 0) {
										var newDate = new Date();
										newDate.setTime(data.date);
										$("#content1")
												.append(
														"<div class='fmsg'><label class='name'>"
																+ $(
																		"#"
																				+ data.fromName)
																		.text()
																+ "&nbsp;"
																+ newDate
																		.toLocaleString()
																+ "</label><div class='"+textCss+"'>"
																+ data.text
																+ "</div></div>");
										scrollToBottom();
									}
									if (data.id == 1) {
										t++;
										$("#online-ul")
												.append(
														'<li id="'
																+ data.from
																+ '" onclick="changes('
																+ "'"
																+ data.from
																+ "'"
																+ ')" class="online-li">用户'
																+ t + "</li>");

									}

									if (data.id == 2) {
										$("#" + data.from).remove();

									}

								};
								websocket.onerror = function(event) {
									console.log("WebSocket:发生错误 ");
									console.log(event);
								};
								websocket.onclose = function(event) {
									console.log("WebSocket:已关闭");
									console.log(event);
								}
								function sendMsg() {
									var v = $("#msg").val();
									if (v == "") {
										return;
									} else {
										var data = {};
										data["from"] = from;
										data["fromName"] = fromName;
										data["to"] = to;
										data["text"] = v;
										websocket.send(JSON.stringify(data));
										$("#content1")
												.append(
														"<div class='tmsg'><label class='name'>我&nbsp;"
																+ new Date()
																		.Format("yyyy-MM-dd hh:mm:ss")
																+ "</label><div class='tmsg_text'>"
																+ data.text
																+ "</div></div>");
										scrollToBottom();
										$("#msg").val("");
									}
								}

								function scrollToBottom() {
									var div = document
											.getElementById('content1');
									div.scrollTop = div.scrollHeight;
								}

								Date.prototype.Format = function(fmt) { //author: meizz 
									var o = {
										"M+" : this.getMonth() + 1, //月份 
										"d+" : this.getDate(), //日 
										"h+" : this.getHours(), //小时 
										"m+" : this.getMinutes(), //分 
										"s+" : this.getSeconds(), //秒 
										"q+" : Math
												.floor((this.getMonth() + 3) / 3), //季度 
										"S" : this.getMilliseconds()
									//毫秒 
									};
									if (/(y+)/.test(fmt))
										fmt = fmt.replace(RegExp.$1, (this
												.getFullYear() + "")
												.substr(4 - RegExp.$1.length));
									for ( var k in o)
										if (new RegExp("(" + k + ")").test(fmt))
											fmt = fmt
													.replace(
															RegExp.$1,
															(RegExp.$1.length == 1) ? (o[k])
																	: (("00" + o[k])
																			.substr(("" + o[k]).length)));
									return fmt;
								}

								function send(event) {
									var code;
									if (window.event) {
										code = window.event.keyCode; // IE
									} else {
										code = e.which; // Firefox
									}
									if (code == 13) {
										sendMsg();
									}
								}

								function clearAll() {
									$("#content1").empty();
								}

								function changes(toUid) {
									to = toUid;
									$(".online-li").attr("style", "");
									$("#" + toUid).attr("style", "color:red");
									$("#title").text(
											"正在与" + $("#" + toUid).text()
													+ "对话中...");
								}
							</script>

							<div class="col col23 no_margin_right">
								<label for="msg">Message:</label>
								<textarea id="msg" name="message" placeholder="请输入要发送的信息"
									rows="0" cols="0" class="required"></textarea>
								<div class="cleaner h10"></div>
								<input type="button" class="submit_btn left" name="submit"
									id="submit" value=" 发 送" onclick="sendMsg()" /> <input
									type="button" class="submit_btn submit_right" name="reset"
									id="reset" value=" 清 空" onclick="clearAll()" />
							</div>


						</form>
					</div>
					<div class="cleaner h40"></div>
					<div class="blank_box">
						<a href="#"><img src="images/free_shipping.jpg"
							alt="Free Shipping" /></a>
					</div>
					<div class="cleaner"></div>
				</div>








				<div class="cleaner"></div>
			</div>
			<!-- END of main -->
		</div>
		<!-- END of main wrapper -->

		<div id="templatemo_footer_wrapper">
			<div id="templatemo_footer">
				<div class="footer_left">
					<a href="#"><img src="images/1311260370_paypal-straight.png"
						alt="Paypal" /></a> <a href="#"><img
						src="images/1311260374_mastercard-straight.png" alt="Master" /></a> <a
						href="#"><img src="images/1311260374_visa-straight.png"
						alt="Visa" /></a>
				</div>
				<div class="footer_right">
					<p>
						<a href="index.html">Home</a> | <a href="products.html">Products</a>
						| <a href="about.html">About</a> | <a href="faqsAdmin.jsp">FAQs</a> | <a
							href="checkout.html">Checkout</a> | <a href="contact.html">Contact</a>
					</p>
					<p>
						Copyright (c) 2084 <a href="#">Company Name</a> | Collect from <a
							href="http://www.mycodes.net/" title="源码之家">源码之家</a>
					</p>
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of footer -->
		</div>
		<!-- END of footer wrapper -->
	</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>