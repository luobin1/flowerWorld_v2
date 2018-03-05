package com.flower.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.Flower;
import com.flower.entity.FlowerType;
import com.flower.service.IFlowerService;
import com.flower.service.IFlowerTypeService;
import com.google.gson.JsonObject;

/**
 * �����ʻ����������
 * @author �˴���
 *
 */
@RequestMapping("/flower")
@Controller("flowerController")
public class FlowerController {

	@Autowired
	private IFlowerService flowerService;
	
	@Autowired
	private IFlowerTypeService flowerTypeService;
	
	
	/**
	 * ����Ա��ҳ���ص�ʱ����Ҫ��ȡ�ʻ��б�ķ���
	 * @param pageNumber:�ʻ���ҳ��ҳ�룬�������null����Ĭ�Ϸ��ص�һҳ
	 * @param model����ǰ������Ҫ������ totalPage:��ҳ����pageNumber��ҳ�룬flowers���ʻ��б�
	 * @return adminIndexPage.jsp ����Ա��ҳ
	 */
	@RequestMapping("loadAdminIndex")
	public String loadAdminIndex(Integer pageNumber, Model model){
		List<Flower> flowers = new ArrayList<Flower>();
		int pageSize = 8;// ÿҳ�����ʾ����
		int totalPage = 0;// ��ҳ������ʼҳ��Ϊ1 pageNumber�ǵ�ǰҳ��
		int totalNumber = flowerService.getAllFlowers().size();// �ܹ��ж�������¼
		if (totalNumber % pageSize != 0) {// ��������ģ��ҳ�������ʾ������Ϊ0
			totalPage = totalNumber / pageSize + 1;
		} else {// ��ģ��Ϊ0����ҳ������
			totalPage = totalNumber / pageSize;
		}
		if (pageNumber == null) {// ��ǰ��û�д�ҳ���ʱ��
			pageNumber = 1;
		}
		if (pageNumber == 1) {
			flowers = flowerService.findFlowerByPage(0);
		} else {
			flowers = flowerService.findFlowerByPage((pageNumber - 1) * pageSize);
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("flowers", flowers);
		return "adminPages/adminIndexPage.jsp";
	}
	
	
	/**
	 * ��ȡ��̨�ʻ��б�����Ҫ������
	 * @param pageNumber:ǰ̨�����ҳ��
	 * @param model����ǰ��ҳ����Ҫ������ totalPage����ҳ��  pageNumber��ҳ��   flowers����ѯ�������ʻ��б�
	 * @return  flowerList.jsp ���ص���̨���ʻ�����ҳ��
	 */
	@RequestMapping("/findFlowers")
	public String getFlowers(Integer pageNumber, Model model) {
		List<Flower> flowers = new ArrayList<Flower>();
		int pageSize = 8;// ÿҳ�����ʾ����
		int totalPage = 0;// ��ҳ������ʼҳ��Ϊ1 pageNumber�ǵ�ǰҳ��
		int totalNumber = flowerService.getAllFlowers().size();// �ܹ��ж�������¼
		if (totalNumber % pageSize != 0) {// ��������ģ��ҳ�������ʾ������Ϊ0
			totalPage = totalNumber / pageSize + 1;
		} else {// ��ģ��Ϊ0����ҳ������
			totalPage = totalNumber / pageSize;
		}
		if (pageNumber == null) {// ��ǰ��û�д�ҳ���ʱ��
			pageNumber = 1;
		}
		if (pageNumber == 1) {
			flowers = flowerService.findFlowerByPage(0);
		} else {
			flowers = flowerService.findFlowerByPage((pageNumber - 1) * pageSize);
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("flowers", flowers);
		return "flowerPage/flowerList.jsp";
	}
	/**
	 * ������ҳ��ʱ���ȡ���ݵķ���
	 * @param pageNumber ǰ�˴����ҳ��
	 * @param model ��ǰ������Ҫ������ totalPage����ҳ��  pageNumber��ҳ��   flowers����ѯ�������ʻ��б�
	 * @return ���ص���ҳ
	 */
	@RequestMapping("getFlowers")
	public String fistLoad(Integer pageNumber, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Flower> flowers = new ArrayList<Flower>();
		List<FlowerType> flowerTypes = flowerTypeService.findAll();
		session.setAttribute("flowerTypes", flowerTypes);
		int pageSize = 8;// ÿҳ�����ʾ����
		int totalPage = 0;// ��ҳ������ʼҳ��Ϊ1 pageNumber�ǵ�ǰҳ��
		int totalNumber = flowerService.getAllFlowers().size();// �ܹ��ж�������¼
		if (totalNumber % pageSize != 0) {// ��������ģ��ҳ�������ʾ������Ϊ0
			totalPage = totalNumber / pageSize + 1;
		} else {// ��ģ��Ϊ0����ҳ������
			totalPage = totalNumber / pageSize;
		}
		if (pageNumber == null) {// ��ǰ��û�д�ҳ���ʱ��
			pageNumber = 1;
		}
		if (pageNumber == 1) {
			flowers = flowerService.findFlowerByPage(0);
		} else {
			flowers = flowerService.findFlowerByPage((pageNumber - 1) * pageSize);
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("flowers", flowers);
		return "index.jsp";
	}
	
	/**
	 * �û��鿴������Ʒ����ϸ��Ϣ
	 * @param flowerId �ʻ�id
	 * @param model flower�������ݣ���ѯ�������ʻ�����
	 * @return productdetail.jsp�����ص�������Ʒҳ��
	 */
	@RequestMapping("/findFlowerById")
	public String getFlowerById(int flowerId, Model model) {
		Flower flower = flowerService.getFlowerById(flowerId);
		model.addAttribute("flower", flower);
		return "productdetail.jsp";
	}

	
	/**
	 * ��ת���޸��ʻ�ҳ��ǰ�Ĳ�ѯ��Ϣ
	 * @param flowerId �ʻ�id
	 * @param model ������ flower����ȡ�����ʻ����� flowerTypes�����е��ʻ�����
	 * @return changePage.jsp �޸��ʻ���Ϣ��ҳ��
	 */
	@RequestMapping("/toChangeFlowerPage")
	public String changeFlowerInfo(int flowerId, Model model) {
		Flower flower = flowerService.getFlowerById(flowerId);
		List<FlowerType> flowerTypes = flowerTypeService.findAll();
		model.addAttribute("flower", flower);
		model.addAttribute("flowerTypes", flowerTypes);
		return "flowerPage/changePage.jsp";
	}

	// �����޸���Ϣ
	
	/**
	 * �޸��ʻ��Ĳ���
	 * @param flower �޸ĺ�Ķ�����Ϣ
	 * @return �ض���findFlowers.do
	 */
	@RequestMapping("/changeFlowerInfo")
	public String changeFlower(Flower flower) {
		flowerService.changeFlowerInfo(flower);
		return "redirect:findFlowers.do";
	}
	
	/**
	 * ͨ���ʻ�id����ɾ������
	 * @param flowerId���ʻ���id
	 * @return �ض���findFlowers.do
	 */
	@RequestMapping("/deleteFlowerById")
	public String deleteFlowerById(int flowerId) {
		flowerService.deleteFlowerById(flowerId);
		return "redirect:findFlowers.do";
	}
	/**
	 * ����ʻ��Ĳ���
	 * @param flowerName �ʻ�����
	 * @param flowerTypeId �ʻ����͵�id
	 * @param purposeId �ʻ���;��id
	 * @param material �ʻ��Ĳ���
	 * @param packing �ʻ��İ�װ��ʽ
	 * @param flowerLanguage ����
	 * @param gifts ���͵����
	 * @param distribution ���ͷ�ʽ
	 * @param price ����
	 * @param flowerUrl1 �ʻ�ͼƬ
	 * @return �ض���findFlowers.do
	 */
	@RequestMapping("addFlower")
	public String addFlower(String flowerName, int flowerTypeId, int purposeId, String material, String packing,
			String flowerLanguage, String gifts, String distribution, double price,String flowerUrl1) {
		// Flower flower2 = new Flower(null,"��õ��", 1, 2, "19֦����õ�壬��ɫʯ��÷Χ��",
		// "Ӣ��ֽ������ɫ�д�����", "������ǣ���������ߣ���ɳ̲�ϻ������ģ�������ӡ���������롣", "�µ���д���ԣ���������;����ؿ���",
		// "ȫ�� ����������ȫ��1000����У����������ͷѣ�", 8888.0, "images/product/image_01.jpg",
		// "xxx", "xxx", "xxx");
		Flower flower = new Flower();
		flower.setFlowerName(flowerName);
		flower.setFlowerTypeId(flowerTypeId);
		flower.setPurposeId(purposeId);
		flower.setMaterial(material);
		flower.setPacking(packing);
		flower.setFlowerLanguage(flowerLanguage);
		flower.setGifts(gifts);
		flower.setDistribution(distribution);
		flower.setPrice(price);
		flower.setFlowerUrl1(flowerUrl1);
		flowerService.addFlowerInfo(flower);
		return "redirect:findFlowers.do";
	}
	/**
	 * �ʻ��ķ����ѯ
	 * @param flowerTypeId �ʻ�������id
	 * @param pageNumber ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("getFlowerByType")
	@ResponseBody
	public JSONObject getFlowerByType(Integer flowerTypeId,Integer pageNumber){
		JSONObject json = new JSONObject();
		if(pageNumber == null){
			pageNumber = 1;
		}
		//ͨ�������ѯ���ʻ���������
		int totalNumber = flowerService.selectFlowerTypeNumber(flowerTypeId);
		int pageMaxSize = 8;//ÿҳ��ʾ���������
		int totalPage = 0;//��ҳ��,Ĭ��Ϊ0
		if(totalNumber % pageMaxSize != 0){//�����������ҳʱ
			totalPage = totalNumber / pageMaxSize + 1;
		}else{//���Ϊ����ҳ
			totalPage = totalNumber / pageMaxSize ;
		}
		List<Flower> flowers = flowerService.selectFlowerByType(flowerTypeId, (pageNumber - 1) * pageMaxSize);
//		model.addAttribute("flowers", flowers);
//		model.addAttribute("pageNumber", pageNumber);
//		model.addAttribute("totalPage", totalPage);
		json.put("totalPage", totalPage);
		json.put("pageNumber", pageNumber);
		json.put("flowers", flowers);
		return json;
	}
	
	@RequestMapping("getFlowerByTypeId")
	public String getFlowerByTypeId(Integer flowerTypeId,Integer pageNumber,Model model){
		if(pageNumber == null){
			pageNumber = 1;
		}
		//ͨ�������ѯ���ʻ���������
		int totalNumber = flowerService.selectFlowerTypeNumber(flowerTypeId);
		int pageMaxSize = 8;//ÿҳ��ʾ���������
		int totalPage = 0;//��ҳ��,Ĭ��Ϊ0
		if(totalNumber % pageMaxSize != 0){//�����������ҳʱ
			totalPage = totalNumber / pageMaxSize + 1;
		}else{//���Ϊ����ҳ
			totalPage = totalNumber / pageMaxSize ;
		}
		List<Flower> flowers = flowerService.selectFlowerByType(flowerTypeId, (pageNumber - 1) * pageMaxSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("flowers", flowers);
		return "index.jsp";
	}
	
	/**
	 * �û�ͨ���ʻ����Ʋ����ʻ��ķ���
	 * @param str
	 * @return
	 */
	@RequestMapping("findSome")
	@ResponseBody
	public JSONObject findSome(String flowerName,Integer pageNumber){
		JSONObject json = new JSONObject();
		if(pageNumber == null){
			pageNumber = 1;
		}
		int size = flowerService.findSome(flowerName,null).size();
		List<Flower> flowers = flowerService.findSome(flowerName,(pageNumber - 1) * 8);
		if(size == 0){
			return null;
		}
		int totalPage = 0;//��ҳ��
		if(size % 8 != 0){
			totalPage = size / 8 +1;
		}else{
			totalPage = size / 8;
		}
		json.put("list", flowers);
		json.put("totalPage", totalPage);
		json.put("pageNumber", pageNumber);
		return json;
	}
}
