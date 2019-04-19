package com.websit.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.constant.AlipayReturnEnum;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_order;
import com.websit.service.AliPayAppService;
import com.websit.until.JsonUtil;

/**
 * App支付宝支付调用接口
 *
 * @ClassName: AliPayAppController

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月27日-下午2:24:30
 */
@Controller
@RequestMapping("/aliPayApp")
public class AliPayAppController {

private static final Logger logger = Logger.getLogger(AliPayAppController.class);
	
	@Autowired
	private AliPayAppService aliPayAppService;
	
	/**
	 * 获取支付宝加签后台的订单信息字符串,唤起支付宝APP
	 *
	 * @Title: getAliPayOrderStr
	 * @description 
	 * @param t_order 订单对象
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午2:28:49
	 */
	@RequestMapping("/getAliPayOrderStr")
	@ResponseBody
	public String getAliPayOrderStr(T_order t_order) {
		
		return aliPayAppService.getAliPayOrderStr(t_order);
	}
	
	
	/**
	 * 支付宝支付成功后.异步请求该接口
	 *
	 * @Title: notify
	 * @description 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午1:46:34
	 */
	@RequestMapping(value="/notify_url",method=RequestMethod.POST)
	@ResponseBody
	public String notify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("==================支付宝异步返回支付结果开始");
		// 1.从支付宝回调的request域中取值
		// 获取支付宝返回的参数集合
		Map<String, String[]> aliParams = request.getParameterMap();
		// 用以存放转化后的参数集合
		Map<String, String> conversionParams = new HashMap<String, String>();
		for (Iterator<String> iter = aliParams.keySet().iterator(); iter.hasNext();) {
			String key = iter.next();
			String[] values = aliParams.get(key);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "uft-8");
			System.out.println("key=="+key+" valueStr=="+valueStr);
			conversionParams.put(key, valueStr);
		}
		logger.info("==================返回参数集合：" + conversionParams);
		String status = aliPayAppService.notify(conversionParams);
		
		return JsonUtil.getResponseJson(1, status, null, null);
	}
	
	/**
	 * 向支付宝发起订单查询请求
	 *
	 * @Title: checkAlipay
	 * @description 
	 * @param order_no 商户订单号
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午2:21:28
	 */
	@RequestMapping("/checkAlipay")
	@ResponseBody
	public String checkAlipay(String order_no) {
		int result = aliPayAppService.checkAlipay(order_no);
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, AlipayReturnEnum.getName(result), null, null);
		
		
	}
	
	/**
	 * 向支付宝发起退款请求
	 *
	 * @Title: alipayTradeRefund
	 * @description 
	 * @param order_no 商户订单号
	 * @param refund_fee 退款金额
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午4:49:47
	 */
	@RequestMapping("/alipayTradeRefund")
	@ResponseBody
	public String alipayTradeRefund(String order_no, Double refund_fee) {
		
		return aliPayAppService.alipayTradeRefund(order_no, refund_fee);
	}
	
	
	
	
}
