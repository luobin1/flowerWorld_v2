<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>鲜花页面</title>
<meta name="keywords" content="free template, floral shop, ecommerce, online shopping, store" />
<meta name="description" content="Floral Shop, Product Details, free template for ecommerce websites." />
<link href="/flowerWorld_v2/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="/flowerWorld_v2/css/orman.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/flowerWorld_v2/css/nivo-slider.css" type="text/css" media="screen" />

<link rel="stylesheet" type="text/css" href="/flowerWorld_v2/css/ddsmoothmenu.css" />
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

<script type="text/javascript" src="/flowerWorld_v2/js/jquery-1-4-2.min.js"></script> 
<link rel="stylesheet" href="/flowerWorld_v2/css/slimbox2.css" type="text/css" media="screen" /> 
<script type="text/JavaScript" src="/flowerWorld_v2/js/slimbox2.js"></script> 

</head>

<body>

<div id="templatemo_wrapper_sp">
<div id="templatemo_header_wsp">
	<div id="templatemo_header" class="header_subpage">
    	<div id="site_title"><a title="花花世界">花花世界</a></div>
        <div id="templatemo_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="/flowerWorld_v2/flower/getFlowers.do" class="selected">首页</a></li>
						<li><a target="_blank" href="/flowerWorld_v2/about.html">关于本店</a></li>
						<li><a href="/flowerWorld_v2/flower/getFlowers.do">鲜花分类</a></li>
						<li><a href="/flowerWorld_v2/to/findAllOrder.do">结账</a></li>
						<li><a href="/flowerWorld_v2/contact.jsp">联系我们</a></li>
						<li><a href="/flowerWorld_v2/faqs.jsp">常见问题解答</a></li>
            </ul>
            <div id="templatemo_search">
                <form action="#" method="get">
                  	<input type="text" value="搜索" name="keyword" id="keyword" title="keyword" 
                  			onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                  	<input type="submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" class="sub_btn" />
                </form>
            </div>
            <br style="clear: left" />
        </div> 
        <a href="#"   class="site_repeat" ><img src="/flowerWorld_v2/images/top_repeat.png" title="#/"  /></a><!-- end of templatemo_menu -->
       
    </div> <!-- END of header -->
</div> <!-- END of header wrapper -->
<div id="templatemo_main_wrapper">
<div id="templatemo_main">
	<div id="sidebar" class="left">
    	<div class="sidebar_box"><span class="bottom"></span>
            <h3>类别</h3>   
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
                    <li><a href="#">其它</a></li>
                </ul>
            </div>
        </div>
        <div class="sidebar_box"><span class="bottom"></span>
            <h3>周花主题</h3>   
            <div class="content special"> 
                <img src="/flowerWorld_v2/images/templatemo_image_01.jpg" style="width: 220px;height: 220px;" alt="Flowers" />
                <a href="#">Citrus Burst Bouquet</a>
                <p>
                	价格:
                    <span class="price normal_price">${flower.price }</span>&nbsp;&nbsp;
                    <span class="price special_price">$100</span>
                </p>
            </div>
        </div>
    </div>
    
    <div id="content" class="right">
    <form action="/flowerWorld_v2/to/addShopCart.do" method="post">
    	<input name="flower_id" type="hidden" value="${flower.flowerId }">
      	<h2>${flower.flowerName }</h2>
        <div class="content_half left">
        	<a  rel="lightbox" href="${flower.flowerUrl1 }"><img src="${flower.flowerUrl1 }" style="width: 165px;height: 165px;" alt="yellow flowers" /></a>
        </div>
            <div class="content_half right">
                <table>
                    <tr>
                        <td width="130">价格:</td>
                        <td width="84">${flower.price }元</td>
                    </tr>
                    <tr>
                    	<td>编号:</td>
                    	<td>${flower.flowerId }</td>
                    </tr>
                    <tr>
                        <td>类别:</td>
                        <td>
                        <c:choose>
                        	<c:when test="${flower.flowerTypeId==2 }">玫瑰</c:when>
                        	<c:otherwise>其它</c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                    <tr><td>数量:</td><td><input name="number" type="text" value="1" size="6" maxlength="2" /></td></tr>
                	<tr>
                		<td colspan="2">配送:${flower.distribution }</td>
                	</tr>
                </table>
                <div class="cleaner h20"></div>
                <input type="submit" value="加入购物车"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="../personalCenter/findCommenByLimit.do?flowerId=${flower.flowerId }">查看鲜花评论</a>
			</div>
            <div class="cleaner h40"></div>
            
            <h4>鲜花介绍</h4>
            <p>材料:${flower. material}
            <br>包装:${flower.packing }
            <br>花语:${flower.flowerLanguage }
            <br>附送:${flower.gifts } </p>
            <div class="cleaner h40">
            </div>
        <div class="blank_box">
        	<a href="#"><img src="/flowerWorld_v2/images/free_shipping.jpg" alt="Free Shipping" /></a>
        </div> 
       </form>   
    </div>
    <div class="cleaner"></div>
</div> <!-- END of main -->
</div> <!-- END of main wrapper -->

<div id="templatemo_footer_wrapper">
<div id="templatemo_footer">
	<div class="footer_left">
    	<a href="#"><img src="/flowerWorld_v2/images/1311260370_paypal-straight.png" alt="Paypal" /></a>
        <a href="#"><img src="/flowerWorld_v2/images/1311260374_mastercard-straight.png" alt="Master" /></a>
        <a href="#"><img src="/flowerWorld_v2/images/1311260374_visa-straight.png" alt="Visa" /></a>
    </div>
	<div class="footer_right">
		<p><a href="/flowerWorld_v2/index.html">Home</a> | <a href="/flowerWorld_v2/products.html">Products</a> | <a href="/flowerWorld_v2/about.html">About</a> | <a href="/flowerWorld_v2/faqs.html">FAQs</a> | <a href="/flowerWorld_v2/checkout.html">Checkout</a> | <a href="/flowerWorld_v2/contact.html">Contact</a></p>
        <p>Copyright (c) 2084 <a href="#">Company Name</a> | Collect from <a title="花花世界">花花世界</a></p>
	</div>
    <div class="cleaner"></div>
</div> <!-- END of footer -->
</div> <!-- END of footer wrapper -->
</div>

</body>
<script type='text/javascript' src='/flowerWorld_v2/js/logging.js'></script>
</html>