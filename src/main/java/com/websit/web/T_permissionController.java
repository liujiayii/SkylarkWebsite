package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_permission;
import com.websit.entity.T_role_permission;
import com.websit.service.IT_permissionService;
import com.websit.until.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
    private static final Logger logger = Logger.getLogger(T_permissionController.class);
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
			msg = ReturnCode.FAILED_SELECT_MSG;
		}
		
		if (StringUtils.isEmpty(listMenu) || listMenu.size() == 0) {
			msg = ReturnCode.NORESULT_SELECT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, listMenu.size(), listMenu);
	}
	
	/**
	 * 添加权限
	 *
	 * @Title: insertPerm
	 * @description 
	 * @param permission
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月16日-上午10:17:56
	 */
	@RequestMapping("/insertPerm")
	@ResponseBody
	public String insertPerm(T_permission permission) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_INSERT_MSG;
		
		try {
			permissionService.insertPermission(permission);
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_INSERT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 修改权限
	 *
	 * @Title: updatePerm
	 * @description 
	 * @param permission
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月16日-上午10:28:01
	 */
	@RequestMapping("/updatePerm")
	@ResponseBody
	public String updatePerm(T_permission permission) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_UPDATE_MSG;
		
		try {
			permissionService.updatePermission(permission);
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_UPDATE_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 删除权限
	 *
	 * @Title: deletePerm
	 * @description 
	 * @param id
	 * @return String    
	 * @author lujinpeng
	 * @createDate 2019年4月23日-上午9:51:44
	 */
	@RequestMapping("/deletePerm")
	@ResponseBody
	public String deletePerm(Long id) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_DELETE_MSG;
		
		try {
			permissionService.deletePermission(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_DELETE_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 显示权限树状结构数据列表
	 *
	 * @Title: selectPermsByRoleId
	 * @description 
	 * @param role_id 角色id
	 * @return String    
	 * @author lujinpeng
	 * @createDate 2019年4月22日-下午6:19:25
	 */
	@RequestMapping("/selectPermsTreeData")
	@ResponseBody
	public String selectPermsTreeData() {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		List<Object> wrapList = new ArrayList<> ();
		// 一级目录
		Map<String, Object> menus = null;
		// 二级菜单
		Map<String, Object> submenu = null;
		// 权限按钮
		Map<String, Object> permBtn = null;
			
		try {
			// 查询角色和权限对应关系
			List<T_permission> permsList = permissionService.selectList(new EntityWrapper<T_permission>());
			
			for (T_permission mperm : permsList) {
				menus = new HashMap<> ();
				// 通过权限id查询权限信息
				//T_permission perms = permissionService.selectById(rolePerm.getPermission_id());
				
				// 一级目录
				if (mperm.getPid() == 0) {
					// 二级菜单集合
					List<Object> submenuList = new ArrayList<> ();
					// 查询二级菜单
					List<T_permission> subPerms = permissionService.selectList(new EntityWrapper<T_permission>().eq("pid", mperm.getId()));
					
					// 一级目录
					menus = new HashMap<> ();
					menus.put("key", mperm.getId());
					menus.put("title", mperm.getName());
					
					for (T_permission sperm : subPerms) {
						// 权限菜单集合
						List<Object> permBtnList = new ArrayList<> ();
						// 查询权限菜单
						List<T_permission> btnPerms = permissionService.selectList(new EntityWrapper<T_permission>().eq("pid", sperm.getId()));
						
						for (T_permission btnPerm : btnPerms) {
							permBtn = new HashMap<> ();
							permBtn.put("key", btnPerm.getId());
							permBtn.put("title", btnPerm.getName());
							permBtnList.add(permBtn);
						}
						
						// 二级菜单
						submenu = new HashMap<> ();
						submenu.put("key", sperm.getId());
						submenu.put("title", sperm.getName());
						submenu.put("children", permBtnList);
						submenuList.add(submenu);
					}
					menus.put("children", submenuList);	
				} else {
					break;
				}
				
				wrapList.add(menus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_SELECT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, wrapList.size(), wrapList);
	}
	
	
}
