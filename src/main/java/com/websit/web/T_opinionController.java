package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_opinion;
import com.websit.service.IT_opinionService;
import com.websit.until.JsonUtil;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 意见表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Controller
public class T_opinionController {

	@Autowired
	private IT_opinionService opinionService ;
	/**
	 * 增加一条意见
	 * @author pangchong
	 * @createDate 2019年3月13日 下午2:00
	 */
	@RequestMapping(value = "/insertOneOpinion", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertOneOpinion(T_opinion t_opinion ) {
		try{
		
		t_opinion.setName("张三");
		t_opinion.setPhone("13514515865");
		t_opinion.setAddress("石家庄市");
		t_opinion.setEmaill("2547813597@qq.com");
		t_opinion.setCreate_time(null);
		boolean result = opinionService.insert(t_opinion);
		if (result) {
			return JsonUtil.getResponseJson(1, "添加成功", null, null);
		} else {
			return JsonUtil.getResponseJson(1, "添加失败", null, null);
		}
	} catch (Exception e) {
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	
	}
	}
}
