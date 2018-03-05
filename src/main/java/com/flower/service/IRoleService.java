package com.flower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Role;

/**
 * 角色表的增删改查
 * 
 * @author Administrator
 *
 */
public interface IRoleService {
	// 新增角色
	public void addRole(Role role);

	// 删除角色
	public void deleteRole(int uId);

	// 修改角色
	public void updateRole(Role role);

	// 根据ID查询角色
	public Role findById(int uId);

	// 查询所有角色
	public List<Role> findAllRole();

	// 根据权限id查询角色名
	public Role findByPid(int pId);

	// 根据多个ID查询角色信息
	public List<Role> findByRoleIds(@Param("lists") List<Integer> lists);
}
