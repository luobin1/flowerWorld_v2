<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <script type="text/javascript" src="js/jquery-1.6.1.js"></script>  
<title>Insert title here</title>
<style type="text/css">
			table{
				border-collapse: collapse;
			}
			td{
				width:100px;
				height:30px;
				border: 1px solid gray;
				text-align: center;
			}
			.header{
				height: 35px;
				font-weight: bold;
				background-color: #ddd;
			}
			
		</style>
  <script type="text/javascript">  
    function del(ftypeId){  
        $.get("<%=basePath%>iFlowerTypeService/delUser?ftypeId=" + ftypeId,function(data){  
            if("success" == data.result){  
                alert("删除成功");  
                window.location.reload();  
            }else{  
                alert("删除失败");  
            }  
        });  
    }  
    function deleteFee(ftypeId){
		var r = window.confirm("确定要删除此分类吗？");
		if(r){
			window.location.href = "deleteiFlowerTypeService?ftypeId="+carId;
		}
		//document.getElementById("operate_result_info").style.display = "block";
	}
</script>  
</head>
<body>
	<table>
		<tr class="header">  
        	<td></td>
            <td></td>  
            <td>类别</td> 
            <td>操作</td> 
        </tr>  
      <c:if test="${!empty iFlowerTypeService }">  
		<c:forEach items="${iFlowerTypeService }" var="iFlowerTypeService">
			<tr>
				<td>${iFlowerTypeService.ftypeId }</td>
				<td>${iFlowerTypeService.fatherId}</td>
				<td>${iFlowerTypeService.ftypeName }</td>
				<td>  
                    <a href="<%=basePath%>iFlowerTypeService/getUser?carId=${iFlowerTypeService.ftypeId}">编辑</a>  
                    <a href="javascript:deleteFee('${iFlowerTypeService.ftypeId }')">删除</a>  
                </td>  
			</tr>
		</c:forEach>
	</c:if>
	</table>
</body>
</html>