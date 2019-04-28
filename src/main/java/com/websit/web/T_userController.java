package com.websit.web;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.T_reply;
import com.websit.entity.T_user;
import com.websit.entity.UserUpdateVo;
import com.websit.entityvo.Personal;
import com.websit.entityvo.T_postingVo;
import com.websit.service.IT_postingService;
import com.websit.service.IT_userService;
import com.websit.until.DesUtil;
import com.websit.until.HttpClientUtil;
import com.websit.until.JsonUtil;
import com.websit.until.MD5Utils;

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
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(UserUpdateVo user) {
		System.out.println("user" + user);
		try {

			userService.updateUserVoById(user);
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
		System.out.println(page + limit);
		try {
			Integer star = (page - 1) * limit;
			List<Personal> result = userService.selectT_postingByUserId(id, star, limit);
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

	/**
	 * 
	 *
	 * @Title: selectT_postingByUserId
	 * 
	 * @description 修改密码
	 *
	 * @param @param
	 *            phid
	 * @param @param
	 *            password
	 * @param @param
	 *            new_password
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月17日
	 */
	@RequestMapping(value = "/user/updatePassworld",method=RequestMethod.POST)
	@ResponseBody
	public String updatePassworld(Long phid, String password, String new_password) {
     //验证前台传输的数据是否有空值
		try {

			if (phid == null || password == null || new_password == null) {
				return JsonUtil.getResponseJson(1, "密码不能为空", null, null);
			}
			
			// 使用正则验证密码格式是否正确
			String regular = "^([^\\s'‘’]{" + 8 + "," + 15 + "})$";
			boolean matches = new_password.matches(regular);
			if (!matches) {
				return JsonUtil.getResponseJson(-1, "密码必须是8-15位数字字母混合的", null, null);
			}
			
			// 正式 Ht3aZQ1EuyhbgPu7
			// 测试KwX3jBV5hOmTSUdc
			password = MD5Utils.hash(password + "Ht3aZQ1EuyhbgPu7");
			new_password = MD5Utils.hash(new_password + "Ht3aZQ1EuyhbgPu7");

			Map<String, String> map = new HashMap<String, String>();
			map.put("userId", phid + "");

			map.put("oldPassword", password);
			map.put("password", new_password);

			Object json = JSONObject.toJSON(map);
			String msg = json.toString();
			// 加密
			String encode = DesUtil.encode("yunquekeji", msg);
			System.out.println(encode);
			String doPost = HttpClientUtil.doPost(
					"https://www.ouyepuhui.com/account/rongyi/restYongyiPassword?encode="+ encode);
			JSONObject logjson = JSONObject.parseObject(doPost);

			if (logjson.get("code").toString().equals("200")) {
				
				List<T_user> selectList = userService.selectList(new EntityWrapper<T_user>().eq("phid", phid));
				T_user t_user = selectList.get(0);
				t_user.setPassword(new_password);
				return JsonUtil.getResponseJson(1, logjson.get("meaasge").toString(), null, null);
			}
			
			return JsonUtil.getResponseJson(1, logjson.get("meaasge").toString(), null, null);

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "", null, null);
		}
	}

}
