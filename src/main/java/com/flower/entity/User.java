package com.flower.entity;

public class User {
	//用户id，主键
	private Integer u_id;
	//用户手机号
	private String u_phone;
	//用户邮箱
	private String u_mail;
	//用户昵称
	private String u_nname;
	//用户姓名
	private String u_rname;
	//用户地址
	private String u_address;
	//用户密码
	private String u_pwd;
	//角色id
	private Integer r_id;
	
	
	
	private long id;
	private String name;
	
	//zxc
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//zxc
	public Integer getU_id() {
		return u_id;
	}
	
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	public String getU_nname() {
		return u_nname;
	}
	public void setU_nname(String u_nname) {
		this.u_nname = u_nname;
	}
	public String getU_rname() {
		return u_rname;
	}
	public void setU_rname(String u_rname) {
		this.u_rname = u_rname;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((r_id == null) ? 0 : r_id.hashCode());
		result = prime * result + ((u_address == null) ? 0 : u_address.hashCode());
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		result = prime * result + ((u_mail == null) ? 0 : u_mail.hashCode());
		result = prime * result + ((u_nname == null) ? 0 : u_nname.hashCode());
		result = prime * result + ((u_phone == null) ? 0 : u_phone.hashCode());
		result = prime * result + ((u_pwd == null) ? 0 : u_pwd.hashCode());
		result = prime * result + ((u_rname == null) ? 0 : u_rname.hashCode());
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
		User other = (User) obj;
		if (r_id == null) {
			if (other.r_id != null)
				return false;
		} else if (!r_id.equals(other.r_id))
			return false;
		if (u_address == null) {
			if (other.u_address != null)
				return false;
		} else if (!u_address.equals(other.u_address))
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		if (u_mail == null) {
			if (other.u_mail != null)
				return false;
		} else if (!u_mail.equals(other.u_mail))
			return false;
		if (u_nname == null) {
			if (other.u_nname != null)
				return false;
		} else if (!u_nname.equals(other.u_nname))
			return false;
		if (u_phone == null) {
			if (other.u_phone != null)
				return false;
		} else if (!u_phone.equals(other.u_phone))
			return false;
		if (u_pwd == null) {
			if (other.u_pwd != null)
				return false;
		} else if (!u_pwd.equals(other.u_pwd))
			return false;
		if (u_rname == null) {
			if (other.u_rname != null)
				return false;
		} else if (!u_rname.equals(other.u_rname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_phone=" + u_phone + ", u_mail=" + u_mail + ", u_nname=" + u_nname
				+ ", u_rname=" + u_rname + ", u_address=" + u_address + ", u_pwd=" + u_pwd + ", r_id=" + r_id + "]";
	}
	public User(Integer u_id, String u_phone, String u_mail, String u_nname, String u_rname, String u_address,
			String u_pwd, Integer r_id) {
		super();
		this.u_id = u_id;
		this.u_phone = u_phone;
		this.u_mail = u_mail;
		this.u_nname = u_nname;
		this.u_rname = u_rname;
		this.u_address = u_address;
		this.u_pwd = u_pwd;
		this.r_id = r_id;
	}
	public User() {
		super();
	}
	
	
	
}
