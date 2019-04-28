package com.websit.service;

import com.websit.entity.T_shopping;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 订单商品表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-17
 */
public interface IT_shoppingService extends IService<T_shopping> {
	/**
	 * 商品发货
	 * @param shoping_logistics
	 * @param shoping_id
	 * @return
	 */
	int   logistics(String  shoping_logistics,Long shoping_id,String state);
}
