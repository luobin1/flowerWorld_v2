package com.flower.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.User;
import com.flower.service.IUserService;
import com.flower.util.CreateMD5;
/**
 * ◊¢≤·’Àªß
 * @author Administrator
 *
 */
@Controller
@RequestMapping
@SuppressWarnings("static-access")
public class RegistController {
	@Resource
	private IUserService iUserService;
	/**
	 * ¥¥Ω®’Àªß
	 * @param u_phone
	 * @param u_mail
	 * @param u_pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="submitRegist.do")
	public JSONObject regist(String u_phone,String u_mail,String u_pwd){
		JSONObject json = new JSONObject();
		CreateMD5 md5 = new CreateMD5();
		u_pwd=md5.getMd5(u_pwd);
		User user = new User(null, u_phone, u_mail, null, null, null, u_pwd, 4);
		iUserService.addUser(user);
		json.put("msg", 1);
		return json;
	}
	/**
	 * 
	 * @param ¥Ê¥¢√‹¬Î
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="savepwd.do")
	public JSONObject savepwd(String pwd,HttpSession session){
		JSONObject json = new JSONObject();
		CreateMD5 md5 = new CreateMD5();
		pwd = md5.getMd5(pwd);
		try {
//			User user = (User) session.getAttribute("user");
			User user =  iUserService.getByU_phone((String)session.getAttribute("phone"));
			user.setU_pwd(pwd);
			iUserService.updateUser2(user);
			session.removeAttribute("phone");
			session.removeAttribute("code");
			session.removeAttribute("user");
			json.put("msg", 1);
         } catch (Exception e) {
            json.put("msg", 0);
         }
		return json;
	}
}
