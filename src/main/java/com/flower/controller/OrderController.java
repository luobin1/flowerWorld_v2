package com.flower.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flower.entity.Flower;
import com.flower.entity.Order;
import com.flower.entity.ShopCart;
import com.flower.entity.User;
import com.flower.service.IFlowerService;
import com.flower.service.IOrderService;
import com.flower.service.IUserService;
import com.flower.service.ShopCartService;
import com.flower.util.RandomOrder;

@Controller
@RequestMapping("/to")
public class OrderController {
	@Autowired 
	private IOrderService orderService;
	@Autowired
	private ShopCartService shopCartService;
	@Autowired
	private IFlowerService flowerService;
	@Autowired
	private IUserService userService;
	/**
	 * 订单表的添加与购物车表的修改
	 * @param res
	 * @param req：获取页面数据
	 * @param chen：页面传输过来的多个购物车ID
	 * @return：重定向到订单页面
	 */
	@RequestMapping("addOrder.do")
	public String add(HttpServletResponse res,HttpServletRequest req,String[] chen){
		try {
			//设置输入输出流的字体编码格式
			res.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			//获取购物车页面选中的购物车的ID
			String[] array = chen;
			//判断获取的购物车ID是否为空
			if(array != null && array.length>0){
				//将获取的ID集合循环遍历
				for (int i = 0; i < array.length; i++) {
					//创建一个订单对象
					Order order = new Order();
					//生成2个随机数
					RandomOrder rOder = new RandomOrder();
					order.setOrderNumber(rOder.getStringRandom(30));
					order.setRnumber(rOder.getStringRandom(50));
					order.setCreatTime(new Date());
					//获取购物车中的user_id，car_id并添加到订单中
					ShopCart shop = shopCartService.findById(Integer.valueOf(array[i]));
					order.setFlowerId(shop.getFlowerId());
					order.setCarId(Integer.valueOf(array[i]));
					order.setUserId(shop.getUserId());
					//调用添加方法
					orderService.addOrder(order);
					//如果购物车中的商品添加到了订单表中就将购物车中的商品状态改为1
					shop.setFlor(1);
					//调用修改方法
					shopCartService.update(shop);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//重定向到订单页面
		return "redirect:findAllOrder.do";
	}
	/**
	 * 根据用户ID查询状态为0的订单记录
	 * 根据用户ID查询状态为1的购物车记录
	 * @param request：获取session
	 * @param model：向页面传数据
	 * @param chen：页面传输过来的多个购物车ID
	 * @return：返回到订单页面
	 */
	@RequestMapping("/findAllOrder.do")
	 public String findAllOrder(HttpServletRequest request,Model model,String[] chen){
		//根据session获取用户
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//根据用户ID查询状态为0的订单记录
		List<Order> order = orderService.findAll(user.getU_id());
		//根据用户ID查询状态为1的购物车记录
		List<ShopCart> shop = shopCartService.findAuth(user.getU_id());
		model.addAttribute("shop", shop);
		model.addAttribute("OrderList", order);
		//返回到订单页面
		return "order.jsp";
	 }
	/**
	 * 根据orderId删除订单数据并且删除对应的购物车记录
	 * @param orderId:页面传过来的订单ID
	 * @return：重定向到订单页面
	 */
	 @RequestMapping("/deleteOrder.do")
		public String delete(int orderId) {
		 		//页面传入orderId，根据orderId删除订单数据
				int i = Integer.valueOf(orderId);
				Order order = orderService.findById(i);
				//删除订单记录对应的购物车记录也删除
				//根据order获取carId，根据carId删除购物车数据
				shopCartService.delete(order.getCarId());
				//调用删除方法
				orderService.delete(i);
				//重定向到订单页面
				return "redirect:findAllOrder.do";
		 }
	 
	 /**
	  * 查询出单条订单记录并获取购物车表中的商品图片和鲜花表中的商品名称
	  * @param orderId：页面传过来的订单ID
	  * @param model：向页面传数据
	  * @return：返回到订单详情页面
	  */
	 @RequestMapping("byidOrder.do")
		public String findById(int orderId,Model model){
		 //根据orderId查询出订单的记录
			model.addAttribute("Order", orderService.findById(orderId));
			Order order = orderService.findById(orderId);
			//根据order获取flowerId，再获取f1对象
			int flower = order.getFlowerId();
			//根据鲜花ID查询出鲜花记录
			Flower fl = flowerService.getFlowerById(flower);
			model.addAttribute("fl",fl);
			//根据购物车ID查询出购物车记录
			ShopCart shop = shopCartService.findById(order.getCarId());
			int userId = shop.getUserId();
			//根据用户ID查询出用户信息
			User user = userService.findByU_id(userId);
			if(order.getFlora() == 0){
				//返回到订单详情页面
				model.addAttribute("user", user);
				model.addAttribute("shop",shop);
				return "contactorder.jsp";
			}else{
				model.addAttribute("user", user);
				model.addAttribute("shop",shop);
				return "contactorder2.jsp";
			}
		}
	 /**
	  * 对订单进行修改（添加地址、收货人、收货人电话）
	  * @param request：获取页面输入框中的值
	  * @param model：向页面传输数据
	  * @return：重定向到订单页面
	  */
	 @RequestMapping("updateOrder.do")
	 public String update(HttpServletRequest request,Model model){
		 //获取页面输入框中的值
		 String phone = request.getParameter("phone");
		 String orderId = request.getParameter("orderId");
		 String rname = request.getParameter("rname");
		 String addre = request.getParameter("addre");
		 //根据订单ID查询出该条记录
		 Order order = orderService.findById(Integer.parseInt(orderId));
		 //设值
		 order.setName(rname);
		 order.setPhone(phone);
		 order.setDeliAddress(addre);
		 //调用修改方法
		 orderService.update(order);
		 //重定向到订单页面
		 return "redirect:findAllOrder.do";
	 }
	 /**
	  * 查询所有 状态为1（已完成）的订单信息
	  * @param request：或去session并向页面传数据
	  * @return：返回到已完成订单页面
	  */
	 @RequestMapping("findStatOrder.do")
		public String findStatOder(HttpServletRequest request) {
		 //获取session
		 HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			//根据用户ID查询状态为1的订单记录
			List<Order> order = orderService.findStatOder(user.getU_id());
			request.setAttribute("OrderList", order);
			//根据用户ID查询状态为1的购物车记录
			List<ShopCart> shop = shopCartService.findAuth(user.getU_id());
			request.setAttribute("shop", shop);
			//返回到已完成订单页面
			return "orderStat.jsp";
		}
}
