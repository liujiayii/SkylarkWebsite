package com.websit.mapper;

import com.websit.entity.T_shopping;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 订单商品表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-17
 */
public interface T_shoppingMapper extends BaseMapper<T_shopping> {
	/**
	 * 单个商品发货
	 * @return
	 */
	int   logistics(@Param ("shoping_logistics")String  shoping_logistics,@Param ("shoping_id")Long shoping_id,@Param ("state")String state);

}
