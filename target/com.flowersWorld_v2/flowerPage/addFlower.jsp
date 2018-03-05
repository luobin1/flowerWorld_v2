<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加鲜花信息</title>
<meta name="keywords"
	content="free template, shopping cart, floral, ecommerce, online, store" />
<meta name="description"
	content="Floral, Shopping Cart, free template for ecommerce websites." />
<link href="/flowerWorld_v2/templatemo_style.css" rel="stylesheet"
	type="text/css" />
<link rel="shortcut icon" href="/flowerWorld_v2/favicon.ico" type="image/x-icon" />
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
	<script type="text/javascript" src="/flowerWorld_v2/js/jquery.min.js">
</script>
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
<script type="text/javascript" src="/flowerWorld_v2/js/flowerPages.js"></script>

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
				<a href="#" title="免费的图像" class="site_repeat"><img
					src="/flowerWorld_v2/images/top_repeat.png" title="免费的图像" /></a>
				<!-- end of templatemo_menu -->

			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		<div id="templatemo_main_wrapper">
			<div id="templatemo_main">
				<div id="sidebar" class="left">
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>Categories</h3>
						<div class="content">
							<ul class="sidebar_list">
								<li><a href="#">全部鲜花</a></li>
								<li><a href="#">爱情鲜花</a></li>
								<li><a href="#">生日鲜花</a></li>
								<li><a href="#">绿植</a></li>
								<li><a href="#">永生花</a></li>
								<li><a href="#">开业花篮</a></li>
								<li><a href="#">精品礼盒花</a></li>
								<li><a href="#">周花主题</a></li>
								<li><a href="#">帮助中心</a></li>
							</ul>
						</div>
					</div>
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>${flower.flowerName }</h3>
						<div class="content special">
							<img src="/flowerWorld_v2/images/templatemo_image_01.jpg"
								alt="Flowers" /> <a href="#">Citrus Burst Bouquet</a>
							<p>
								价格: <span class="price normal_price">￥160</span>&nbsp;&nbsp;
								<span class="price special_price">￥100</span>
							</p>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					function gen_base64(img) {
						var file = img.files[0];
						r = new FileReader(); //本地预览
						r.onload = function() {
							document.getElementById("image").src = r.result;
							var str = r.result;

						}
						r.readAsDataURL(file); //Base64
					}

					function uploadimg() {

						$.ajax({
							type : "POST",
							url : "/flowerWorld_v2/img/addImg.do",
							data : {
								'img' : $(".image").attr("src")
							},
							dataType : "json",
							//  traditional: true, //提交数组
							success : function(data) {
								$("#flowerUrl1").val(data.names + ".jpg");
							},
							error : function(XMLHttpRequest, textStatus,
									errorThrown) {
								alert(XMLHttpRequest + "   " + textStatus
										+ "   " + errorThrown);
							}
						});
					}
				</script>

				<div id="content" class="right">
					<div class="content_half left form_field">
						<form action="/flowerWorld_v2/flower/addFlower.do" method="post">
							<img id="image" class="image"
								style="width: 200px; height: 200px;"> <input type="file"
								onchange="gen_base64(this);"><br /> <a
								href="javascript:;" onclick="uploadimg()">确认添加图片</a><br> <input
								type="hidden" id="flowerUrl1" name="flowerUrl1" /> <span
								id="suc-msg"></span> 名称:<input id="flowerName" name="flowerName"
								maxlength="40"><br>
							<br> 类型: <select id="flowerTypeId" name="flowerTypeId">
								<c:forEach items="${flowerTypes}" var="flowerType">
        							<option value="${flowerType.ftypeId }" >${flowerType.ftypeName }</option>
        						</c:forEach></select>
							<input type="hidden" name="purposeId" value="1" /><br>
							<br> 材质:<input id="material" name="material" maxlength="40"><br>
							包装:<input id="packing" name="packing" maxlength="40"><br>
							花语:<input id="flowerLanguage" name="flowerLanguage"
								maxlength="40"><br> 附送:<input id="gifts"
								name="gifts" maxlength="40"><br> 配送:<input
								id="distribution" name="distribution" maxlength="40"><br>
							价格:<input id="price" onblur="checkDouble2(this.value);"  value="${flower.price }" name="price" maxlength="40">&nbsp;元<span style="color: red;" id="doubleErr"></span><br>
							<input type="submit" value="添 加">&nbsp; <input
								type="reset" value="重 置">
						</form>
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
							href="#" title="花花世界">花花世界</a>
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