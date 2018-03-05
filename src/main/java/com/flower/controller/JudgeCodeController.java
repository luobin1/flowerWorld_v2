package com.flower.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.flower.entity.User;
import com.flower.service.IUserService;

/**
 * 验证码
 * @author Administrator
 *
 */
@Controller
@RequestMapping
public class JudgeCodeController {
	
	@Resource
	private IUserService userService;
	
	//验证网站验证码
	@ResponseBody
	@RequestMapping(value="/equlsCode.do")
	public JSONObject equlsCode(String code,HttpServletRequest request){
		String verifyCode = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); //验证码
		JSONObject json = new JSONObject();
		if(code.equals(verifyCode)){
			json.put("msg", 1);
		}else{
			json.put("msg", 0);
		}
		return json;
	}
	//验证手机验证码
	@ResponseBody
	@RequestMapping(value="/equlsMsgCode.do")
	public JSONObject equlsMsgCode(String code,HttpSession session){
		String msgCode = (String)session.getAttribute("msgCode"); //验证码
		JSONObject json = new JSONObject();
		if(code.equals(msgCode)){
			json.put("msg", 1);
		}else{
			json.put("msg", 0);
		}
		return json;
	}
	
	
    //注册时发送的手机验证码
    @ResponseBody
	@RequestMapping(value="/rsendSms.do")
    public  JSONObject rsendSms(String phone,HttpSession session) throws ClientException {
    	JSONObject j = new JSONObject();
    	String reg = "^1[3|4|5|7|8][0-9]\\d{8}$";
    	 if(phone==null||!phone.matches(reg)){
    		 j.put("state", "手机格式不正确");
    		 return j;
    	 }
    	 User user = userService.getByU_phone(phone);
    	 if(user!=null){
    		 j.put("state", "账号已经存在，请直接登入！");
    		 return j;
    	 }
    	 String code = (int)(Math.random()*1000000)+"";
         System.out.println(code);
         session.setAttribute("msgCode", code);
        try {
            // SendMassage.sendSms(phone,code);
            j.put("state","发送成功");
         } catch (Exception e) {
            System.out.println("发送失败");
            j.put("state","发送失败");
         }
        return j;
    }
    
    //找回密码时发送的手机验证码
    @ResponseBody
	@RequestMapping(value="/fsendSms.do")
    public  JSONObject fsendSms(String phone,HttpSession session) throws ClientException {
    	JSONObject j = new JSONObject();
    	String reg = "^1[3|4|5|7|8][0-9]\\d{8}$";
    	 if(phone==null||!phone.matches(reg)){
    		 j.put("state", "手机格式不正确");
    		 return j;
    	 }
    	 User user = userService.getByU_phone(phone);
    	 if(user==null){
    		 j.put("state", "账号不存在，请注册！");
    		 return j;
    	 }
    	 user.setU_pwd(null);
//    	 session.setAttribute("user", user);
    	 String code = (int)(Math.random()*1000000)+"";
         System.out.println(code);
         session.setAttribute("phone", user.getU_phone());
         session.setAttribute("msgCode", code);
        try {
            // SendMassage.sendSms(phone,code);
            j.put("state","发送成功");
         } catch (Exception e) {
            System.out.println("发送失败");
            j.put("state","发送失败");
         }
        return j;
    }
    

}
