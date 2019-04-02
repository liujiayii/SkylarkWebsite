package com.websit.web;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.RequestMessage;
import com.websit.entity.ResponseMessage;
import com.websit.entity.T_comment;
import com.websit.service.IT_commentService;
import com.websit.until.JsonUtil;
import com.websit.until.fileuiil;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */

@Controller
@RequestMapping("/t_comment")
public class T_commentController {
	@Autowired
	public IT_commentService T_commentService;
	/** 回复发帖接口
     * @param T_posting
     * @return
     */
	@RequestMapping("/addt_comment")
	@ResponseBody
	public String T_postingController(@RequestBody T_comment T_comment) {
		// System.out.println("请求成功"+T_posting.toString());
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		Date sdf = new Date();
		
		//更新最新回复时间
		   int  it=T_commentService.update(T_comment.getPosting_id().toString());
		//try {
			//System.out.println(T_comment.getContext().toString());
			String  content=T_comment.getComment();
			fileuiil fileuiil=new fileuiil();
			String cent=fileuiil.upfileuiil(content);
			T_comment.setComment(cent);
			//System.out.println(it+"99999999999999999999999999999999999999999999999999"+T_comment.getPosting_id().toString());
			T_comment.setCreate_time(sdf);//获取当前时间
			boolean fig = T_commentService.insert(T_comment);// 调用T_postingService层
			if (fig) {
				msg = "回复成功";
				cood = 1;
			} else {
				msg = "回复失败";
				cood = -1;
			}

			return JsonUtil.getResponseJson(cood, msg, null, null);

		//} catch (Exception e) {
			// TODO: handle exception

			//return JsonUtil.getResponseJson(cood, msg, null, null);
		//}

	}
	
	@SendTo("/topic/selectbbsPost")
	@MessageMapping("/selectbbsPost")
	public String selectCount(RequestMessage name) {

		return JsonUtil.getResponseJson(1, "成功", null, null);
	}

	

}
