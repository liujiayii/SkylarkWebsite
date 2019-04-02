package com.websit.mapper;

import com.websit.entity.T_admin;

import io.lettuce.core.dynamic.annotation.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

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
	
	
	

}
