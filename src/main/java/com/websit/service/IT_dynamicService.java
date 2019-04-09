package com.websit.service;

import com.websit.entity.T_dynamic;
import com.websit.entityvo.T_dynamicVo;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 公司动态表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-02
 */
public interface IT_dynamicService extends IService<T_dynamic> {
	/**
	 * @Title: SelectAllDy
	 * @description 查询所有动态
	 * @param @param t_dynamic
	 * @param @return    
	 * @return List<T_dynamic>    
	 * @author linhongyu
	 * @createDate 2019年4月3日
	 */
	public List<T_dynamicVo> SelectAllDy(T_dynamicVo t_dynamic);
}
