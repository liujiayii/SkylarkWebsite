package com.websit.service;

import com.websit.entity.T_wxpay_refund;
import com.websit.mapper.T_wxpay_refundMapper;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 退款记录表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public interface IT_wxpay_refundService extends IService<T_wxpay_refund> {
	/**
	 * 
	 * @Title: findByOrderId
	 * @description: 根据商户生成的订单编号查找退款记录表
	 *
	 * @return    
	 * @return T_wxpay_refundMapper   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月26日-下午3:23:29
	 */
	T_wxpay_refundMapper findByOrderIds(String out_trade_no);
	
	public int insertSome(Map<String, String> record);
}
