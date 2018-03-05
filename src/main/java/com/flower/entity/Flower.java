package com.flower.entity;
/**
 * 鲜花类
 * @author 潘春利
 *
 */
public class Flower {
	private Integer flowerId;//鲜花id
	private String flowerName;//鲜花名称
	private Integer flowerTypeId;//鲜花类型id
	private Integer purposeId;//鲜花用途
	private String material;//鲜花材质
	private String packing;//打包方式
	private String flowerLanguage;//花语
	private String gifts;//买鲜花附送的礼物
	private String distribution;//配送方式
	private Double price;//单价
	private String flowerUrl1;//鲜花对应链接1
	private String flowerUrl2;//鲜花对应链接2
	private String flowerUrl3;//鲜花对应链接3
	private String flowerUrl4;//鲜花对应链接4
	public Integer getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public Integer getFlowerTypeId() {
		return flowerTypeId;
	}
	public void setFlowerTypeId(Integer flowerTypeId) {
		this.flowerTypeId = flowerTypeId;
	}
	public Integer getPurposeId() {
		return purposeId;
	}
	public void setPurposeId(Integer purposeId) {
		this.purposeId = purposeId;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getFlowerLanguage() {
		return flowerLanguage;
	}
	public void setFlowerLanguage(String flowerLanguage) {
		this.flowerLanguage = flowerLanguage;
	}
	public String getGifts() {
		return gifts;
	}
	public void setGifts(String gifts) {
		this.gifts = gifts;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFlowerUrl1() {
		return flowerUrl1;
	}
	public void setFlowerUrl1(String flowerUrl1) {
		this.flowerUrl1 = flowerUrl1;
	}
	public String getFlowerUrl2() {
		return flowerUrl2;
	}
	public void setFlowerUrl2(String flowerUrl2) {
		this.flowerUrl2 = flowerUrl2;
	}
	public String getFlowerUrl3() {
		return flowerUrl3;
	}
	public void setFlowerUrl3(String flowerUrl3) {
		this.flowerUrl3 = flowerUrl3;
	}
	public String getFlowerUrl4() {
		return flowerUrl4;
	}
	public void setFlowerUrl4(String flowerUrl4) {
		this.flowerUrl4 = flowerUrl4;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distribution == null) ? 0 : distribution.hashCode());
		result = prime * result + ((flowerId == null) ? 0 : flowerId.hashCode());
		result = prime * result + ((flowerLanguage == null) ? 0 : flowerLanguage.hashCode());
		result = prime * result + ((flowerName == null) ? 0 : flowerName.hashCode());
		result = prime * result + ((flowerTypeId == null) ? 0 : flowerTypeId.hashCode());
		result = prime * result + ((flowerUrl1 == null) ? 0 : flowerUrl1.hashCode());
		result = prime * result + ((flowerUrl2 == null) ? 0 : flowerUrl2.hashCode());
		result = prime * result + ((flowerUrl3 == null) ? 0 : flowerUrl3.hashCode());
		result = prime * result + ((flowerUrl4 == null) ? 0 : flowerUrl4.hashCode());
		result = prime * result + ((gifts == null) ? 0 : gifts.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((packing == null) ? 0 : packing.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((purposeId == null) ? 0 : purposeId.hashCode());
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
		Flower other = (Flower) obj;
		if (distribution == null) {
			if (other.distribution != null)
				return false;
		} else if (!distribution.equals(other.distribution))
			return false;
		if (flowerId == null) {
			if (other.flowerId != null)
				return false;
		} else if (!flowerId.equals(other.flowerId))
			return false;
		if (flowerLanguage == null) {
			if (other.flowerLanguage != null)
				return false;
		} else if (!flowerLanguage.equals(other.flowerLanguage))
			return false;
		if (flowerName == null) {
			if (other.flowerName != null)
				return false;
		} else if (!flowerName.equals(other.flowerName))
			return false;
		if (flowerTypeId == null) {
			if (other.flowerTypeId != null)
				return false;
		} else if (!flowerTypeId.equals(other.flowerTypeId))
			return false;
		if (flowerUrl1 == null) {
			if (other.flowerUrl1 != null)
				return false;
		} else if (!flowerUrl1.equals(other.flowerUrl1))
			return false;
		if (flowerUrl2 == null) {
			if (other.flowerUrl2 != null)
				return false;
		} else if (!flowerUrl2.equals(other.flowerUrl2))
			return false;
		if (flowerUrl3 == null) {
			if (other.flowerUrl3 != null)
				return false;
		} else if (!flowerUrl3.equals(other.flowerUrl3))
			return false;
		if (flowerUrl4 == null) {
			if (other.flowerUrl4 != null)
				return false;
		} else if (!flowerUrl4.equals(other.flowerUrl4))
			return false;
		if (gifts == null) {
			if (other.gifts != null)
				return false;
		} else if (!gifts.equals(other.gifts))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (packing == null) {
			if (other.packing != null)
				return false;
		} else if (!packing.equals(other.packing))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (purposeId == null) {
			if (other.purposeId != null)
				return false;
		} else if (!purposeId.equals(other.purposeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flower [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerTypeId=" + flowerTypeId
				+ ", purposeId=" + purposeId + ", material=" + material + ", packing=" + packing + ", flowerLanguage="
				+ flowerLanguage + ", gifts=" + gifts + ", distribution=" + distribution + ", price=" + price
				+ ", flowerUrl1=" + flowerUrl1 + ", flowerUrl2=" + flowerUrl2 + ", flowerUrl3=" + flowerUrl3
				+ ", flowerUrl4=" + flowerUrl4 + "]";
	}
	public Flower(Integer flowerId, String flowerName, Integer flowerTypeId, Integer purposeId, String material,
			String packing, String flowerLanguage, String gifts, String distribution, Double price, String flowerUrl1,
			String flowerUrl2, String flowerUrl3, String flowerUrl4) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.flowerTypeId = flowerTypeId;
		this.purposeId = purposeId;
		this.material = material;
		this.packing = packing;
		this.flowerLanguage = flowerLanguage;
		this.gifts = gifts;
		this.distribution = distribution;
		this.price = price;
		this.flowerUrl1 = flowerUrl1;
		this.flowerUrl2 = flowerUrl2;
		this.flowerUrl3 = flowerUrl3;
		this.flowerUrl4 = flowerUrl4;
	}
	public Flower() {
		super();
	}
	
}
