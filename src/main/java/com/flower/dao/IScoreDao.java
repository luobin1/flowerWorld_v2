package com.flower.dao;

import com.flower.entity.Score;

public interface IScoreDao {
	
	public Score findByUid(int u_id);
	
	public void updateIntegral(Score integral);
	
	public void addIntegral(Score integral);
}
