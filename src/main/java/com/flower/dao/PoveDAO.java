package com.flower.dao;

import java.util.List;

import com.flower.entity.Pove;


public interface PoveDAO {
	public List<Pove> findAllPove();
	
	public Pove findBypid(int pid);
}
