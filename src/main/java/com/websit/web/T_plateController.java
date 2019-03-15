package com.websit.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.websit.service.IT_plateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 板块表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Controller
@RequestMapping("/t_plate")
public class T_plateController {

	@Autowired
	private IT_plateService t_plateService;
	
	@RequestMapping("/showPlateInfo")
	@ResponseBody
	public String showPlateInfo() {
		
		return t_plateService.selectPlateInfo();
	}
	
	
}
