package com.flower.entity;

import java.sql.Timestamp;

/**
 * 信息表
 * @author lily
 *
 */
public class News {
	//主键
	private Integer n_id;
	//用户的id
	private Integer u_id;
	//要发送的信息
	private String n_info;
	//要接收的用户
	private Integer u_number;
	//创建信息的时间
	private Timestamp n_time;
	//
	private String n_theme;
	
	private Integer n_sign;

	public Integer getN_id() {
		return n_id;
	}

	public void setN_id(Integer n_id) {
		this.n_id = n_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getN_info() {
		return n_info;
	}

	public void setN_info(String n_info) {
		this.n_info = n_info;
	}

	public Integer getU_number() {
		return u_number;
	}

	public void setU_number(Integer u_number) {
		this.u_number = u_number;
	}

	public Timestamp getN_time() {
		return n_time;
	}

	public void setN_time(Timestamp n_time) {
		this.n_time = n_time;
	}

	public String getN_theme() {
		return n_theme;
	}

	public void setN_theme(String n_theme) {
		this.n_theme = n_theme;
	}

	public Integer getN_sign() {
		return n_sign;
	}

	public void setN_sign(Integer n_sign) {
		this.n_sign = n_sign;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((n_id == null) ? 0 : n_id.hashCode());
		result = prime * result + ((n_info == null) ? 0 : n_info.hashCode());
		result = prime * result + ((n_sign == null) ? 0 : n_sign.hashCode());
		result = prime * result + ((n_theme == null) ? 0 : n_theme.hashCode());
		result = prime * result + ((n_time == null) ? 0 : n_time.hashCode());
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		result = prime * result + ((u_number == null) ? 0 : u_number.hashCode());
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
		News other = (News) obj;
		if (n_id == null) {
			if (other.n_id != null)
				return false;
		} else if (!n_id.equals(other.n_id))
			return false;
		if (n_info == null) {
			if (other.n_info != null)
				return false;
		} else if (!n_info.equals(other.n_info))
			return false;
		if (n_sign == null) {
			if (other.n_sign != null)
				return false;
		} else if (!n_sign.equals(other.n_sign))
			return false;
		if (n_theme == null) {
			if (other.n_theme != null)
				return false;
		} else if (!n_theme.equals(other.n_theme))
			return false;
		if (n_time == null) {
			if (other.n_time != null)
				return false;
		} else if (!n_time.equals(other.n_time))
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		if (u_number == null) {
			if (other.u_number != null)
				return false;
		} else if (!u_number.equals(other.u_number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [n_id=" + n_id + ", u_id=" + u_id + ", n_info=" + n_info + ", u_number=" + u_number + ", n_time="
				+ n_time + ", n_theme=" + n_theme + ", n_sign=" + n_sign + "]";
	}

	public News(Integer n_id, Integer u_id, String n_info, Integer u_number, Timestamp n_time, String n_theme,
			Integer n_sign) {
		super();
		this.n_id = n_id;
		this.u_id = u_id;
		this.n_info = n_info;
		this.u_number = u_number;
		this.n_time = n_time;
		this.n_theme = n_theme;
		this.n_sign = n_sign;
	}

	public News() {
		super();
	}
	
	
	
	
}
