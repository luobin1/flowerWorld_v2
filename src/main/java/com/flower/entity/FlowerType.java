package com.flower.entity;
/**
 * �ʻ����ʵ����
 * @author Administrator
 *
 */
public class FlowerType {
	//�ʻ��������
	private Integer ftypeId;
	//�ʻ��ϼ����
	private Integer fatherId;
	//�������
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
