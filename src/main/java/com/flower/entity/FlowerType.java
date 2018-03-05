package com.flower.entity;
/**
 * 鲜花类别实例类
 * @author Administrator
 *
 */
public class FlowerType {
	//鲜花本级类别
	private Integer ftypeId;
	//鲜花上级类别
	private Integer fatherId;
	//类别名称
	private String ftypeName;
	
	public FlowerType() {
		super();
	}

	public FlowerType(Integer ftypeId, Integer fatherId, String ftypeName) {
		super();
		this.ftypeId = ftypeId;
		this.fatherId = fatherId;
		this.ftypeName = ftypeName;
	}

	@Override
	public String toString() {
		return "FlowerType [ftypeId=" + ftypeId + ", fatherId=" + fatherId + ", ftypeName=" + ftypeName + "]";
	}

	public Integer getFtypeId() {
		return ftypeId;
	}

	public void setFtypeId(Integer ftypeId) {
		this.ftypeId = ftypeId;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public String getFtypeName() {
		return ftypeName;
	}

	public void setFtypeName(String ftypeName) {
		this.ftypeName = ftypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fatherId == null) ? 0 : fatherId.hashCode());
		result = prime * result + ((ftypeId == null) ? 0 : ftypeId.hashCode());
		result = prime * result + ((ftypeName == null) ? 0 : ftypeName.hashCode());
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
		FlowerType other = (FlowerType) obj;
		if (fatherId == null) {
			if (other.fatherId != null)
				return false;
		} else if (!fatherId.equals(other.fatherId))
			return false;
		if (ftypeId == null) {
			if (other.ftypeId != null)
				return false;
		} else if (!ftypeId.equals(other.ftypeId))
			return false;
		if (ftypeName == null) {
			if (other.ftypeName != null)
				return false;
		} else if (!ftypeName.equals(other.ftypeName))
			return false;
		return true;
	}
	
}
