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