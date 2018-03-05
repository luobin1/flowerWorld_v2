package com.flower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Flower;

public interface IFlowerService {
	/**
	 * 获取所有的鲜花
	 * @return
	 */
	public List<Flower> getAllFlowers();
	/**
	 * 通过鲜花的id查询鲜花信息
	 * @param flowerId
	 * @return
	 */
	public Flower getFlowerById(int flowerId);
	/**
	 * 修改鲜花的信息
	 * @param flower
	 */
	public void changeFlowerInfo(Flower flower);
	/**
	 * 通过鲜花id删除鲜花记录
	 * @param flowerId
	 */
	public void deleteFlowerById(int flowerId);
	
	/**
	 * 添加鲜花信息
	 * @param flower
	 */
	public void addFlowerInfo(Flower flower);
	
	/**
	 * 通过页码查询鲜花信息
	 * @param pageNumber
	 * @return
	 */
	public List<Flower> findFlowerByPage(int pageNumber);
	
	/**
	 * 通过类型查找鲜花列表
	 * @return
	 */
	public List<Flower> selectFlowerByType(int flowerTypeId,int pageNumber);
	
	/**
	 * 查询同一类鲜花的总条数
	 */
	public int selectFlowerTypeNumber(int FlowerTypeId);
	
	/**
	 * 通过鲜花名称的模糊查询
	 * @return
	 */
	public  List<Flower> findSome(String flowerName,Integer pageNumber);
}
