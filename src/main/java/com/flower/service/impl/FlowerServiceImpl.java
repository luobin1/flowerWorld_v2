package com.flower.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower.dao.IFlowerDao;
import com.flower.entity.Flower;
import com.flower.service.IFlowerService;

@Service("flowerService")
public class FlowerServiceImpl implements IFlowerService {

	@Autowired
	private IFlowerDao flowerDao;
	
	public List<Flower> getAllFlowers() {
		// TODO Auto-generated method stub
		return flowerDao.findAll();
	}
	/**
	 * ͨ���ʻ���Ż�ȡ�ʻ���Ϣ
	 */
	public Flower getFlowerById(int flowerId) {
		
		return flowerDao.findFlowerById(flowerId);
	}
	/**
	 * �޸ĵ����ʻ�����Ϣ
	 */
	public void changeFlowerInfo(Flower flower) {	
		flowerDao.updateFlower(flower);	
	}
	/**
	 * ͨ���ʻ�idɾ���ʻ���¼
	 */
	public void deleteFlowerById(int flowerId) {
		flowerDao.deleteFlowerById(flowerId);
	}
	/**
	 * ����ʻ���Ϣ
	 * @param flower
	 */
	public void addFlowerInfo(Flower flower) {
		flowerDao.addFlower(flower);	
	}
	/**
	 * �ʻ��ķ�ҳ��ѯ
	 */
	public List<Flower> findFlowerByPage(int pageNumber) {
		
		return flowerDao.findFlowerByPage(pageNumber);
	}
	public List<Flower> selectFlowerByType(int flowerTypeId,int pageNumber) {
		
		return flowerDao.selectFlowerByType(flowerTypeId, pageNumber);
	}
	public int selectFlowerTypeNumber(int FlowerTypeId) {
		
		return flowerDao.selectFlowerTypeNumber(FlowerTypeId);
	}
	
	public List<Flower> findSome(String flowerName,Integer pageNumber) {
		return flowerDao.findSome(flowerName,pageNumber);
	}

}
