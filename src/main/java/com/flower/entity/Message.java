package com.flower.entity;

import java.util.Date;
/**
 * ��Ϣ��
 * @author senly
 */
public class Message {

	public String id;
	//������
	public String from;
	//����������
	public String fromName;
	//������
	public String to;
	//���͵��ı�
	public String text;
	//��������
	public Date date;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
