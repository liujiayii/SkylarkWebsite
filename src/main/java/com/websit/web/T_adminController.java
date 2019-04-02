package com.websit.web;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_admin;
import com.websit.entityvo.Logivo;
import com.websit.service.IT_adminService;
import com.websit.until.JsonUtil;
import com.websit.until.MD5Utils;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	 * @param t
	 * @param session
	 * @return
	 */
	@RequestMapping("/admin")
	@ResponseBody
	public String admin(T_admin t, HttpSession session){
		String str;
		// MD5密码
		try {
			
			String hash = MD5Utils.hash(t.getPassword() + "KwX3jBV5hOmTSUdc");
			t.setPassword(hash);
			Integer a=adminService.selectby(t);
			if(a==1){
				str=JsonUtil.getResponseJson(1, "查询成功", null, null);
			}else{
				T_admin ts=adminService.selectbyName(t.getUsername());
				if(ts==null){
					str=JsonUtil.getResponseJson(-1, "账号不存在", null, null);
				}else{
					str=JsonUtil.getResponseJson(1, "密码错误", null, null);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
				
		return str;
	}
	
	/**
	 * 添加账号
	 * @param t
	 * @return
	 */
	@RequestMapping("/addAdmin")
	@ResponseBody
	public String Register(@RequestBody T_admin t) {
		String str;
		try {

			String hash = MD5Utils.hash(t.getPassword() + "KwX3jBV5hOmTSUdc");
			t.setCreate_time(new Date());
			t.setPassword(hash);
			boolean a=adminService.insert(t);
			if(a==true){
				str=JsonUtil.getResponseJson(1, "增加成功", null, null);
			}else{
				str=JsonUtil.getResponseJson(-1, "增加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
	/**
	 * 修改状态和修改数据通用
	 * @param t
	 * @return
	 */
	@RequestMapping("/updateAdmin")
	@ResponseBody
	public String updateAdmin(@RequestBody T_admin t) {
		String str;
		String hash;
		String password=(adminService.selectById(t.getId())).getPassword();
		try {
             if(t.getPassword().equals(password)){
            	 hash=t.getPassword();
             }else{
            	 hash = MD5Utils.hash(t.getPassword() + "KwX3jBV5hOmTSUdc"); 
             }
			 
			
			t.setPassword(hash);
			boolean a=adminService.updateById(t);
			if(a==true){
				str=JsonUtil.getResponseJson(1, "修改成功", null, null);
			}else{
				str=JsonUtil.getResponseJson(-1, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
	
	public static void main(String[] args) {
		String hash = MD5Utils.hash(12345678 + "KwX3jBV5hOmTSUdc");
		System.out.println(hash);
	}

}
