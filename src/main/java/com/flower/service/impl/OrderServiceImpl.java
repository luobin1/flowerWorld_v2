package com.flower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.dao.IOrderDao;
import com.flower.entity.Order;
import com.flower.service.IOrderService;
@Service  
@Transactional
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private IOrderDao orderDao;
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.addOrder(order);
	}
	
	public List<Order> findAll(int userId) {
		// TODO Auto-generated method stub
		return orderDao.findAll(userId);
	}

	public boolean delete(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.delete(orderId);
	}

	public Order findById(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.findById(orderId);
	}

	public boolean update(Order order) {
		// TODO Auto-generated method stub
		return orderDao.update(order);
	}
	
	public List<Order> findStatOder(int userId) {
		// TODO Auto-generated method stub
		return orderDao.findStatOder(userId);
	}

	public Order findByIds(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.findByIds(orderId);
	}
}
