package com.websit.service;

import com.websit.entity.T_revert;
import com.websit.entityvo.T_revertVo;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品评论回复表（蔺） 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface IT_revertService extends IService<T_revert> {
	/**
	 * @Title: seleceFirstRevert
	 * @description 通过评论表id查询回复评论
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	public List<T_revertVo> seleceFirstRevert(long id,Integer page,Integer limit);
}
