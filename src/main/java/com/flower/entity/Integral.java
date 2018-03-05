package com.flower.entity;

public class Integral {
	private Integer i_id;
	
	private Integer u_id;
	
	private Integer integral;

	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((i_id == null) ? 0 : i_id.hashCode());
		result = prime * result + ((integral == null) ? 0 : integral.hashCode());
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
		Integral other = (Integral) obj;
		if (i_id == null) {
			if (other.i_id != null)
				return false;
		} else if (!i_id.equals(other.i_id))
			return false;
		if (integral == null) {
			if (other.integral != null)
				return false;
		} else if (!integral.equals(other.integral))
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
		return "Integral [i_id=" + i_id + ", u_id=" + u_id + ", integral=" + integral + "]";
	}

	public Integral(Integer i_id, Integer u_id, Integer integral) {
		super();
		this.i_id = i_id;
		this.u_id = u_id;
		this.integral = integral;
	}

	public Integral() {
		super();
	}
	
	
	

}
