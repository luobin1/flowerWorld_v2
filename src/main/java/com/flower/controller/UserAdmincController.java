package com.flower.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.Role;
import com.flower.entity.User;
import com.flower.service.IRoleService;
import com.flower.service.IUserService;

@Controller("userAdmincController")
@RequestMapping("/userAdmin")
public class UserAdmincController {
	//��ȡ��ɫservicce
	@Autowired
	private IRoleService iRoleService;
	//��ȡ�û�servicce
	@Autowired
	private IUserService iUserService;
	//userAdmin/findByUserAndRoleAll.do
	/**
	 * ��ѯ���н�ɫ��Ϣ���û���Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/findByUserAndRoleAll")
	public String getUserAdmin(Model model){
		List<Role> roles = iRoleService.findAllRole();
		List<User> users = iUserService.findAllUser();
		model.addAttribute("roles",roles);
		model.addAttribute("users",users);
		return "userAdmin/backGroundUser.jsp";
		
	}
	/**
	 * ���ݽ�ɫID��ȡ�û���Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/roleIDs")
	public String roleIDs(Model model){
		List<Role> roles = new ArrayList<Role>();
		Role role1 = iRoleService.findById(3);
		Role role2 = iRoleService.findById(4);
		roles.add(role1);
		roles.add(role2);
		System.out.println(roles);
		model.addAttribute("roles", roles);
//		List<Integer> rId = new ArrayList<Integer>();
//		rId.add(1);
//		rId.add(2);
//		List<Role> roles = iRoleService.findByRoleIds(rId);
//		model.addAttribute("roles", roles);
		return "userAdmin/adminUser.jsp";
		
	}
	
	
	/**
	 * ���ݽ�ɫ��ȡ�û���Ϣ
	 * @param rId
	 * @return
	 */
	@RequestMapping("UserAdminById")
	@ResponseBody
	public JSONObject getUserAdminById(int rId){
		JSONObject json = new JSONObject();
		//Role role = iRoleService.findById(rId);
		List<User> users = iUserService.findByRoleId(rId);
		json.put("users", users);
//		model.addAttribute("role",role);
//		model.addAttribute("user",user);
		return json;
		
	}
	/**
	 * ɾ����̨�û���Ϣ
	 * @param uId
	 * @param model
	 * @param requset
	 * @return
	 */
	@RequestMapping("/deleteUserAdmin")
	public String getdeleteUserAdmin(int uId,Model model,HttpServletRequest requset){
		iUserService.deleteByU_id(uId);
		return "redirect:findByUserAndRoleAll.do";
	}
	
	@RequestMapping("/deleteUserAdmin2")
	public String getdeleteUserAdmin2(int uId,Model model,HttpServletRequest requset){
			iUserService.deleteByU_id(uId);
		return "redirect:findByUphone.do";
	}
	
	
	/**
	 * ��ת��������ԱȨ���޸�ҳ��
	 * @param model
	 * @param requset
	 * @return
	 */
	@RequestMapping("/toUpdateUserAdmin")
	public String toUpdateUserAdmin(int uId,Model model,HttpServletRequest requset){
		User user = iUserService.findByU_id(uId);
		model.addAttribute("user", user);
		return "userAdmin/updateBackGroundUser.jsp";
	}
	/**
	 * ��ת����ԱȨ���޸�ҳ��
	 * @param model
	 * @param requset
	 * @return
	 */
	@RequestMapping("/toUpdateUserAdmin2")
	public String toUpdateUserAdmin2(int uId,Model model,HttpServletRequest requset){
		User user = iUserService.findByU_id(uId);
		model.addAttribute("user", user);
		return "userAdmin/updateAdminUser.jsp";
	}
	/**
	 * �޸�Ȩ�޵ȼ�
	 * @param role
	 * @param model
	 * @param requset
	 * @return
	 */
	@RequestMapping("/updateUserAdmin")
	public String getUpdateUserAdmin(User user,Model model,HttpServletRequest requset){
		List<Role> roles = iRoleService.findAllRole();
		model.addAttribute("roles", roles);
		iUserService.updateUser(user);
		return "redirect:findByUserAndRoleAll.do";
	}
	
	
	@RequestMapping("/updateUserAdmin2")
	public String getUpdateUserAdmin2(User user,Model model,HttpServletRequest requset){
		List<Role> roles = iRoleService.findAllRole();
		model.addAttribute("roles", roles);
		iUserService.updateUser(user);
		return "redirect:roleIDs.do";
	}
	
	
	@RequestMapping("/findByUphone")
	public String getUserPhone(String u_phone,Model model){
		User users = iUserService.getByU_phone(u_phone);
		model.addAttribute("users", users);
		return "userAdmin/adminFindUser.jsp";
		
	}
}
