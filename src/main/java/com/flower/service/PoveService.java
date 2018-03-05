package com.flower.service;

import java.util.List;

import com.flower.entity.Pove;


public interface PoveService {
	public List<Pove> findAllPove();
	
	public Pove findBypid(int pid);
}
