package com.flower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.Comment;

public interface ICommentDao {
	//添加评论
	public void addComment(Comment comment);
	//查询自己的评论
	public List<Comment> findByU_id(int u_id);
	//查询鲜花的所有评论
	public List<Comment> findByF_id(int f_id);
	//管理员删除评论
	public void deleteByC_id(int c_id);
	
	public long findCount(@Param(value="u_id") Integer u_id,@Param("flowerId") Integer flowerId); 
	
	
	/**
	 * 
	 * 评论分页查询
	 */
	public List<Comment> findCommentLimit(@Param("flowerId") Integer flowerId,@Param(value="u_id") Integer u_id,@Param(value="pageSize") Integer pageSize,@Param(value="startPos") Integer startPos);
}
