package com.websit.mapper;

import com.websit.entity.T_role;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
public interface T_roleMapper extends BaseMapper<T_role> {

	/**
	 * 通过admin_id 查询对应角色信息
	 *
	 * @Title: selectRoleByAdminId
	 * @description 
	 * @param user_id
	 * @return  
	 * List<T_role>    
	 * @author lujinpeng
	 * @createDate 2019年4月4日-下午5:24:07
	 */
	List<T_role> selectRoleByAdminId (Long admin_id);
	
	/**
	 * 查询所有角色列表
	 *
	 * @Title: findAll
	 * @description 
	 * @return  
	 * List<T_role>    
	 * @author lujinpeng
	 * @createDate 2019年4月14日-上午10:47:51
	 */
	List<T_role> findAll ();
	
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
	
	
	
}
