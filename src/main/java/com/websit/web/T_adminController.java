package com.websit.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_admin;
import com.websit.entity.T_role_admin;
import com.websit.entity.T_role;
import com.websit.service.IT_adminService;
import com.websit.service.IT_admin_roleService;
import com.websit.service.IT_roleService;
import com.websit.until.JsonUtil;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
@Controller

public class T_adminController {
	@Autowired
	private IT_adminService adminService;

	@Autowired
	private IT_roleService roleService;
	
	@Autowired
	private IT_admin_roleService admin_roleService;
	
	/**
	 * 添加账号
	 *
	 * @Title: addAdmin
	 * @description 
	 * @param t
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年5月4日-上午10:44:11
	 */
	@RequestMapping("/addAdmin")
	@ResponseBody
	public String addAdmin(T_admin t) {
		String str = "";
		
		try {
			T_admin admin = adminService.findByUserName(t.getUsername());
			
			if (admin != null) {
				return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, "该用户名已存在", null, null);
			}
			T_role role = roleService.selectById(Long.parseLong(t.getPost()));
			t.setPost(role.getName());
			t.setPassword(new BCryptPasswordEncoder().encode(t.getPassword()));
			t.setCreate_time(new Date());
			// 将用户添加到用户表
			boolean res = adminService.insert(t);
			
			if (res == true) {
				// 向用户角色中间表添加用户和角色的关联关系
				admin_roleService.insertAllColumn(new T_role_admin(null, t.getId(), role.getId()));
				str = JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_INSERT_MSG, null, null);
			} else {
				str = JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.FAILED_INSERT_MSG, null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return str;
	}

	/**
	 * 查询管理员账户列表
	 *
	 * @Title: findAdminList
	 * @description
	 * @param page
	 * @param limit
	 * @return String
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午2:42:45
	 */
	@RequestMapping(value="/findAdminList", produces="application/json;charset=utf-8")
	@ResponseBody
	public String findAdminList(Integer page, Integer limit) {
		if (page == null || limit == null) {
			return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, "参数缺失", null, null);
		}
		page = (page - 1) * limit;
		
		return adminService.findAdminList(page, limit);
	}

	/**
	 * 通过id查询管理员账户信息
	 *
	 * @Title: findAdminById
	 * @description
	 * @param id
	 * @return String
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午3:48:01
	 */
	@RequestMapping("/findAdminById")
	@ResponseBody
	public String findAdminById(Long id) {

		return adminService.findAdminById(id);
	}

	/**
	 * 通过id删除管理员信息
	 *
	 * @Title: deleteAdminById
	 * @description
	 * @param id
	 * @return String
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午4:46:39
	 */
	@RequestMapping("/deleteAdminById")
	@ResponseBody
	public String deleteAdminById(Long id) {

		return adminService.deleteAdminById(id);
	}

	/**
	 * 通过管理员姓名或电话搜索
	 *
	 * @Title: findAdminListByNameOrPhone
	 * @description
	 * @param name
	 *            管理员姓名
	 * @param phone
	 *            管理员电话
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页显示条数
	 * @return String
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午4:49:50
	 */
	@RequestMapping("/findAdminByNameOrPhone")
	@ResponseBody
	public String findAdminByNameOrPhone(String name, String phone, Integer page, Integer limit) {
		if (page == null || limit == null) {
			return JsonUtil.getResponseJson(1, "参数缺失", null, null);
		}
        page = (page - 1) * limit;
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("page", page);
		map.put("limit", limit);

		return adminService.findAdminListByNameOrPhone(map);
	}

	/**
	 * 修改管理员账号信息
	 *
	 * @Title: updateAdminById
	 * @description
	 * @param admin
	 * @return String
	 * @author lujinpeng
	 * @createDate 2019年4月3日-下午5:19:20
	 */
	@RequestMapping("/updateAdmin")
	@ResponseBody
	public String updateAdmin(T_admin admin) {

		return adminService.updateAdminById(admin);
	}


}
