package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_admin;
import com.websit.entity.T_permission;
import com.websit.entity.T_role;
import com.websit.entity.T_role_admin;
import com.websit.entity.T_role_permission;
import com.websit.service.IT_adminService;
import com.websit.service.IT_admin_roleService;
import com.websit.service.IT_permissionService;
import com.websit.service.IT_roleService;
import com.websit.service.IT_role_permissionService;
import com.websit.until.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  角色前端控制器
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
@Controller
@RequestMapping(value = "/role", produces = "application/json;charset=UTF-8")
public class T_roleController {

	@Autowired
	private IT_roleService roleService;
	
	@Autowired
	private IT_role_permissionService role_permissionService;
	
	@Autowired
	private IT_permissionService permissionService;
	
	@Autowired
	private IT_adminService adminService;
	
	@Autowired
	private IT_admin_roleService admin_roleService;
	
	/**
	 * 添加角色
	 *
	 * @Title: add
	 * @description 
	 * @param role
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月22日-上午10:38:24
	 */
	@RequestMapping("/addRole")
	@ResponseBody
	public String add(T_role role) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_INSERT_MSG;
		try {
			roleService.insert(role);
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_INSERT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, 0, null);
	}
	
	/**
	 * 为角色批量添加或修改权限
	 *
	 * @Title: addPermsForRole
	 * @description 
	 * @param role_id 角色id
	 * @param permission_ids 权限id数组
	 * @return String    
	 * @author lujinpeng
	 * @createDate 2019年4月19日-下午3:15:06
	 */
	@RequestMapping("/addOrUpdatePermsForRole")
	@ResponseBody
	public String addOrUpdatePermsForRole(Long role_id, Long...permission_ids) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_INSERT_MSG;
		List<Map<String, Object>> list = new ArrayList<>();
		int count = role_permissionService.selectCount(new EntityWrapper<T_role_permission>().eq("role_id", role_id));
		// 如果是修改权限，则先删除，再添加权限
		if (count > 0) {
			role_permissionService.delete(new EntityWrapper<T_role_permission>().eq("role_id", role_id));
		}
		
		for (Long permission_id : permission_ids) {
			Map<String, Object> map = new HashMap<>();
			map.put("role_id", role_id);
			map.put("permission_id", permission_id);
			list.add(map);
		}
		
		try {
			roleService.insertPermsForRole(list);
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_INSERT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, 0, null);
	}
	
	/**
	 * 查询角色列表
	 *
	 * @Title: listRole
	 * @description 
	 * @param ipage
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月22日-上午11:26:42
	 */
	@RequestMapping("/listRole")
	@ResponseBody
	public String listRole(Page<T_role> ipage, Integer page, Integer limit) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		
		if (StringUtils.isEmpty(page) || StringUtils.isEmpty(limit)) {
			return JsonUtil.getResponseJson(code, "参数缺失", null, null);
		}
		page = (page < 0) ? 0 : limit * (page -1);
		ipage.setCurrent(page);
		ipage.setSize(limit);
		Page<T_role> selectPage = null;
		
		try {
			selectPage = roleService.selectPage(ipage);
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_SELECT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, (int)selectPage.getTotal(), selectPage.getRecords());
	}
	
	/**
	 * 修改角色信息
	 *
	 * @Title: updateRole
	 * @description 
	 * @param role
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月22日-上午11:40:00
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	@Transactional
	public String updateRole(T_role role) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_UPDATE_MSG;
		int result = 0;
		T_role oldRole = roleService.selectById(role.getId());
		
		try {
			result = roleService.updateRole(role);
			T_role t_role = roleService.selectById(role.getId());
			if (result > 0) {
				T_admin adm = new T_admin();
				adm.setPost(t_role.getName());
				List<T_admin> adminList = adminService.selectListSelective(adm);
				if (t_role.getStatus() == 1 && t_role.getStatus() != oldRole.getStatus()) {
					for (T_admin admin : adminList) {
						admin.setStatus(1);
						adminService.updateByIdSelective(admin);
					}
					msg = "角色状态锁定成功，该角色所有用户将被锁定";
				} else if (t_role.getStatus() == 0 && t_role.getStatus() != oldRole.getStatus()) {
					for (T_admin admin : adminList) {
						admin.setStatus(0);
						adminService.updateByIdSelective(admin);
					}
					msg = "角色启用成功";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = result = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_UPDATE_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, result, null);
	}
	
	/**
	 * 删除角色
	 *
	 * @Title: deleteRole
	 * @description 
	 * @param id
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月22日-上午11:56:57
	 */
	@RequestMapping("/deleteRole")
	@ResponseBody
	@Transactional
	public String deleteRole(Long id) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_DELETE_MSG;
		int result = 0;
		
		try {
			// 删除角色
			result = roleService.deleteRole(id);
			if (result > 0) {
				// 删除角色权限关系表关联数据
				role_permissionService.delete(new EntityWrapper<T_role_permission>().eq("role_id", id));
				// 删除用户与角色关系表关联数据
				admin_roleService.delete(new EntityWrapper<T_role_admin>().eq("role_id", id));
				
				msg = "角色删除成功，请尽快为该角色用户分配新角色，以免影响账号正常使用";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = result = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_DELETE_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, result, null);
	}
	
	/**
	 * 通过id查询角色
	 *
	 * @Title: selectRoleById
	 * @description 
	 * @param id
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月22日-下午3:02:51
	 */
	@RequestMapping("/selectRoleById")
	@ResponseBody
	public String selectRoleById(Long id) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		T_role role = null;
				
		try {
			role = roleService.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_SELECT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, role);
	}
	
	/**
	 * 显示角色对应权限列表
	 *
	 * @Title: selectPermsByRoleId
	 * @description 
	 * @param role_id 角色id
	 * @return String    
	 * @author lujinpeng
	 * @createDate 2019年4月22日-下午6:19:25
	 */
	@RequestMapping("/selectPermsByRoleId")
	@ResponseBody
	public String selectPermsByRoleId(Long role_id) {
		int code = ReturnCode.SUCCSEE_CODE;
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		List<Object> wrapList = new ArrayList<> ();
			
		try {
			// 查询角色和权限对应关系
			List<T_role_permission> rpList = role_permissionService.selectList(new EntityWrapper<T_role_permission>().eq("role_id", role_id));
			
			for (T_role_permission rolePerm : rpList) {
				wrapList.add(rolePerm.getPermission_id());
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_SELECT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, wrapList.size(), wrapList);
	}
	
}
