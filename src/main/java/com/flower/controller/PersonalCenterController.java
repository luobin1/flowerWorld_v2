package com.flower.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.flower.entity.News;
import com.flower.entity.PayAccount;
import com.flower.entity.Pove;
import com.flower.entity.Score;
import com.flower.entity.User;
import com.alibaba.fastjson.JSONObject;
import com.flower.entity.Address;
import com.flower.entity.City;
import com.flower.entity.Comment;
import com.flower.entity.Flower;
import com.flower.service.CityService;
import com.flower.service.IAddressService;
import com.flower.service.ICommentService;
import com.flower.service.IFlowerService;
import com.flower.service.INewsService;
import com.flower.service.IPayAccountService;
import com.flower.service.IScoreService;
import com.flower.service.IUserService;
import com.flower.service.PoveService;

@Controller
@RequestMapping("/personalCenter")
public class PersonalCenterController {
	
	@Autowired
	private INewsService newsService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ICommentService commentService;
	@Autowired
	private PoveService poveService;
	@Autowired
	private CityService cityService;
	@Autowired
	private IScoreService scoreService;
	@Autowired
	private IPayAccountService payAccountService;
	@Autowired
	private IAddressService addressService;
	@Autowired
	private IFlowerService flowerService;
	
	
	/**
	 * ��ȡ��¼����û�
	 * @param request
	 * @return
	 */
	public User getUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		return user;
	}
	
	/**
	 * ������������ҳ
	 * @return
	 */
	@RequestMapping("/toPersonalCenter")
	public String toPersonalCenter(Model mod,HttpServletRequest request) {
		User user = getUser(request);
		
		mod.addAttribute("user",user);

		return "liiy/Personal_Center2.jsp";
	}
	/**
	 * ���ҵĸ�������
	 * @return
	 */
	@RequestMapping("/toPersonal")
	public String toPersonal(Model mod,HttpServletRequest request) {
		User user = getUser(request);
		mod.addAttribute("user",user);
		return "liiy/Presonal.jsp";
	}
	/**
	 * ���ҵ���Ϣ
	 * @return
	 */
	@RequestMapping("/toNews")
	public String toNews(Model mod,HttpServletRequest request) {
		User user = getUser(request);
		//ͨ���û�id��ȡ��Ϣ
		List<News> news = newsService.findByU_id(user.getU_id());
		mod.addAttribute("news",news);

		return "liiy/News.jsp";
	}
	/**
	 * ��ҳ��Ϣ
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "myProductPage", method = RequestMethod.GET)  
	public String showMyProduct(HttpServletRequest request, Model model) {  
		User user = getUser(request);
	    this.newsService.showProductsByPage(request, model,user.getU_id());  
	    return "liiy/News.jsp";  
	} 
		/**
		 * ��Ϣ����ɾ��
		 * @param request
		 * @param response
		 */
	 	@RequestMapping("/batchDeletes")
	    @ResponseBody
	    public void batchDeletes(HttpServletRequest request,HttpServletResponse response){
	 		//��ȡҪɾ��������Ϣid���ַ���
	        String items = request.getParameter("delitems");
	        //����һ���µļ���
	        List<Integer> delList = new ArrayList<Integer>();
	        //���ַ�����ֳ��ַ�������
	        String[] strs = items.split(",");
	        //�����ַ�������
	        for (String str : strs) {
	        	//���ַ�����ӵļ�����
	            delList.add(Integer.parseInt(str));
	        }
	        //ִ��ɾ��
	        newsService.deleteFind(delList);
	    }
	 	/**
	 	 * �ҵĵ�����Ϣ
	 	 * @param mod
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping("/Message")
	 	public String message(Model mod,int nid,int uid) {
	 		User user = userService.findByU_id(uid);
	 		News news = newsService.findByN_id(nid);
	 		//���Ϊ�Ѷ�״̬
	 		news.setN_sign(2);
	 		newsService.updateNsign(news);
	 		mod.addAttribute("usernname",user.getU_nname());
	 		mod.addAttribute("message",news);
	 		return "liiy/Message_details.jsp"; 
	 	}
	 	/**
	 	 * �޸ĸ�����Ϣ
	 	 * @param mod
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping("/updateUser")
	 	public String updateUser(User user,Model mod,HttpServletRequest request) {
	 		//��ѯԭ�ȵ���Ϣ
	 		User user2 = userService.findByU_id(user.getU_id());
	 		//ΪҪ�޸ĵ�ֵ��ֵ
	 		user2.setU_phone(user.getU_phone());
	 		user2.setU_mail(user.getU_mail());
	 		user2.setU_nname(user.getU_nname());
	 		user2.setU_rname(user.getU_rname());
	 		user2.setU_address(user.getU_address());
	 		//�޸�
	 		userService.updateUser2(user2);
	 		//���°�session
	 		request.getSession().setAttribute("user", user2);
	 		return "redirect:toPersonalCenter.do"; 
	 	}

	 	/**
	 	 * ����
	 	 * @param mod
	 	 * @param request
	 	 * @return
	 	 */
		@RequestMapping("/toScore")
	 	public String toScore(Model mod,HttpServletRequest request) {
			User user = getUser(request);
			Score score = scoreService.findByUid(user.getU_id());
			//�ж��û��Ƿ��л�����Ϣ�����û�о����
			if(score == null){
				score = new Score(null, user.getU_id(), 0);
				scoreService.addIntegral(score);
			}
			mod.addAttribute("score", score);
			return "liiy/score.jsp";
	 	}
		/**
		 * Ԥ֧���˻�
		 * @param mod
		 * @param request
		 * @return
		 */
		@RequestMapping("/toPayAccount")
	 	public String toPayAccount(Model mod,HttpServletRequest request) {
			User user = getUser(request);
			PayAccount payAccounts = payAccountService.findByU_id(user.getU_id());
			mod.addAttribute("payAccounts", payAccounts);
			return "liiy/PayAccount.jsp";
	 	}
		/**
		 * �޸�Ԥ֧���˻�����
		 * @param payAccount
		 * @param request
		 * @return
		 */
		@RequestMapping("/upPayAccountPwd")
		@ResponseBody
		public JSONObject upPayAccountPwd(PayAccount payAccount,HttpServletRequest request) {
			PayAccount payAccount2 = payAccountService.findByP_id(payAccount.getP_id());
			JSONObject json = new JSONObject();
			//��֤ԭ�����Ƿ���ͬ
			if(payAccount.getP_pwd().equals(payAccount2.getP_pwd())) {
				payAccount2.setP_pwd(request.getParameter("p_pwd2"));
				payAccountService.updatePayAccount(payAccount2);
				json.put("message", 1);
			}else {
				json.put("message", 2);
			}
			return json;
		}
		/**
		 * ����˻�
		 * @param payAccount
		 * @return
		 */
		@RequestMapping("/addPayAccount")
		public String Addpay(PayAccount payAccount) {
			//�������Ĭ��Ϊ0Ԫ
			payAccount.setP_balance(0.00);
			payAccountService.addPayAccount(payAccount);
			return "redirect:toPayAccount.do";
		}
		/**
		 * ��֧��ҳ��
		 * @return
		 */
		@RequestMapping("/toPay")
		public String toPay(){
			return "liiy/PayAccount2.jsp";
		}
		/**
		 * ����ַ����
		 * @param mod
		 * @return
		 */
		@RequestMapping("/toAddress")
		public String toAddress(Model mod,HttpServletRequest request){
			User user = getUser(request);
			List<Address> address = addressService.findByUid(user.getU_id());
			System.out.println(address);
			//Ϊ��ַ���������ó�ʼֵ
			List<Pove> poves = poveService.findAllPove();
			mod.addAttribute("address", address);
			mod.addAttribute("poves", poves);

			return "liiy/Address2.jsp";
		}
		/**
		 * ����ѡ��ĵ�ַ��ϸ��Ϣ
		 * @param a_id
		 * @return
		 */
		@RequestMapping("/toUpAddress")
		@ResponseBody
		public JSONObject toUpAddress(int a_id){
			Address address = addressService.findByAid(a_id);
			JSONObject json = new JSONObject();
			json.put("address",address);
			return json;
		}
		
		/**
		 * ����ʡ���ɳ���
		 * @param pid
		 * @return
		 */
		@RequestMapping("/queryCity")
		@ResponseBody
		public JSONObject queryCity(int pid){
			List<City> citys = cityService.findByid(pid);
			JSONObject json = new JSONObject();
			json.put("citys",citys);
			return json;
		}
		
		/**
		 * �޸��ջ���ַ
		 * @param address
		 * @return
		 */
		@RequestMapping("/upAddress")
		public String upAddress(Address address){
			addressService.updateAddress(address);
			return "redirect:toAddress.do";
		}
		/**
		 * ɾ����ַ
		 * @param a_id
		 * @return
		 */
		@RequestMapping("/deleteAddress")
		public String deleteAddress(int a_id){
			addressService.deleteByAid(a_id);
			return "redirect:toAddress.do";
		}
		
		/**
		 * ��ӵ�ַ
		 * @param address
		 * @return
		 */
		@RequestMapping("/Address")
		public String Address(Address address){
			addressService.addAddress(address);
			return "redirect:toAddress.do";
		}
		/**
		 * �ʻ����û����۵ķ�ҳ���ѯ
		 * @param flowerId �ʻ�id
		 * @param u_id �û�id
		 * @param mod
		 * @param request
		 * @return
		 */
		@RequestMapping(value="findCommenByLimit", method = RequestMethod.GET)
		public String findCommenByLimit(Integer flowerId,Integer u_id,Model mod,HttpServletRequest request){
			//��ѯ���ҳ
			this.commentService.findCommentLimit(flowerId, u_id, request,mod);
			//�ж��ǲ�ѯ���ʻ������û������۷��ض�Ӧ��ҳ��
			if(flowerId == null){
				return "liiy/Comment.jsp";
			}
			Flower flowe = flowerService.getFlowerById(flowerId);
			mod.addAttribute("flower", flowe);
			return "liiy/Flower_review.jsp";
		}
		/**
		 * �������
		 * @param comment
		 * @return
		 */
		@RequestMapping("/addComment")
		public String addComment(Comment comment){
			//��������ʱ��
			comment.setC_time(new Date());
			commentService.addComment(comment);
			return "redirect:findCommenByLimit.do?flowerId="+comment.getF_id();
		}
}
