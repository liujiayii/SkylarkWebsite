package com.websit.mapper;

import com.websit.entity.T_access;
import com.websit.entityvo.Personal;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 会员与访问数量表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_accessMapper extends BaseMapper<T_access> {
	
	public T_access conent(@Param("create_time")String create_time);
	
	public Integer insert(@Param("create_time")Date create_time);
	
	public Integer updatenumber(@Param("create_time")String create_time);

}
