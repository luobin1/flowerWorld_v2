package com.flower.dao;

import com.flower.entity.PayAccount;

public interface IPayAccountDao {
	//新建账户
	public void addPayAccount(PayAccount payAccount);
	//修改余额
	public void updatePayAccount(PayAccount payAccount);
	//查询账户
	public PayAccount findByU_id(int u_id);
	
	//查询账户
	public PayAccount findByP_id(int p_id);
	
}
