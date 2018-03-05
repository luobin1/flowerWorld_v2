package com.flower.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flower.dao.PoveDAO;
import com.flower.entity.Pove;
import com.flower.service.PoveService;

@Service("poveSerivce")
public class PoveSerivceImpl implements PoveService {
	@Resource
	private PoveDAO poveDao;

	public List<Pove> findAllPove() {
		return poveDao.findAllPove();
	}

	public Pove findBypid(int pid) {
		return poveDao.findBypid(pid);
	}

}
