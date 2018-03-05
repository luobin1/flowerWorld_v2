package com.flower.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.flower.entity.Comment;

public interface ICommentService {
	//添加评论
	public void addComment(Comment comment);
	//查询自己的评论
	public List<Comment> findByU_id(int u_id);
	//查询鲜花的所有评论
	public List<Comment> findByF_id(int f_id);
	//管理员删除评论
	public void deleteByC_id(int c_id);
	
	
	/**
	 * 
	 * 评论分页查询
	 */
	public void findCommentLimit(Integer flowerId,Integer u_id,HttpServletRequest request,Model model);
}
