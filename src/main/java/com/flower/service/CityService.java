package  com.flower.service;

import java.util.List;


import com.flower.entity.City;


public interface CityService {
	public List<City> findByid(int pid);
	
	public City findBycid(int cid);
}
