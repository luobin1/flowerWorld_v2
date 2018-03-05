package com.flower.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Flower;

public interface IFlowerService {
	/**
	 * ��ȡ���е��ʻ�
	 * @return
	 */
	public List<Flower> getAllFlowers();
	/**
	 * ͨ���ʻ���id��ѯ�ʻ���Ϣ
	 * @param flowerId
	 * @return
	 */
	public Flower getFlowerById(int flowerId);
	/**
	 * �޸��ʻ�����Ϣ
	 * @param flower
	 */
	public void changeFlowerInfo(Flower flower);
	/**
	 * ͨ���ʻ�idɾ���ʻ���¼
	 * @param flowerId
	 */
	public void deleteFlowerById(int flowerId);
	
	/**
	 * ����ʻ���Ϣ
	 * @param flower
	 */
	public void addFlowerInfo(Flower flower);
	
	/**
	 * ͨ��ҳ���ѯ�ʻ���Ϣ
	 * @param pageNumber
	 * @return
	 */
	public List<Flower> findFlowerByPage(int pageNumber);
	
	/**
	 * ͨ�����Ͳ����ʻ��б�
	 * @return
	 */
	public List<Flower> selectFlowerByType(int flowerTypeId,int pageNumber);
	
	/**
	 * ��ѯͬһ���ʻ���������
	 */
	public int selectFlowerTypeNumber(int FlowerTypeId);
	
	/**
	 * ͨ���ʻ����Ƶ�ģ����ѯ
	 * @return
	 */
	public  List<Flower> findSome(String flowerName,Integer pageNumber);
}
