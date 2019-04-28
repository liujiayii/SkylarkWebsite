package com.websit.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websit.entity.RequestMessage;
import com.websit.entity.ResponseMessage;
import com.websit.entity.T_access;
import com.websit.service.IT_accessService;
import com.websit.service.IT_productService;
import com.websit.service.IT_userService;

@Controller

public class T_indesController {
	@Autowired
	private IT_accessService accessService;
	@Autowired
	private IT_userService userService;
	@Autowired
	private IT_productService productService;

	@SendTo("/topic/getResponse")
	@MessageMapping("/welcome")
	public ResponseMessage toIndex() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String format = simpleDateFormat.format(date);
		T_access t = accessService.conent(format);

		if (t == null) {
			Integer a = accessService.insert1();
			System.out.println("a" + a);
		} else {
			Integer b = accessService.updatenumber(format);
		}

		T_access tnow = accessService.conent(format);
		System.out.println("tnow" + tnow);
		return new ResponseMessage(tnow.getNumber());
	}

	@SendTo("/topic/selectCount")
	@MessageMapping("/selectCount")
	public ResponseMessage selectCount(RequestMessage name) {

		return new ResponseMessage(Long.parseLong(name.getName()));
	}

	@RequestMapping("/")
	public ModelAndView index() {

		Long c = userService.slectCount();
		
		ModelAndView mv = new ModelAndView();

		mv.addObject("count", c);

		mv.setViewName("home/home");
		return mv;
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/about");

		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView guanyu() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/contact");

		return mv;
	}
	@RequestMapping("/searchs")
	public ModelAndView searchs() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/searchs");

		return mv;
	}
	

	@RequestMapping("/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/login");

		return mv;
	}

	@RequestMapping("/club")
	public ModelAndView club() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsIndex");

		return mv;
	}

	@RequestMapping("/forum")
	public ModelAndView forum() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsList");

		return mv;
	}

	@RequestMapping("/post")
	public ModelAndView post() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsPost");

		return mv;
	}

	@RequestMapping("/space")
	public ModelAndView space() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsSpace");

		return mv;
	}

	@RequestMapping("/mall")
	public ModelAndView mall() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/index");

		return mv;
	}

	/* 后台管理系统 */
	@RequestMapping("/backer/")
	public ModelAndView backer() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backer/index");

		return mv;
	}

	@RequestMapping("/goodList")
	public ModelAndView goodList() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/goodsList");

		return mv;
	}

	@RequestMapping("/goodDetails")
	public ModelAndView goodDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/goodDetails");

		return mv;
	}

	@RequestMapping("/userDetails")
	public ModelAndView userDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/userDetails");

		return mv;
	}

	@RequestMapping("/ShoppingCart")
	public ModelAndView ShoppingCart() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/ShoppingCart");

		return mv;
	}

	@RequestMapping("/OrderOk")
	public ModelAndView OrderOk() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/OrderOk");

		return mv;
	}

	@RequestMapping("/orderList")
	public ModelAndView orderList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/orderList");

		return mv;
	}
	
	@RequestMapping("/orderDetails")
	public ModelAndView orderDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/orderDetails");

		return mv;
	}

	@RequestMapping("/newaddress")
	public ModelAndView newaddress() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/newaddress");

		return mv;
	}

	@RequestMapping("/logistics")
	public ModelAndView logistics() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/logistics");

		return mv;
	}
	@RequestMapping("/demo")
	public ModelAndView demo() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/demo");

		return mv;
	}
	@RequestMapping("/evaluates")
	public ModelAndView evaluates() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/evaluates");

		return mv;
	}
}
