<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript" src="/flowerWorld_v2/js/luobin.js"></script>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>  
    <title>用户列表</title>  
      <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
      
  </head>  
  <body>  
   
<form action="/flowerWorld_v2/to/findAllOrder.do"> 
    <table border="1" id="infotb">  
        <tbody>  
            <tr>  
            	<th>序列</th>
                <th>图片</th>  
                <th>描述</th>  
                <th>数量</th>
                <th>单价</th> 
                <th>小计</th>
                <th>操作</th>   
            </tr>  
            <c:if test="${!empty ShopCartList }">  
                <c:forEach items="${ShopCartList}" var="ShopCartList" >  
                    <tr>  
                    	<td><input id="car${ShopCartList.carId }" value="${ShopCartList.carId }" /></td>
                    	<td><input id="imagesUri${ShopCartList.carId }" value="${ShopCartList.imagesUri}" /></td>
                        <td><input id="flowerId${ShopCartList.carId }" value="${ShopCartList.flowerId}" /></td>
                        <td><input id="number${ShopCartList.carId }" value="${ShopCartList.number }" onblur="cal(${ShopCartList.carId });" /></td>
                        <td><input id="subtotal${ShopCartList.carId }" value="${ShopCartList.subtotal }" /></td>
                        <td><input id="total${ShopCartList.carId }" value="${ShopCartList.total }" /></td>
                        <td> 
							<input type="hidden" name="id" value="${ShopCartList.carId}">
							<a href="/flowerWorld_v2/to/delete.do?carId=${ShopCartList.carId}">删除</a>	
                        </td>  
                    </tr>               
                </c:forEach>
            </c:if>  
        </tbody>  
    </table>  
    	<div id="totalSum111">${totalSum}</div>
    	<input type="submit" value="去结算" />
    </form> 

  </body>  
</html>  