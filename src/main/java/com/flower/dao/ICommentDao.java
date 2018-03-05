package com.flower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Comment;

public interface ICommentDao {
	//�������
	public void addComment(Comment comment);
	//��ѯ�Լ�������
	public List<Comment> findByU_id(int u_id);
	//��ѯ�ʻ�����������
	public List<Comment> findByF_id(int f_id);
	//����Աɾ������
	public void deleteByC_id(int c_id);
	
	public long findCount(@Param(value="u_id") Integer u_id,@Param("flowerId") Integer flowerId); 
	
	
	/**
	 * 
	 * ���۷�ҳ��ѯ
	 */
	public List<Comment> findCommentLimit(@Param("flowerId") Integer flowerId,@Param(value="u_id") Integer u_id,@Param(value="pageSize") Integer pageSize,@Param(value="startPos") Integer startPos);
}
