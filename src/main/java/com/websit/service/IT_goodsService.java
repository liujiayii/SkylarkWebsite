package com.websit.service;

import com.websit.entity.T_goods;

import io.lettuce.core.dynamic.annotation.Param;

import java.math.BigInteger;
import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 收货地址 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
public interface IT_goodsService extends IService<T_goods> {

	
	public List<T_goods> selectGoods(BigInteger id);
}
