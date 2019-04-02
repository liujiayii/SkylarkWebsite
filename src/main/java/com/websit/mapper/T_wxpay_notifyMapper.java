package com.websit.mapper;

import com.websit.entity.T_wxpay_notify;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 微信支付回调表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
public interface T_wxpay_notifyMapper extends BaseMapper<T_wxpay_notify> {
	/**
	 * 
	 * @Title: findByOrderId
	 * @description: 根据商户生成的订单编号查找回调表
	 *
	 * @return    
	 * @return T_wxpay_notify   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月25日-下午5:49:06
	 */
	T_wxpay_notify findByOrderId(String out_trade_no);
}
