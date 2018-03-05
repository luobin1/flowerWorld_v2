$(function() {
	$("#content2").hide();
	$("#allType").css("color","red");
});
function addFlower() {
	$.ajax({
		type : "POST",
		url : "/flowerWorld_v2/flower/addFlower.do",
		data : {
			'flowerName' : $("#flowerName").val(),
			'flowerTypeId' : $("#flowerTypeId").val(),
			'purposeId' : $("#purposeId").val(),
			'material' : $("#material").val(),
			'packing' : $("#packing").val(),
			'flowerLanguage' : $("#flowerLanguage").val(),
			'gifts' : $("#gifts").val(),
			'distribution' : $("#distribution").val(),
			'price' : $("#price").val(),
			'flowerUrl1' : $("#flowerUrl1").val()
		},
		dataType : "json",
		// traditional: true, //提交数组
		success : function(data) {
			$("#str").empty();
			for (var i = 0; i < data.length; i++) {
				var b = new Option(data[i].name, data[i].id);
				$("#str").append(b);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest + "   " + textStatus + "   " + errorThrown);
		},
		async : false
	// 这个 testAsync()方法中的Ajax请求将整个浏览器锁死 ，只有执行完一个ajax才能执行下一个
	});

}

// 为在线用户列表的a标签绑定点击事件

$(function() {
	$(".online-li").click(function() {
		$(".online-li").css("color","");
		$(this).css("color", "red");
		$("#ontalk").html($(this).html());
	});
});
//检查价格输入框是否输入正确
function checkDouble(n,price){
	var reg = /^[0-9]+\.?[0-9]*$/;
	if(n=="" ||!reg.test(n)){
		$("#doubleErr").html("请正确输入！");
		$("#price").val(price);
	}else{
		$("#doubleErr").html("");
	}
}

function checkDouble2(n){
	var reg = /^[0-9]+\.?[0-9]*$/;
	if(n=="" ||!reg.test(n)){
		$("#doubleErr").html("请正确输入！");
		$("#price").val(0);
	}else{
		$("#doubleErr").html("");
	}
}

var pcl=0;
var pclPageNumber=1;
/**
 * author:潘春利
 * 修改值 
 */
function changeTypeNumber(obj,n){
	$(".sidebar_li").css("color","");
	$(obj).css("color","red");
	$("#flowerTitle").html($(obj).html());
	pcl=n;
	pclPageNumber=1;
	changeNumber(0);
}
function limitByType(pageNumbers){
	$("#content").hide();
	$("#content2").show();
	$.ajax({
		type : "POST",
		url : "/flowerWorld_v2/flower/getFlowerByType.do",
		data : {
			'flowerTypeId' : pcl,
			'pageNumber':pageNumbers
		},
		dataType : "json",
		// traditional: true, //提交数组
		success : function(data) {
			var flowers = data.flowers;
			var totalPage = data.totalPage;
			var pageNumber = data.pageNumber;
			$("#flowerList").html("");
			var list = "";
			for(var i=0;i<flowers.length;i++){
				list += "<div class='product_box'>" +
				"<a href='/flowerWorld_v2/flower/toChangeFlowerPage.do?flowerId="+flowers[i].flowerId+"'>" +
				"<img src='"+flowers[i].flowerUrl1+"'" +
				"alt='floral set 1' style='width: 165px; height: 165px;' /></a>" +
				"<h3>"+flowers[i].flowerName+"</h3>" +
				"<p class='product_price'>"+flowers[i].price+"元</p>" +
				"<p class='add_to_cart'>" +
				"<a href='/flowerWorld_v2/flower/toChangeFlowerPage.do?flowerId="+flowers[i].flowerId+"'>修改</a>" +
				"<a href='/flowerWorld_v2/flower/deleteFlowerById.do?flowerId="+flowers[i].flowerId+"'>删除</a></p></div>";	
			}
			var indexStr = "";
			if(pageNumber == 1){
				indexStr += "<div id='limit-div'>" +
				"<div style='float: left;'><a href='#' class='button left'>上一页</a></div>";	
			}else{
				indexStr += "<div style='float: left;'>" +
						"<a href='javascript:;' onclick='changeNumber(-1)' class='button left'>上一页</a>";
			}
			var page="<div style='float: left; width: 100px;' align='center'>";
			for(var i=1;i<=totalPage;i++){
				if(pageNumber == i){
					page += "<a class='limit-a1' href='#' style='color: red; font-size: 15px;'>"+i+"</a>&nbsp;";
				}else{
					page +="<a class='limit-a2' href='/flowerWorld_v2/flower/getFlowerByType.do?flowerTypeId="+pcl+"&pageNumber="+i+"' style='color: white; font-size: 15px;'>"+i+"</a>";
				}
			}
			page += "</div>";
			var last = "";
			if(pageNumber==totalPage){
				last += "<a href='#' class='button left'>下一页</a>";
			}else{
				last +="<a onclick='changeNumber(1)' class='button left'>下一页</a>";
			}
			
			$("#flowerList").html(list);
			$("#pageIndex").html(indexStr+page+last);
		}
	});
	
}

/**
 * 分页的时候修改页面数 
 */
function changeNumber(pclNumber){
	pclPageNumber+=pclNumber;
	limitByType(pclPageNumber);
}

