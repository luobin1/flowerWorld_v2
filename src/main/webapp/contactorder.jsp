<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript" src="/flowerWorld_v2/js/luobin.js"></script>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">  
    <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>  
    <title>确认订单</title>  
      <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Floral Shop, Shopping Cart, Online Store</title>
<meta name="keywords" content="free template, shopping cart, floral, ecommerce, online, store" />
<meta name="description" content="Floral, Shopping Cart, free template for ecommerce websites." />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/orman.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
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


	<div id="templatemo_wrapper_h">
		<div id="templatemo_header_wh">
			<div id="templatemo_header" class="header_home">
				<div id="site_title">
					<a title="花花世界">花花世界</a>
				</div>
				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="/flowerWorld_v2/flower/getFlowers.do" class="selected">首页</a></li>
						<li><a target="_blank" href="/flowerWorld_v2/about.html">关于本店</a></li>
						<li><a href="javascript:;" onclick="changeTypeNumber(this,0)">鲜花分类</a>
							<ul>
								<li><a href="javascript:;" onclick="changeTypeNumber(this,0)">全部鲜花</a></li>
								<c:forEach items="${flowerTypes }" var="flowerType">
								<li><a href="javascript:;" class="sidebar_li" onclick="changeTypeNumber(this,${flowerType.ftypeId})">${flowerType.ftypeName }</a></li>
								</c:forEach>
								<li><a href="#">周花主题</a></li>
								<li><a href="#">帮助中心</a></li>
							</ul>
						</li>
						<li><a href="/flowerWorld_v2/checkout.html">结账</a></li>
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
						<img src="/flowerWorld_v2/images/portfolio/01.jpg" alt="slider image 1" /> <a
							href="http://www.mycodes.net/"> <img
							src="images/portfolio/02.jpg" alt="slider image 2"
							title="This is an example of a caption" />
						</a> <img src="/flowerWorld_v2/images/portfolio/03.jpg" alt="slider image 3" /> <img
							src="/flowerWorld_v2/images/portfolio/04.jpg" alt="slider image 4"
							title="#htmlcaption" /> <img src="/flowerWorld_v2/images/portfolio/05.jpg"
							alt="slider image 5" title="#htmlcaption" />
					</div>
					<div id="htmlcaption" class="nivo-html-caption">
						<strong>Example</strong> caption with <a href="#">a credit
							link</a> for <em>this slider</em>.
					</div>
				</div>
				<script type="text/javascript" src="/flowerWorld_v2/js/jquery-1.6.1.min.js"></script>
				<script type="text/javascript" src="/flowerWorld_v2/js/jquery.nivo.slider.pack.js"></script>
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
						<h3>导航栏</h3>
						<div class="content">
							<ul class="sidebar_list">
								<li><a href="javascript:;" id="allType" class="sidebar_li" onclick="changeTypeNumber(this,0)">全部鲜花</a></li>
								<c:forEach items="${flowerTypes }" var="flowerType">
								<li><a href="javascript:;" class="sidebar_li" onclick="changeTypeNumber(this,${flowerType.ftypeId})">${flowerType.ftypeName }</a></li>
								</c:forEach>
								<li><a>周花主题</a></li>
								<li><a>帮助中心</a></li>
							</ul>
						</div>
					</div>
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>每周推荐</h3>
						<div class="content special">
							<img src="/flowerWorld_v2/images/templatemo_image_01.jpg" style="width: 220px;height: 220px;" alt="Flowers" /> <a
								href="#">菊花</a>
							<p>
								价格: <span class="price normal_price">￥160</span>&nbsp;&nbsp; <span
									class="price special_price">￥100</span>
							</p>
						</div>
					</div>
				</div>
<div id="templatemo_main_wrapper">
			<div id="templatemo_main">
				<div id="sidebar" class="left">
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>导航栏</h3>
						<div class="content">
							<ul class="sidebar_list">
								<li><a href="javascript:;" id="allType" class="sidebar_li" onclick="changeTypeNumber(this,0)">全部鲜花</a></li>
								<c:forEach items="${flowerTypes }" var="flowerType">
								<li><a href="javascript:;" class="sidebar_li" onclick="changeTypeNumber(this,${flowerType.ftypeId})">${flowerType.ftypeName }</a></li>
								</c:forEach>
								<li><a>周花主题</a></li>
								<li><a>帮助中心</a></li>
							</ul>
						</div>
					</div>
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>每周推荐</h3>
						<div class="content special">
							<img src="/flowerWorld_v2/images/templatemo_image_01.jpg" alt="Flowers" /> <a
								href="#">菊花</a>
							<p>
								价格: <span class="price normal_price">￥160</span>&nbsp;&nbsp; <span
									class="price special_price">￥100</span>
							</p>
						</div>
					</div>
				</div>
    
    <div id="content" class="right">
    	
   		 <form action="/flowerWorld_v2/to/updateOrder.do">
	    	<h1>确认订单</h1>
			<input type="hidden" name="orderId" value="${Order.orderId}"><br />
	   		收货地址：<input name="addre" value="${Order.deliAddress }"><br /><br />
	   		收货人：<input name="rname" value="${Order.name }"><br /><br />
	   		收货人电话：<input name="phone" value="${Order.phone }">
	    	<div>订单号：${shop.flowerId }</div>
	    	<div>付款方式：${Order.payMethod }</div>
	    	商品图片：<img src="${fl.flowerUrl1 }"/>
	    	<div>商品名称：${f1.flowerName }</div>
	    	<div>商品详情：${f1.material }</div>
	    	<div>商品单价：${fl.price }</div>
	    	<div>商品数量：${shop.number }</div>
	    	<div>商品总价：${shop.total }</div> 
	    	<input type="submit" name="id" value=提交>
	    </form>
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
		<p><a href="index.html">Home</a> | <a href="products.html">Products</a> | <a href="about.html">About</a> | <a href="faqs.html">FAQs</a> | <a href="checkout.html">Checkout</a> | <a href="contact.html">Contact</a></p>
        <p>Copyright (c) 2084 <a href="#">Company Name</a> | Collect from <a href="http://www.mycodes.net/" title="Ã¦ÂºÂÃ§Â ÂÃ¤Â¹ÂÃ¥Â®Â¶">Ã¦ÂºÂÃ§Â ÂÃ¤Â¹ÂÃ¥Â®Â¶</a></p>
	</div>
    <div class="cleaner"></div>
</div> <!-- END of footer -->
</div> <!-- END of footer wrapper -->
</div>

</body>
<script type='text/javascript' src='js/logging.js'></script>
</html>