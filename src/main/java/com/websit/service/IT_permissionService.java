package com.websit.service;

import com.websit.entity.T_permission;

import java.util.List;

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
	 * 查询权限
	 *
	 * @Title: selectPermission
	 * @description 
	 * @return  
	 * int    
	 * @author lujinpeng
	 * @createDate 2019年4月23日-上午10:10:48
	 */
	//public int selectPermission();
	
	
}
