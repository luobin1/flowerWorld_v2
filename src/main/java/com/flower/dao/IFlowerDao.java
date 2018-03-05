package com.flower.dao;
/**
 * 鲜花类的dao层
 * @author 潘春利
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Flower;

public interface IFlowerDao {
	/**
	 * 查询所有鲜花的信息
	 * @return
	 */
	public List<Flower> findAll();
	
	/**
	 * 通过鲜花的编号查找鲜花
	 * @param flowerId
	 * @return
	 */
	public Flower findFlowerById(int flowerId);
	
	/**
	 * 通过鲜花的类型查找鲜花
	 * @param type
	 * @return
	 */
	public List<Flower> findByType(int type);
	
	/**
	 * 添加鲜花
	 * @param flower
	 */
	public void addFlower(Flower flower);
	
	/**
	 * 通过鲜花id删除鲜花
	 * @param flowerId
	 */
	public void deleteFlowerById(int flowerId);
	
	/**
	 * 修改鲜花信息
	 * @param flower
	 */
	public void updateFlower(Flower flower);
	
	/**
	 * 实现分页查询
	 */
	public List<Flower> findFlowerByPage(int pageNumber);
	
	/**
	 * 通过类型查找鲜花列表
	 * @return
	 */
	public List<Flower> selectFlowerByType(@Param("flowerTypeId")int flowerTypeId,@Param("pageNumber")int pageNumber);
	
	/**
	 * 查询同一类鲜花的总条数
	 */
	public int selectFlowerTypeNumber(@Param("flowerTypeId")int FlowerTypeId);
	
	/**
	 * 通过鲜花名称的模糊查询
	 * @return
	 */
	public  List<Flower> findSome(@Param("flowerName")String flowerName,@Param("pageNumber")Integer pageNumber);
}
