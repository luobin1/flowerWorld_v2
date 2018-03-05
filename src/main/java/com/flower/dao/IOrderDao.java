package com.flower.dao;

import java.util.List;

import com.flower.entity.Order;

public interface IOrderDao {
	/**
	 * 添加订单
	 * @param order
	 */
	public void addOrder(Order order);
	/**
	 * 查看所有订单
	 */
	public List<Order> findAll(int userId);
	/**
	 * 根据ID删除订单
	 * @param orderId
	 * @return
	 */
	public boolean delete(int orderId);
	/**
	 * 根据ID查询订单
	 * @param orderId
	 * @return
	 */
	public Order findById(int orderId);
	/**
	 * 根据ID和状态查询订单
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public Order findByIds(int orderId);
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public boolean update(Order order);
	
	/**
	 * 根据订单状态查询
	 * @return
	 */
	public List<Order> findStatOder(int userId);
}
