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
	
	 function getUsers(obj,rId) {
		 $.ajax({
				type : "POST",
				url : "/flowerWorld_v2/userAdmin/UserAdminById.do",
				data : {
					'rId' : rId
				},
				dataType : "json",
				// traditional: true, //提交数组
				success : function(data) {
					$(".rId_v1").css("color","");
					$(obj).css("color","red");
					$("#datalist").html();
					var table = "<tr style='background-color: #fbedce;height: 35px;font-weight:bold'><td style='width: 80px'>id</td><td style='width: 80px'>姓名</td><td style='width: 80px'>昵称</td><td>手机</td><td>邮箱</td><td>操作</td></tr>";
					$("#datalist").html(table); 
					var list = data.users;
					for(var i=0;i<list.length;i++){
						table +=
						"<tr><td>"+list[i].u_id+"</td><td>"+list[i].u_rname+"</td><td>"+list[i].u_nname+"</td><td>"+list[i].u_phone+"</td><td>"+list[i].u_mail+"</td>"+
						"<td class='td_modi'>&nbsp;"+
						"<a href='/flowerWorld_v2/userAdmin/toUpdateUserAdmin.do?uId="+list[i].u_id+"'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
						"<a href='/flowerWorld_v2/userAdmin/deleteUserAdmin.do?uId="+list[i].u_id+"'>删除</a>"+
						"</td></tr>";
					}
					$("#datalist").html(table); 
				}
				});
	}
	 $(function(){
	      $("#subBtn").trigger("click");
	   });
</script>
<style type="text/css">
.colours {
	color: #e8a92d;
	background: #e8f3f8;
	border: none;
}

.colours:hover {
	color: #73B52D;
	cursor: pointer;
}

.rId_v1 {
	text-decoration: none;
	color: #73B52D;
	font-size: 20px;
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
							<span style="font-size: 16px;">用户权限管理：</span>
							<c:forEach items="${roles }" var="roles">

								<a id="subBtn" href="javascript:;"
									onclick="getUsers(this,${roles.rId });" class="rId_v1">
									${roles.rName }</a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:forEach>
						</div>
						<div>
							<form action="/flowerWorld_v2/userAdmin/findByUphone.do"
								method="post">
								<input name="u_phone" placeholder="需要查询的账户" size="22"
									class="text_search width200" /> <input type="submit"
									value="搜索" class="btn_search" />
							</form>
						</div>
						<a href="/flowerWorld_v2/flower/regist.do"> <input
							type="button" value="添加用户" class="btn_add" />
						</a>
					</div>
					<div id="data">
						<table id="datalist" style="font-size: 10px; color: #020528">
							<tr>
								<th style='width: 80px'>ID</th>
								<th style='width: 80px'>姓名</th>
								<th style='width: 80px'>昵称</th>
								<th>电话</th>
								<th>邮箱</th>
								<th>操作</th>
							</tr>
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