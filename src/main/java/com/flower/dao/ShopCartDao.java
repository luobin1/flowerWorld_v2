package com.flower.dao;

import java.util.List;

import com.flower.entity.ShopCart;


public interface ShopCartDao {
	/**
	 * 查询购物车 中的所有商品信息
	 * @return
	 */
	public List<ShopCart> findAll(int userId);
	/**
	 * 根据ID查询单个商品信息
	 * @return
	 */
	public ShopCart findById(int carId);
	/**
	 * 根据ID删除单个商品
	 * @return
	 */
	public boolean delete(int carId);
	/**
	 * 根据ID修改单个商品
	 * @return
	 */
	public boolean update(ShopCart shop);
	/**
	 * 添加商品到购物车
	 * @param shop_cart
	 */
	public void add(ShopCart shop);
	/**
	 * 显示购物车的总金额
	 * @return
	 */
	public double findSum(int userId);
	
	/**
	 * 根据状态和用户ID查询购物车信息
	 * @param userId
	 * @return
	 */
	public List<ShopCart> findAuth(int userId);
	/**
	 * 根据状态和用户ID查询购物车中的flower_id字段
	 * @param userId
	 * @return
	 */
	public List<Integer> findFlowerId(int userId);
	/**
	 * 根据鲜花ID查询购物车单个商品
	 * @param flowerId
	 * @return
	 */
	public ShopCart findByFlowerId(int flowerId);
}
