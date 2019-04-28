package com.websit.service;

import com.websit.entity.T_role;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
public interface IT_roleService extends IService<T_role> {

	/**
	 * 查询所有角色信息
	 *
	 * @Title: findAll
	 * @description 
	 * @return  
	 * List<T_role>    
	 * @author lujinpeng
	 * @createDate 2019年4月16日-上午10:38:58
	 */
	List<T_role> findAll();
	
	/**
	 * 通过用户id查询角色信息
	 *
	 * @Title: selectRoleByAdminId
	 * @description 
	 * @param admin_id
	 * @return  
	 * List<T_role>    
	 * @author lujinpeng
	 * @createDate 2019年4月16日-上午10:40:09
	 */
	List<T_role> selectRoleByAdminId(Long admin_id);
	
	/**
	 * 添加角色
	 *
	 * @Title: insertRole
	 * @description 
	 * @param role
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2019年4月14日-上午10:00:05
	 */
	int insertRole(T_role role);
	
	/**
	 * 修改角色
	 *
	 * @Title: updateRole
	 * @description 
	 * @param role
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2019年4月14日-上午10:00:36
	 */
	int updateRole(T_role role);
	
	/**
	 * 删除角色
	 *
	 * @Title: deleteRole
	 * @description 
	 * @param id
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2019年4月14日-上午10:01:21
	 */
	int deleteRole(Long id);
	
	/**
	 * 为角色批量分配权限
	 *
	 * @Title: insertPermsForRole
	 * @description 
	 * @param maps
	 * @return  
	 * int    
	 * @author lujinpeng
	 * @createDate 2019年4月19日-下午2:23:34
	 */
	int insertPermsForRole(List<Map<String, Object>> maps);
	
}
