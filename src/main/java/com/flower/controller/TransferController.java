package com.flower.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用户注册，登录，修改密码的请求分发
 * @author Administrator
 *
 */
@RequestMapping("flower")
@Controller
public class TransferController {
	/**
	 * 注册成功之后跳转
	 * @return
	 */
	@RequestMapping("registSuccess")
	public String registSuccess(){
		return "registSuccess.html";
	}
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("regist")
	public String regist(){
		return "regist.html";
	}
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("sign")
	public String sign(){
		return "login.html";
	}
	/**
	 * 跳转到找回密码界面
	 * @return
	 */
	@RequestMapping("resetPwd")
	public String resetPwd(){
		return "resetPwd1.html";
	}
	/**
	 * 跳转到修改密码界面
	 * @param session
	 * @param phone
	 * @param code
	 * @return
	 */
	@RequestMapping("resetPwdNext")
	public String resetPwdNext(HttpSession session,String phone,String code){
		phone = (String) session.getAttribute("phone");
		code = (String) session.getAttribute("msgCode");
		if(phone!=null && code!=null){
			return "resetPwd2.html";
		}else{
			return "resetPwd1.html";
		}
	}
	/**
	 * 跳转到修改密码成功后界面
	 * @return
	 */
	@RequestMapping("saveSuccess")
	public String saveSuccess(){
		return "saveSuccess.html";
	}
}
