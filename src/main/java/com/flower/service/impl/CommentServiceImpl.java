package com.flower.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.flower.dao.ICommentDao;
import com.flower.entity.Comment;
import com.flower.service.ICommentService;
import com.flower.util.Page;


@Service("commentService")
public class CommentServiceImpl implements ICommentService {
	
	@Resource
	private ICommentDao commentDao;
	
	public void addComment(Comment comment) {
		commentDao.addComment(comment);

	}

	public List<Comment> findByU_id(int u_id) {
		return commentDao.findByU_id(u_id);
	}

	public List<Comment> findByF_id(int f_id) {
		return commentDao.findByF_id(f_id);
	}

	public void deleteByC_id(int c_id) {
		commentDao.deleteByC_id(c_id);

	}

	public void findCommentLimit(Integer flowerId, Integer u_id,HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");  
		  
	    Page page = null;  
	  
	    List<Comment> comment = new ArrayList<Comment>(); 
	  
	    int totalCount = (int) commentDao.findCount(u_id,flowerId);
	  
	    if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	        comment = this.commentDao.findCommentLimit(flowerId,u_id, page.getPageSize(), page.getStartPos());  
	    } else {  
	        page = new Page(totalCount, 1);  
	        comment = this.commentDao.findCommentLimit(flowerId,u_id, page.getPageSize(), page.getStartPos());  
	    }  
	  
	    model.addAttribute("comments", comment);  
	    model.addAttribute("page", page); 
	}

}
