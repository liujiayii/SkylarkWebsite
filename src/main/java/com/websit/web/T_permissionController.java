package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.constant.ReturnCode;
import com.websit.service.IT_permissionService;
import com.websit.until.JsonUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
@Controller
@RequestMapping(value = "/perms", produces = { "application/json;charset=UTF-8" })
public class T_permissionController {

	@Autowired
	private IT_permissionService permissionService;
	
	/**
	 * 显示左侧菜单目录和列表
	 *
	 * @Title: showMenuList
	 * @description 
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月15日-下午4:24:12
	 */
	@RequestMapping("/showMenuList")
	@ResponseBody
	public String showMenuList() {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		List<Object> listMenu = null;
		
		try {
			listMenu = permissionService.ListMenu();
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.EXCEPTION_MSG;
		}
		
		if (StringUtils.isEmpty(listMenu) || listMenu.size() == 0) {
			msg = ReturnCode.NORESULT_SELECT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, listMenu.size(), listMenu);
	}
	
}
