package com.websit.service;

import com.websit.entity.T_access;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.Date;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 会员与访问数量表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_accessService extends IService<T_access> {

	

      public T_access conent(String time);
	
	public Integer insert1();
	
	public Integer updatenumber(String time);
}
