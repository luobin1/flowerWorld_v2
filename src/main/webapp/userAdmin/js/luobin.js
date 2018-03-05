function cal(n){
	//获取3个值
	var price = window.document.getElementById("number"+n).value;
	var rate = window.document.getElementById("subtotal"+n).value;
	str = price*rate;
	window.document.getElementById("total"+n).value = str;

	 $.ajax( {
		    type : "POST",
		    url : "/flowerWorld_v2/to/order.do",
		    data : {

		        'carId' :$("#car"+n).val(),
		        'imagesUri' : $("#imagesUri"+n).val(),
		        'flowerId' : $("#flowerId"+n).val(),
		        'number' : $("#number"+n).val(),
		        'subtotal' : $("#subtotal"+n).val(),
		        'total' : $("#total"+n).val()
		    },
		    dataType: "json",
		  //traditional: true, //提交数组
		    success : function(data) {
		    	//window.document.getElementById("totalSum111").innerHtml=data.totalSum;
		    	$("#totalSum111").html(data.totalSum);
		    },
		    error :function(XMLHttpRequest, textStatus, errorThrown){
		        alert(XMLHttpRequest+"   "+textStatus+"   "+errorThrown);
		    },
		    async: false //这个 testAsync()方法中的Ajax请求将整个浏览器锁死 ，只有执行完一个ajax才能执行下一个
		});
}
function aaaa(){
	var father = document.getElementById("infotb");//获取父节点
	var last = father.childNodes.children.length;
	alert(last);
}

