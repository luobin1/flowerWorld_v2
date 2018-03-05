package com.flower.entity;

public class Address {
	private Integer a_id;
	private Integer u_id;
	private String a_name;
	private String a_address;
	private String a_Posetal_Code;
	private String a_phone;
	private Integer a_pid;
	private Integer a_cid;
	private Pove pove;
	private City city;
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
	}
	public String getA_Posetal_Code() {
		return a_Posetal_Code;
	}
	public void setA_Posetal_Code(String a_Posetal_Code) {
		this.a_Posetal_Code = a_Posetal_Code;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	public Integer getA_pid() {
		return a_pid;
	}
	public void setA_pid(Integer a_pid) {
		this.a_pid = a_pid;
	}
	public Integer getA_cid() {
		return a_cid;
	}
	public void setA_cid(Integer a_cid) {
		this.a_cid = a_cid;
	}
	public Pove getPove() {
		return pove;
	}
	public void setPove(Pove pove) {
		this.pove = pove;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a_Posetal_Code == null) ? 0 : a_Posetal_Code.hashCode());
		result = prime * result + ((a_address == null) ? 0 : a_address.hashCode());
		result = prime * result + ((a_cid == null) ? 0 : a_cid.hashCode());
		result = prime * result + ((a_id == null) ? 0 : a_id.hashCode());
		result = prime * result + ((a_name == null) ? 0 : a_name.hashCode());
		result = prime * result + ((a_phone == null) ? 0 : a_phone.hashCode());
		result = prime * result + ((a_pid == null) ? 0 : a_pid.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((pove == null) ? 0 : pove.hashCode());
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
		Address other = (Address) obj;
		if (a_Posetal_Code == null) {
			if (other.a_Posetal_Code != null)
				return false;
		} else if (!a_Posetal_Code.equals(other.a_Posetal_Code))
			return false;
		if (a_address == null) {
			if (other.a_address != null)
				return false;
		} else if (!a_address.equals(other.a_address))
			return false;
		if (a_cid == null) {
			if (other.a_cid != null)
				return false;
		} else if (!a_cid.equals(other.a_cid))
			return false;
		if (a_id == null) {
			if (other.a_id != null)
				return false;
		} else if (!a_id.equals(other.a_id))
			return false;
		if (a_name == null) {
			if (other.a_name != null)
				return false;
		} else if (!a_name.equals(other.a_name))
			return false;
		if (a_phone == null) {
			if (other.a_phone != null)
				return false;
		} else if (!a_phone.equals(other.a_phone))
			return false;
		if (a_pid == null) {
			if (other.a_pid != null)
				return false;
		} else if (!a_pid.equals(other.a_pid))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (pove == null) {
			if (other.pove != null)
				return false;
		} else if (!pove.equals(other.pove))
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
		return "Address [a_id=" + a_id + ", u_id=" + u_id + ", a_name=" + a_name + ", a_address=" + a_address
				+ ", a_Posetal_Code=" + a_Posetal_Code + ", a_phone=" + a_phone + ", a_pid=" + a_pid + ", a_cid="
				+ a_cid + ", pove=" + pove + ", city=" + city + "]";
	}
	public Address(Integer a_id, Integer u_id, String a_name, String a_address, String a_Posetal_Code, String a_phone,
			Integer a_pid, Integer a_cid, Pove pove, City city) {
		super();
		this.a_id = a_id;
		this.u_id = u_id;
		this.a_name = a_name;
		this.a_address = a_address;
		this.a_Posetal_Code = a_Posetal_Code;
		this.a_phone = a_phone;
		this.a_pid = a_pid;
		this.a_cid = a_cid;
		this.pove = pove;
		this.city = city;
	}
	public Address() {
		super();
	}
	
	
	
}
