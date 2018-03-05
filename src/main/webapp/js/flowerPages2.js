$(function() {
	$("#content2").hide();
	$("#allType").css("color","red");
});

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
				"<a href='/flowerWorld_v2/flower/findFlowerById.do?flowerId="+flowers[i].flowerId+"'>查看详情</a>" +
				"<a href='/flowerWorld_v2/to/findAllShopCar.do?'>加入购物车</a></p></div>";	
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
					page +="<a class='limit-a2' href='/flowerWorld_v2/flower/getFlowerByTypeId.do?flowerTypeId="+pcl+"&pageNumber="+i+"' style='color: white; font-size: 15px;'>"+i+"</a>";
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
/**
 * 模糊匹配查找鲜花
 */
function findSome(){
	var flowerName = $("#keyword").val();
	$.ajax({
		type : "POST",
		url : "/flowerWorld_v2/flower/findSome.do",
		data : {
			'flowerName' : flowerName
		},
		dataType : "json",
		// traditional: true, //提交数组
		success : function(data) {
			var listStr = "";
			if(!data){
				alert("未找到符合条件的商品！");
			}else{
				var list = data.list;
				var totalPage = data.totalPage;
				var pageNumber = data.pageNumber;
				var indexStr = "";
				for(var i=0;i<list.length;i++){
					listStr += "<div class='product_box'>" +
					"<a href='/flowerWorld_v2/flower/findFlowerById.do?flowerId="+list[i].flowerId+"'>" +
					"<img src='"+list[i].flowerUrl1+"'" +
					"alt='floral set 1' style='width: 165px; height: 165px;' /></a>" +
					"<h3>"+list[i].flowerName+"</h3>" +
					"<p class='product_price'>"+list[i].price+"元</p>" +
					"<p class='add_to_cart'>" +
					"<a href='/flowerWorld_v2/flower/findFlowerById.do?flowerId="+list[i].flowerId+"'>查看详情</a>" +
					"<a href='/flowerWorld_v2/to/findAllShopCar.do?'>加入购物车</a></p></div>";	
				}
				$(".flowerList").html(listStr);
				if(pageNumber == 1){
					indexStr += "<div id='limit-div'>" +
					"<div style='float: left;'><a href='#' class='button left'>上一页</a></div>";	
				}else{
					indexStr += "<div style='float: left;'>" +
							"<a href='/flowerWorld_v2/flower/findSome.do?flowerName="+flowerName+"&pageNumber="+(pageNumber-1)+"' class='button left'>上一页</a>";
				}
				var page="<div style='float: left; width: 100px;' align='center'>";
				for(var i=1;i<=totalPage;i++){
					if(pageNumber == i){
						page += "<a class='limit-a1' href='#' style='color: red; font-size: 15px;'>"+i+"</a>&nbsp;";
					}else{
						page +="<a class='limit-a2' href='/flowerWorld_v2/flower/findSome.do?flowerName="+flowerName+"&pageNumber="+i+"' style='color: white; font-size: 15px;'>"+i+"</a>";
					}
				}
				page += "</div>";
				var last = "";
				if(pageNumber==totalPage){
					last += "<a href='#' class='button left'>下一页</a>";
				}else{
					last +="<a onclick='/flowerWorld_v2/flower/findSome.do?flowerName="+flowerName+"&pageNumber="+(pageNumber+1)+"' class='button left'>下一页</a>";
				}
				$(".pageIndex").html(indexStr+page+last);
			}
		}
	});
}
