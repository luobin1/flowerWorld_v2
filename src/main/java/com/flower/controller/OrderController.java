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
	 * �����������빺�ﳵ����޸�
	 * @param res
	 * @param req����ȡҳ������
	 * @param chen��ҳ�洫������Ķ�����ﳵID
	 * @return���ض��򵽶���ҳ��
	 */
	@RequestMapping("addOrder.do")
	public String add(HttpServletResponse res,HttpServletRequest req,String[] chen){
		try {
			//�����������������������ʽ
			res.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			//��ȡ���ﳵҳ��ѡ�еĹ��ﳵ��ID
			String[] array = chen;
			//�жϻ�ȡ�Ĺ��ﳵID�Ƿ�Ϊ��
			if(array != null && array.length>0){
				//����ȡ��ID����ѭ������
				for (int i = 0; i < array.length; i++) {
					//����һ����������
					Order order = new Order();
					//����2�������
					RandomOrder rOder = new RandomOrder();
					order.setOrderNumber(rOder.getStringRandom(30));
					order.setRnumber(rOder.getStringRandom(50));
					order.setCreatTime(new Date());
					//��ȡ���ﳵ�е�user_id��car_id����ӵ�������
					ShopCart shop = shopCartService.findById(Integer.valueOf(array[i]));
					order.setFlowerId(shop.getFlowerId());
					order.setCarId(Integer.valueOf(array[i]));
					order.setUserId(shop.getUserId());
					//������ӷ���
					orderService.addOrder(order);
					//������ﳵ�е���Ʒ��ӵ��˶������оͽ����ﳵ�е���Ʒ״̬��Ϊ1
					shop.setFlor(1);
					//�����޸ķ���
					shopCartService.update(shop);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�ض��򵽶���ҳ��
		return "redirect:findAllOrder.do";
	}
	/**
	 * �����û�ID��ѯ״̬Ϊ0�Ķ�����¼
	 * �����û�ID��ѯ״̬Ϊ1�Ĺ��ﳵ��¼
	 * @param request����ȡsession
	 * @param model����ҳ�洫����
	 * @param chen��ҳ�洫������Ķ�����ﳵID
	 * @return�����ص�����ҳ��
	 */
	@RequestMapping("/findAllOrder.do")
	 public String findAllOrder(HttpServletRequest request,Model model,String[] chen){
		//����session��ȡ�û�
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//�����û�ID��ѯ״̬Ϊ0�Ķ�����¼
		List<Order> order = orderService.findAll(user.getU_id());
		//�����û�ID��ѯ״̬Ϊ1�Ĺ��ﳵ��¼
		List<ShopCart> shop = shopCartService.findAuth(user.getU_id());
		model.addAttribute("shop", shop);
		model.addAttribute("OrderList", order);
		//���ص�����ҳ��
		return "order.jsp";
	 }
	/**
	 * ����orderIdɾ���������ݲ���ɾ����Ӧ�Ĺ��ﳵ��¼
	 * @param orderId:ҳ�洫�����Ķ���ID
	 * @return���ض��򵽶���ҳ��
	 */
	 @RequestMapping("/deleteOrder.do")
		public String delete(int orderId) {
		 		//ҳ�洫��orderId������orderIdɾ����������
				int i = Integer.valueOf(orderId);
				Order order = orderService.findById(i);
				//ɾ��������¼��Ӧ�Ĺ��ﳵ��¼Ҳɾ��
				//����order��ȡcarId������carIdɾ�����ﳵ����
				shopCartService.delete(order.getCarId());
				//����ɾ������
				orderService.delete(i);
				//�ض��򵽶���ҳ��
				return "redirect:findAllOrder.do";
		 }
	 
	 /**
	  * ��ѯ������������¼����ȡ���ﳵ���е���ƷͼƬ���ʻ����е���Ʒ����
	  * @param orderId��ҳ�洫�����Ķ���ID
	  * @param model����ҳ�洫����
	  * @return�����ص���������ҳ��
	  */
	 @RequestMapping("byidOrder.do")
		public String findById(int orderId,Model model){
		 //����orderId��ѯ�������ļ�¼
			model.addAttribute("Order", orderService.findById(orderId));
			Order order = orderService.findById(orderId);
			//����order��ȡflowerId���ٻ�ȡf1����
			int flower = order.getFlowerId();
			//�����ʻ�ID��ѯ���ʻ���¼
			Flower fl = flowerService.getFlowerById(flower);
			model.addAttribute("fl",fl);
			//���ݹ��ﳵID��ѯ�����ﳵ��¼
			ShopCart shop = shopCartService.findById(order.getCarId());
			int userId = shop.getUserId();
			//�����û�ID��ѯ���û���Ϣ
			User user = userService.findByU_id(userId);
			if(order.getFlora() == 0){
				//���ص���������ҳ��
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
	  * �Զ��������޸ģ���ӵ�ַ���ջ��ˡ��ջ��˵绰��
	  * @param request����ȡҳ��������е�ֵ
	  * @param model����ҳ�洫������
	  * @return���ض��򵽶���ҳ��
	  */
	 @RequestMapping("updateOrder.do")
	 public String update(HttpServletRequest request,Model model){
		 //��ȡҳ��������е�ֵ
		 String phone = request.getParameter("phone");
		 String orderId = request.getParameter("orderId");
		 String rname = request.getParameter("rname");
		 String addre = request.getParameter("addre");
		 //���ݶ���ID��ѯ��������¼
		 Order order = orderService.findById(Integer.parseInt(orderId));
		 //��ֵ
		 order.setName(rname);
		 order.setPhone(phone);
		 order.setDeliAddress(addre);
		 //�����޸ķ���
		 orderService.update(order);
		 //�ض��򵽶���ҳ��
		 return "redirect:findAllOrder.do";
	 }
	 /**
	  * ��ѯ���� ״̬Ϊ1������ɣ��Ķ�����Ϣ
	  * @param request����ȥsession����ҳ�洫����
	  * @return�����ص�����ɶ���ҳ��
	  */
	 @RequestMapping("findStatOrder.do")
		public String findStatOder(HttpServletRequest request) {
		 //��ȡsession
		 HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			//�����û�ID��ѯ״̬Ϊ1�Ķ�����¼
			List<Order> order = orderService.findStatOder(user.getU_id());
			request.setAttribute("OrderList", order);
			//�����û�ID��ѯ״̬Ϊ1�Ĺ��ﳵ��¼
			List<ShopCart> shop = shopCartService.findAuth(user.getU_id());
			request.setAttribute("shop", shop);
			//���ص�����ɶ���ҳ��
			return "orderStat.jsp";
		}
}
