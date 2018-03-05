<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>花花世界-权限管理</title>
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
</script>
<style type="text/css">
.rId_v1 {
	text-decoration: none;
	color: #73B52D;
	font-size: 20px;
}
.nullu{
	position: absolute;
	color: #8600ff;
	font-size: 55px;
	width:570px;
	height:20px;
	left:50%;
	top:50%; 
	margin-left:-255px;
	margin-top:-10px;

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
						<li><a
							href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">个人信息</a></li>
						<li><a href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a>
							<ul>
								<li><a href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a></li>
								<li><a href="/flowerWorld_v2/flowerType/type.do">鲜花分类管理</a></li>
							</ul></li>
						<li><a href="/flowerWorld_v2/userAdmin/roleIDs.do">用户管理</a></li>
						<li><a href="/flowerWorld_v2/adminContact.jsp">在线系统</a></li>
						<li><a href="/flowerWorld_v2/faqsAdmin.jsp">帮助中心</a></li>
					</ul>
					<div id="templatemo_search">
						<form action="#" method="get">
							<input type="text" style="height: 30px;" value="搜索"
								name="keyword" id="keyword" title="keyword"
								onfocus="clearText(this)" onblur="clearText(this)"
								class="txt_field" /> <input type="submit" name="Search"
								value="" alt="Search" id="searchbutton" title="Search"
								class="sub_btn" />
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
					<div class="search_add" style="font-size: 10px; color: #020528">
						<div>
							<span style="font-size: 16px;">用户查询：</span>
						</div>
						<div>
							<form action="/flowerWorld_v2/userAdmin/findByUphone.do"
								method="post">
								<input name="u_phone" placeholder="需要查询的账户" size="22"
									class="text_search width200" /> <input type="submit"
									value="搜索" class="btn_search" />
							</form>
						</div>
						<a style="font-size: 15px" href="/flowerWorld_v2/userAdmin/findByUserAndRoleAll.do">返回上一级</a>
					</div>
					<div id="data">
						<table id="datalist" style="font-size: 12px; color: #020528">
							<tr>
								<th style='width: 80px'>ID</th>
								<th style='width: 80px'>姓名</th>
								<th style='width: 80px'>昵称</th>
								<th>电话</th>
								<th>邮箱</th>
								<th>操作</th>
							</tr>
							<c:if test="${!empty users }">
							<tr style='width: 80px;background-color: #fff'>
								<td style='width: 80px'>${users.u_id}</td>
								<td style='width: 80px'>${users.u_rname}</td>
								<td style='width: 80px'>${users.u_nname}</td>
								<td>${users.u_phone}</th>
								<td>${users.u_mail}</th>
								<td><a
									href="<%=basePath%>userAdmin/toUpdateUserAdmin.do?uId=${users.u_id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a
									href="<%=basePath%>userAdmin/deleteUserAdmin2.do?uId=${users.u_id}">删除</a>
								</td>
							</tr>
							</c:if>
							<c:if test="${empty users }">
							<div class="nullu">
							哎呀！东西不见了......
							</br>
							</div>
							</c:if>
						</table>
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
						<a href="/flowerWorld_v2/flower/loadAdminIndex.do">首页</a> | <a
							href="/flowerWorld_v2/personalCenter/toPersonalCenter.do">个人信息</a>
						| <a href="/flowerWorld_v2/flower/findFlowers.do">鲜花管理</a> | <a
							href="/flowerWorld_v2/userAdmin/roleIDs.do">用户管理</a> | <a
							href="/flowerWorld_v2/adminContact.jsp">在线系统</a> | <a
							href="/flowerWorld_v2/faqsAdmin.jsp">帮助中心</a>
					</p>
					<p>
						Copyright (c) 2017 | <a>FLOWER WORLD</a> | Collect from <a
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