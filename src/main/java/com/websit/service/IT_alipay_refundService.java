package com.websit.service;

import com.websit.entity.T_alipay_refund;
import com.websit.entity.T_order;

import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 支付宝退款记录表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-27
 */
public interface IT_alipay_refundService extends IService<T_alipay_refund> {
	/**
	 * 
	*
	 * @Title: refund
	
	 * @description 支付宝退款
	*
	 * @param @param order
	 * @param @param httpResponse
	 * @param @return
	 * @param @throws AlipayApiException 
	   
	 * @return boolean    true 成功 false失败
	
	 *
	 * @author lishaozhang 
	 * @createDate 2019年3月27日
	 */
	boolean refund(String order_no,String money, HttpServletResponse httpResponse);
}
