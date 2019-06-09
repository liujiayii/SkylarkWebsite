package com.websit.web;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websit.entityvo.PostingForUpdateVo;
import com.websit.entityvo.T_postingVo;
import com.websit.service.IT_commentService;
import com.websit.service.IT_postingService;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_comment;
import com.websit.entity.T_plate;
import com.websit.entity.T_posting;
import com.websit.until.JsonUtil;
import com.websit.until.fileuiil;
import java.util.Date;


/**
 * <p>
 * 发帖表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @param <T_postingController>
 * @since 2019-03-13
 */
@Controller
public class T_postingController {

	@Autowired
	public IT_postingService T_postingService;
	@Autowired
	public IT_commentService t_commentService;
    /**
     * 发帖接口
     * @author chengzhihao
     * @param T_posting
     * @return
     * @Title: selecAllSome
     */
	@RequestMapping("/addT_posting")
	@ResponseBody
	public String postingController(@RequestBody T_posting T_posting) {
		// System.out.println("请求成功"+T_posting.toString());
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		Date sdf = new Date();

		try {
			T_posting.setCreate_time(sdf);//获取当前时间
			T_posting.setIs_dele(1);
			T_posting.setNew_time(sdf);
			
			String  content=T_posting.getContext();
			fileuiil fileuiil=new fileuiil();
			String cent=fileuiil.upfileuiil(content);
			T_posting.setContext(cent);
			boolean fig = T_postingService.insert(T_posting);// 调用T_postingService层
			
			if (fig==true) {
				msg = "发帖成功";
				cood = 1;
			} else {
				msg = "发帖失败";
				cood = -1;
			}
			return JsonUtil.getResponseJson(cood, msg, null, fig);

		} catch (Exception e) {
			// TODO: handle exception

			return JsonUtil.getResponseJson(cood, msg, null, null);
		}

	}


	

	/**
	 * @Title: selecAllSome
	 * @description 查询版主下的话题列表
	 * @return map
	 * @author linhongyu
	 * @createDate 2019年03月14日
	 */
	@RequestMapping(value = "/selecAllSome", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object selecAllSome(T_postingVo postingVo,Integer page,Integer limit) {
		try{
			postingVo.setPage((page-1)*limit);
			postingVo.setLimit(limit);
			postingVo.getPlate_id();
			List<T_postingVo> post=T_postingService.selecAllSome(postingVo);
			T_postingVo selectCount = T_postingService.selectCountTwo(postingVo);
			Integer count = selectCount.getCount();
			if (post.size() >=1&&count!=null) {
				return JsonUtil.getResponseJson(1, "查看成功", count, post);
			} else {
				return JsonUtil.getResponseJson(2, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: selecAllSomeTop
	 * @description 查询版主下的话题列表置顶
	 * @return List<T_postingVo> 
	 * @author linhongyu
	 * @createDate 2019年03月19日
	 */
	@RequestMapping(value = "/selecAllSomeTop", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object selecAllSomeTop(T_postingVo postingVo) {
		try{
			postingVo.getPlate_id();
			List<T_postingVo> post=T_postingService.selecAllSomeTop(postingVo);
			
			if (post.size() >=1) {
				return JsonUtil.getResponseJson(1, "查看成功", null, post);
			} else {
				return JsonUtil.getResponseJson(2, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 显示热门帖子
	 *
	 * @Title: showHotPostings
	
	 * @description 
	 *
	 * @param row 查询热门帖子条数
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月14日-下午5:28:09
	 */
	@RequestMapping("/showHotPostings")
	@ResponseBody
	public String showHotPostings(String page, String row) {
		Integer limit = null;
		if (StringUtils.isEmpty(page)) {
			page = "1";
		}
		
		if (StringUtils.isNotEmpty(row)) {
			limit = Integer.valueOf(row);
		} else {
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, "参数缺失", null, null);
		}
		
		return T_postingService.showHotPostings(Integer.valueOf(page), limit);
	}
	
	/**
	 * 显示最新发表帖子
	 *
	 * @Title: showNewestPostings
	
	 * @description 
	 *
	 * @param row 显示最新帖子数量
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月14日-下午5:42:05
	 */
	@RequestMapping("/showNewestPostings")
	@ResponseBody
	public String showNewestPostings(@RequestParam(value="plate_id", required = false) String plate_id, String row) {
		Long plateId = null;
		
		if (StringUtils.isNotEmpty(plate_id)) {
			plateId = Long.valueOf(plate_id);
		}
		
		if (StringUtils.isEmpty(row)) {
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, "参数缺失", null, null);
		}
		
		return T_postingService.showNewestPotings(plateId, Integer.valueOf(row));
	}
	
	/**
	 * 显示精华帖子
	 *
	 * @Title: showGoodPostings
	
	 * @description 
	 *
	 * @param row 显示精华帖子数量
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月15日-上午9:49:54
	 */
	@RequestMapping("/showGoodPostings")
	@ResponseBody
	public String showGoodPostings(Integer row) {
		
		return T_postingService.showGoodPostings(row);
	}

	/**
	 * 显示昨天、今天发帖数量以及总发帖数量
	 *
	 * @Title: showPostCount
	 * @description 
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月15日-下午5:13:40
	 */
	@RequestMapping("/showPostCount")
	@ResponseBody
	public String showPostCount() {
		
		return T_postingService.selectPostCounts();
	}
	
	/**
	 * @Title: selectNewMember
	 * @description 1.2 显示最新一个会员名称
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	@RequestMapping("/selectNewMember")
	@ResponseBody
	public String selectNewMember() {
		
		return T_postingService.selectNewMember();
	}
	
	
	/**
	 * 显示昨天、今天发帖数量以及总发帖数量
	 *
	 * @Title: showPostCount
	 * @description 
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月15日-下午5:13:40
	 */
	@RequestMapping("/showPost")
	@ResponseBody
	public String upnumber() {
		
		return null;
	}
	
	/**
	 *
	 * @Title: updatePostingTopState
	 * @description 修改帖子的置顶状态(是否置顶)
	 * @param @param postingVo
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@RequestMapping("/updatePostingTopState")
	@ResponseBody
	public String updatePostingTopState(@RequestBody PostingForUpdateVo postingVo) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		try {
			int fig = T_postingService.updatePostingTopState(postingVo);// 调用T_plate Service层
			if (fig != 0) {
				msg = "修改置顶状态成功";
				code = 1;
			} else {
				msg = "修改置顶状态失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, null, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	/**
	 *
	 * @Title: updatePostingDelState
	 * @description 修改帖子的删除状态(是否删除)
	 * @param @param postingVo
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@RequestMapping("/updatePostingDelState")
	@ResponseBody
	public String updatePostingDelState(@RequestBody PostingForUpdateVo postingVo) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		try {
			int fig = T_postingService.updatePostingDelState(postingVo);// 调用T_plate Service层
			if (fig != 0) {
				msg = "修改删除状态成功";
				code = 1;
			} else {
				msg = "修改删除状态失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, null, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	/**
	 * @Title: deletePosting
	 * @description （硬删除）删除一条帖子
	 * @param postingVo(user_id、id)
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	@RequestMapping("/deletePostingById")
	@ResponseBody
	public String deletePostingById(@RequestBody PostingForUpdateVo postingVo,HttpSession session) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		T_comment t_comment = new T_comment();
		t_comment.setPosting_id(postingVo.getId());  //前台传入帖子表的id
		if(postingVo.getUser_id().equals(session.getId())){ //判断当前用户是否为帖主，若是，执行操作
			try {
				int fig = T_postingService.deletePostingById(postingVo);// 调用T_posting Service层
				int num = t_commentService.deleteCommentByPostingId(t_comment);  //删除该帖子下的所有评论
				if (fig != 0 && num !=0) {
					msg = "删除该帖子成功";
					code = 1;
				} else {
					msg = "删除该帖子失败";
					code = -1;
				}

				return JsonUtil.getResponseJson(code, msg, null, null);

			} catch (Exception e) {
				// TODO: handle exception
				return JsonUtil.getResponseJson(code, msg, null, null);
			}
		}else{
			msg = "你没有权限删除该帖子";
			code = -1;
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	/**
	 *
	 * @Title: updatePostingTopState
	 * @description 修改帖子的精华状态(是否为精华帖)
	 * @param @param postingVo
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@RequestMapping("/updatePostingGoodState")
	@ResponseBody
	public String updatePostingGoodState(@RequestBody PostingForUpdateVo postingVo) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		try {
			int fig = T_postingService.updatePostingGoodState(postingVo);// 调用T_plate Service层
			if (fig != 0) {
				msg = "修改精华状态成功";
				code = 1;
			} else {
				msg = "修改精华状态失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, null, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	
	
}
