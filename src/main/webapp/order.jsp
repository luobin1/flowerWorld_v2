<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript" src="/flowerWorld_v2/js/luobin.js"></script>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">  
    <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>  
    <title>订单页面</title>  
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

<div id="templatemo_wrapper_sp">
		<div id="templatemo_header_wsp">
			<div id="templatemo_header" class="header_subpage">
				<div id="site_title">
					<a href="http://www.mycodes.net/" title="Ã¦ÂºÂÃ§Â ÂÃ¤Â¹ÂÃ¥Â®Â¶">Ã¦ÂºÂÃ§Â ÂÃ¤Â¹ÂÃ¥Â®Â¶</a>
				</div>
				<div id="templatemo_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="/flowerWorld_v2/flower/getFlowers.do"
							class="selected">首页</a></li>
						<li><a href="/flowerWorld_v2/about.html">关于</a></li>
						<li><a href="/flowerWorld_v2/products.html">产品</a>
							<ul>
								<li><a href="#">全部鲜花</a></li>
								<li><a href="#">爱情鲜花</a></li>
								<li><a href="#">生日鲜花</a></li>
								<li><a href="#">绿植</a></li>
								<li><a href="#">永生花</a></li>
								<li><a href="#">开业花篮</a></li>
								<li><a href="#">精品礼盒花</a></li>
								<li><a href="#">周花主题</a></li>
								<li><a href="#">帮助中心</a></li>
							</ul></li>
						<li><a href="/flowerWorld_v2/checkout.html">结账</a></li>
						<li><a href="/flowerWorld_v2/contact.jsp">联系我们</a></li>
						<li><a href="/flowerWorld_v2/faqs.html">常见问题解答</a></li>
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
				<a href="#" title="Ã¥ÂÂÃ¨Â´Â¹Ã§ÂÂÃ¥ÂÂ¾Ã¥ÂÂ"
					class="site_repeat"><img src="images/top_repeat.png"
					title="Ã¥ÂÂÃ¨Â´Â¹Ã§ÂÂÃ¥ÂÂ¾Ã¥ÂÂ" /></a>
    </div> <!-- END of header -->
</div> <!-- END of header wrapper -->
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
    
   		<table border="1" id="infotb">  
        <tbody>  
            <tr>  
            	<th>创建时间</th> 
                <th>商品图片</th>
                <th>商品编号</th>
                <th>和我联系</th>
                <th>订单详情</th>
                <th>删除</th>   
            </tr>  
           
            <c:if test="${!empty OrderList }">  
                <c:forEach items="${OrderList}" var="order" >  
                    <tr>
						<td><div>
								<fmt:formatDate type="date" value="${order.creatTime}"
									dateStyle="default" />
							</div></td>
						
					
						<c:forEach items="${shop}" var="s" >
						<c:if test="${order.carId == s.carId }">
						<td><img src="${s.imagesUri }"/></td>
						</c:if>
						</c:forEach>
					
						<td>${order.flowerId }</td>
						<td><input type="hidden" name="flower_id" value="${order.flowerId }" ><a href="#">违规举报</a></td>
						<td>
							<input type="hidden" name="id" value="${order.orderId}">
							<a href="/flowerWorld_v2/to/byidOrder.do?orderId=${order.orderId}">确认订单</a>
						</td>
						<td> 
							<input type="hidden" name="id" value="${order.orderId}">
							<a href="/flowerWorld_v2/to/deleteOrder.do?orderId=${order.orderId}">删除</a>	
                        </td>
						 
                    </tr>               
                </c:forEach>
            </c:if>  
        </tbody>  
    </table>
    <a href="/flowerWorld_v2/to/findStatOrder.do"><h3>已完成订单</h3></a>
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