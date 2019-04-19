package com.websit.service.impl;

import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.constant.AlipayAppConfig;
import com.websit.constant.AlipayReturnEnum;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_alipayment_order;
import com.websit.entity.T_order;
import com.websit.service.AliPayAppService;
import com.websit.service.IT_alipayment_orderService;
import com.websit.until.DateUtils;
import com.websit.until.JsonUtil;

/**
 * 阿里支付实现类
 *
 * @ClassName: AliPayServiceImpl
 * 
 * @description
 *
 * @author lujinpeng
 * @createDate 2019年3月25日-下午4:42:02
 */
@Service
public class AliPayAppServiceImpl implements AliPayAppService {

	private static final Logger logger = Logger.getLogger(AliPayAppServiceImpl.class);
	
	@Autowired
	private IT_alipayment_orderService alipayment_orderService;

	/** 获取支付宝加签后台的订单信息字符串 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String getAliPayOrderStr(T_order t_order) {
		// 最终返回加签之后的，app需要传给支付宝app的订单信息字符串
		String orderString = "";
		
		logger.info("==================支付宝下单,商户订单号为：" + t_order.getOrder_no());

		// 创建商户支付宝订单(因为需要记录每次支付宝支付的记录信息，单独存一个表跟商户订单表关联，以便以后查证)
		T_alipayment_order alipaymentOrder = new T_alipayment_order();
		if (t_order.getOrder_id() != null) {
			alipaymentOrder.setOrder_id(t_order.getOrder_id().longValue()); // 商户订单主键
		}
		alipaymentOrder.setOut_trade_no(t_order.getOrder_no().toString());// 商户订单号
		alipaymentOrder.setTrade_status(0);// 交易状态
		alipaymentOrder.setTotal_amount(t_order.getOrder_money());// 订单金额
		alipaymentOrder.setReceipt_amount(0.00);// 实收金额
		alipaymentOrder.setBuyer_pay_amount(0.00);// 付款金额
		alipaymentOrder.setRefund_fee(0.00); // 总退款金额

		try {
			// 实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayAppConfig.URL, AlipayAppConfig.APPID,
					AlipayAppConfig.APP_PRIVATE_KEY, AlipayAppConfig.FORMAT, AlipayAppConfig.CHARSET,
					AlipayAppConfig.ALIPAY_PUBLIC_KEY, AlipayAppConfig.SIGNTYPE);

			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();

			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
			AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

			// 业务参数传入,可以传很多，参考API
			// model.setPassbackParams(URLEncoder.encode(request.getBody().toString()));
			// //公用参数（附加数据）
			//model.setBody(t_order.getBody()); // 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
			model.setSubject("该订单"); // 商品名称
			model.setOutTradeNo(t_order.getOrder_no()); // 商户订单号(自动生成)
			// model.setTimeoutExpress("30m"); //交易超时时间
			model.setTotalAmount(String.valueOf(t_order.getOrder_money())); // 支付金额
			model.setProductCode("QUICK_MSECURITY_PAY"); // 销售产品码（固定值）
			ali_request.setBizModel(model);
			//logger.info("====================异步通知的地址为：);
			ali_request.setNotifyUrl(AlipayAppConfig.notify_url); // 异步回调地址（后台）
			//ali_request.setReturnUrl(AlipayAppConfig.return_url); // 同步回调地址（APP）

			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request); // 返回支付宝订单信息(预处理)
			orderString = alipayTradeAppPayResponse.getBody();// 就是orderString
																// 可以直接给APP请求，无需再做处理。
			// 如果商家订单表没有该订单数据则添加
			if ( alipayment_orderService.selectCount(new EntityWrapper<T_alipayment_order>()
					.eq("out_trade_no", t_order.getOrder_no().toString())) == 0 ) {
				alipayment_orderService.createAlipayMentOrder(alipaymentOrder); //创建新的商户支付宝订单
			}
			
		} catch (AlipayApiException e) {
			e.printStackTrace();
			logger.info("与支付宝交互出错，未能生成订单，请检查代码！");
			JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, "返回数据失败", null, null);
		}

		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, "返回数据成功", null, orderString);
	}

	/** 向支付宝发起订单查询请求 */
	@Override
	public int checkAlipay(String order_no) {
		logger.info("==================向支付宝发起查询，查询商户订单号为：" + order_no);

		try {
			// 实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayAppConfig.URL, AlipayAppConfig.APPID,
					AlipayAppConfig.APP_PRIVATE_KEY, AlipayAppConfig.FORMAT, AlipayAppConfig.CHARSET,
					AlipayAppConfig.ALIPAY_PUBLIC_KEY, AlipayAppConfig.SIGNTYPE);

			AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
			alipayTradeQueryRequest.setBizContent("{" + "\"out_trade_no\" : \"" + order_no + "\"}");

			AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
			if (alipayTradeQueryResponse.isSuccess()) {

				T_alipayment_order alipaymentOrder = alipayment_orderService.selectByOutTradeNo(order_no);
				// 修改数据库支付宝订单表
				//alipaymentOrder.setTrade_no(alipayTradeQueryResponse.getTradeNo());  //支付宝交易号
				//alipaymentOrder.setBuyer_logon_id(alipayTradeQueryResponse.getBuyerLogonId()); // 买家支付宝账号
				//alipaymentOrder.setTotal_amount(Double.parseDouble(alipayTradeQueryResponse.getTotalAmount())); // 订单金额
				//alipaymentOrder.setReceipt_amount(Double.parseDouble(alipayTradeQueryResponse.getReceiptAmount())); // 实收金额
				//alipaymentOrder.setInvoiceAmount(Double.parseDouble(alipayTradeQueryResponse.getInvoiceAmount())); // 开票金额
				//alipaymentOrder.setBuyer_pay_amount(Double.parseDouble(alipayTradeQueryResponse.getBuyerPayAmount())); //付款金额
				switch (alipayTradeQueryResponse.getTradeStatus()) // 判断交易结果
				{
				case "TRADE_FINISHED": // 交易结束并不可退款
					alipaymentOrder.setTrade_status(3);
					break;
				case "TRADE_SUCCESS": // 交易支付成功
					alipaymentOrder.setTrade_status(2);
					break;
				case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
					alipaymentOrder.setTrade_status(1);
					break;
				case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
					alipaymentOrder.setTrade_status(0);
					break;
				default:
					break;
				}

				alipayment_orderService.updateByPrimaryKey(alipaymentOrder); // 更新表记录
				return alipaymentOrder.getTrade_status();
			} else {
				logger.info("==================调用支付宝查询接口失败！");
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/** 支付宝异步请求逻辑处理 */
	@Override
	public String notify(Map<String, String> conversionParams) {
		logger.info("==================支付宝异步请求逻辑处理");

		System.out.println("==异步通知参数值=="+conversionParams);
		
		// 签名验证(对支付宝返回的数据验证，确定是支付宝返回的)
		boolean signVerified = false;

		try {
			// 调用SDK验证签名
			signVerified = AlipaySignature.rsaCheckV1(conversionParams, AlipayAppConfig.ALIPAY_PUBLIC_KEY,
					AlipayAppConfig.CHARSET, AlipayAppConfig.SIGNTYPE);

		} catch (AlipayApiException e) {
			logger.info("==================验签失败 ！");
			e.printStackTrace();
		}

		// 对验签进行处理
		if (signVerified) {
			System.out.println("验签通过");
			// 验签通过
			// 获取需要保存的数据
			String appId = conversionParams.get("app_id");// 支付宝分配给开发者的应用Id
			String notifyTime = conversionParams.get("notify_time");// 通知时间:yyyy-MM-dd
																	// HH:mm:ss
			String gmtCreate = conversionParams.get("gmt_create");// 交易创建时间:yyyy-MM-dd
																	// HH:mm:ss
			String gmtPayment = conversionParams.get("gmt_payment");// 交易付款时间
			//String gmtRefund = conversionParams.get("gmt_refund");// 交易退款时间
			//String gmtClose = conversionParams.get("gmt_close");// 交易结束时间
			String tradeNo = conversionParams.get("trade_no");// 支付宝的交易号
			String outTradeNo = conversionParams.get("out_trade_no");// 获取商户之前传给支付宝的订单号（商户系统的唯一订单号）
			//String outBizNo = conversionParams.get("out_biz_no");// 商户业务号(商户业务ID，主要是退款通知中返回退款申请的流水号)
			String buyerLogonId = conversionParams.get("buyer_logon_id");// 买家支付宝账号
			String buyerId = conversionParams.get("buyer_id"); //买家支付宝用户号(唯一)
			String sellerId = conversionParams.get("seller_id");// 卖家支付宝用户号
			String sellerEmail = conversionParams.get("seller_email");// 卖家支付宝账号
			String totalAmount = conversionParams.get("total_amount");// 订单金额:本次交易支付的订单金额，单位为人民币（元）
			String receiptAmount = conversionParams.get("receipt_amount");// 实收金额:商家在交易中实际收到的款项，单位为元
			//String invoiceAmount = conversionParams.get("invoice_amount");// 开票金额:用户在交易中支付的可开发票的金额
			String buyerPayAmount = conversionParams.get("buyer_pay_amount");// 付款金额:用户在交易中支付的金额
			String tradeStatus = conversionParams.get("trade_status");// 获取交易状态

			// 支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）
			T_alipayment_order alipaymentOrder = alipayment_orderService.selectByOutTradeNo(outTradeNo);

			if (alipaymentOrder != null && totalAmount.equals(alipaymentOrder.getTotal_amount().toString())
					&& AlipayAppConfig.APPID.equals(appId)) {
				// 修改数据库支付宝订单表(因为要保存每次支付宝返回的信息到数据库里，以便以后查证)
				alipaymentOrder.setNotify_time(DateUtils.parse(notifyTime));  // 通知时间
				alipaymentOrder.setGmt_create(DateUtils.parse(gmtCreate));	  // 交易创建时间 
				alipaymentOrder.setGmt_payment(DateUtils.parse(gmtPayment));  // 交易付款时间
				//alipaymentOrder.setGmt_refund(DateUtils.parse(gmtRefund));  // 交易退款时间
				//alipaymentOrder.setGmt_close(DateUtils.parse(gmtClose));	  // 交易结束时间
				alipaymentOrder.setTrade_no(tradeNo);	// 支付宝交易号
				//alipaymentOrder.setOut_biz_no(outBizNo);  // 商户业务号(商户业务ID，主要是退款通知中返回退款申请的流水号)
				alipaymentOrder.setBuyer_logon_id(buyerLogonId);  // 买家支付宝账号
				alipaymentOrder.setBuyer_id(buyerId); // 买家支付宝用户号(唯一)
				alipaymentOrder.setSeller_id(sellerId);	// 卖家支付宝用户号
				alipaymentOrder.setSeller_email(sellerEmail);  // 卖家支付宝账号
				alipaymentOrder.setTotal_amount(Double.parseDouble(totalAmount));  //订单金额:本次交易支付的订单金额，单位为人民币（元）
				alipaymentOrder.setReceipt_amount(Double.parseDouble(receiptAmount)); // 实收金额:商家在交易中实际收到的款项，单位为元
				//alipaymentOrder.setInvoiceAmount(Double.parseDouble(invoiceAmount)); // 开票金额:用户在交易中支付的可开发票的金额
				alipaymentOrder.setBuyer_pay_amount(Double.parseDouble(buyerPayAmount)); // 付款金额:用户在交易中支付的金额
				
				switch (tradeStatus) // 判断交易结果
				{
				case "TRADE_FINISHED": // 交易结束并不可退款
					alipaymentOrder.setTrade_status(3);
					break;
				case "TRADE_SUCCESS": // 交易支付成功
					alipaymentOrder.setTrade_status(2);
					break;
				case "TRADE_CLOSED": // 未付款交易超时关闭或支付完成后全额退款
					alipaymentOrder.setTrade_status(1);
					break;
				case "WAIT_BUYER_PAY": // 交易创建并等待买家付款
					alipaymentOrder.setTrade_status(0);
					break;
				default:
					break;
				}
				int returnResult = alipayment_orderService.updateByPrimaryKey(alipaymentOrder); // 更新交易表中状态

				if (tradeStatus.equals("TRADE_SUCCESS")) { // 只处理支付成功的订单:
															// 修改交易表状态,支付成功
					if (returnResult > 0) {
						logger.info("======更新商户订单表成功======");
						return "success";
					} else {
						return "fail";
					}
				} else {
					return "fail";
				}

			} else {
				logger.info("=========支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）,不一致！返回fail");
				return "fail";
			}

		} else { // 验签不通过
			logger.info("=========验签不通过 ！");
			return "fail";
		}
	}

	/**
	 * 向支付宝发起退款请求
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public String alipayTradeRefund(String order_no, Double refund_fee) {
		String returnStr = null;
		int code = ReturnCode.SUCCSEE_CODE;
		try {
			
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayAppConfig.URL, AlipayAppConfig.APPID, 
					AlipayAppConfig.APP_PRIVATE_KEY, AlipayAppConfig.FORMAT, AlipayAppConfig.CHARSET, 
					AlipayAppConfig.ALIPAY_PUBLIC_KEY, AlipayAppConfig.SIGNTYPE); //获得初始化的AlipayClient
			
			AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();//创建API对应的request类
			request.setBizContent("{" +
			"    \"out_trade_no\":\"" + order_no + "\"," +
			"    \"refund_amount\":\"" + refund_fee + "\"" +
			"  }");//设置业务参数
			AlipayTradeRefundResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
		
			logger.info("退款返回参数===="+response);
			
			if (response.isSuccess()) {
				logger.info("====支付宝退款成功");
				// 通过订单号查询到商家支付宝订单信息
				T_alipayment_order alipaymentOrder = alipayment_orderService.selectByOutTradeNo(order_no);
				
				if (alipaymentOrder == null) {
					logger.info("该订单不存在");
				}
				// 退款总金额
				alipaymentOrder.setRefund_fee(Double.valueOf(response.getRefundFee()));
				// 退款时间
				alipaymentOrder.setGmt_refund(response.getGmtRefundPay());
				// 退款状态
				alipaymentOrder.setTrade_status(AlipayReturnEnum.TRADE_CLOSED.getIndex());
				// 本次退款是否发生了资金变化
				alipaymentOrder.setFund_change(response.getFundChange());
				// 交易在支付时候的门店名称
				alipaymentOrder.setStore_name(response.getStoreName());
				// 修改商家支付宝订单状态以及退款金额
				alipayment_orderService.updateByPrimaryKey(alipaymentOrder);
				
				returnStr = response.getMsg();
			} else {
				// 返回退款失败消息
				logger.info("===退款失败===原因："+response.getSubMsg());
				returnStr = response.getSubMsg();
			}
			code = Integer.parseInt(response.getCode());
			
		} catch (AlipayApiException e) {
			e.printStackTrace();
			JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, e.getMessage(), null, null);
		}
		
		return JsonUtil.getResponseJson(code, returnStr, null, null);
	}

	

}
