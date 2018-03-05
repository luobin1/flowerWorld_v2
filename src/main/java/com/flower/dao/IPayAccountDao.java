package com.flower.dao;

import com.flower.entity.PayAccount;

public interface IPayAccountDao {
	//�½��˻�
	public void addPayAccount(PayAccount payAccount);
	//�޸����
	public void updatePayAccount(PayAccount payAccount);
	//��ѯ�˻�
	public PayAccount findByU_id(int u_id);
	
	//��ѯ�˻�
	public PayAccount findByP_id(int p_id);
	
}
