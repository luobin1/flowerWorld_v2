package com.flower.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flower.dao.IPayAccountDao;
import com.flower.entity.PayAccount;
import com.flower.service.IPayAccountService;


@SuppressWarnings("restriction")
@Service("payAccountService")
public class PayAccountServiceImpl implements IPayAccountService {

	@Resource
	private IPayAccountDao payAccountDao;
	
	public void addPayAccount(PayAccount payAccount) {
		payAccountDao.addPayAccount(payAccount);

	}

	public void updatePayAccount(PayAccount payAccount) {
		payAccountDao.updatePayAccount(payAccount);

	}

	public PayAccount findByU_id(int u_id) {
		return payAccountDao.findByU_id(u_id);
	}

	public PayAccount findByP_id(int p_id) {
		return payAccountDao.findByP_id(p_id);
	}

}
