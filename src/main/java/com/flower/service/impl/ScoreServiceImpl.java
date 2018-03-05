package com.flower.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flower.dao.IScoreDao;
import com.flower.entity.Score;
import com.flower.service.IScoreService;

@SuppressWarnings("restriction")
@Service("scoreService")
public class ScoreServiceImpl implements IScoreService {

	@Resource
	private IScoreDao integraDao;
	
	public Score findByUid(int u_id) {
		
		return integraDao.findByUid(u_id);
	}

	public void updateIntegral(Score integral) {
		integraDao.updateIntegral(integral);

	}

	public void addIntegral(Score integral) {
		integraDao.addIntegral(integral);

	}

}
