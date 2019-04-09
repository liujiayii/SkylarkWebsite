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
	/**
	 * @Title: selectThink
	 * @description 查询合作名称是否重复
	 * @param @param cooperation
	 * @param @return    
	 * @return T_cooperation    
	 * @author linhongyu
	 * @createDate 2019年4月4日
	 */
	public T_cooperation selectThink(T_cooperation cooperation);
	/**
	 * @Title: selectThinkTwo
	 * @description 查询地址名称是否重复
	 * @param @param cooperation
	 * @param @return    
	 * @return T_cooperation    
	 * @author linhongyu
	 * @createDate 2019年4月4日
	 */
	public T_cooperation selectThinkTwo(T_cooperation cooperation);
}
