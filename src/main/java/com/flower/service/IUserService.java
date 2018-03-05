package com.flower.service;

import java.util.List;
import java.util.Set;

import com.flower.entity.User;

public interface IUserService {
	//�����û�
	public void addUser(User user);
	
	public void addUserAdmin(User user);
	//�޸��û�
	public void updateUser(User user);
	//�޸��û�
	public void updateUser2(User user);
	//��ѯ�û�
	public User findByU_id(int u_id);
	//����Աɾ���û�
	public void deleteByU_id(int u_id);
	//����Ա��ѯ�����û�
	public List<User> findAllUser();
	/**
	 * ͨ���û��ֻ���ѯ�û�
	 * @param u_phone
	 * @return
	 */
	public User getByU_phone(String u_phone);
	
	/**
	 * ͨ���û��ֻ���ѯ��ɫ��Ϣ
	 * @param u_phone
	 * @return
	 */
	public Set<String> getRoles(String u_phone);
	
	/**
	 * ͨ���û��ֻ���ѯȨ����Ϣ
	 * @param u_phone
	 * @return
	 */
	public Set<String> getPermissions(String u_phone);
	
	/**
	 * ͨ���û�����ѯ��ɫ��Ϣ
	 * @param userName
	 * @return
	 */
	public Set<String> findRoles(String iphone);
	
	/**
	 * ͨ���û�����ѯȨ����Ϣ
	 * @param userName
	 * @return
	 */
	public Set<String> findPermissions(String iphone);
	
	/**
	 * ͨ����ɫ��ѯ�û���Ϣ
	 * @param r_id
	 * @return
	 */
	public List<User> findByRoleId(int r_id);
}
