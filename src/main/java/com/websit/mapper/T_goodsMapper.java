package com.websit.mapper;

import com.websit.entity.T_goods;



import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 收货地址 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
public interface T_goodsMapper extends BaseMapper<T_goods> {
	
	public List<T_goods> selectGoods(@Param("user_id") BigInteger id);

}
