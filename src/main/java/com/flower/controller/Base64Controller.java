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
 * �����˶��ʻ���Ϣ�޸ĺ��ϴ���ͼƬ���ϴ�����
 * @author �˴���
 *
 */
@Controller
@RequestMapping("img")
public class Base64Controller {
	
	@Autowired
	private IFlowerService flowerService;
	
	/**
	 * �ļ��ϴ�
	 * @param img��ͼƬ��base64����
	 * @param flowerId���ʻ���id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/upload")
	public JSONObject upload(String img,int flowerId){
		Flower flower = new Flower();
		
		JSONObject json = new JSONObject();
			Date d = new Date();
			String name = d.getTime()+"";
			System.out.println("�����ϴ�����:"+ name);
			if(Base64Util.generateImage(img.split(",")[1], name))
			{
				json.put("state","success");
				json.put("names", name);
				json.put("msg","ͼƬ�޸ĳɹ���");
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
	 * �����ʻ�
	 * @param img:ͼƬ��base64����
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addImg")
	public JSONObject addImg(String img){
		
		JSONObject json = new JSONObject();
			Date d = new Date();
			String name = d.getTime()+" ";
			System.out.println("�����������:"+FinalParam.savePath + name);
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
