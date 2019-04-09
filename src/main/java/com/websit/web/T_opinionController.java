package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.Classification;
import com.websit.entity.T_opinion;
import com.websit.service.IT_opinionService;
import com.websit.until.JsonUtil;

import java.util.Date;
import java.util.List;
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
	public String insertOneOpinion(T_opinion opinion ) {
		try{
		/*opinion.setName("张儿");
	    opinion.setPhone("13514515865");
		opinion.setAddress("石家庄市啊");
		opinion.setEmaill("2547813597@qq.com");
		opinion.setCreate_time(new Date());
		opinion.setContent("刚发的");*/
		boolean result = opinionService.insertOneOpinion(opinion);
		if (result) {
			return JsonUtil.getResponseJson(1, "添加成功", null, null);
		} else {
			return JsonUtil.getResponseJson(1, "无数据", null, null);
		}
	} catch (Exception e) {
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	
	}
	}
	/**
	 * 查询所有意见---分页
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@RequestMapping(value = "/listAllOpinion", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listAllOpinion(Integer page,Integer limit,T_opinion opinion) {
		try{
			Integer star = (page - 1) * limit;
		List<T_opinion> result = opinionService.listAllOpinion(star, limit);
		Integer count = opinionService.findOpinionCount(opinion);
		if (result.size() >=1) {
			return JsonUtil.getResponseJson(1, "查看成功", count, result);
		} else {
			return JsonUtil.getResponseJson(1, "无数据", null, null);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	}
	}
}
