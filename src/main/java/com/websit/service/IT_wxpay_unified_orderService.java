package com.websit.service;

import com.websit.entity.T_wxpay_unified_order;
import com.websit.pay.Json;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 微信统一下单表（预支付） 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
public interface IT_wxpay_unified_orderService extends IService<T_wxpay_unified_order> {

	/**
	 * 
	 * @Title: wxPay
	 * @description: 发起微信支付
	 *
	 * @param out_trade_no
	 * @param total_money
	 * @param status
	 * @param request
	 * @return
	 * @throws Exception    
	 * @return Json   
	 *
	 * @author HanMeng
	 * @createDate 2019年3月24日-下午6:38:35
	 */
	Json wxPay( String user_id,String out_trade_no, String total_money,HttpServletRequest request) throws Exception;
}
