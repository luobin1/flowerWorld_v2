<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>花花世界</title>
<meta name="keywords"
	content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description"
	content="Floral Shop is free website template for ecommerce or online shopping websites. Products, Shopping Cart, FAQs and Checkout pages are included." />
<link href="/flowerWorld_v2/templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/flowerWorld_v2/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/flowerWorld_v2/css/orman.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/flowerWorld_v2/css/nivo-slider.css" type="text/css"
	media="screen" />

<link rel="stylesheet" type="text/css" href="/flowerWorld_v2/css/ddsmoothmenu.css" />

<script type="text/javascript" src="/flowerWorld_v2/js/jquery.min.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js/ddsmoothmenu.js">
	/***********************************************
	 * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	 * This notice MUST stay intact for legal use
	 * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	 ***********************************************/
</script>
<script>
	$.ajax({
		type : "POST",
		url : "/flowerWorld_v2/getUsername.do",
		dataType : "json",
		success : function(data) {
			$("#userName").text(data.info);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + "   " + textStatus + "   " + errorThrown);
		}
	});
</script>
<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/style.css" />
<link rel="stylesheet" type="text/css"
	href="/flowerWorld_v2/css2/shopping-mall-index.css" />
<script type="text/javascript" src="/flowerWorld_v2/js2/jQuery.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhonglin.js"></script>
<script type="text/javascript" src="/flowerWorld_v2/js2/zhongling2.js"></script>
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
				<a>您好，欢迎来到花花世界</a><span>|</span> <a
					href="/flowerWorld_v2/role/findAllRole.do"></a>
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
				<c:if test="${user==null }">
					<a href="/flowerWorld_v2/login.html">登录</a>
				</c:if>
				<span>|</span> <a href="/flowerWorld_v2/to/findAllShopCar.do">我的购物车</a><span>|</span> <a
					href="/flowerWorld_v2/to/findAllOrder.do">我的订单</a><span>|</span>
				<c:if test="${user!=null }">
					<a href="/flowerWorld_v2/logOut.do">退出</a>
				</c:if>
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
						<li><a href="/flowerWorld_v2/flower/getFlowers.do">首页</a></li>
						<li><a href="/flowerWorld_v2/about.html">关于本店</a></li>
						<li><a href="/flowerWorld_v2/flower/getFlowers.do">鲜花分类</a></li>
						<li><a href="/flowerWorld_v2/to/findAllOrder.do">结账</a></li>
						<li><a href="/flowerWorld_v2/contact.jsp">联系我们</a></li>
						<li><a href="/flowerWorld_v2/faqs.jsp">常见问题解答</a></li>
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
							src="images/portfolio/02.jpg" alt="slider image 2"
							title="This is an example of a caption" />
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
					src="/flowerWorld_v2/js/jquery-1.6.1.min.js"></script>
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
						<div class="personal-l-tit">
							<h3 style="margin-left: 0px;">
								<a href="toPersonalCenter.do">个人中心</a>
							</h3>
						</div>
						<ul class="sidebar_list">
								<li class="per-li1"><a href="myProductPage.do">消息中心<span>></span></a></li>
								<li class="per-li2"><a href="toPersonal.do">个人资料<span>></span></a></li>
								<li class="per-li3"><a href="/flowerWorld_v2/to/findAllOrder.do">我的订单<span>></span></a></li>
								<li class="per-li5"><a href="/flowerWorld_v2/to/findAllShopCar.do">购物车<span>></span></a></li>
								<li class="current-li per-li6"><a href="toAddress.do">管理收货地址<span>></span></a></li>
								<li class="per-li7"><a href="toPayAccount.do">预支付账户<span>></span></a></li>
								<li class="per-li8"><a href="/flowerWorld_v2//to/findStatOrder.do">购买记录<span>></span></a></li>
								<li class="per-li9"><a href="findCommenByLimit.do?u_id=${user.u_id }">我的评论<span>></span></a></li>
								<li class="per-li10"><a href="toScore.do">会员积分<span>></span></a></li>
							</ul>
					</div>
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>每周推荐</h3>
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
				<div id="content" class="right">
					<div class="product_box">
						<div class="personal-right" style="width: 800px;border: 0px;">
							<div  style="height: 30px;;margin-bottom 5px;">
								<h3 style="font-size: 20pt;">个人中心列表 < ${user.u_nname }</h3>
							</div>
							<div class="pcm-con">
								<div style="height: 30px;">
									<h3 style="font-size: 20pt;">个人资料</h3>
								</div>
								<div class="data-con">
									<input type="hidden" name="u_id" value="${user.u_id }" />
									<p class="dt-p f-l">昵称：</p>
									<div class="dt1">
										<div class="pcm-info"
											style="width: 300px; height: 30px; font-size: 25pt; padding: 15px;">
											${user.u_nname }</div>
										<div style="clear: both;"></div>
									</div>
									<p class="dt-p f-l">用户名：</p>
									<div class="dt1">
										<div class="pcm-info"
											style="width: 300px; height: 30px; font-size: 25pt; padding: 15px;">
											${user.u_nname}</div>
										<div style="clear: both;"></div>
									</div>
									<p class="dt-p f-l">手机号：</p>
									<div class="dt1 dt3">
										<div class="pcm-info"
											style="width: 300px; height: 30px; font-size: 25pt; padding: 15px;">
											${user.u_phone }</div>
										<div style="clear: both;"></div>
									</div>
									<p class="dt-p f-l">地址：</p>
									<div class="dt1">
										<div class="pcm-info"
											style="width: 300px; height: 30px; font-size: 25pt; padding: 15px;">
											${user.u_address }</div>
										<div style="clear: both;"></div>
									</div>
									<p class="dt-p f-l">邮箱：</p>
									<div class="dt1">
										<div class="pcm-info"
											style="width: 300px; height: 30px; font-size: 25pt; padding: 15px;">
											${user.u_mail }</div>
										<div style="clear: both;"></div>
									</div>
								</div>
							</div>
						</div>
					</div>

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

	</div>

	<!--底部一块-->
	<div class="footer-box">
		<ul class="footer-info1 w1200">
			<li>
				<div class="ft-tu1">
					<a href="JavaScript:;"><img src="images2/zl2-86.gif" /></a>
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
				<P>我们只专注于鲜花行业的信息服务</P>
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
				<a href="#"><img src="/flowerWorld_v2/images/zl2-91.gif" /></a> <a
					href="#"><img src="/flowerWorld_v2/images/zl2-92.gif" /></a> <a
					href="#"><img src="/flowerWorld_v2/images/zl2-93.gif" /></a>
			</div>
		</div>
	</div>



</body>
<script type='text/javascript' src='/flowerWorld_v2/js/logging.js'></script>
</html>