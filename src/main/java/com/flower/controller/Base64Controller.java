package com.flower.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.Flower;
import com.flower.service.IFlowerService;
import com.flower.util.Base64Util;
import com.flower.util.FinalParam;

/**
 * 包含了对鲜花信息修改和上传是图片的上传方法
 * @author 潘春利
 *
 */
@Controller
@RequestMapping("img")
public class Base64Controller {
	
	@Autowired
	private IFlowerService flowerService;
	
	/**
	 * 文件上传
	 * @param img：图片的base64编码
	 * @param flowerId：鲜花的id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/upload")
	public JSONObject upload(String img,int flowerId){
		Flower flower = new Flower();
		
		JSONObject json = new JSONObject();
			Date d = new Date();
			String name = d.getTime()+"";
			System.out.println("我是上传请求:"+ name);
			if(Base64Util.generateImage(img.split(",")[1], name))
			{
				json.put("state","success");
				json.put("names", name);
				json.put("msg","图片修改成功！");
				flower.setFlowerId(flowerId);
				flower.setFlowerUrl1(FinalParam.savePath+name+".jpg");
				flowerService.changeFlowerInfo(flower);
			}else{
				json.put("state","fail");
				json.put("names", name);
			}	
		return json;
	}
	
	/**
	 * 增加鲜花
	 * @param img:图片的base64编码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addImg")
	public JSONObject addImg(String img){
		
		JSONObject json = new JSONObject();
			Date d = new Date();
			String name = d.getTime()+" ";
			System.out.println("我是添加请求:"+FinalParam.savePath + name);
			if(Base64Util.generateImage(img.split(",")[1], name))
			{
				json.put("state","success");
				json.put("names", FinalParam.savePath + name);
			}else{
				json.put("state","fail");
				json.put("names", FinalParam.savePath + name);
			}	
		return json;
	}
}
