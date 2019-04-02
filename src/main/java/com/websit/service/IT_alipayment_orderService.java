package com.websit.service;

import com.websit.entity.T_alipayment_order;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商户支付宝订单 服务类
 * </p>
 *
 * @author lujinpeng
 * @since 2019-03-27
 */
public interface IT_alipayment_orderService extends IService<T_alipayment_order> {

	/**
	 * 通过商户订单号查询商户订单
	 *
	 * @Title: selectByOutTradeNo
	 * @description 
	 * @param order_no
	 * @return  
	 * T_alipayment_order    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午2:32:24
	 */
	public T_alipayment_order selectByOutTradeNo(String order_no);
	
	/**
	 * 更新交易表中状态
	 *
	 * @Title: updateByPrimaryKey
	 * @description
	 * @return int
	 * @author lujinpeng
	 * @createDate 2019年3月25日-下午6:15:03
	 */
	public int updateByPrimaryKey(T_alipayment_order alipaymentOrder);
	
	/**
	 * 创建新的商户支付宝订单
	 *
	 * @Title: createAlipayMentOrder
	 * @description 
	 * @param alipaymentOrder
	 * @return  
	 * boolean    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-上午11:50:51
	 */
	public boolean createAlipayMentOrder(T_alipayment_order alipaymentOrder);
	
	
	
}
