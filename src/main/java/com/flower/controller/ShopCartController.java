package com.flower.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.flower.entity.ShopCart;
import com.flower.entity.User;
import com.flower.service.IFlowerService;

@Controller
@RequestMapping("to")
public class ShopCartController {
	@Autowired
	private com.flower.service.ShopCartService shopCartService;
	@Autowired
	private IFlowerService flowerService;

	/**
	 * 根据用户ID查询所有状态为0的购物车记录
	 * 
	 * @param model：向页面传输数据
	 * @param request：获取session
	 * @return：返回到购物车页面
	 */
	@RequestMapping("/findAllShopCar.do")
	public String findAllShopCar(Model model, HttpServletRequest request) {

		// String str = request.getSession().getAttribute("user").toString();
		// String aa = str.substring(25,36);
		// 根据session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 根据用户ID查询购物车中所有状态为0的记录
		List<ShopCart> shop = shopCartService.findAll(user.getU_id());
		// 将shop传到页面
		model.addAttribute("ShopCartList", shop);
		// 判断查询出来的内容是否为空集合。如果为空就不查询total字段的和
		if (shop.toString() != "[]") {
			// 如果不为空集合就将状态为0的记录的subtotal字段的值相加并传到页面（user_id）
			double totalSum = shopCartService.findSum(user.getU_id());
			model.addAttribute("totalSum", totalSum);
		}
		// 返回到购物车页面
		return "shopcart.jsp";
	}

	/**
	 * 购物车的修改和total字段的和的查询
	 * 
	 * @param shopCart：页面传过来的一个购物车对象
	 * @param request：向页面传输数据
	 * @return：将total字段的和作为json对象传到页面
	 */
	@RequestMapping("/order.do")
	@ResponseBody
	public JSONObject toOrder(ShopCart shopCart, HttpServletRequest request) {
		// 页面传入一个shopcart对象过来，直接调用修改方法
		shopCartService.update(shopCart);
		// 创建一个json对象
		JSONObject json = new JSONObject();
		// List<ShopCart> shop = shopCartService.findAll();
		// request.setAttribute("ShopCartList", shop);
		// int totalSum = shopCartService.findSum();
		// request.setAttribute("totalSum", totalSum);
		// 根据session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 根据用户ID查询出当前用户并且状态为0的所有记录
		List<ShopCart> shop = shopCartService.findAll(user.getU_id());
		// 根据用户ID查询购物车中状态为0的total字段的和
		double totalSum = shopCartService.findSum(user.getU_id());
		// model.addAttribute("totalSum", totalSum);
		// request.setAttribute("totalSum", totalSum);
		// 将totalSum加入到json中
		json.put("totalSum", totalSum);
		// 将json传到页面
		return json;

	}

	/**
	 * 根据购物车ID进行删除
	 * 
	 * @param carId：页面传过来的购物车ID
	 * @return：重定向到购物车页面
	 */
	@RequestMapping("/delete.do")
	public String delete(int carId) {
		// 页面传入一个carId，根据carId删除数据
		int i = Integer.valueOf(carId);
		// 调用删除方法
		shopCartService.delete(i);
		// 重定向到购物车页面
		return "redirect:findAllShopCar.do";
	}

	// @RequestMapping("/update.do")
	// @ResponseBody
	// public String update(ShopCart shopCart,HttpServletRequest request,Model
	// model){
	// if(shopCartService.update(shopCart)){
	// return "redirect:order.do";
	// }else{
	// return "error";
	// }
	// }
	/**
	 * 查询出购物车单条记录
	 * 
	 * @param carId：页面传过来的购物车ID
	 * @param request：向页面传输数据
	 * @return：返回到购物车页面
	 */
	@RequestMapping("byid.do")
	public String findById(int carId, HttpServletRequest request) {
		// 根据carId查询出单条记录并传给页面
		request.setAttribute("ShopCartList", shopCartService.findById(carId));
		// 返回到购物车页面
		return "shopcart.jsp";
	}

	/**
	 * 对购物车实现增加或者修改
	 * 
	 * @param flower_id:页面穿过来的鲜花ID
	 * @param request：获取session
	 * @param model：向页面传数据
	 * @return：重定向到购物车页面
	 */
	@RequestMapping("addShopCart.do")
	public String add(Integer flower_id, HttpServletRequest request, Model model) {
		// 通过session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 验证用户是否登录，没登录就回到登录页面
		if (user == null) {
			return "redirect:/flower/sign.do";
		}
		// 获取购物车表中现有的数据进行判断，为空就直接增加记录，不为空就循环遍历
		// 根据页面穿过来的鲜花ID与状态为0进行查询，如果存在记录就将数量加一
		// 如果不存在记录就新增加一条记录
		List<ShopCart> shops = shopCartService.findAll(user.getU_id());
		if (shops.toString() == "[]") {
			// 新建一个购物车实体类
			ShopCart shopCart = new ShopCart();
			// 给其字段赋值
			shopCart.setFlowerId(flower_id);
			shopCart.setNumber(1);
			shopCart.setUserId(user.getU_id());
			shopCart.setImagesUri(flowerService.getFlowerById(flower_id).getFlowerUrl1());
			shopCart.setSubtotal(flowerService.getFlowerById(flower_id).getPrice());
			shopCart.setTotal(flowerService.getFlowerById(flower_id).getPrice() * 1);
			shopCart.setFlor(0);
			// 调用增加方法添加记录
			shopCartService.add(shopCart);
		}
		// 如果该商品已存在购物车中并且状态为0，就不添加新的记录，数量加一就行
		for (int i = 0; i < shops.size(); i++) {
			int dd = shops.get(i).getFlowerId();
			// 如果flower_id已存在
			if (dd == flower_id) {
				// 如果根据flower_id与状态查询出对应记录
				ShopCart shopa = shops.get(i);
				// 将原有的数量加一
				shopa.setNumber(shopa.getNumber() + 1);
				// 小计就等于加一后的数量*单价
				shopa.setTotal((shopa.getNumber() + 1) * shopa.getSubtotal());
				// 调用修改方法
				shopCartService.update(shopa);
				// 如果根据flower_id与状态查询不到记录，就让购物车表添加一条记录
			} else if (dd != flower_id) {
				// 如果登录了，就获取页面的商品信息并添加到购物车表
				ShopCart shopCart = new ShopCart();
				shopCart.setFlowerId(flower_id);
				shopCart.setNumber(1);
				shopCart.setUserId(user.getU_id());
				shopCart.setImagesUri(flowerService.getFlowerById(flower_id).getFlowerUrl1());
				shopCart.setSubtotal(flowerService.getFlowerById(flower_id).getPrice());
				shopCart.setTotal(flowerService.getFlowerById(flower_id).getPrice() * 1);
				shopCart.setFlor(0);
				// 调用增加方法添加记录
				shopCartService.add(shopCart);
				// 该方法执行一次就必须跳出循环
				break;
			}
		}
		// 重定向到购物车页面
		return "redirect:findAllShopCar.do";
	}

	// public String add(HttpServletRequest request,Model model){
	// String id = request.getParameter("flower_id");
	// HttpSession session = request.getSession();
	// String number;
	// if(request.getParameter("number")==null){
	// number = "1";
	// }else{
	// number = request.getParameter("number");
	// }
	// Flower flower = flowerService.getFlowerById(Integer.valueOf(id));
	//
	// ShopCart shopCart = new ShopCart();
	// shopCart.setFlowerId(flower.getFlowerId());
	// shopCart.setImagesUri(flower.getFlowerUrl1());
	// shopCart.setNumber(Integer.valueOf(number));
	// shopCart.setSubtotal(flower.getPrice());
	// shopCart.setTotal(Integer.valueOf(number)*flower.getPrice());
	// //String str = session.getAttribute("user").toString();
	// User u = (User)session.getAttribute("user");
	// if(u != null){
	// shopCart.setUserId(u.getU_id());
	// shopCartService.add(shopCart);
	// return "redirect:findAllShopCar.do";
	// }
	// System.out.println(u);
	// System.out.println(flower);
	// System.out.println(shopCart);
	//// String aa = str.substring(25,36);
	////// User user =userService.getByU_phone(str);
	////// shopCart.setUserId(user.getU_id());
	//// if(request.getSession().getAttribute("user")!=null){
	//// User user =userService.getByU_phone(aa);
	//// shopCart.setUserId(user.getU_id());
	//// shopCartService.add(shopCart);
	//// return "redirect:findAllShopCar.do";
	//// }
	// return "login.html";
	// }
	/**
	 * 查询购物车的历史记录
	 * 
	 * @param model：
	 *            向页面传输数据
	 * @param request：
	 *            获取session
	 * @return
	 */

	@RequestMapping("/findAuth.do")
	public String findAuth(Model model, HttpServletRequest request) {
		// 根据session获取用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 根据user_id查询状态为1的购物车记录
		List<ShopCart> shop = shopCartService.findAuth(user.getU_id());
		model.addAttribute("ShopCartList", shop);
		// 返回购物车历史记录页面
		return "shopcart2.jsp";
	}
}
