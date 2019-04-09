package com.websit.service;

import com.websit.entity.T_cooperation;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 首页合作商 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_cooperationService extends IService<T_cooperation> {

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
