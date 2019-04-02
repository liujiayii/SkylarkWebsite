package com.websit.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.websit.entity.T_reply;
import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.T_replylist;
import com.websit.entityvo.postinglist;

import com.websit.service.IT_replyService;
import com.websit.until.JsonUtil;

import java.util.Date;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
		//System.out.println("请求成功" + T_reply.toString());
		
		
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		Date sdf = new Date();
		T_reply.getResponse().length();
		//更新最新的回复时间
		
		if(T_reply.getResponse().length()>50) {
			msg = "发帖的字符太长，请修改";
			cood = -1;
		}else{
		@SuppressWarnings("unused")
		int fig1=T_replyService.updime(T_reply.getComment_id().toString());
		try {
			@SuppressWarnings("unused")
			T_postingController T_postingController=new T_postingController();
			//T_postingController
			T_reply.setCreate_time(sdf);// 获取当前时间
			boolean fig = T_replyService.insert(T_reply);// 调用T_postingService层
			if (fig) {
				msg = "回复评论成功";
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
		return JsonUtil.getResponseJson(cood, msg, null, null);
	}

	/**
	 * 查询详情的列表
	 *//*
		 * @RequestMapping("/xqlist")
		 * 
		 * @ResponseBody public String listtre(String id) { String msg = "系统异常，请稍后再试";
		 * Integer cood = -1; try {
		 * 
		 * List<postinglist> postinglist=T_replyService.postingli(id); //
		 * List<postinglist> t_commentlist=T_replyService.t_commentlist(id);
		 * //postinglist.addAll(t_commentlist); if (postinglist.size()>0) { msg =
		 * "查询成功"; cood = 1;
		 * 
		 * } else { msg = "暂无数据"; cood = -1; }
		 * 
		 * return JsonUtil.getResponseJson(cood, msg, null,postinglist );
		 * 
		 * } catch (Exception e) { 
		 * 
		 * return JsonUtil.getResponseJson(cood, msg, null, null); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
	/**
	 * 查询楼中楼的方法
	 */
	@RequestMapping("/querylist")
	@ResponseBody
	public String listtr(String id ,RowBounds RowBounds,Integer page,Integer limit) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
	
		try {
	    int  num=T_replyService.querlist(id);
		System.out.println(RowBounds.getLimit());
             int  upnumber=T_replyService.upnumber(id);//更新帖子的访问量
			// List<T_replylist> T_plateputing=T_replyService.T_replylist(id);
           /**
            * 查询回复内容
            */
			List<postinglist> postinglist = T_replyService.postingli(id,new RowBounds(page,limit));
			  /**
             * 查询标题和帖子
             */
			
			List<T_plateputing> T_plateputin = T_replyService.tret(id);
			/*/
			 * 查询总数量
			 */
			
			
			for (int i = 0; i < postinglist.size(); i++) {
				
				/**
				 * 查询回复的回复的内容
				 */
				int  num2=T_replyService.querlistnuk(postinglist.get(i).getId());
				postinglist.get(i).setNum2(num2);
				postinglist.get(i).setT_replylist(T_replyService.T_replylist(postinglist.get(i).getId(),new RowBounds(0,5)));
			}
			for (int i = 0; i < T_plateputin.size(); i++) {
				
				T_plateputin.get(i).setMap(postinglist);
			}

			//System.out.println(T_plateputing.toString());

			if (T_plateputin.size() > 0) {
				msg = "查询成功";
				cood = 1;

			} else {
				msg = "暂无数据";
				cood = -1;
			}

			return JsonUtil.getResponseJson(cood, msg, num, T_plateputin);

	} catch (Exception e) {
			 

			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}

	/**
	 * 查询回复评论信息
	 */
	@RequestMapping("/t_replylist")
	@ResponseBody
	public String t_reply(String comment_id,Integer page,Integer limit,RowBounds RowBounds) {
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		try {
			int  num=T_replyService.querlistnuk(comment_id);
			List<T_replylist> T_plateputing = T_replyService.T_replylist(comment_id,new RowBounds(page,limit));

			if (T_plateputing.size() > 0) {
				msg = "查询成功";
				cood = 1;

			} else {
				msg = "暂无数据";
				cood = -1;
			}

			return JsonUtil.getResponseJson(cood, msg, num, T_plateputing);

		} catch (Exception e) {
			

			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}

}
