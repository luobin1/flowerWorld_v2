package com.flower.dao;

import java.util.List;

import com.flower.entity.Flower;
import com.flower.entity.FlowerType;

public interface IFlowerTypeDao {
	//��ѯ���з����б�
	public List<FlowerType> findAll();
	//��ӷ����б�
	public void addFlowerType(FlowerType flowertype);
	//�޸ķ����б�
	public void updateFlowerType(FlowerType flowertype);
	//��ѯ���������б�
	public FlowerType findFlowerType(int ftypeId);
	//ɾ�������б�
	public void deleteByType(int ftypeId);
	//��ѯ�����ϼ�����
	public List<FlowerType> finAllSuper();
	//��ѯ��������
	public FlowerType findByTypeName(String ftypeName);
	//��ѯ��������������
	public FlowerType findSuperName(int ftypeId);
}
