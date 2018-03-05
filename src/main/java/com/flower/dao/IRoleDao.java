package com.flower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Role;
/**
 * ��ɫ�����ɾ�Ĳ�
 * @author Administrator
 *
 */

public interface IRoleDao {
	// ������ɫ
	public void addRole(Role role);

	// ����Աɾ���û�
	public void deleteRole(int uId);
	
	// �޸��û�
	
	public void updateRole(Role role);

	// ��ѯ�û�
	public Role findById(int uId);

	// ����Ա��ѯ�����û�
	public List<Role> findAllRole();
	
	//����Ȩ��id��ѯ��ɫ��
	public Role findByPid(int pId);
	
	//���ݶ��ID��ѯ��ɫ��Ϣ
	public List<Role> findByRoleIds(@Param("lists")List<Integer> lists);
}
