package com.websit.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.config.AlipayConfig;
import com.websit.entity.T_alipay_refund;
import com.websit.entity.T_alipay_success;
import com.websit.entity.T_order;
import com.websit.service.IT_alipay_refundService;
import com.websit.service.IT_alipay_successService;
import com.websit.service.IT_orderService;
import com.websit.until.JsonUtil;

@Controller
@RequestMapping("alipay")
public class AliPcPay {

	@Autowired
	IT_orderService orderService;
	@Autowired
	IT_alipay_successService paysuccessService;
	@Autowired
	IT_alipay_refundService refundService;

	/**
	 * 
	 *
	 * @Title: notify_url
	 * 
	 * @description 异步校验
	 *
	 * @param @param
	 *            req
	 * @param @param
	 *            rps
	 * 
	 * @return void
	 *
	 * 
	 * @author lishaozhang
	 * @throws Exception
	 * @createDate 2019年3月26日
	 */
	@RequestMapping("notify_url")
	public void notify_url(HttpServletRequest request, HttpServletResponse rps) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名

		// ——请在这里编写您的程序（以下代码仅作参考）——

		/*
		 * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		 * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		 * 3、校验通知中的seller_id（或者seller_email)
		 * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		 * 4、验证app_id是否为该商户本身。
		 */
		if (signVerified) {// 验证成功
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

			// 商家支付宝号
			String seller_id = new String(request.getParameter("seller_id").getBytes("ISO-8859-1"), "UTF-8");

			if (trade_status.equals("TRADE_FINISHED")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 付款完成后，支付宝系统发送该交易状态通知
			}

			// 异步校验成功后修改订单状态为已支付待发货
			T_order t_order = new T_order();
			t_order.setOrder_state("1");
			t_order.setOrder_payment("0");
			orderService.update(t_order, new EntityWrapper<T_order>().eq("order_no", out_trade_no));

			// 将返回的支付信息存入数据库
			T_alipay_success t_pay_success = new T_alipay_success();
			t_pay_success.setOut_trade_no(out_trade_no);
			t_pay_success.setTotal_amount(new BigDecimal(total_amount));
			t_pay_success.setTrade_no(trade_no);
			t_pay_success.setSeller_id(Long.parseLong(seller_id));
			t_pay_success.setPay_date(new Date());
			
			paysuccessService.insert(t_pay_success);

			rps.getWriter().println("success");
			System.out.println("异步校验成功");
		} else {// 验证失败
			rps.getWriter().println("fail");
			System.out.println("异步校验失败");
			// 调试用，写文本函数记录程序运行情况是否正常
			// String sWord = AlipaySignature.getSignCheckContentV1(params);
			// AlipayConfig.logResult(sWord);
		}

	}

	/**
	 * 
	 *
	 * @Title: return_url
	 * 
	 * @description 同步校验
	 *
	 * @param @param
	 *            request
	 * @param @param
	 *            rps
	 * @param @throws
	 *            AlipayApiException
	 * @param @throws
	 *            UnsupportedEncodingException
	 * 
	 * @return void
	 *
	 * 
	 * @author lishaozhang
	 * @throws IOException
	 * @createDate 2019年3月26日
	 */
	@RequestMapping("return_url")
	public String return_url(HttpServletRequest request, HttpServletResponse rps) throws AlipayApiException, IOException {
		System.out.println("同步执行");
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			// out.println(valueStr);
			/*rps.getWriter().println(valueStr);*/
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名

		System.out.println("signVerified"+signVerified);
		// ——请在这里编写您的程序（以下代码仅作参考）——
		if (signVerified) {
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

			/*rps.getWriter().println(
					"trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);*/
			
			System.out.println("验签成功");
		} else {
			rps.getWriter().println("验签失败");
			System.out.println("验签失败");
		}
		return "mall/index";
	}

	/**
	 * 
	 *
	 * @Title: doPost
	 * 
	 * @description
	 *
	 * @param @param
	 *            httpRequest
	 * @param @param
	 *            httpResponse
	 * @param @throws
	 *            ServletException
	 * @param @throws
	 *            IOException
	 * 
	 * @return void PC支付
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月26日
	 */
	@RequestMapping("pcPay")
	public void doPost(T_order order, HttpServletResponse httpResponse) throws ServletException, IOException {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);// 在公共参数中设置回跳和通知地址

		 String out_trade_no = new String(order.getOrder_no());
	//	String out_trade_no = new String("9575");
		// 付款金额，必填
		 String total_amount = new String(order.getOrder_money()+"");
	//	String total_amount = new String(300.0 + "");
		// 订单名称，必填
		String subject = new String("商品");
		// 商品描述，可空
		String body = new String("");

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 必填项+选填项
		/*
		 * alipayRequest.setBizContent("{" +
		 * "    \"out_trade_no\":\"20150320010101002\"," +
		 * "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
		 * "    \"total_amount\":88.88," + "    \"subject\":\"Iphone6 16G\"," +
		 * "   " + " \"body\":\"Iphone6 16G\"," +
		 * "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
		 * + "    \"extend_params\":{" +
		 * "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" +
		 * "  }");// 填充业务参数
		 */
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		httpResponse.setContentType("text/html;charset=" + AlipayConfig.charset);
		httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}

	/**
	 * 
	 *
	 * @Title: doPost2
	 * 
	 * @description
	 *
	 * @param @param
	 *            order
	 * @param @param
	 *            httpResponse
	 * @param @throws
	 *            AlipayApiException
	 * 
	 * @return void 退款接口
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月26日
	 */
	@RequestMapping("refund")
	public String doPost2(T_order order, HttpServletResponse httpResponse) throws AlipayApiException {
			
	
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();


		request.setBizContent("{\"out_trade_no\":\"" + order.getOrder_no() + "\"," + "\"refund_amount\":\""
				+ order.getOrder_money() + "\"," + "\"refund_reason\":\"" + "正常退款" + "\"}");
		AlipayTradeRefundResponse response = alipayClient.execute(request);
		

		if (response.isSuccess()) {
			// 调用成功
			try {

				T_alipay_refund t_alipay_refund = new T_alipay_refund();

				t_alipay_refund.setOut_trade_no(response.getOutTradeNo());
				t_alipay_refund.setBuyer_user_id(response.getBuyerLogonId());
				t_alipay_refund.setFund_change(response.getFundChange());
				t_alipay_refund.setGmt_refund_pay(response.getGmtRefundPay());
				t_alipay_refund.setOut_trade_no(response.getOutTradeNo());
				// t_alipay_refund.setPresent_refund_buyer_amount(response.getPresentRefundBuyerAmount()+"");
				t_alipay_refund.setRefund_fee(new BigDecimal(response.getRefundFee()));
				t_alipay_refund.setStore_name(response.getStoreName());
				t_alipay_refund.setSend_back_fee(response.getSendBackFee());
				// t_alipay_refund.setPresent_refund_discount_amount(response.getPresentRefundDiscountAmount());
				// t_alipay_refund.setPresent_refund_mdiscount_amount(response.getPresentRefundMdiscountAmount());
				refundService.insert(t_alipay_refund);

			} catch (Exception e) {
               return JsonUtil.getResponseJson(-1, "系统错误退款信息保存失败请记录订单联系技术同学", null, null);
			}
			System.out.println("调用成功");
		} else {
			System.out.println("调用失败");
			 return JsonUtil.getResponseJson(-1, "请仔细核对单号和金额", null, null);			
		}
		
		return null;

	}
	
	/**
	 * 
	*
	 * @Title: pcQuery
	
	 * @description 查询支付状态
	*
	 * @param @param order_no
	 * @param @return
	 * @param @throws ServletException
	 * @param @throws IOException
	 * @param @throws AlipayApiException 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月28日
	 */
	@RequestMapping("pcQuery")
	@ResponseBody
	public synchronized String pcQuery(String order_no) throws ServletException, IOException, AlipayApiException {
	
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		/*request.setBizContent("{" +
				"    \"out_trade_no\":\"20150320010101001\"," +
		     	"    \"trade_no\":\"2014112611001004680\"" +
				"  }");*/
		//,"+"\"trade_no\":\""+ trade_no +"\"
		request.setBizContent("{\"out_trade_no\":\""+ order_no +"\"}");
		AlipayTradeQueryResponse response = alipayClient.execute(request);
		
		
		
		String msg="";
		
		if(response.isSuccess()){
		System.out.println("调用成功");
		
		
		
		Object json = JSONObject.toJSON(response);
		System.out.println("json"+json);
		System.out.println(response+"response");
		String trade_status = response.getTradeStatus();
		
		switch (trade_status) {
		case "WAIT_BUYER_PAY":
			msg ="交易创建，等待买家付款";
			break;
        case "TRADE_CLOSED":
        	msg ="未付款交易超时关闭，或支付完成后全额退款";
			break;
        case "TRADE_SUCCESS": 
        	msg ="交易支付成功";
	        break;
        case "TRADE_FINISHED":
        	msg ="交易结束，不可退款";
	        break;

		default:
			break;
		}
		

		} else {
		System.out.println("调用失败");
		return JsonUtil.getResponseJson(1, "请检查单号是否正确", null, null);
		}
		return JsonUtil.getResponseJson(1, msg, null, null);
		
		
	}


}
