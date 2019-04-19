package com.websit.mapper;

import com.websit.entity.T_app;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * app版本控制 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-15
 */
public interface T_appMapper extends BaseMapper<T_app> {
	public boolean uodatevison(T_app app);
}
