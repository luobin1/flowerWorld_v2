<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分类管理</title>
<meta name="keywords"
	content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description"
	content="Floral Shop, About page, free website template for ecommerce stores or online shopping websites." />
<link href="/flowerWorld_v2/templatemo_style.css" rel="stylesheet"
	type="text/css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/flowerWorld_v2/css/orman.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="/flowerWorld_v2/css/nivo-slider.css"
	type="text/css" media="screen" />

<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css/ddsmoothmenu.css" />

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
table {
	width: 1000px;
	border-collapse: collapse;
	background-color: #006400;
}

td {
	width: 100px;
	height: 50px;
	border: 1px solid gray;
	text-align: center;
}
</style>

</head>

<body>

	<div id="templatemo_wrapper_sp">
		<div id="templatemo_header_wsp">
			<div id="templatemo_header" class="header_subpage">
				<div id="site_title">
					<a title="花花世界">花花世界</a>
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
							</ul>
						</li>
						<li><a href="/flowerWorld_v2/userAdmin/roleIDs.do">用户管理</a></li>
						<li><a href="/flowerWorld_v2/adminContact.jsp"
							target="_blank">在线系统</a></li>
						<li><a href="/flowerWorld_v2/faqs.jsp">帮助中心设置</a></li>
					</ul>
					<div id="templatemo_search">
						<form action="#" method="get">
							<input type="text" value="搜索" name="keyword" id="keyword"
								title="keyword" onfocus="clearText(this)"
								onblur="clearText(this)" class="txt_field" /> <input
								type="submit" name="Search" value="" alt="Search"
								id="searchbutton" title="Search" class="sub_btn" />
						</form>
					</div>
					<br style="clear: left" />
				</div>
				<a href="#" title="请单击此处" class="site_repeat" target="_blank"><img
					src="/flowerWorld_v2/images/top_repeat.png" title="请单击此处"
					alt="请单击此处" /></a>
				<!-- end of templatemo_menu -->

			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		<div id="templatemo_main_wrapper">
			<div id="templatemo_main">
				<div id="sidebar" class="left">
					<h1>分类导航管理</h1>
					<div style="width: 400px;">
						<a
							style="background-color: #7ac330; font-weight: bold; font-size: 20px; color: white;"
							href="toAddType.do">+添加分类</a>
						<table>
							<tr
								style="font-weight: bold; color: black; background-color: #7fffd4; font-size: 25px">
								<td>分类</td>
								<td>操作</td>
							</tr>
							<c:if test="${!empty iFlowerTypeService }">
								<c:forEach items="${iFlowerTypeService }"
									var="iFlowerTypeService">
									<input type="hidden" id="ftypeId${iFlowerTypeService.ftypeId}"
										name="ftypeId" value="${iFlowerTypeService.ftypeId} " />
									<input type="hidden" value="${iFlowerTypeService.fatherId} " />
									<tr>
										<td style="font-size: 20px">
											${iFlowerTypeService.ftypeName }</td>
										<td><a
											href="toModifyType.do?ftypeId=${iFlowerTypeService.ftypeId }">编辑</a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
											href="deleteType.do?ftypeId=${iFlowerTypeService.ftypeId }">删除</a>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
					</div>

				</div>
				<div id="content" class="right">

					<div class="cleaner h20"></div>

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
					<a href="#"><img
						src="/flowerWorld_v2/images/1311260370_paypal-straight.png"
						alt="Paypal" /></a> <a href="#"><img
						src="/flowerWorld_v2/images/1311260374_mastercard-straight.png"
						alt="Master" /></a> <a href="#"><img
						src="/flowerWorld_v2/images/1311260374_visa-straight.png"
						alt="Visa" /></a>
				</div>
				<div class="footer_right">
		<p><a href="#">首页</a> | <a href="#">鲜花</a> | <a href="#">关于本店</a> | <a href="#">常见问题解答</a> | <a href="#">结算</a> | <a href="#">在线咨询</a></p>
        <p>Copyright (c) 2048 <a href="#">花花世界</a> | Collect from <a href="#" ></a></p>
	</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of footer -->
		</div>
		<!-- END of footer wrapper -->
	</div>

</body>

</html>