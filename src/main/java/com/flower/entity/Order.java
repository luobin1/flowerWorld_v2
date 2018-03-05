package com.flower.entity;

import java.util.Date;

public class Order {
	private Integer orderId;//订单ID
	private String payMethod;//付款方式
	private Integer flowerId;//鲜花ID
	private String deliAddress;//收货地址
	private String name;//物流信息
	private String phone;//积分奖励
	private Date creatTime;//创建时间
	private String orderNumber;//订单号
	private String rnumber;//商户订单号
	private Integer userId;//用户ID
	private Integer carId;//购物车ID
	private int flora;//状态
	

	


	

	public Order(Integer orderId, String payMethod, Integer flowerId, String deliAddress, String name, String phone,
			Date creatTime, String orderNumber, String rnumber, Integer userId, Integer carId, int flora) {
		super();
		this.orderId = orderId;
		this.payMethod = payMethod;
		this.flowerId = flowerId;
		this.deliAddress = deliAddress;
		this.name = name;
		this.phone = phone;
		this.creatTime = creatTime;
		this.orderNumber = orderNumber;
		this.rnumber = rnumber;
		this.userId = userId;
		this.carId = carId;
		this.flora = flora;
	}







	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", payMethod=" + payMethod + ", flowerId=" + flowerId + ", deliAddress="
				+ deliAddress + ", name=" + name + ", phone=" + phone + ", creatTime=" + creatTime + ", orderNumber="
				+ orderNumber + ", rnumber=" + rnumber + ", userId=" + userId + ", carId=" + carId + ", flora=" + flora
				+ "]";
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((creatTime == null) ? 0 : creatTime.hashCode());
		result = prime * result + ((deliAddress == null) ? 0 : deliAddress.hashCode());
		result = prime * result + flora;
		result = prime * result + ((flowerId == null) ? 0 : flowerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((payMethod == null) ? 0 : payMethod.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((rnumber == null) ? 0 : rnumber.hashCode());
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
		Order other = (Order) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (creatTime == null) {
			if (other.creatTime != null)
				return false;
		} else if (!creatTime.equals(other.creatTime))
			return false;
		if (deliAddress == null) {
			if (other.deliAddress != null)
				return false;
		} else if (!deliAddress.equals(other.deliAddress))
			return false;
		if (flora != other.flora)
			return false;
		if (flowerId == null) {
			if (other.flowerId != null)
				return false;
		} else if (!flowerId.equals(other.flowerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (payMethod == null) {
			if (other.payMethod != null)
				return false;
		} else if (!payMethod.equals(other.payMethod))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (rnumber == null) {
			if (other.rnumber != null)
				return false;
		} else if (!rnumber.equals(other.rnumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}







	public Integer getOrderId() {
		return orderId;
	}







	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}







	public String getPayMethod() {
		return payMethod;
	}







	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}







	public Integer getFlowerId() {
		return flowerId;
	}







	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
	}







	public String getDeliAddress() {
		return deliAddress;
	}







	public void setDeliAddress(String deliAddress) {
		this.deliAddress = deliAddress;
	}







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public String getPhone() {
		return phone;
	}







	public void setPhone(String phone) {
		this.phone = phone;
	}







	public Date getCreatTime() {
		return creatTime;
	}







	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}







	public String getOrderNumber() {
		return orderNumber;
	}







	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}







	public String getRnumber() {
		return rnumber;
	}







	public void setRnumber(String rnumber) {
		this.rnumber = rnumber;
	}







	public Integer getUserId() {
		return userId;
	}







	public void setUserId(Integer userId) {
		this.userId = userId;
	}







	public Integer getCarId() {
		return carId;
	}







	public void setCarId(Integer carId) {
		this.carId = carId;
	}







	public int getFlora() {
		return flora;
	}







	public void setFlora(int flora) {
		this.flora = flora;
	}







	public Order() {
		super();
	}
	
	
}
