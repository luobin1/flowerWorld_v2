package com.flower.service;

import java.util.List;

import com.flower.entity.Order;

public interface IOrderService {

	/**
	 * ���Ӷ���
	 * @param order
	 */
	public void addOrder(Order order);
	/**
	 * �鿴���ж���
	 */
	public List<Order> findAll(int userId);
	/**
	 * ����IDɾ������
	 * @param orderId
	 * @return
	 */
	public boolean delete(int orderId);
	/**
	 * ����ID��ѯ����
	 * @param orderId
	 * @return
	 */
	public Order findById(int orderId);
	/**
	 * �޸Ķ�����Ϣ
	 * @param order
	 * @return
	 */
	public boolean update(Order order);
	
	/**
	 * ���ݶ���״̬��ѯ
	 * @return
	 */
	public List<Order> findStatOder(int userId);

	/**
	 * ����ID��״̬��ѯ����
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public Order findByIds(int orderId);
}