package com.websit.mapper;

import com.websit.entity.T_permission;

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
public interface T_permissionMapper extends BaseMapper<T_permission> {

	/**
	 * 通过用户id查询权限
	 *
	 * @Title: selectPermsByUserName
	 * @description 
	 * @param userId
	 * @return  
	 * List<T_permissionMapper>    
	 * @author lujinpeng
	 * @createDate 2019年4月8日-下午1:49:17
	 */
	public List<T_permission> selectPermsByUserId(Long userId);
	
	/**
	 * 查询全部权限信息
	 *
	 * @Title: findAll
	 * @description 
	 * @return  
	 * List<T_permission>    
	 * @author lujinpeng
	 * @createDate 2019年4月8日-下午2:18:00
	 */
	public List<T_permission> findAll();
	
	/**
	 * 添加权限
	 *
	 * @Title: insertPermission
	 * @description 
	 * @param permission
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2019年4月14日-上午9:32:33
	 */
	public int insertPermission(T_permission permission);
	
	/**
	 * 修改权限
	 *
	 * @Title: updatePermission
	 * @description 
	 * @param permission
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2019年4月14日-上午9:40:24
	 */
	public int updatePermission(T_permission permission);
	
	/**
	 * 删除权限
	 *
	 * @Title: deletePermission
	 * @description 
	 * @param id
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2019年4月14日-上午9:45:27
	 */
	public int deletePermission(Long id);
	
}
