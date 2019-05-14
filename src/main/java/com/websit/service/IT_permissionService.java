package com.websit.service;

import com.websit.entity.T_permission;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
public interface IT_permissionService extends IService<T_permission> {
	
	/**
	 * 通过角色查询左侧菜单列表
	 *
	 * @Title: ListMenusByRoleId
	 * @description 
	 * @param role_id
	 * @return List<Object>    
	 * @author lujinpeng
	 * @createDate 2019年5月1日-上午8:55:33
	 */
	public List<Object> ListMenusByRoleId(Long role_id);
	/**
	 * 左侧菜单列表
	 *
	 * @Title: ListMenu
	 * @description 
	 * @return  
	 * List<Object>    
	 * @author lujinpeng
	 * @createDate 2019年4月15日-下午4:15:07
	 */
	public List<Object> ListMenu();
	
	/**
	 * 添加权限
	 *
	 * @Title: insertPerms
	 * @description 
	 * @param permission
	 * @return  
	 * int   
	 * @author lujinpeng
	 * @createDate 2019年4月16日-上午10:01:44
	 */
	public int insertPermission(T_permission permission);
	
	/**
	 * 修改权限
	 *
	 * @Title: updatePermission
	 * @description 
	 * @param permission
	 * @return  
	 * int 
	 * @author lujinpeng
	 * @createDate 2019年4月16日-上午10:03:32
	 */
	public int updatePermission(T_permission permission);
	
	/**
	 * 删除权限
	 *
	 * @Title: deletePermission
	 * @description 
	 * @param id
	 * @return  
	 * int    
	 * @author lujinpeng
	 * @createDate 2019年4月16日-上午10:05:12
	 */
	public int deletePermission(Long id); 
	
	/**
	 * 将对象中的属性以及属性值添加到map集合中
	 *
	 * @Title: getAttribute
	 * @description 
	 * @param obj
	 * @param map  
	 * void    
	 * @author lujinpeng
	 * @createDate 2019年4月29日-下午3:03:32
	 */
	public void getAttribute(Object obj, Map<String, Object> map);
	
	
}
