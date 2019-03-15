package com.websit.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_plate;
import com.websit.entity.T_posting;
import com.websit.entity.T_reply;
import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.postinglist;
import com.websit.service.IT_commentService;
import com.websit.service.IT_postingService;
import com.websit.service.IT_replyService;
import com.websit.until.JsonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 评论回复表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */

@Controller
@RequestMapping("/t_reply")
public class T_replyController {
	@Autowired
	public IT_replyService T_replyService;


	
	@RequestMapping("/addT_reply")
	@ResponseBody
	public String T_postingController(@RequestBody T_reply T_reply) {
		System.out.println("请求成功"+T_reply.toString());
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		Date sdf = new Date();
		
		try {
			T_reply.setCreate_time(sdf);// 获取当前时间
			boolean fig = T_replyService.insert(T_reply);// 调用T_postingService层
			if (fig) {
				msg = "发帖成功";
				cood = 1;
			} else {
				msg = "发帖失败";
				cood = -1;
			}

			return JsonUtil.getResponseJson(cood, msg, null, null);

		} catch (Exception e) {
			// TODO: handle exception

			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}
	/**
	 * 查询详情的列表
	 */
	@RequestMapping("/xqlist")
	@ResponseBody
	public String listtre(String  id) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		try {
			List<postinglist>  postinglist=T_replyService.postingli(id);
		    List<postinglist>  t_commentlist=T_replyService.t_commentlist(id);
		    postinglist.addAll(t_commentlist);
    if (postinglist.size()>0) {
		msg = "查询成功";
		cood = 1;
		
	} else {
		msg = "暂无数据";
		cood = -1;
	}

	return JsonUtil.getResponseJson(cood, msg, null,postinglist );

		} catch (Exception e) {
			// TODO: handle exception

			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
		
		
	
   
    
    
    
		
	
	}
	/**
	 * 查询标题和模块信息
	 */
	@RequestMapping("/tiel")
	@ResponseBody
	public String listtr(String  id) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		try {
    List<T_plateputing> T_plateputing=T_replyService.tret(id);
    if (T_plateputing.size()>0) {
		msg = "查询成功";
		cood = 1;
		
	} else {
		msg = "暂无数据";
		cood = -1;
	}

	return JsonUtil.getResponseJson(cood, msg, null, T_plateputing);

		} catch (Exception e) {
			// TODO: handle exception

			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}
	
}
