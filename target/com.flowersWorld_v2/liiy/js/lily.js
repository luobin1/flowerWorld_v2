function upANDadd(pid) {
	$("#light,#fade").css("display", "block");
	$("#p_id").val(pid);
}
function add() {
	$("#light1,#fade1").css("display", "block");
}
function upANDadd2() {
	$("#light,#fade,#light1,#fade1").css("display", "none");
	$(":text,:password").val("");
}

function upPwd() {
	$.ajax({
		type : "POST",
		url : "upPayAccountPwd.do",
		data : {
			'p_id' : $("#p_id").val(),
			'p_pwd' : $("#p_pwd").val(),
			'p_pwd2' : $("#p_pwd2").val()
		},
		dataType : "json",
		success : function(data) {
			if (data.message == "1") {
				location.href = "toPayAccount.do";
				alert("修改成功")
			} else {
				$("#message").html("原密码错误");
			}
		},
		error : function() {
		}
	});
}

/**
 * 正则验证密码
 */
function validate(pwd) {
	var reg = /^\d{6}$/;
	if (!reg.test(pwd.value)) {
		del_ff(pwd).innerHTML="请输入6个数字！";
	}
}

function regval(pwd2) {
	var pwd = $("#p_pw").val();
	if (pwd2.value != pwd) {
		del_ff(pwd2).innerHTML="请输入相同的密码！";
	}
}
function regval2(pwd2) {
	var pwd = $("#p_pwd1").val();
	if (pwd2.value != pwd) {
		del_ff(pwd2).innerHTML="请输入相同的密码！";
	}
}

function del(pwd){
	del_ff(pwd).innerHTML="";
}
/**
 * 
 */
function del_ff(pwd) {
	var s = pwd.parentNode.parentNode.lastChild.previousSibling; 
	return s;
}





function xiugai(a_id,a_pid,a_cid){
	$("#Pove").val(a_pid);
	pove();
	$("#City").val(a_cid);
	$.ajax({
		type : "POST",
		url : "toUpAddress.do",
		data : {
			'a_id' : a_id
		},
		dataType : "json",
		success : function(date) {
			$("[xgdz2]").show();
			$("#xxdc").text(date.address.a_address);
			$("#yzbm").val(date.address.a_Posetal_Code);
			$("#shxm").val(date.address.a_name);
			$("#lxdh").val(date.address.a_phone);
			$("#aid").val(date.address.a_id);
			
		},
		error : function() {
		}
	});
}


function pove(){
	var val = $('#Pove option:selected').val()
	
	  $.ajax( {  
          type : "post",  
          url : "queryCity.do",  
          data :  {
  			'pid' : val
  		},
          dataType : "json",  
          success : function(data) { 
        	  $("#city").html("");
        	 for(var i=0;i<data.citys.length;i++){
        		 $("#city").append(
                         "<option value="+data.citys[i].cid+">" +data.citys[i].cname+ "</option>");
        	 };
          },  
          error : function() {  
              alert("请与管理员联系");  
          }    
      });  
	
}


function pove1(){
	var val = $('#Pove1 option:selected').val()
	
	  $.ajax( {  
          type : "post",  
          url : "queryCity.do",  
          data :  {
  			'pid' : val
  		},
          dataType : "json",  
          success : function(data) { 
        	  $("#city1").html("");
        	 for(var i=0;i<data.citys.length;i++){
        		 $("#city1").append(
                         "<option value="+data.citys[i].cid+">" +data.citys[i].cname+ "</option>");
        	 };
          },  
          error : function() {  
              alert("请与管理员联系");  
          }    
      });  
	
}

var f1 = false;
var f2 = false;
var f3 = false;

function address(){
	var value = $(".textarea1").text();
	if(value == ""){
		$(".a_address_err").text("地址不能为空");
	}else{
		f1 = true;
	}
}

function yanz(va){
	if(va == ""){
		$(".yanz_err").text("收货人不能为空");
	}else{
		f2 = true;
	}
}

function yanz2(va){
	if(va == ""){
		$(".yanz_err2").text("联系电话不能为空");
	}else{
		f3 = true;
	}
}
function delate(){
	$(".a_address_err").text("");
	$(".yanz_err").text("");
	$(".yanz_err2").text("");
	$(".messge").text("");
}

function liiy(){
	if(f1 && f2 && f3){
		return true;
	}else{
		$(".messge").text("请正确的填写");
		return false;
	}
}










