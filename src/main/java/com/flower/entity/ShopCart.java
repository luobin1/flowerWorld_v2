package com.flower.entity;

import java.util.List;

public class ShopCart {
	private Integer carId;//购物车ID
	private Integer flowerId;//鲜花ID
	private Integer number;//商品数量
	private Double subtotal;//商品价格
	private Double total;//商品小计
	private String imagesUri;//图片地址
	private Integer userId;//用户ID
	private int flor;//状态
	
	public ShopCart(Integer carId, Integer flowerId, Integer number, Double subtotal, Double total, String imagesUri,
			Integer userId, int flor) {
		super();
		this.carId = carId;
		this.flowerId = flowerId;
		this.number = number;
		this.subtotal = subtotal;
		this.total = total;
		this.imagesUri = imagesUri;
		this.userId = userId;
		this.flor = flor;
	}

	@Override
	public String toString() {
		return "ShopCart [carId=" + carId + ", flowerId=" + flowerId + ", number=" + number + ", subtotal=" + subtotal
				+ ", total=" + total + ", imagesUri=" + imagesUri + ", userId=" + userId + ", flor=" + flor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + flor;
		result = prime * result + ((flowerId == null) ? 0 : flowerId.hashCode());
		result = prime * result + ((imagesUri == null) ? 0 : imagesUri.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		ShopCart other = (ShopCart) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (flor != other.flor)
			return false;
		if (flowerId == null) {
			if (other.flowerId != null)
				return false;
		} else if (!flowerId.equals(other.flowerId))
			return false;
		if (imagesUri == null) {
			if (other.imagesUri != null)
				return false;
		} else if (!imagesUri.equals(other.imagesUri))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (subtotal == null) {
			if (other.subtotal != null)
				return false;
		} else if (!subtotal.equals(other.subtotal))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getImagesUri() {
		return imagesUri;
	}

	public void setImagesUri(String imagesUri) {
		this.imagesUri = imagesUri;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getFlor() {
		return flor;
	}

	public void setFlor(int flor) {
		this.flor = flor;
	}

	public ShopCart() {
		super();
	}
	
	
}
