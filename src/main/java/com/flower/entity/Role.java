package com.flower.entity;
/**
 * 角色表的实体类 
 * @author Administrator
 *
 */
public class Role {
	
	private Integer rId;
	private String rName;
	private Integer pId;
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pId == null) ? 0 : pId.hashCode());
		result = prime * result + ((rId == null) ? 0 : rId.hashCode());
		result = prime * result + ((rName == null) ? 0 : rName.hashCode());
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
		Role other = (Role) obj;
		if (pId == null) {
			if (other.pId != null)
				return false;
		} else if (!pId.equals(other.pId))
			return false;
		if (rId == null) {
			if (other.rId != null)
				return false;
		} else if (!rId.equals(other.rId))
			return false;
		if (rName == null) {
			if (other.rName != null)
				return false;
		} else if (!rName.equals(other.rName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + ", pId=" + pId + "]";
	}
	public Role(Integer rId, String rName, Integer pId) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.pId = pId;
	}
	public Role() {
		super();
	}
	
}
