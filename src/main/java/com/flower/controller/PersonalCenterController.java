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
	 * 获取登录后的用户
	 * @param request
	 * @return
	 */
	public User getUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		return user;
	}
	
	/**
	 * 到个人中心首页
	 * @return
	 */
	@RequestMapping("/toPersonalCenter")
	public String toPersonalCenter(Model mod,HttpServletRequest request) {
		User user = getUser(request);
		
		mod.addAttribute("user",user);

		return "liiy/Personal_Center2.jsp";
	}
	/**
	 * 到我的个人资料
	 * @return
	 */
	@RequestMapping("/toPersonal")
	public String toPersonal(Model mod,HttpServletRequest request) {
		User user = getUser(request);
		mod.addAttribute("user",user);
		return "liiy/Presonal.jsp";
	}
	/**
	 * 到我的消息
	 * @return
	 */
	@RequestMapping("/toNews")
	public String toNews(Model mod,HttpServletRequest request) {
		User user = getUser(request);
		//通过用户id获取消息
		List<News> news = newsService.findByU_id(user.getU_id());
		mod.addAttribute("news",news);

		return "liiy/News.jsp";
	}
	/**
	 * 分页消息
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
		 * 消息多条删除
		 * @param request
		 * @param response
		 */
	 	@RequestMapping("/batchDeletes")
	    @ResponseBody
	    public void batchDeletes(HttpServletRequest request,HttpServletResponse response){
	 		//获取要删除所有消息id的字符串
	        String items = request.getParameter("delitems");
	        //创建一个新的集合
	        List<Integer> delList = new ArrayList<Integer>();
	        //将字符串拆分成字符串数组
	        String[] strs = items.split(",");
	        //遍历字符串数组
	        for (String str : strs) {
	        	//将字符串添加的集合里
	            delList.add(Integer.parseInt(str));
	        }
	        //执行删除
	        newsService.deleteFind(delList);
	    }
	 	/**
	 	 * 我的单个消息
	 	 * @param mod
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping("/Message")
	 	public String message(Model mod,int nid,int uid) {
	 		User user = userService.findByU_id(uid);
	 		News news = newsService.findByN_id(nid);
	 		//标记为已读状态
	 		news.setN_sign(2);
	 		newsService.updateNsign(news);
	 		mod.addAttribute("usernname",user.getU_nname());
	 		mod.addAttribute("message",news);
	 		return "liiy/Message_details.jsp"; 
	 	}
	 	/**
	 	 * 修改个人信息
	 	 * @param mod
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping("/updateUser")
	 	public String updateUser(User user,Model mod,HttpServletRequest request) {
	 		//查询原先的信息
	 		User user2 = userService.findByU_id(user.getU_id());
	 		//为要修改的值赋值
	 		user2.setU_phone(user.getU_phone());
	 		user2.setU_mail(user.getU_mail());
	 		user2.setU_nname(user.getU_nname());
	 		user2.setU_rname(user.getU_rname());
	 		user2.setU_address(user.getU_address());
	 		//修改
	 		userService.updateUser2(user2);
	 		//重新绑定session
	 		request.getSession().setAttribute("user", user2);
	 		return "redirect:toPersonalCenter.do"; 
	 	}

	 	/**
	 	 * 积分
	 	 * @param mod
	 	 * @param request
	 	 * @return
	 	 */
		@RequestMapping("/toScore")
	 	public String toScore(Model mod,HttpServletRequest request) {
			User user = getUser(request);
			Score score = scoreService.findByUid(user.getU_id());
			//判断用户是否有积分信息，如果没有就添加
			if(score == null){
				score = new Score(null, user.getU_id(), 0);
				scoreService.addIntegral(score);
			}
			mod.addAttribute("score", score);
			return "liiy/score.jsp";
	 	}
		/**
		 * 预支付账户
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
		 * 修改预支付账户密码
		 * @param payAccount
		 * @param request
		 * @return
		 */
		@RequestMapping("/upPayAccountPwd")
		@ResponseBody
		public JSONObject upPayAccountPwd(PayAccount payAccount,HttpServletRequest request) {
			PayAccount payAccount2 = payAccountService.findByP_id(payAccount.getP_id());
			JSONObject json = new JSONObject();
			//验证原密码是否相同
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
		 * 添加账户
		 * @param payAccount
		 * @return
		 */
		@RequestMapping("/addPayAccount")
		public String Addpay(PayAccount payAccount) {
			//设置余额默认为0元
			payAccount.setP_balance(0.00);
			payAccountService.addPayAccount(payAccount);
			return "redirect:toPayAccount.do";
		}
		/**
		 * 到支付页面
		 * @return
		 */
		@RequestMapping("/toPay")
		public String toPay(){
			return "liiy/PayAccount2.jsp";
		}
		/**
		 * 到地址管理
		 * @param mod
		 * @return
		 */
		@RequestMapping("/toAddress")
		public String toAddress(Model mod,HttpServletRequest request){
			User user = getUser(request);
			List<Address> address = addressService.findByUid(user.getU_id());
			System.out.println(address);
			//为地址下拉框设置初始值
			List<Pove> poves = poveService.findAllPove();
			mod.addAttribute("address", address);
			mod.addAttribute("poves", poves);

			return "liiy/Address2.jsp";
		}
		/**
		 * 返回选择的地址详细信息
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
		 * 根据省生成城市
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
		 * 修改收货地址
		 * @param address
		 * @return
		 */
		@RequestMapping("/upAddress")
		public String upAddress(Address address){
			addressService.updateAddress(address);
			return "redirect:toAddress.do";
		}
		/**
		 * 删除地址
		 * @param a_id
		 * @return
		 */
		@RequestMapping("/deleteAddress")
		public String deleteAddress(int a_id){
			addressService.deleteByAid(a_id);
			return "redirect:toAddress.do";
		}
		
		/**
		 * 添加地址
		 * @param address
		 * @return
		 */
		@RequestMapping("/Address")
		public String Address(Address address){
			addressService.addAddress(address);
			return "redirect:toAddress.do";
		}
		/**
		 * 鲜花或用户评论的分页与查询
		 * @param flowerId 鲜花id
		 * @param u_id 用户id
		 * @param mod
		 * @param request
		 * @return
		 */
		@RequestMapping(value="findCommenByLimit", method = RequestMethod.GET)
		public String findCommenByLimit(Integer flowerId,Integer u_id,Model mod,HttpServletRequest request){
			//查询与分页
			this.commentService.findCommentLimit(flowerId, u_id, request,mod);
			//判断是查询的鲜花还是用户的评论返回对应的页面
			if(flowerId == null){
				return "liiy/Comment.jsp";
			}
			Flower flowe = flowerService.getFlowerById(flowerId);
			mod.addAttribute("flower", flowe);
			return "liiy/Flower_review.jsp";
		}
		/**
		 * 添加评论
		 * @param comment
		 * @return
		 */
		@RequestMapping("/addComment")
		public String addComment(Comment comment){
			//设置评论时间
			comment.setC_time(new Date());
			commentService.addComment(comment);
			return "redirect:findCommenByLimit.do?flowerId="+comment.getF_id();
		}
}
