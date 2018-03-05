package com.flower.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.flower.dao.INewsDao;
import com.flower.entity.News;
import com.flower.service.INewsService;
import com.flower.util.Page;

@Service("newsService")
public class NewsServiceImpl implements INewsService{
	
	@Resource
	private INewsDao newsDao;
	
	public void addNews(News news) {
		newsDao.addNews(news);
	}

	public List<News> findByU_id(int u_id) {
		return newsDao.findByU_id(u_id);
	}

	public void deleteByN_id(int n_id) {
		newsDao.deleteByN_id(n_id);
		
	}

	public void showProductsByPage(HttpServletRequest request, Model model, int loginUserId) {
		 String pageNow = request.getParameter("pageNow");  
		  
		    Page page = null;  
		  
		    List<News> newss = new ArrayList<News>();  
		  
		    int totalCount = (int) newsDao.findCount(loginUserId);
		  
		    if (pageNow != null) {  
		        page = new Page(totalCount, Integer.parseInt(pageNow));  
		        newss = this.newsDao.selectProductsByPage(page.getStartPos(), page.getPageSize(), loginUserId);  
		    } else {  
		        page = new Page(totalCount, 1);  
		        newss = this.newsDao.selectProductsByPage(page.getStartPos(), page.getPageSize(), loginUserId);  
		    }  
		  
		    model.addAttribute("news", newss);  
		    model.addAttribute("page", page); 
		
	}

	public void deleteFind(List<Integer> list) {
		newsDao.deleteFind(list);
	}

	public News findByN_id(int n_id) {
		return newsDao.findByN_id(n_id);
	}

	public void updateNsign(News news) {
		newsDao.updateNsign(news);
	}

	

}
