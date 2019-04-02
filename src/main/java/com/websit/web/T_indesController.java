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

		mv.setViewName("home/home.html");
		return mv;
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/about.html");

		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView guanyu() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/contact.html");

		return mv;
	}

	@RequestMapping("/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/login.html");

		return mv;
	}

	@RequestMapping("/club")
	public ModelAndView club() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsIndex.html");

		return mv;
	}

	@RequestMapping("/forum")
	public ModelAndView forum() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsList.html");

		return mv;
	}

	@RequestMapping("/post")
	public ModelAndView post() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsPost.html");

		return mv;
	}

	@RequestMapping("/space")
	public ModelAndView space() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bbs/bbsSpace.html");

		return mv;
	}

	@RequestMapping("/mall")
	public ModelAndView mall() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/index.html");

		return mv;
	}

	/* 后台管理系统 */
	@RequestMapping("/backer/")
	public ModelAndView backer() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backer/index.html");

		return mv;
	}

	@RequestMapping("/goodList")
	public ModelAndView goodList() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/goodsList.html");

		return mv;
	}

	@RequestMapping("/goodDetails")
	public ModelAndView goodDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/goodDetails.html");

		return mv;
	}

	@RequestMapping("/userDetails")
	public ModelAndView userDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/userDetails.html");

		return mv;
	}

	@RequestMapping("/ShoppingCart")
	public ModelAndView ShoppingCart() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/ShoppingCart.html");

		return mv;
	}

	@RequestMapping("/OrderOk")
	public ModelAndView OrderOk() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/OrderOk.html");

		return mv;
	}

	@RequestMapping("/orderList")
	public ModelAndView orderList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/orderList.html");

		return mv;
	}

	@RequestMapping("/newaddress")
	public ModelAndView newaddress() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/newaddress.html");

		return mv;
	}

	@RequestMapping("/logistics")
	public ModelAndView logistics() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/logistics.html");

		return mv;
	}

	@RequestMapping("/searchs")
	public ModelAndView searchs() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/mall/searchs.html");

		return mv;
	}

}
