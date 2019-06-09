package com.websit.web;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.RequestMessage;
import com.websit.entity.ResponseMessage;
import com.websit.entity.T_comment;
import com.websit.entityvo.PostingForUpdateVo;
import com.websit.service.IT_commentService;
import com.websit.until.JsonUtil;
import com.websit.until.fileuiil;

import java.util.Date;

import javax.servlet.http.HttpSession;

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
			System.out.println("fig::"+fig);
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
	
	/**
	 *
	 * @Title: deleteCommentById
	 * @description （后台）通过id删除一条违规评论
	 * @param @param id
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月4日
	 */
	@RequestMapping("/deleteCommentById")
	@ResponseBody
	public String deleteCommentById(@RequestBody Long id) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		boolean isDel = T_commentService.deleteById(id);// 调用T_commentService层
		System.out.println("isDel::" + isDel);
		if (isDel) {
			msg = "删除评论成功";
			code = 1;
		} else {
			msg = "删除评论失败";
			code = -1;
		}

		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * @Title: deleteCommentByUser
	 * @description 前台用户删除自己帖子下的评论
	 * @param @param t_comment
	 * @param @param postingVo
	 * @param @param session
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	@RequestMapping("/deleteCommentByUser")
	@ResponseBody
	public String deleteCommentByUser(@RequestBody T_comment t_comment, PostingForUpdateVo postingVo, HttpSession session) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		t_comment.setPosting_id(postingVo.getId());  //前台传入帖子表的id
		if(postingVo.getUser_id().equals(session.getId())){  //判断当前用户是否为帖主，若是，执行操作
			T_comment comment = T_commentService.selectById(t_comment.getId());  //通过id查询posting_id
			if(postingVo.getId().equals(comment.getPosting_id())){  //若帖子表id == 评论表的posting_id，执行删除操作
				
				int isDel = T_commentService.deleteCommentByPostingId(t_comment);// 调用T_commentService层
				if (isDel != 0) {
					msg = "删除评论成功";
					code = 1;
				} else {
					msg = "删除评论失败";
					code = -1;
				}
			}else{
				msg = "你没有权限删除该评论";
				code = -1;
				return JsonUtil.getResponseJson(code, msg, null, null);
			}
			
		}else{
			msg = "你没有权限删除该评论";
			code = -1;
			return JsonUtil.getResponseJson(code, msg, null, null);
		}

		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * @Title: deleteCommentByPostingId
	 * @description 根据帖子id删除回复信息
	 * @param @param t_comment
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	@RequestMapping("/deleteCommentByPostingId")
	@ResponseBody
	public String deleteCommentByPostingId(@RequestBody T_comment t_comment) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		int isDel = T_commentService.deleteCommentByPostingId(t_comment);// 调用T_commentService层
		System.out.println("isDel::" + isDel);
		if (isDel != 0) {
			msg = "删除评论成功";
			code = 1;
		} else {
			msg = "删除评论失败";
			code = -1;
		}

		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	

}
