package com.flower.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.flower.entity.Comment;

public interface ICommentService {
	//�������
	public void addComment(Comment comment);
	//��ѯ�Լ�������
	public List<Comment> findByU_id(int u_id);
	//��ѯ�ʻ�����������
	public List<Comment> findByF_id(int f_id);
	//����Աɾ������
	public void deleteByC_id(int c_id);
	
	
	/**
	 * 
	 * ���۷�ҳ��ѯ
	 */
	public void findCommentLimit(Integer flowerId,Integer u_id,HttpServletRequest request,Model model);
}
