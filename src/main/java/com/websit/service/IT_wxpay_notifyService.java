package com.websit.service;

import com.websit.entity.T_wxpay_notify;
import com.websit.pay.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 微信支付回调表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
public interface IT_wxpay_notifyService extends IService<T_wxpay_notify> {

	/**
	 * 
	 * @Title: wxNotify
	 * @description: 支付回调
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception    
	 * @return String   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月26日-上午9:53:51
	 */
	public String wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/**
	 * 
	 * @Title: findByOrderId
	 * @description: 根据商户订单号查找回调记录
	 *
	 * @return    
	 * @return T_wxpay_notify   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月26日-下午3:37:34
	 */
	T_wxpay_notify findByOrderId(String out_trade_no);
}
