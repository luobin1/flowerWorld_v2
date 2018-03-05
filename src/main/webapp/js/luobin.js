function cal(n){
	//获取3个值
	var price = window.document.getElementById("number"+n).value;
	//var rate = window.document.getElementById("subtotal"+n).value;
	var rate = $("#subtotal"+n).html();
	str = price*rate;
	window.document.getElementById("total"+n).innerText = str;
	//$("#total"+n).html() = str;//
	 $.ajax( {
		    type : "POST",
		    url : "/flowerWorld_v2/to/order.do",
		    data : {

		        'carId' :$("#car"+n).val(),
		        'imagesUri' : $("#imagesUri"+n).text(),
		        'flowerId' : $("#flowerId"+n).text(),
		        'number' : $("#number"+n).val(),
		        'subtotal' : $("#subtotal"+n).text(),
		        'total' : $("#total"+n).text()
		        
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
	 
//	 var arr = $("input[type='checkbox']:checked").val();
//	 var str;
//	 for (var i = 0; i < arr.length; i++) {
//		
//		str += $("#total"+arr[i]).html();
//	}
	 var str=document.getElementsByName("chen");
	 var objarray=str.length;
	 var chestr = parseFloat(0);
	 for(var i=0;i<objarray;i++){
		 if(str[i].checked == true){
			 chestr += parseFloat($("#total"+str[i].value).html());
		 }
	 }
	 $("#totalSum111").html(chestr);
	 
}
function ssa(){
	var str=document.getElementsByName("chen");
	 var objarray=str.length;
	 var chestr = parseFloat(0);
	 for(var i=0;i<objarray;i++){
		 if(str[i].checked == true){
			 chestr += parseFloat($("#total"+str[i].value).html());
		 }
	 }
	 $("#totalSum111").html(chestr);
}


