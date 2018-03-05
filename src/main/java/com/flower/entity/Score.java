package com.flower.entity;

public class Score {
	private Integer s__id;
	
	private Integer u_id;
	
	private Integer s_integral;

	public Integer getS__id() {
		return s__id;
	}

	public void setS__id(Integer s__id) {
		this.s__id = s__id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getS_integral() {
		return s_integral;
	}

	public void setS_integral(Integer s_integral) {
		this.s_integral = s_integral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s__id == null) ? 0 : s__id.hashCode());
		result = prime * result + ((s_integral == null) ? 0 : s_integral.hashCode());
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
		Score other = (Score) obj;
		if (s__id == null) {
			if (other.s__id != null)
				return false;
		} else if (!s__id.equals(other.s__id))
			return false;
		if (s_integral == null) {
			if (other.s_integral != null)
				return false;
		} else if (!s_integral.equals(other.s_integral))
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
		return "Score [s__id=" + s__id + ", u_id=" + u_id + ", s_integral=" + s_integral + "]";
	}

	public Score(Integer s__id, Integer u_id, Integer s_integral) {
		super();
		this.s__id = s__id;
		this.u_id = u_id;
		this.s_integral = s_integral;
	}

	public Score() {
		super();
	}

	
	

}
