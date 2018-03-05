<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Floral Shop, Products, Online Shopping</title>
<meta name="keywords"
	content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description"
	content="Floral Shop, Product Details, free template for ecommerce websites." />
<link href="/flowerWorld_v2/templatemo_style.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet" href="/flowerWorld_v2/css/orman.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/flowerWorld_v2/css/nivo-slider.css"
	type="text/css" media="screen" />


<link type="text/css" rel="stylesheet" media="all"
	href="/flowerWorld_v2/userAdmin/styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="/flowerWorld_v2/userAdmin/styles/global_color.css" />


<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css/ddsmoothmenu.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
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
<style type="text/css">
.edge{
	border: 1px solid #8ac1db;
}
.styles{
	background:url("/flowerWorld_v2/userAdmin/img/form_btn.png") no-repeat;
	border:0px;
	width:100px;
	height:36px;
	color:#fff;
	font-weight:bold;
	font-size:15pt;
}
.styles:hover{
	background:url("/flowerWorld_v2/userAdmin/img/form_btn_on.png") no-repeat;
}
</style>
<script type="text/javascript"
	src="/flowerWorld_v2/js/jquery-1-4-2.min.js"></script>
<link rel="stylesheet" href="/flowerWorld_v2/css/slimbox2.css"
	type="text/css" media="screen" />
<script type="text/JavaScript" src="/flowerWorld_v2/js/slimbox2.js"></script>

</head>

<body>

<!-- 台头 -->
	<div class="zl-header">
		<div class="zl-hd w1200">
			<p class="hd-p1 f-l">
				<a>您好，欢迎来到我的花花世界</a>
			</p>
			<p class="hd-p2 f-r">
				<c:if test="${user!=null }">
					<c:if test="${user.u_nname!=null}">
						<a href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">${user.u_nname}</a>
					</c:if>
					<c:if test="${user.u_nname==null}">
						<a href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">${user.u_phone}</a>
					</c:if>
				</c:if>
				<span>|</span>
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
					<a href="#" title="花花世界">花花世界</a>
				</div>
				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="/flowerWorld_v2/flower/loadAdminIndex.do">首页</a></li>
						<li><a href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">个人信息</a></li>
						<li><a href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a>
							<ul>
								<li><a href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a></li>
								<li><a href="/flowerWorld_v2/flowerType/type.do">鲜花分类管理</a></li>
							</ul>
						</li>
						<li><a href="/flowerWorld_v2/userAdmin/roleIDs.do">用户管理</a></li>
						<li><a href="/flowerWorld_v2/adminContact.jsp">在线系统</a></li>
						<li><a href="/flowerWorld_v2/faqsAdmin.jsp">帮助中心</a></li>
					</ul>
					<div id="templatemo_search">
						<form action="#" method="get">
							<input type="text" style="height: 30px;" value="搜索" name="keyword"
								id="keyword" title="keyword" onfocus="clearText(this)"
								onblur="clearText(this)" class="txt_field" /> <input
								type="submit" name="Search" value="" alt="Search"
								id="searchbutton" title="Search" class="sub_btn" />
						</form>
					</div>
					<br style="clear: left" />
				</div>
				<a href="#" class="site_repeat"><img
					src="/flowerWorld_v2/images/top_repeat.png" title="#/" /></a>
				<!-- end of templatemo_menu -->

			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		<div id="templatemo_main_wrapper">
			<div id="templatemo_main">
				<div id="sidebar" class="left"></div>

				<!-- 中间div方块 -->
				<div id="main">
					<form action="/flowerWorld_v2/userAdmin/updateUserAdmin2.do" method="post">
						<div class="search_add" style="font-size: 15px; text-align:center; color: #020528">
						    ID:&nbsp;&nbsp;&nbsp;
							<input style="background-color: #E8F3F8;color: #7ab900" readonly="readonly" name="u_id" value="${user.u_id }" /></br></br>
							姓名:&nbsp;&nbsp;&nbsp;
							<input style="background-color: #E8F3F8;color: #7ab900" readonly="readonly" name="rName" value="${user.u_rname }" /></br></br>
							昵称:&nbsp;&nbsp;&nbsp;
							<input style="background-color: #E8F3F8;color: #7ab900" readonly="readonly" name="uName" value="${user.u_nname }" /></br></br>
							手机:&nbsp;&nbsp;&nbsp;
							<input style="background-color: #E8F3F8;color: #7ab900" readonly="readonly" name="uPhone" value="${user.u_phone }" /></br></br>
							邮箱:&nbsp;&nbsp;&nbsp;
							<input style="background-color: #E8F3F8;color: #7ab900" readonly="readonly" name="uMail" value="${user.u_mail }" /></br></br>
							密码:&nbsp;&nbsp;&nbsp;
							<input type="password" style="background-color: #E8F3F8;color: #7ab900" readonly="readonly" name="uPwd" value="${user.u_pwd }" /></br></br>
							修改权限等级：&nbsp;&nbsp;&nbsp;
							<select id="rId" name="r_id" class="edge">
								<option value="3" <c:if test="${user.r_id==3}">selected</c:if>>VIP</option>
								<option value="4" <c:if test="${user.r_id==4}">selected</c:if>>ORDINARY</option>
								
							</select>
							</br></br>
							
							<input type="submit" value="保存" class="styles"/>
								
						</div>
					</form>
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
						<a href="/flowerWorld_v2/flower/loadAdminIndex.do">首页</a> | <a
							href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">个人信息</a> | <a
							href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a> | <a
							href="/flowerWorld_v2/userAdmin/roleIDs.do">用户管理</a> | <a
							href="/flowerWorld_v2/adminContact.jsp">在线系统</a> | <a
							href="/flowerWorld_v2/faqsAdmin.jsp">帮助中心</a>
					</p>
					<p>
						Copyright (c) 2017  | <a>FLOWER WORLD</a> | Collect from <a
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