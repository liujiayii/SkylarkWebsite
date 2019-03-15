package com.websit.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_user;
import com.websit.entityvo.Personal;
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
	/**
	 * 
	*
	 * @Title: updateUser
	
	 * @description 修改个人信息
	*
	 * @param @param user
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月13日
	 */
	@RequestMapping("updateUser")
	public String updateUser(T_user user, HttpSession session){
		
		boolean updateById = userService.updateById(user);
		if(updateById){
			session.setAttribute("username", user.getNickname());
			return JsonUtil.getResponseJson(1, "修改成功", null, null);
		}
		return JsonUtil.getResponseJson(-1, "修改失败", null, null);
		
	}


	/**
	 * 根据用户id查询个人贴吧详细信息
	 * @author pangchong
	 * @createDate 2019年3月13日 下午2:00
	 */
@RequestMapping(value = "/selectUserById", produces = "application/json; charset=utf-8")
@ResponseBody
	public String selectUserById(Personal personal ) {
	
		try{
		List<Personal> result = userService.selectUserById(personal);
		
		if (result.size() >=1) {
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
		 * @author pangchong
		 * @createDate 2019年3月15日 下午2:00
		 */
	@RequestMapping(value = "/selectUserDayById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectUserDayById(Personal personal ) {
		
		return  userService.selectUserDayById(personal);
	
	}	
}
