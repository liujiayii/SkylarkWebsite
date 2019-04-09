package com.websit.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_admin;
import com.websit.service.IT_adminService;
import com.websit.until.JsonUtil;
import com.websit.until.MD5Utils;

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

	/**
	 * 登录
	 * 
	 * @param t
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin")
	@ResponseBody
	public String admin(T_admin t, HttpSession session) {
		String str;
		// MD5密码
		try {

			String hash = MD5Utils.hash(t.getPassword() + "KwX3jBV5hOmTSUdc");
			t.setPassword(hash);
			Integer a = adminService.selectby(t);
			if (a == 1) {
				str = JsonUtil.getResponseJson(1, "查询成功", null, null);
			} else {
				T_admin ts = adminService.selectbyName(t.getUsername());
				if (ts == null) {
					str = JsonUtil.getResponseJson(-1, "账号不存在", null, null);
				} else {
					str = JsonUtil.getResponseJson(1, "密码错误", null, null);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}

		return str;
	}

	/**
	 * 添加账号
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping("/addAdmin")
	@ResponseBody
	public String Register(T_admin t) {
		String str;
		try {

			String hash = MD5Utils.hash(t.getPassword() + "KwX3jBV5hOmTSUdc");
			t.setCreate_time(new Date());
			t.setPassword(hash);
			boolean a = adminService.insert(t);
			if (a == true) {
				str = JsonUtil.getResponseJson(1, "增加成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(-1, "增加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}

	/**
	 * 修改状态和修改数据通用
	 * 
	 * @param t
	 * @return
	 */
	@RequestMapping("/updateAdmin")
	@ResponseBody
	public String updateAdmin(T_admin t) {
		String str;
		String hash;
		String password = (adminService.selectById(t.getId())).getPassword();
		try {
			if (t.getPassword().equals(password)) {
				hash = t.getPassword();
			} else {
				hash = MD5Utils.hash(t.getPassword() + "KwX3jBV5hOmTSUdc");
			}

			t.setPassword(hash);
			boolean a = adminService.updateById(t);
			if (a == true) {
				str = JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(-1, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "系统异常", null, null);
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
	@RequestMapping("/findAdminList")
	@ResponseBody
	public String findAdminList(Integer page, Integer limit) {

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
	 * 
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

		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("current", page);
		map.put("size", limit);

		return adminService.findAdminListByNameOrPhone(map);
	}

	/**
	 * 修改管理员账号信息
	 *
	 * @Title: updateAdminById
	 * @description 
	 * @param admin
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月3日-下午5:19:20
	 */
	@RequestMapping("/updateAdminById")
	@ResponseBody
	public String updateAdminById(T_admin admin) {
		
		return adminService.updateAdminById(admin);
	}
	
	
	
	public static void main(String[] args) {
		String hash = MD5Utils.hash(12345678 + "KwX3jBV5hOmTSUdc");
		System.out.println(hash);
	}

}
