<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>鲜花管理</title>
<meta name="keywords"
	content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description"
	content="Floral Shop, Products, free website template for ecommerce shopping websites." />
<link href="/flowerWorld_v2/templatemo_style.css" rel="stylesheet"
	type="text/css" />
<link rel="shortcut icon" href="/flowerWorld_v2/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" href="/flowerWorld_v2/css/orman.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/flowerWorld_v2/css/nivo-slider.css"
	type="text/css" media="screen" />

<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/style.css" />
<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/shopping-mall-index.css" />
<script type="text/javascript" src="/flowerWorld_v2/js2/jQuery.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhonglin.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhongling2.js"></script>

<script type="text/javascript" src="/flowerWorld_v2/js/jquery.min.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js/ddsmoothmenu.js">
	/***********************************************
	 * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	 * This notice MUST stay intact for legal use
	 * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	 ***********************************************/
</script>

<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "templatemo_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})

	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
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
					<a href="http://www.mycodes.net/" title="花花世界">花花世界</a>
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
						<li><a href="/flowerWorld_v2/userAdmin/roleIDs.do">用户管理</a></li>
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
				<!-- end of templatemo_menu -->

			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		<div id="templatemo_main_wrapper">
			<div id="templatemo_main">

				<div id="content" class="right">
					<h2>所有鲜花列表</h2>
					<a style="font-size: 20px; color: red; font-weight: bold;"
						href="/flowerWorld_v2/flowerPage/addFlower.jsp">添加鲜花信息</a>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						flowersWorld是成都市第一鲜花网，是成都本土专业的鲜花礼品网络订购服务平台。
						我网站目前专注做成都10区10县城区及周边鲜花配送，坚持以“专业、专注、高效、方便、快捷”为工作目标，
						为全成都1435万常住人口、400万流动人口、50万高校学生提供优质服务，为他们的爱人、亲人、尊敬的人、关心的人时刻准备着，
						送出那一束饱含爱意的鲜花。
					</p>
					<c:forEach items="${flowers }" var="flower">
						<div class="product_box">
							<a
								href="/flowerWorld_v2/flower/toChangeFlowerPage.do?flowerId=${flower.flowerId }"><img
								src="${flower.flowerUrl1}"
								alt="floral set 1" style="width: 165px; height: 165px;" /></a>
							<h3>${flower.flowerName }</h3>
							<p class="product_price">${flower.price }元</p>
							<p class="add_to_cart">
								<a
									href="/flowerWorld_v2/flower/toChangeFlowerPage.do?flowerId=${flower.flowerId }">修
									改</a> <a
									href="/flowerWorld_v2/flower/deleteFlowerById.do?flowerId=${flower.flowerId }">删
									除</a>
							</p>
						</div>
					</c:forEach>
					<div id="limit-div">
						<c:if test="${pageNumber==1 }">
							<div style="float: left;">
								<a href="#" class="button left">上一页</a>
							</div>
						</c:if>
						<c:if test="${pageNumber>1 }">
							<div style="float: left;">
								<a
									href="/flowerWorld_v2/flower/findFlowers.do?pageNumber=${pageNumber-1 }"
									class="button left">上一页</a>
							</div>
						</c:if>

						<div style="float: left; width: 100px;" align="center">
							<c:forEach begin="1" end="${totalPage }" var="n">
								<c:if test="${pageNumber==n }">
									<a class="limit-a1" href="#" style="color: red; font-size: 15px;">${n }</a>
								</c:if>
								<c:if test="${pageNumber!=n }">
									<a class="limit-a2"
										href="/flowerWorld_v2/flower/findFlowers.do?pageNumber=${n }"
										style="color: white; font-size: 15px;">${n }</a>
								</c:if>
							</c:forEach>
						</div>


						<c:if test="${pageNumber==totalPage }">
							<a href="#" class="button left">下一页</a>
						</c:if>
						<c:if test="${pageNumber<totalPage }">
							<a
								href="/flowerWorld_v2/flower/findFlowers.do?pageNumber=${pageNumber+1 }"
								class="button left">下一页</a>
						</c:if>
					</div>
					
<!-- ----------------------------------------------------------------------------- -->
					<div class="blank_box">
						<a href="#"><img
							src="/flowerWorld_v2/images/free_shipping.jpg"
							alt="Free Shipping" /></a>
					</div>
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of main -->
		</div>
		<!-- END of main wrapper -->

		<div id="templatemo_footer_wrapper">
			<div id="templatemo_footer">
				<div class="footer_left">
					<a href="#"><img
						src="/flowerWorld_v2/images/1311260370_paypal-straight.png"
						alt="Paypal" /></a> <a href="#"><img
						src="/flowerWorld_v2/images/1311260374_mastercard-straight.png"
						alt="Master" /></a> <a href="#"><img
						src="/flowerWorld_v2/images/1311260374_visa-straight.png"
						alt="Visa" /></a>
				</div>
				<div class="footer_right">
					<p>
						<a href="/flowerWorld_v2/index.html">Home</a> | <a
							href="/flowerWorld_v2/products.html">Products</a> | <a
							href="/flowerWorld_v2/about.html">About</a> | <a
							href="/flowerWorld_v2/faqsAdmin.jsp">FAQs</a> | <a
							href="/flowerWorld_v2/checkout.html">Checkout</a> | <a
							href="/flowerWorld_v2/contact.html">Contact</a>
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
<script type='text/javascript' src='/flowerWorld_v2/js/logging.js'></script>
</html>