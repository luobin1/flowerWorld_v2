package com.flower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flower.entity.News;

public interface INewsDao {
	//新建信息
	public void addNews(News news);
	//查询信息
	public List<News> findByU_id(int u_id);
	//查询信息
	public News findByN_id(int n_id);
	//删除信息
	public void deleteByN_id(int n_id);
	//批量刪除
	public void deleteFind(List<Integer> list);
	
	public void updateNsign(News news);
	 
	
	
	public List<News> selectProductsByPage(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="u_id") Integer u_id);  
	 
	public long findCount(@Param(value="u_id") Integer u_id);  
}
