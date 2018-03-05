package com.flower.dao;

import com.flower.entity.Integral;

public interface IIntegralDao {
	public Integral findByUid(int u_id);
	
	public void updateIntegral(Integral integral);
	
	public void addIntegral(Integral integral);
}
