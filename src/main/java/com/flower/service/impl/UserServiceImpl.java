package com.flower.service.impl;

import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower.dao.IUserDao;
import com.flower.entity.User;
import com.flower.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);

	}

	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	public User findByU_id(int u_id) {
		return userDao.findByU_id(u_id);
	}

	public void deleteByU_id(int u_id) {
		userDao.deleteByU_id(u_id);

	}
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	public User getByU_phone(String u_phone) {
		return userDao.getByU_phone(u_phone);
	}

	public Set<String> getRoles(String u_phone) {
		return userDao.getRoles(u_phone);
	}

	public Set<String> getPermissions(String u_phone) {
		return userDao.getPermissions(u_phone);
	}

	public Set<String> findRoles(String iphone) {
		return userDao.findRoles(iphone);
	}

	public Set<String> findPermissions(String iphone) {
		return userDao.findPermissions(iphone);
	}

	public List<User> findByRoleId(int r_id) {
		
		return userDao.findByRoleId(r_id);
	}

	public void addUserAdmin(User user) {
		userDao.addUserAdmin(user);
		
	}

	public void updateUser2(User user) {
		userDao.updateUser2(user);
		
	}


}
