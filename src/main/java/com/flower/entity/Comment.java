package com.flower.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
/**
 * 评论表
 * @author lily
 *
 */
public class Comment {
	//主键
	private Integer c_id;
	//用户
	private Integer u_id;
	//要评论的鲜花
	private Integer f_id;
	//评论内容
	private String c_comment;
	//创建评论的时间
	private Date c_time;
	
	private Flower flower;
	
	private User user;

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getC_comment() {
		return c_comment;
	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}

	public Date getC_time() {
		return c_time;
	}

	public void setC_time(Date c_time) {
		this.c_time = c_time;
	}

	public Flower getFlower() {
		return flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_comment == null) ? 0 : c_comment.hashCode());
		result = prime * result + ((c_id == null) ? 0 : c_id.hashCode());
		result = prime * result + ((c_time == null) ? 0 : c_time.hashCode());
		result = prime * result + ((f_id == null) ? 0 : f_id.hashCode());
		result = prime * result + ((flower == null) ? 0 : flower.hashCode());
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Comment other = (Comment) obj;
		if (c_comment == null) {
			if (other.c_comment != null)
				return false;
		} else if (!c_comment.equals(other.c_comment))
			return false;
		if (c_id == null) {
			if (other.c_id != null)
				return false;
		} else if (!c_id.equals(other.c_id))
			return false;
		if (c_time == null) {
			if (other.c_time != null)
				return false;
		} else if (!c_time.equals(other.c_time))
			return false;
		if (f_id == null) {
			if (other.f_id != null)
				return false;
		} else if (!f_id.equals(other.f_id))
			return false;
		if (flower == null) {
			if (other.flower != null)
				return false;
		} else if (!flower.equals(other.flower))
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [c_id=" + c_id + ", u_id=" + u_id + ", f_id=" + f_id + ", c_comment=" + c_comment + ", c_time="
				+ c_time + ", flower=" + flower + ", user=" + user + "]";
	}

	public Comment(Integer c_id, Integer u_id, Integer f_id, String c_comment, Date c_time, Flower flower, User user) {
		super();
		this.c_id = c_id;
		this.u_id = u_id;
		this.f_id = f_id;
		this.c_comment = c_comment;
		this.c_time = c_time;
		this.flower = flower;
		this.user = user;
	}

	public Comment() {
		super();
	}
	
	
	
	
}
