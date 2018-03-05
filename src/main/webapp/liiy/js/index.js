$(function() {
	$("#regeist-div,#regeist-bg").hide();
})

/**
 * 注册按钮点击事件
 */
function showRegist() {
	$("#regeist-div,#regeist-bg").show();
}

/**
 * 注册页面X的点击事件
 */
function hideRegist() {
	$("#regeist-div,#regeist-bg").hide();
}
function checkNull(obj, n) {
	if ($(obj).val() == "") {
		$("#err0" + n).html("不能为空");
	} else {
		$("#err0" + n).html(" ");
	}
}
function checkPwds() {
	if ($("#pwd01").val() != $("#pwd02").val()) {
		$("#regpwd-err").html("密码不一致");
	}
	if ($("#pwd01").val() == $("#pwd02").val()) {
		$("#regpwd-err").html(" ");
	}
}
function checkName() {
	if ($("#reName").val() == "") {
		$("#err03").html("不能为空");
	} else {
		$("#err03").html(" ");
	}
}





