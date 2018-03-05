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
 * 关于鲜花的相关请求
 * @author 潘春利
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
	 * 管理员主页加载的时候需要获取鲜花列表的方法
	 * @param pageNumber:鲜花分页的页码，如果传入null，则默认返回第一页
	 * @param model：绑定前端所需要的数据 totalPage:总页数，pageNumber：页码，flowers：鲜花列表
	 * @return adminIndexPage.jsp 管理员主页
	 */
	@RequestMapping("loadAdminIndex")
	public String loadAdminIndex(Integer pageNumber, Model model){
		List<Flower> flowers = new ArrayList<Flower>();
		int pageSize = 8;// 每页最大显示数量
		int totalPage = 0;// 总页数，初始页码为1 pageNumber是当前页码
		int totalNumber = flowerService.getAllFlowers().size();// 总共有多少条记录
		if (totalNumber % pageSize != 0) {// 当总条数模除页面最大显示数量不为0
			totalPage = totalNumber / pageSize + 1;
		} else {// 当模除为0，总页数等于
			totalPage = totalNumber / pageSize;
		}
		if (pageNumber == null) {// 当前端没有传页码的时候
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
	 * 获取后台鲜花列表所需要的数据
	 * @param pageNumber:前台传入的页码
	 * @param model：绑定前端页面需要的数据 totalPage：总页数  pageNumber：页码   flowers：查询出来的鲜花列表
	 * @return  flowerList.jsp 返回到后台的鲜花管理页面
	 */
	@RequestMapping("/findFlowers")
	public String getFlowers(Integer pageNumber, Model model) {
		List<Flower> flowers = new ArrayList<Flower>();
		int pageSize = 8;// 每页最大显示数量
		int totalPage = 0;// 总页数，初始页码为1 pageNumber是当前页码
		int totalNumber = flowerService.getAllFlowers().size();// 总共有多少条记录
		if (totalNumber % pageSize != 0) {// 当总条数模除页面最大显示数量不为0
			totalPage = totalNumber / pageSize + 1;
		} else {// 当模除为0，总页数等于
			totalPage = totalNumber / pageSize;
		}
		if (pageNumber == null) {// 当前端没有传页码的时候
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
	 * 访问首页的时候获取数据的方法
	 * @param pageNumber 前端传入的页码
	 * @param model 绑定前端所需要的数据 totalPage：总页数  pageNumber：页码   flowers：查询出来的鲜花列表
	 * @return 返回到首页
	 */
	@RequestMapping("getFlowers")
	public String fistLoad(Integer pageNumber, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Flower> flowers = new ArrayList<Flower>();
		List<FlowerType> flowerTypes = flowerTypeService.findAll();
		session.setAttribute("flowerTypes", flowerTypes);
		int pageSize = 8;// 每页最大显示数量
		int totalPage = 0;// 总页数，初始页码为1 pageNumber是当前页码
		int totalNumber = flowerService.getAllFlowers().size();// 总共有多少条记录
		if (totalNumber % pageSize != 0) {// 当总条数模除页面最大显示数量不为0
			totalPage = totalNumber / pageSize + 1;
		} else {// 当模除为0，总页数等于
			totalPage = totalNumber / pageSize;
		}
		if (pageNumber == null) {// 当前端没有传页码的时候
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
	 * 用户查看单个商品的详细信息
	 * @param flowerId 鲜花id
	 * @param model flower：绑定数据，查询出来的鲜花对象
	 * @return productdetail.jsp，返回到单个商品页面
	 */
	@RequestMapping("/findFlowerById")
	public String getFlowerById(int flowerId, Model model) {
		Flower flower = flowerService.getFlowerById(flowerId);
		model.addAttribute("flower", flower);
		return "productdetail.jsp";
	}

	
	/**
	 * 跳转到修改鲜花页面前的查询信息
	 * @param flowerId 鲜花id
	 * @param model 绑定数据 flower：获取到的鲜花对象 flowerTypes：所有的鲜花分类
	 * @return changePage.jsp 修改鲜花信息的页面
	 */
	@RequestMapping("/toChangeFlowerPage")
	public String changeFlowerInfo(int flowerId, Model model) {
		Flower flower = flowerService.getFlowerById(flowerId);
		List<FlowerType> flowerTypes = flowerTypeService.findAll();
		model.addAttribute("flower", flower);
		model.addAttribute("flowerTypes", flowerTypes);
		return "flowerPage/changePage.jsp";
	}

	// 进行修改信息
	
	/**
	 * 修改鲜花的操作
	 * @param flower 修改后的对象信息
	 * @return 重定向到findFlowers.do
	 */
	@RequestMapping("/changeFlowerInfo")
	public String changeFlower(Flower flower) {
		flowerService.changeFlowerInfo(flower);
		return "redirect:findFlowers.do";
	}
	
	/**
	 * 通过鲜花id进行删除操作
	 * @param flowerId：鲜花的id
	 * @return 重定向到findFlowers.do
	 */
	@RequestMapping("/deleteFlowerById")
	public String deleteFlowerById(int flowerId) {
		flowerService.deleteFlowerById(flowerId);
		return "redirect:findFlowers.do";
	}
	/**
	 * 添加鲜花的操作
	 * @param flowerName 鲜花名称
	 * @param flowerTypeId 鲜花类型的id
	 * @param purposeId 鲜花用途的id
	 * @param material 鲜花的材质
	 * @param packing 鲜花的包装方式
	 * @param flowerLanguage 花语
	 * @param gifts 附送的礼服
	 * @param distribution 配送方式
	 * @param price 单价
	 * @param flowerUrl1 鲜花图片
	 * @return 重定向到findFlowers.do
	 */
	@RequestMapping("addFlower")
	public String addFlower(String flowerName, int flowerTypeId, int purposeId, String material, String packing,
			String flowerLanguage, String gifts, String distribution, double price,String flowerUrl1) {
		// Flower flower2 = new Flower(null,"红玫瑰", 1, 2, "19枝香槟玫瑰，白色石竹梅围绕",
		// "英文纸，咖啡色缎带花结", "和你手牵手漫步海边，在沙滩上画两颗心，心心相印，永不分离。", "下单填写留言，即免费赠送精美贺卡！",
		// "全国 （可配送至全国1000多城市，市区免配送费）", 8888.0, "images/product/image_01.jpg",
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
	 * 鲜花的分类查询
	 * @param flowerTypeId 鲜花的类型id
	 * @param pageNumber 页码
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
		//通过分类查询出鲜花的总条数
		int totalNumber = flowerService.selectFlowerTypeNumber(flowerTypeId);
		int pageMaxSize = 8;//每页显示的最大条数
		int totalPage = 0;//总页数,默认为0
		if(totalNumber % pageMaxSize != 0){//如果不是整数页时
			totalPage = totalNumber / pageMaxSize + 1;
		}else{//如果为整数页
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
		//通过分类查询出鲜花的总条数
		int totalNumber = flowerService.selectFlowerTypeNumber(flowerTypeId);
		int pageMaxSize = 8;//每页显示的最大条数
		int totalPage = 0;//总页数,默认为0
		if(totalNumber % pageMaxSize != 0){//如果不是整数页时
			totalPage = totalNumber / pageMaxSize + 1;
		}else{//如果为整数页
			totalPage = totalNumber / pageMaxSize ;
		}
		List<Flower> flowers = flowerService.selectFlowerByType(flowerTypeId, (pageNumber - 1) * pageMaxSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("flowers", flowers);
		return "index.jsp";
	}
	
	/**
	 * 用户通过鲜花名称查找鲜花的方法
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
		int totalPage = 0;//总页数
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
