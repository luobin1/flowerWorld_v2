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
	 * �����û�ID��ѯ����״̬Ϊ0�Ĺ��ﳵ��¼
	 * 
	 * @param model����ҳ�洫������
	 * @param request����ȡsession
	 * @return�����ص����ﳵҳ��
	 */
	@RequestMapping("/findAllShopCar.do")
	public String findAllShopCar(Model model, HttpServletRequest request) {

		// String str = request.getSession().getAttribute("user").toString();
		// String aa = str.substring(25,36);
		// ����session��ȡ�û�
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// �����û�ID��ѯ���ﳵ������״̬Ϊ0�ļ�¼
		List<ShopCart> shop = shopCartService.findAll(user.getU_id());
		// ��shop����ҳ��
		model.addAttribute("ShopCartList", shop);
		// �жϲ�ѯ�����������Ƿ�Ϊ�ռ��ϡ����Ϊ�վͲ���ѯtotal�ֶεĺ�
		if (shop.toString() != "[]") {
			// �����Ϊ�ռ��Ͼͽ�״̬Ϊ0�ļ�¼��subtotal�ֶε�ֵ��Ӳ�����ҳ�棨user_id��
			double totalSum = shopCartService.findSum(user.getU_id());
			model.addAttribute("totalSum", totalSum);
		}
		// ���ص����ﳵҳ��
		return "shopcart.jsp";
	}

	/**
	 * ���ﳵ���޸ĺ�total�ֶεĺ͵Ĳ�ѯ
	 * 
	 * @param shopCart��ҳ�洫������һ�����ﳵ����
	 * @param request����ҳ�洫������
	 * @return����total�ֶεĺ���Ϊjson���󴫵�ҳ��
	 */
	@RequestMapping("/order.do")
	@ResponseBody
	public JSONObject toOrder(ShopCart shopCart, HttpServletRequest request) {
		// ҳ�洫��һ��shopcart���������ֱ�ӵ����޸ķ���
		shopCartService.update(shopCart);
		// ����һ��json����
		JSONObject json = new JSONObject();
		// List<ShopCart> shop = shopCartService.findAll();
		// request.setAttribute("ShopCartList", shop);
		// int totalSum = shopCartService.findSum();
		// request.setAttribute("totalSum", totalSum);
		// ����session��ȡ�û�
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// �����û�ID��ѯ����ǰ�û�����״̬Ϊ0�����м�¼
		List<ShopCart> shop = shopCartService.findAll(user.getU_id());
		// �����û�ID��ѯ���ﳵ��״̬Ϊ0��total�ֶεĺ�
		double totalSum = shopCartService.findSum(user.getU_id());
		// model.addAttribute("totalSum", totalSum);
		// request.setAttribute("totalSum", totalSum);
		// ��totalSum���뵽json��
		json.put("totalSum", totalSum);
		// ��json����ҳ��
		return json;

	}

	/**
	 * ���ݹ��ﳵID����ɾ��
	 * 
	 * @param carId��ҳ�洫�����Ĺ��ﳵID
	 * @return���ض��򵽹��ﳵҳ��
	 */
	@RequestMapping("/delete.do")
	public String delete(int carId) {
		// ҳ�洫��һ��carId������carIdɾ������
		int i = Integer.valueOf(carId);
		// ����ɾ������
		shopCartService.delete(i);
		// �ض��򵽹��ﳵҳ��
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
	 * ��ѯ�����ﳵ������¼
	 * 
	 * @param carId��ҳ�洫�����Ĺ��ﳵID
	 * @param request����ҳ�洫������
	 * @return�����ص����ﳵҳ��
	 */
	@RequestMapping("byid.do")
	public String findById(int carId, HttpServletRequest request) {
		// ����carId��ѯ��������¼������ҳ��
		request.setAttribute("ShopCartList", shopCartService.findById(carId));
		// ���ص����ﳵҳ��
		return "shopcart.jsp";
	}

	/**
	 * �Թ��ﳵʵ�����ӻ����޸�
	 * 
	 * @param flower_id:ҳ�洩�������ʻ�ID
	 * @param request����ȡsession
	 * @param model����ҳ�洫����
	 * @return���ض��򵽹��ﳵҳ��
	 */
	@RequestMapping("addShopCart.do")
	public String add(Integer flower_id, HttpServletRequest request, Model model) {
		// ͨ��session��ȡ�û�
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// ��֤�û��Ƿ��¼��û��¼�ͻص���¼ҳ��
		if (user == null) {
			return "redirect:/flower/sign.do";
		}
		// ��ȡ���ﳵ�������е����ݽ����жϣ�Ϊ�վ�ֱ�����Ӽ�¼����Ϊ�վ�ѭ������
		// ����ҳ�洩�������ʻ�ID��״̬Ϊ0���в�ѯ��������ڼ�¼�ͽ�������һ
		// ��������ڼ�¼��������һ����¼
		List<ShopCart> shops = shopCartService.findAll(user.getU_id());
		if (shops.toString() == "[]") {
			// �½�һ�����ﳵʵ����
			ShopCart shopCart = new ShopCart();
			// �����ֶθ�ֵ
			shopCart.setFlowerId(flower_id);
			shopCart.setNumber(1);
			shopCart.setUserId(user.getU_id());
			shopCart.setImagesUri(flowerService.getFlowerById(flower_id).getFlowerUrl1());
			shopCart.setSubtotal(flowerService.getFlowerById(flower_id).getPrice());
			shopCart.setTotal(flowerService.getFlowerById(flower_id).getPrice() * 1);
			shopCart.setFlor(0);
			// �������ӷ�����Ӽ�¼
			shopCartService.add(shopCart);
		}
		// �������Ʒ�Ѵ��ڹ��ﳵ�в���״̬Ϊ0���Ͳ�����µļ�¼��������һ����
		for (int i = 0; i < shops.size(); i++) {
			int dd = shops.get(i).getFlowerId();
			// ���flower_id�Ѵ���
			if (dd == flower_id) {
				// �������flower_id��״̬��ѯ����Ӧ��¼
				ShopCart shopa = shops.get(i);
				// ��ԭ�е�������һ
				shopa.setNumber(shopa.getNumber() + 1);
				// С�ƾ͵��ڼ�һ�������*����
				shopa.setTotal((shopa.getNumber() + 1) * shopa.getSubtotal());
				// �����޸ķ���
				shopCartService.update(shopa);
				// �������flower_id��״̬��ѯ������¼�����ù��ﳵ�����һ����¼
			} else if (dd != flower_id) {
				// �����¼�ˣ��ͻ�ȡҳ�����Ʒ��Ϣ����ӵ����ﳵ��
				ShopCart shopCart = new ShopCart();
				shopCart.setFlowerId(flower_id);
				shopCart.setNumber(1);
				shopCart.setUserId(user.getU_id());
				shopCart.setImagesUri(flowerService.getFlowerById(flower_id).getFlowerUrl1());
				shopCart.setSubtotal(flowerService.getFlowerById(flower_id).getPrice());
				shopCart.setTotal(flowerService.getFlowerById(flower_id).getPrice() * 1);
				shopCart.setFlor(0);
				// �������ӷ�����Ӽ�¼
				shopCartService.add(shopCart);
				// �÷���ִ��һ�ξͱ�������ѭ��
				break;
			}
		}
		// �ض��򵽹��ﳵҳ��
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
	 * ��ѯ���ﳵ����ʷ��¼
	 * 
	 * @param model��
	 *            ��ҳ�洫������
	 * @param request��
	 *            ��ȡsession
	 * @return
	 */

	@RequestMapping("/findAuth.do")
	public String findAuth(Model model, HttpServletRequest request) {
		// ����session��ȡ�û�
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// ����user_id��ѯ״̬Ϊ1�Ĺ��ﳵ��¼
		List<ShopCart> shop = shopCartService.findAuth(user.getU_id());
		model.addAttribute("ShopCartList", shop);
		// ���ع��ﳵ��ʷ��¼ҳ��
		return "shopcart2.jsp";
	}
}
