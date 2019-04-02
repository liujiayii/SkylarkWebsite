package com.websit.mapper;

import com.websit.entity.T_wxpay_refund;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 退款记录表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public interface T_wxpay_refundMapper extends BaseMapper<T_wxpay_refund> {
	/**
	 * 
	 * @Title: findByOrderId
	 * @description: 根据商户生成的订单编号查找退款记录表
	 *
	 * @return    
	 * @return T_wxpay_refundMapper   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月26日-下午3:13:46
	 */
	T_wxpay_refundMapper findByOrderId(String out_trade_no);
	/**
	 * 
	 * @Title: insert
	 * @description: 插入退款数据
	 *
	 * @param record    
	 * @return void   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月26日-下午4:14:38
	 */
	public int insert(Map<String, String> record);
}
