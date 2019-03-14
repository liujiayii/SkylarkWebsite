package com.websit.mapper;

import com.websit.entity.T_cooperation;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 首页合作商 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_cooperationMapper extends BaseMapper<T_cooperation> {

	public T_cooperation selectThink(T_cooperation cooperation);
	public T_cooperation selectThinkTwo(T_cooperation cooperation);
}
