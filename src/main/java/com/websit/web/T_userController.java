package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_reply;
import com.websit.entity.T_user;
import com.websit.entity.UserUpdateVo;
import com.websit.entityvo.Personal;
import com.websit.entityvo.T_postingVo;
import com.websit.service.IT_postingService;
import com.websit.service.IT_userService;
import com.websit.until.JsonUtil;

/**
 * <p>
 * 前台用户表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Controller
public class T_userController {

	@Autowired
	private IT_userService userService;
	@Autowired
	private IT_postingService T_postingService;

	/**
	 * 
	 *
	 * @Title: updateUser
	 * 
	 * @description 修改个人信息
	 *
	 * @param @param
	 *            user
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月13日
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(UserUpdateVo user) {
		try {

			boolean updateById = userService.updateUserVoById(user);
			T_user selectById = userService.selectById(user.getId());
			selectById.setPassword(null);
				return JsonUtil.getResponseJson(1, "修改成功", null, selectById);
			
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "修改失败", null, null);
		}

	}

	/**
	 * 根据用户id查询个人贴吧详细信息
	 * 
	 * @author pangchong
	 * @createDate 2019年3月13日 下午2:00
	 */
	@RequestMapping(value = "/selectUserById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectUserById(Personal personal, HttpSession session) {
		/*
		 * // 获得当前用户id BigInteger id = new BigInteger(session.getAttribute("id")
		 * + ""); personal.setId(id);
		 */
		try {
			List<Personal> result = userService.selectUserById(personal);

			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 根据用户id查询会员天数
	 * 
	 * @author pangchong
	 * @createDate 2019年3月15日 下午2:00
	 */
	@RequestMapping(value = "/selectUserDayById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectUserDayById(Personal personal) {

		return userService.selectUserDayById(personal);

	}

	/**
	 * 查询用户回帖数量
	 * 
	 * @author pangchong
	 * @createDate 2019年3月18日 下午2:00
	 */
	@RequestMapping(value = "/selectUserReplyCountByUserId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectUserReplyCountByUserId(T_reply reply) {

		try {
			Integer count = userService.selectUserReplyCountByUserId(reply);
			System.out.println(count);
			if (count != null) {
				return JsonUtil.getResponseJson(1, "查看成功", null, count);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 根据id查看用户发布过的贴子及数量
	 * 
	 * @author pangchong
	 * @createDate 2019年3月13日 下午2:00
	 */
	@RequestMapping(value = "/selectT_postingByUserId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectT_postingByUserId(Integer page, Integer limit, Integer id) {
		System.out.println(page+limit);
		try {
			 Integer star = (page - 1) * limit;
			List<Personal> result = userService.selectT_postingByUserId(id, star,limit);
			Integer count = T_postingService.selectPostingCount();
			if (result.size() > 0) {
				return JsonUtil.getResponseJson(1, "查询成功", count, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

}
