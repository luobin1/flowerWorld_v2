<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员中心</title>
<meta name="keywords"
	content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description"
	content="Floral Shop is free website template for ecommerce or online shopping websites. Products, Shopping Cart, FAQs and Checkout pages are included." />
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

<script type="text/javascript" src="/flowerWorld_v2/js/jquery.min.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js/ddsmoothmenu.js">
	/***********************************************
	 * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	 * This notice MUST stay intact for legal use
	 * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	 ***********************************************/
</script>



<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/style.css" />
<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/shopping-mall-index.css" />
<script type="text/javascript" src="/flowerWorld_v2/js2/jQuery.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhonglin.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhongling2.js"></script>

<script type="text/javascript"
	src="/flowerWorld_v2/js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js/flowerPages.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js/ddsmoothmenu.js">
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


	<div id="templatemo_wrapper_h">
		<div id="templatemo_header_wh">
			<div id="templatemo_header" class="header_home">
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
							<input type="text" value="搜索" name="keyword" id="keyword"
								title="keyword" onfocus="clearText(this)"
								onblur="clearText(this)" class="txt_field" /> <input
								type="submit" name="Search" value="" alt="Search"
								id="searchbutton" title="Search" class="sub_btn" />
						</form>
					</div>
					<br style="clear: left" />
				</div>
				<a href="#" title="visit " class="site_repeat" target="_blank"><img
					src="/flowerWorld_v2/images/top_repeat.png" alt="visit " /></a>
				<!-- end of templatemo_menu -->

				<div class="slider-wrapper theme-orman">
					<div class="ribbon"></div>
					<div id="slider" class="nivoSlider">
						<img src="/flowerWorld_v2/images/portfolio/01.jpg"
							alt="slider image 1" /> <a href="http://www.mycodes.net/"> <img
							src="/flowerWorld_v2/images/portfolio/02.jpg"
							alt="slider image 2" title="This is an example of a caption" />
						</a> <img src="/flowerWorld_v2/images/portfolio/03.jpg"
							alt="slider image 3" /> <img
							src="/flowerWorld_v2/images/portfolio/04.jpg"
							alt="slider image 4" title="#htmlcaption" /> <img
							src="/flowerWorld_v2/images/portfolio/05.jpg"
							alt="slider image 5" title="#htmlcaption" />
					</div>
					<div id="htmlcaption" class="nivo-html-caption">
						<strong>Example</strong> caption with <a href="#">a credit
							link</a> for <em>this slider</em>.
					</div>
				</div>
				<script type="text/javascript"
					src="/flowerWorld_v2/js/jquery.nivo.slider.pack.js"></script>
				<script type="text/javascript">
					$(window).load(function() {
						$('#slider').nivoSlider({
							controlNav : false
						});
					});
				</script>
			</div>
			<!-- END of header -->
		</div>
		<!-- END of header wrapper -->
		<div id="templatemo_main_wrapper">
			<div id="templatemo_main">
				<div id="sidebar" class="left">
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>
							<a href="/flowerWorld_v2/flowerType/type.do">鲜花分类管理</a>
						</h3>
						<div class="content">
							<ul class="sidebar_list">
								<li><a href="javascript:;" id="allType" class="sidebar_li"
									onclick="changeTypeNumber(this,0)">全部鲜花</a></li>
								<li><a href="javascript:;" class="sidebar_li"
									onclick="changeTypeNumber(this,1)">爱情鲜花</a></li>
								<li><a href="javascript:;" class="sidebar_li"
									onclick="changeTypeNumber(this,2)">生日鲜花</a></li>
								<li><a href="javascript:;" class="sidebar_li"
									onclick="changeTypeNumber(this,3)">绿植</a></li>
								<li><a href="javascript:;" class="sidebar_li"
									onclick="changeTypeNumber(this,4)">永生花</a></li>
								<li><a href="javascript:;" class="sidebar_li"
									onclick="changeTypeNumber(this,5)">开业花篮</a></li>
								<li><a href="javascript:;" class="sidebar_li"
									onclick="changeTypeNumber(this,6)">精品礼盒花</a></li>
								<li><a>周花主题</a></li>
								<li><a>帮助中心</a></li>
							</ul>
						</div>
					</div>
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>周花设置</h3>
						<div class="content special">
							<img src="/flowerWorld_v2/images/templatemo_image_01.jpg"
								alt="Flowers" /> <a href="#">菊花</a>
							<p>
								价格: <span class="price normal_price">￥160</span>&nbsp;&nbsp; <span
									class="price special_price">￥100</span>
							</p>
						</div>
					</div>
				</div>
				<div class="copyrights">
					Collect from <a href="http://www.mycodes.net/">Website Template</a>
				</div>
				<div id="content2" style="width: 700px;" class="right">
					<h2 id="flowerTitle" style="font-size: 28px"></h2>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						flowersWorld是成都市第一鲜花网，是成都本土专业的鲜花礼品网络订购服务平台。
						我网站目前专注做成都10区10县城区及周边鲜花配送，坚持以“专业、专注、高效、方便、快捷”为工作目标，
						为全成都1435万常住人口、400万流动人口、50万高校学生提供优质服务，为他们的爱人、亲人、尊敬的人、关心的人时刻准备着，
						送出那一束饱含爱意的鲜花。 信我们 得永生！！</p>

					<div id="flowerList"></div>
					<div id="pageIndex"
						style="width: 100%; height: 50px; float: right;"></div>


					<div class="blank_box">
						<a href="#"><img
							src="/flowerWorld_v2/images/free_shipping.jpg"
							alt="Free Shipping" /></a>
					</div>
				</div>






				<!-- ************************************************************************ -->
				<div id="content" class="right">
					<h2 style="font-size: 28px">全部鲜花</h2>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						flowersWorld是成都市第一鲜花网，是成都本土专业的鲜花礼品网络订购服务平台。
						我网站目前专注做成都10区10县城区及周边鲜花配送，坚持以“专业、专注、高效、方便、快捷”为工作目标，
						为全成都1435万常住人口、400万流动人口、50万高校学生提供优质服务，为他们的爱人、亲人、尊敬的人、关心的人时刻准备着，
						送出那一束饱含爱意的鲜花。 信我们 得永生！！</p>

					<c:forEach items="${flowers }" var="flower">
						<div class="product_box">
							<a
								href="/flowerWorld_v2/flower/toChangeFlowerPage.do?flowerId=${flower.flowerId }"><img
								src="${flower.flowerUrl1}" alt="floral set 1"
								style="width: 165px; height: 165px;" /></a>
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
									href="/flowerWorld_v2/flower/loadAdminIndex.do?pageNumber=${pageNumber-1 }"
									class="button left">上一页</a>
							</div>
						</c:if>

						<div style="float: left; width: 100px;" align="center">
							<c:forEach begin="1" end="${totalPage }" var="n">
								<c:if test="${pageNumber==n }">
									<a class="limit-a1" href="#"
										style="color: red; font-size: 15px;">${n }</a>
								</c:if>
								<c:if test="${pageNumber!=n }">
									<a class="limit-a2"
										href="/flowerWorld_v2/flower/loadAdminIndex.do?pageNumber=${n }"
										style="color: white; font-size: 15px;">${n }</a>
								</c:if>
							</c:forEach>
						</div>
						<c:if test="${pageNumber==totalPage }">
							<a href="#" class="button left">下一页</a>
						</c:if>
						<c:if test="${pageNumber<totalPage }">
							<a
								href="/flowerWorld_v2/flower/loadAdminIndex.do?pageNumber=${pageNumber+1 }"
								class="button left">下一页</a>
						</c:if>
					</div>

					<div class="blank_box">
						<a href="#"><img
							src="/flowerWorld_v2/images/free_shipping.jpg"
							alt="Free Shipping" /></a>
					</div>
				</div>

				<!-- ************************************************************************ -->
				<div class="cleaner"></div>
			</div>
			<!-- END of main -->
		</div>
		<!-- END of main wrapper -->

	</div>

	<!--底部一块-->
	<div class="footer-box">
		<ul class="footer-info1 w1200">
			<li>
				<div class="ft-tu1">
					<a href="JavaScript:;"><img
						src="/flowerWorld_v2/images2/zl2-86.gif" /></a>
				</div>
				<h3>
					<a href="JavaScript:;">号码保障</a>
				</h3>
				<P>所有会员，手机短信验证</P>
			</li>
			<li>
				<div class="ft-tu1">
					<a href="JavaScript:;"><img
						src="/flowerWorld_v2/images2/zl2-87.gif" /></a>
				</div>
				<h3>
					<a href="JavaScript:;">5*8小时客服</a>
				</h3>
				<P>有任何问题随时免费资讯</P>
			</li>
			<li>
				<div class="ft-tu1">
					<a href="JavaScript:;"><img
						src="/flowerWorld_v2/images2/zl2-88.gif" /></a>
				</div>
				<h3>
					<a href="JavaScript:;">专业专攻</a>
				</h3>
				<P>我们只专注于建筑行业的信息服务</P>
			</li>
			<li>
				<div class="ft-tu1">
					<a href="JavaScript:;"><img
						src="/flowerWorld_v2/images2/zl2-89.gif" /></a>
				</div>
				<h3>
					<a href="regist.html">注册有礼</a>
				</h3>
				<P>随时随地注册有大礼包</P>
			</li>
			<li>
				<div class="ft-tu1">
					<a href="JavaScript:;"><img
						src="/flowerWorld_v2/images2/zl2-90.gif" /></a>
				</div>
				<h3>
					<a href="JavaScript:;">值得信赖</a>
				</h3>
				<P>专业的产品，专业的团队</P>
			</li>
			<div style="clear: both;"></div>
		</ul>
		<div class="footer-info2 w1200">
			<div class="ft-if2-left f-l">
				<dl>
					<dt>
						<a href="6-1服务协议.html">新手上路</a>
					</dt>
					<dd>
						<a href="6-1服务协议.html">购物流程</a> <a href="6-1服务协议.html">在线支付</a> <a
							href="6-1服务协议.html">投诉与建议</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="6-1服务协议.html">配送方式</a>
					</dt>
					<dd>
						<a href="6-1服务协议.html">货到付款区域</a> <a href="6-1服务协议.html">配送费标准</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="6-1服务协议.html">购物指南</a>
					</dt>
					<dd>
						<a href="6-1服务协议.html">订购流程</a> <a href="6-1服务协议.html">购物常见问题</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="6-1服务协议.html">售后服务</a>
					</dt>
					<dd>
						<a href="6-1服务协议.html">售后服务保障</a> <a href="6-1服务协议.html">退换货政策总则</a>
						<a href="6-1服务协议.html">自营商品退换细则</a>
					</dd>
				</dl>
				<div style="clear: both;"></div>
			</div>
			<div class="ft-if2-right f-r">
				<h3>400-0000-000</h3>
				<p>周一至周日 9:00-24:00</p>
				<p>（仅收市话费）</p>
			</div>
			<div style="clear: both;"></div>
		</div>
		<div class="footer-info3 w1200">
			<p>
				<a href="#">免责条款</a><span>|</span> <a href="#">隐私保护</a><span>|</span>
				<a href="#">咨询热点</a><span>|</span> <a href="#">联系我们</a><span>|</span>
				<a href="#">公司简介</a>
			</p>
			<p>
				<a href="#">川ICP备13044278号</a><span>|</span> <a href="#">合字B1.B2-20130004</a><span>|</span>
				<a href="#">营业执照</a><span>|</span> <a href="#">互联网药品信息服务资格证</a><span>|</span>
				<a href="#">互联网药品交易服务资格证</a>
			</p>
			<div class="ft-if3-tu1">
				<a href="#"><img src="" /></a> <a href="#"><img src="" /></a> <a
					href="#"><img src="" /></a>
			</div>
		</div>
	</div>



</body>
<script type='text/javascript' src='/flowerWorld_v2/js/logging.js'></script>
</html>