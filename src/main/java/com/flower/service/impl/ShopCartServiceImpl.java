package com.flower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flower.dao.ShopCartDao;
import com.flower.entity.ShopCart;
import com.flower.service.ShopCartService;

@Service  
@Transactional
public class ShopCartServiceImpl implements ShopCartService{

	@Autowired
	private ShopCartDao shopCart;
	
	public List<ShopCart> findAll(int userId) {
//		List<ShopCart> list = shopCart.findAll();
		return shopCart.findAll(userId);
	}

	

	

	

	

	
	public ShopCart findById(int carId) {
		// TODO Auto-generated method stub
		return shopCart.findById(carId);
	}

	
	public void add(ShopCart shop) {
		// TODO Auto-generated method stub
		shopCart.add(shop);
	}










	
	public boolean delete(int carId) {
		// TODO Auto-generated method stub
		return shopCart.delete(carId);
	}










	
	public boolean update(ShopCart shop) {
		// TODO Auto-generated method stub
		return shopCart.update(shop);
	}










	public double findSum(int userId) {
		// TODO Auto-generated method stub
		return shopCart.findSum(userId);
	}










	public List<ShopCart> findAuth(int userId) {
		// TODO Auto-generated method stub
		return shopCart.findAuth(userId);
	}










	public List<Integer> findFlowerId(int userId) {
		// TODO Auto-generated method stub
		return shopCart.findFlowerId(userId);
	}










	public ShopCart findByFlowerId(int flowerId) {
		// TODO Auto-generated method stub
		return shopCart.findByFlowerId(flowerId);
	}
	

}
