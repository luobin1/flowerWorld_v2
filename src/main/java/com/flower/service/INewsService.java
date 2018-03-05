package com.flower.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.flower.entity.News;

public interface INewsService {
	//新建信息
	public void addNews(News news);
	//查询信息
	public List<News> findByU_id(int u_id);
	//查询信息
	public News findByN_id(int n_id);
	//删除信息
	public void deleteByN_id(int n_id);
	
	public void updateNsign(News news);
	
	//批量刪除
	public void deleteFind(List<Integer> list);
	
	public void showProductsByPage(HttpServletRequest request,Model model,int loginUserId);
	 
}
