package com.flower.service;

import java.util.List;
import java.util.Set;

import com.flower.entity.User;

public interface IUserService {
	//新增用户
	public void addUser(User user);
	
	public void addUserAdmin(User user);
	//修改用户
	public void updateUser(User user);
	//修改用户
	public void updateUser2(User user);
	//查询用户
	public User findByU_id(int u_id);
	//管理员删除用户
	public void deleteByU_id(int u_id);
	//管理员查询所有用户
	public List<User> findAllUser();
	/**
	 * 通过用户手机查询用户
	 * @param u_phone
	 * @return
	 */
	public User getByU_phone(String u_phone);
	
	/**
	 * 通过用户手机查询角色信息
	 * @param u_phone
	 * @return
	 */
	public Set<String> getRoles(String u_phone);
	
	/**
	 * 通过用户手机查询权限信息
	 * @param u_phone
	 * @return
	 */
	public Set<String> getPermissions(String u_phone);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> findRoles(String iphone);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> findPermissions(String iphone);
	
	/**
	 * 通过角色查询用户信息
	 * @param r_id
	 * @return
	 */
	public List<User> findByRoleId(int r_id);
}
