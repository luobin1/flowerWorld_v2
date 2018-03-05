package com.flower.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.flower.entity.News;

public interface INewsService {
	//�½���Ϣ
	public void addNews(News news);
	//��ѯ��Ϣ
	public List<News> findByU_id(int u_id);
	//��ѯ��Ϣ
	public News findByN_id(int n_id);
	//ɾ����Ϣ
	public void deleteByN_id(int n_id);
	
	public void updateNsign(News news);
	
	//�����h��
	public void deleteFind(List<Integer> list);
	
	public void showProductsByPage(HttpServletRequest request,Model model,int loginUserId);
	 
}
