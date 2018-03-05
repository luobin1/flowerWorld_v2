package com.flower.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flower.dao.CityDAO;
import com.flower.entity.City;
import com.flower.service.CityService;

@Service("citySerivce")
public class CitySerivceImpl implements CityService {

	@Resource
	private CityDAO cityDao;
	
	public List<City> findByid(int pid) {
		return cityDao.findByid(pid);
	}

	public City findBycid(int cid) {
		return cityDao.findBycid(cid);
	}

}
