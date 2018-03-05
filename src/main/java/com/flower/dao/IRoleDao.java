package com.flower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Role;
/**
 * 角色表的增删改查
 * @author Administrator
 *
 */

public interface IRoleDao {
	// 新增角色
	public void addRole(Role role);

	// 管理员删除用户
	public void deleteRole(int uId);
	
	// 修改用户
	
	public void updateRole(Role role);

	// 查询用户
	public Role findById(int uId);

	// 管理员查询所有用户
	public List<Role> findAllRole();
	
	//根据权限id查询角色名
	public Role findByPid(int pId);
	
	//根据多个ID查询角色信息
	public List<Role> findByRoleIds(@Param("lists")List<Integer> lists);
}
