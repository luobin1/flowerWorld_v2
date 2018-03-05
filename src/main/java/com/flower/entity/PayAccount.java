package com.flower.entity;
/**
 * 预支付账户表
 * @author lily
 *
 */
public class PayAccount {
	//主键
	private Integer p_id;
	//用户
	private Integer u_id;
	//支付名
	private String p_user;
	//支付密码
	private String p_pwd;
	//余额
	private Double p_balance;
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getP_user() {
		return p_user;
	}
	public void setP_user(String p_user) {
		this.p_user = p_user;
	}
	public String getP_pwd() {
		return p_pwd;
	}
	public void setP_pwd(String p_pwd) {
		this.p_pwd = p_pwd;
	}
	public Double getP_balance() {
		return p_balance;
	}
	public void setP_balance(Double p_balance) {
		this.p_balance = p_balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_balance == null) ? 0 : p_balance.hashCode());
		result = prime * result + ((p_id == null) ? 0 : p_id.hashCode());
		result = prime * result + ((p_pwd == null) ? 0 : p_pwd.hashCode());
		result = prime * result + ((p_user == null) ? 0 : p_user.hashCode());
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PayAccount other = (PayAccount) obj;
		if (p_balance == null) {
			if (other.p_balance != null)
				return false;
		} else if (!p_balance.equals(other.p_balance))
			return false;
		if (p_id == null) {
			if (other.p_id != null)
				return false;
		} else if (!p_id.equals(other.p_id))
			return false;
		if (p_pwd == null) {
			if (other.p_pwd != null)
				return false;
		} else if (!p_pwd.equals(other.p_pwd))
			return false;
		if (p_user == null) {
			if (other.p_user != null)
				return false;
		} else if (!p_user.equals(other.p_user))
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PayAccount [p_id=" + p_id + ", u_id=" + u_id + ", p_user=" + p_user + ", p_pwd=" + p_pwd
				+ ", p_balance=" + p_balance + "]";
	}
	public PayAccount(Integer p_id, Integer u_id, String p_user, String p_pwd, Double p_balance) {
		super();
		this.p_id = p_id;
		this.u_id = u_id;
		this.p_user = p_user;
		this.p_pwd = p_pwd;
		this.p_balance = p_balance;
	}
	public PayAccount() {
		super();
	}
	
	
	
}
