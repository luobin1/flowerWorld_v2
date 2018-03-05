package com.flower.dao;
/**
 * �ʻ����dao��
 * @author �˴���
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Flower;

public interface IFlowerDao {
	/**
	 * ��ѯ�����ʻ�����Ϣ
	 * @return
	 */
	public List<Flower> findAll();
	
	/**
	 * ͨ���ʻ��ı�Ų����ʻ�
	 * @param flowerId
	 * @return
	 */
	public Flower findFlowerById(int flowerId);
	
	/**
	 * ͨ���ʻ������Ͳ����ʻ�
	 * @param type
	 * @return
	 */
	public List<Flower> findByType(int type);
	
	/**
	 * ����ʻ�
	 * @param flower
	 */
	public void addFlower(Flower flower);
	
	/**
	 * ͨ���ʻ�idɾ���ʻ�
	 * @param flowerId
	 */
	public void deleteFlowerById(int flowerId);
	
	/**
	 * �޸��ʻ���Ϣ
	 * @param flower
	 */
	public void updateFlower(Flower flower);
	
	/**
	 * ʵ�ַ�ҳ��ѯ
	 */
	public List<Flower> findFlowerByPage(int pageNumber);
	
	/**
	 * ͨ�����Ͳ����ʻ��б�
	 * @return
	 */
	public List<Flower> selectFlowerByType(@Param("flowerTypeId")int flowerTypeId,@Param("pageNumber")int pageNumber);
	
	/**
	 * ��ѯͬһ���ʻ���������
	 */
	public int selectFlowerTypeNumber(@Param("flowerTypeId")int FlowerTypeId);
	
	/**
	 * ͨ���ʻ����Ƶ�ģ����ѯ
	 * @return
	 */
	public  List<Flower> findSome(@Param("flowerName")String flowerName,@Param("pageNumber")Integer pageNumber);
}
