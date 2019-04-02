package com.websit.service;

import com.websit.entity.T_admin;

import io.lettuce.core.dynamic.annotation.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
public interface IT_adminService extends IService<T_admin> {

	
	public T_admin selectbyName(@Param("username") String name);
	
	public Integer selectby(T_admin t);
}
