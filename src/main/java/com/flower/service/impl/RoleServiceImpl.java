package com.flower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower.dao.IRoleDao;
import com.flower.entity.Role;
import com.flower.service.IRoleService;
/**
 * 角色表的增删改查
 * @author Administrator
 *
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	private IRoleDao dao;
	
	public void addRole(Role role) {
		dao.addRole(role);
		
	}

	public void deleteRole(int uId) {
		dao.deleteRole(uId);
		
	}

	public void updateRole(Role role) {
		dao.updateRole(role);
		
	}

	public Role findById(int uId) {
		// TODO Auto-generated method stub
		return dao.findById(uId);
	}

	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return dao.findAllRole();
	}

	public Role findByPid(int pId) {
		// TODO Auto-generated method stub
		return dao.findByPid(pId);
	}

	public List<Role> findByRoleIds(List<Integer> lists) {
		// TODO Auto-generated method stub
		return dao.findByRoleIds(lists);
	}
	
}
