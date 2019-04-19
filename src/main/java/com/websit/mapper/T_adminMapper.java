package com.websit.mapper;

import com.websit.entity.T_admin;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
public interface T_adminMapper extends BaseMapper<T_admin> {
	/**
	 * 判断是否有这个账号
	 * @param name
	 * @return
	 */
	public T_admin selectbyName(@Param("username") String name);
	/**
	 * 验证登录
	 * @param t
	 * @return
	 */
	public Integer selectby(@Param("t")T_admin t);
	
	/**
	 * 分页查询管理员账号列表
	 *
	 * @Title: findAdminList
	 * @description 
	 * @param page
	 * @return  
	 * List<T_admin>    
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午2:17:50
	 */
	public List<T_admin> findAdminList(Pagination page);
	
	/**
	 * 通过登录名称获取管理员信息
	 *
	 * @Title: findByUserName
	 * @description 
	 * @param name
	 * @return T_admin    
	 * @author lujinpeng
	 * @createDate 2019年4月11日-上午9:30:53
	 */
	public T_admin findByUserName (String name);

}
