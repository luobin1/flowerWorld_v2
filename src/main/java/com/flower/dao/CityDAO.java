package  com.flower.dao;

import java.util.List;

import com.flower.entity.City;


public interface CityDAO {
	public List<City> findByid(int pid);
	
	public City findBycid(int cid);
}
