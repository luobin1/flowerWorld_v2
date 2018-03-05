<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>花花世界-常见问题解答</title>
<meta name="keywords" content="free template, faqs, floral shop, ecommerce, online shopping, store" />
<meta name="description" content="Floral Shop, FAQs or Frequently Asked Questions, free theme for online shopping sites" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/orman.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<link rel="shortcut icon" href="/flowerWorld_v2/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
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
				<a>您好，欢迎来到花花世界</a>
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
					<a href="/flowerWorld_v2/flower/sign.do">登录</a>
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

<div id="templatemo_wrapper_sp">
<div id="templatemo_header_wsp">
	<div id="templatemo_header" class="header_subpage">
    	<div id="site_title"><a href="http://www.mycodes.net/" title="æºç ä¹å®¶">æºç ä¹å®¶</a></div>
        <div id="templatemo_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="/flowerWorld_v2/flower/getFlowers.do" class="selected">首页</a></li>
				<li><a target="_blank" href="/flowerWorld_v2/about.html">关于本店</a></li>
				<li><a href="/flowerWorld_v2/flower/getFlowers.do">鲜花分类</a>
				<li><a href="/flowerWorld_v2/checkout.html">结账</a></li>
				<li><a href="/flowerWorld_v2/contact.jsp">联系我们</a></li>
				<li><a href="/flowerWorld_v2/faqs.jsp">常见问题解答</a></li>
            </ul>
            <div id="templatemo_search">
                <form action="#" method="get">
                  	<input type="text" value="Site Search" name="keyword" id="keyword" title="keyword" 
                  			onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                  	<input type="submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" class="sub_btn" />
                </form>
            </div>
            <br style="clear: left" />
        </div> 
        <a href="#" title="çç¨åè´¹å¾å"  class="site_repeat" target="_blank"><img src="images/top_repeat.png" title="çç¨åè´¹å¾å" alt="çç¨åè´¹å¾å" /></a><!-- end of templatemo_menu -->

    </div> <!-- END of header -->
</div> <!-- END of header wrapper -->
<div id="templatemo_main_wrapper">
<div id="templatemo_main">
	<div id="sidebar" class="left">
    	<div class="sidebar_box"></div>
        <div class="sidebar_box"><span class="bottom"></span>
            <h3>周花主题</h3>   
            <div class="content special"> 
                <img src="images/templatemo_image_01.jpg" alt="Flowers" />
                <a href="#">爱情鲜花</a>
                <p>
                	价格:
                    <span class="price normal_price">￥160</span>&nbsp;&nbsp;
                    <span class="price special_price">￥100</span>
                </p>
            </div>
        </div>
    </div>
    
    <div id="content" class="right faqs">
		<h2>问题解答</h2>
            <h5>我怎么知道我的订单是否已经放置？</h5>
            <p>您将收到一封确认您的订单已收到的电子邮件。如果您没有收到电子邮件确认，请登录查看您的订单状态。</p>
            
          <h5>我的订单什么时候处理？</h5>
            <p>请查看订单详情。</p>
            
            <h5>都有哪些付款方式呢？</h5>
            <p>货到付款、在线支付（微信、支付宝、银联账号）等都可以进行支付</p>
            
            <h5>如果我不喜欢的话，我可以退货吗？</h5>
            <p>请阅读我们的外汇政策</p>
            
            <h5>我怎么知道网上订购是否安全？</h5>
            <p>
            保护您的信息是本网站的首要任务。我们使用安全套接字层（SSL）加密您的信用卡号、姓名和地址，因此只有这个站点能够解码您的信息。SSL是计算机安全通信的行业标准方法，没有数据拦截、操作或收件人模拟的风险。为了确保您的连接是安全的；当您在购物车时，请查看浏览器窗口的下角。如果您看到一个未中断的密钥或关闭的锁，SSL是活动的，您的信息是安全的。由于大多数客户仍然提供您的信用卡在线不舒服，我们使用贝宝及2Checkout服务，他们不需要提供信用卡信息。</p>
          <p>
          这个网站是注册的HackerGuardian。hackerguardian认证黑客免费网站和信用卡trustlogo确认你的可信度将信用卡信息在线。</p>

			
            <h5>你的隐私政策是什么？</h5>
            <p>本网站尊重您的隐私，并确保您了解什么信息，我们需要完成您的订单，以及什么信息，你可以选择与我们分享，并与我们的市场合作伙伴。在我们的隐私政策的完整信息。</p>
            <div class="cleaner h40"></div>
        <div class="blank_box">
        	<a href="#"><img src="images/free_shipping.jpg" alt="Free Shipping" /></a>
        </div>    
    </div>
    <div class="cleaner"></div>
</div> <!-- END of main -->
</div> <!-- END of main wrapper -->

<div id="templatemo_footer_wrapper">
<div id="templatemo_footer">
	<div class="footer_left">
    	<a href="#"><img src="images/1311260370_paypal-straight.png" alt="Paypal" /></a>
        <a href="#"><img src="images/1311260374_mastercard-straight.png" alt="Master" /></a>
        <a href="#"><img src="images/1311260374_visa-straight.png" alt="Visa" /></a>
    </div>
	<div class="footer_right">
		<p><a href="#">首页</a> | <a href="#">鲜花</a> | <a href="#">关于本店</a> | <a href="#">常见问题解答</a> | <a href="#">结算</a> | <a href="#">在线咨询</a></p>
        <p>Copyright (c) 2048 <a href="#">花花世界</a> | Collect from <a href="#" ></a></p>
	</div>
    <div class="cleaner"></div>
</div> <!-- END of footer -->
</div> <!-- END of footer wrapper -->
</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>