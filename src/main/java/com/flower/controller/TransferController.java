package com.flower.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * �û�ע�ᣬ��¼���޸����������ַ�
 * @author Administrator
 *
 */
@RequestMapping("flower")
@Controller
public class TransferController {
	/**
	 * ע��ɹ�֮����ת
	 * @return
	 */
	@RequestMapping("registSuccess")
	public String registSuccess(){
		return "registSuccess.html";
	}
	/**
	 * ��ת��ע��ҳ��
	 * @return
	 */
	@RequestMapping("regist")
	public String regist(){
		return "regist.html";
	}
	/**
	 * ��ת����¼ҳ��
	 * @return
	 */
	@RequestMapping("sign")
	public String sign(){
		return "login.html";
	}
	/**
	 * ��ת���һ��������
	 * @return
	 */
	@RequestMapping("resetPwd")
	public String resetPwd(){
		return "resetPwd1.html";
	}
	/**
	 * ��ת���޸��������
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
	 * ��ת���޸�����ɹ������
	 * @return
	 */
	@RequestMapping("saveSuccess")
	public String saveSuccess(){
		return "saveSuccess.html";
	}
}
