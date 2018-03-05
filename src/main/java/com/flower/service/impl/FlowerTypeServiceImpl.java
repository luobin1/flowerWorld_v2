package com.flower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.flower.dao.IFlowerTypeDao;
import com.flower.entity.FlowerType;
import com.flower.service.IFlowerTypeService;
@Service  
@Transactional
public class FlowerTypeServiceImpl implements IFlowerTypeService{
	@Autowired
	private IFlowerTypeDao typeDao;
	
	public List<FlowerType> findAll() {
		return  typeDao.findAll();
	}

	public void addFlowerType(FlowerType flowertype) {
		typeDao.addFlowerType(flowertype);
		
	}

	public void updateFlowerType(FlowerType flowertype) {
		typeDao.updateFlowerType(flowertype);
		
	}

	public FlowerType findFlowerType(int ftypeId) {
		return typeDao.findFlowerType(ftypeId);
	}

	public void deleteByType(int ftypeId) {
		typeDao.deleteByType(ftypeId);
	}

	public List<FlowerType> finAllSuper() {
		return typeDao.finAllSuper();
	}

	public FlowerType findByTypeName(String ftypeName) {
		return typeDao.findByTypeName(ftypeName);
	}

	public FlowerType findSuperName(int ftypeId) {
		return typeDao.findSuperName(ftypeId);
	}
}
