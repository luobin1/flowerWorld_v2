package com.flower.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.User;
import com.flower.jedis.JedisClient;
import com.flower.service.IUserService;
import com.flower.util.CreateMD5;

/**
 * 登录功能
 */
@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private JedisClient jedis;
	
	@Resource
	private IUserService userService;
	
	/**
	 * 登录账户
	 * @param u_phone
	 * @param u_pwd
	 * @param session
	 * @return
	 */
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value="login.do")
	public JSONObject login(String u_phone,String u_pwd,HttpSession session){
		Subject subject=SecurityUtils.getSubject();
		JSONObject json = new JSONObject();
		jedis.del(subject.getSession().getId()+":roles");
		User user = userService.getByU_phone(u_phone);
		CreateMD5 md5 = new CreateMD5();
		u_pwd=md5.getMd5(u_pwd);
//		if(user == null || !user.getU_pwd().equals(u_pwd)){
//			json.put("msg", 0);
//		}else{
//			json.put("msg", 1);
//			user.setU_pwd(null);
//		    session.setAttribute("user", user);
//		}
		/**
		 * 登录判断权限和角色
		 */
		if(user == null){
			json.put("msg", 0);
		}else{
			UsernamePasswordToken token=new UsernamePasswordToken(u_phone, u_pwd);
			try{
				subject.login(token);
				Session session1=subject.getSession();
				System.out.println("sessionId:"+session1.getId());
				System.out.println("sessionHost:"+session1.getHost());
				System.out.println("sessionTimeout:"+session1.getTimeout());
				if(user.getR_id()==1){//如果是超级管理员，则添加1
					json.put("msg", 1);
				}else if(user.getR_id()==2){
					json.put("msg", 2);//如果是官管理员，则添加2
				}else if(user.getR_id()==3){
					json.put("msg", 3);//如果会员，则绑定3
				}else if(user.getR_id()==4){
					json.put("msg", 4);//如果普用户，则绑定4
				}
				user.setU_pwd(null);
			    session.setAttribute("user", user);
				return json;
			}catch(Exception e){
				e.printStackTrace();
				json.put("msg", 0);
				return json;
			}
		}
		return json;
	}
	
	/**
	 * 获取用户信息
	 */
	@ResponseBody
	@RequestMapping(value="getUsername.do")
	public JSONObject getUserName(HttpSession session){
		JSONObject json = new JSONObject();
		User user = (User)session.getAttribute("user");
		if(user == null){
			json.put("info","游客");
		}else{
			if(user.getU_nname()!=null && !user.getU_nname().equals("")){
				json.put("info",user.getU_nname());
			}else{
				json.put("info",user.getU_phone());
			}
		}
		return json;
	}
	/**
	 * 退出登录请求
	 */
	@RequestMapping("logOut")
	public String loginOut(HttpSession session){
		Subject subject=SecurityUtils.getSubject();
		jedis.del(subject.getSession().getId()+":roles");
		subject.logout();
		return "redirect:flower/getFlowers.do";
	}
}