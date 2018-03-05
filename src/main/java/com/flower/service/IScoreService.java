package com.flower.service;

import com.flower.entity.Score;

public interface IScoreService {
	
	public Score findByUid(int u_id);
	
	public void updateIntegral(Score integral);
	
	public void addIntegral(Score integral);
}
