<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript" src="/flowerWorld_v2/js/luobin.js"></script>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>  
    <title>用户列表</title>  
      <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
      
  </head>  
  <body>  
    

    <table border="1" id="infotb">  
        <tbody>  
            <tr>  
            	<th>创建时间</th> 
                <th>订单号</th>
                <th>和我联系</th>
                <th>订单详情</th>
                <th>删除</th>   
            </tr>  
           
            <c:if test="${!empty OrderList }">  
                <c:forEach items="${OrderList}" var="OrderList" >  
                    <tr>
						<td><div>
								<fmt:formatDate type="date" value="${OrderList.creatTime}"
									dateStyle="default" />
							</div></td>
						
						
						
						<td><div>${OrderList.orderNumber }</div></td>
						
						<td><input type="hidden" name="flower_id" value="${OrderList.flowerId }" ><a href="#">违规举报</a></td>
						
						<td>
							<input type="hidden" name="id" value="${OrderList.orderId}">
							<a href="/flowerWorld_v2/to/byidOrder.do?orderId=${OrderList.orderId}">详情</a>
						</td>
						<td> 
							<input type="hidden" name="id" value="${OrderList.orderId}">
							<a href="/flowerWorld_v2/to/deleteOrder.do?orderId=${OrderList.orderId}">删除</a>	
                        </td>
						 
                    </tr>               
                </c:forEach>
            </c:if>  
        </tbody>  
    </table>  

  </body>  
</html>  