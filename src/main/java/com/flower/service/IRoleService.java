package com.flower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Role;

/**
 * ��ɫ�����ɾ�Ĳ�
 * 
 * @author Administrator
 *
 */
public interface IRoleService {
	// ������ɫ
	public void addRole(Role role);

	// ɾ����ɫ
	public void deleteRole(int uId);

	// �޸Ľ�ɫ
	public void updateRole(Role role);

	// ����ID��ѯ��ɫ
	public Role findById(int uId);

	// ��ѯ���н�ɫ
	public List<Role> findAllRole();

	// ����Ȩ��id��ѯ��ɫ��
	public Role findByPid(int pId);

	// ���ݶ��ID��ѯ��ɫ��Ϣ
	public List<Role> findByRoleIds(@Param("lists") List<Integer> lists);
}
