package com.flower.service;


import com.flower.entity.PayAccount;

public interface IPayAccountService {
	//�½��˻�
	public void addPayAccount(PayAccount payAccount);
	//�޸����
	public void updatePayAccount(PayAccount payAccount);
	//��ѯ���
	public PayAccount findByU_id(int u_id);
	//��ѯ�˻�
		public PayAccount findByP_id(int p_id);
}
