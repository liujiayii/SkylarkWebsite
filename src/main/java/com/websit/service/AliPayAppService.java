package com.websit.service;

import java.util.Map;

import com.websit.entity.T_order;
/**
 * 支付宝APP支付业务层接口
 *
 * @ClassName: AliPayAppService

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月27日-上午9:26:46
 */
public interface AliPayAppService {

	/**
	 *  获取支付宝加签后台的订单信息字符串 
	 *
	 * @Title: getAliPayOrderStr
	 * @description 
	 * @param t_order 订单表对象
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-上午9:23:03
	 */
	public String getAliPayOrderStr(T_order t_order);
	
	/** 支付宝支付成功后.异步请求该接口 */
	//public String notify(HttpServletRequest request,HttpServletResponse response) throws IOException;
	
	/**
	 * 支付宝异步请求逻辑处理
	 *
	 * @Title: notify
	 * @description 
	 * @param conversionParams 
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-上午9:23:36
	 */
	public String notify(Map<String, String> conversionParams);
	
	/**
	 * 向支付宝发起订单查询请求 
	 *
	 * @Title: checkAlipay
	 * @description 
	 * @param order_no 订单号
	 * @return  
	 * int    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午2:48:48
	 */
	public int checkAlipay(String order_no);
	
	/**
	 * 向支付宝发起退款请求
	 *
	 * @Title: alipayTradeRefund
	 * @description 
	 * @param order_no  订单号
	 * @param refund_fee 总退款金额
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午2:48:32
	 */
	public String alipayTradeRefund(String order_no, Double refund_fee);
	
}
