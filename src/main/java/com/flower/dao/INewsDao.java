package com.flower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.News;

public interface INewsDao {
	//�½���Ϣ
	public void addNews(News news);
	//��ѯ��Ϣ
	public List<News> findByU_id(int u_id);
	//��ѯ��Ϣ
	public News findByN_id(int n_id);
	//ɾ����Ϣ
	public void deleteByN_id(int n_id);
	//�����h��
	public void deleteFind(List<Integer> list);
	
	public void updateNsign(News news);
	 
	
	
	public List<News> selectProductsByPage(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="u_id") Integer u_id);  
	 
	public long findCount(@Param(value="u_id") Integer u_id);  
}
