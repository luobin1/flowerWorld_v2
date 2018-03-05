package com.flower.dao;

import java.util.List;

import com.flower.entity.Flower;
import com.flower.entity.FlowerType;

public interface IFlowerTypeDao {
	//查询所有分类列表
	public List<FlowerType> findAll();
	//添加分类列表
	public void addFlowerType(FlowerType flowertype);
	//修改分类列表
	public void updateFlowerType(FlowerType flowertype);
	//查询单个分类列表
	public FlowerType findFlowerType(int ftypeId);
	//删除分类列表
	public void deleteByType(int ftypeId);
	//查询所有上级分类
	public List<FlowerType> finAllSuper();
	//查询分类名称
	public FlowerType findByTypeName(String ftypeName);
	//查询单个父分类名字
	public FlowerType findSuperName(int ftypeId);
}
