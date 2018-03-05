package com.flower.dao;

import java.util.List;

import com.flower.entity.ShopCart;


public interface ShopCartDao {
	/**
	 * ��ѯ���ﳵ �е�������Ʒ��Ϣ
	 * @return
	 */
	public List<ShopCart> findAll(int userId);
	/**
	 * ����ID��ѯ������Ʒ��Ϣ
	 * @return
	 */
	public ShopCart findById(int carId);
	/**
	 * ����IDɾ��������Ʒ
	 * @return
	 */
	public boolean delete(int carId);
	/**
	 * ����ID�޸ĵ�����Ʒ
	 * @return
	 */
	public boolean update(ShopCart shop);
	/**
	 * �����Ʒ�����ﳵ
	 * @param shop_cart
	 */
	public void add(ShopCart shop);
	/**
	 * ��ʾ���ﳵ���ܽ��
	 * @return
	 */
	public double findSum(int userId);
	
	/**
	 * ����״̬���û�ID��ѯ���ﳵ��Ϣ
	 * @param userId
	 * @return
	 */
	public List<ShopCart> findAuth(int userId);
	/**
	 * ����״̬���û�ID��ѯ���ﳵ�е�flower_id�ֶ�
	 * @param userId
	 * @return
	 */
	public List<Integer> findFlowerId(int userId);
	/**
	 * �����ʻ�ID��ѯ���ﳵ������Ʒ
	 * @param flowerId
	 * @return
	 */
	public ShopCart findByFlowerId(int flowerId);
}
