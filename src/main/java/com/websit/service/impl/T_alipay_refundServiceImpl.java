package com.websit.service.impl;

import com.websit.config.AlipayConfig;
import com.websit.entity.T_alipay_refund;
import com.websit.entity.T_order;
import com.websit.mapper.T_alipay_refundMapper;
import com.websit.service.IT_alipay_refundService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付宝退款记录表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-27
 */
@Service
public class T_alipay_refundServiceImpl extends ServiceImpl<T_alipay_refundMapper, T_alipay_refund> implements IT_alipay_refundService {
  
	  @Autowired
	  private IT_alipay_refundService refundService;
	  /**
	   * 支付宝pc退款
	   */
	@Override
	public boolean refund(String order_no,String money, HttpServletResponse httpResponse) {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		
	//	 order.setOrder_no("9568");
	//	 order.setOrder_money(300.0);
		 
	    request.setBizContent("{\"out_trade_no\":\"" 
			        + order_no
					+ "\"," + "\"refund_amount\":\"" 
			        + money + "\"," 
					+ "\"refund_reason\":\"" + "正常退款" + "\"}");
		AlipayTradeRefundResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		
		
		if(response.isSuccess()){
			//调用成功
			try {
			
			T_alipay_refund t_alipay_refund = new T_alipay_refund();
		
			t_alipay_refund.setOut_trade_no(response.getOutTradeNo());
			t_alipay_refund.setBuyer_user_id(response.getBuyerLogonId());
			t_alipay_refund.setFund_change(response.getFundChange());
			t_alipay_refund.setGmt_refund_pay(response.getGmtRefundPay());
			t_alipay_refund.setOut_trade_no(response.getOutTradeNo());
//			t_alipay_refund.setPresent_refund_buyer_amount(response.getPresentRefundBuyerAmount()+"");
			t_alipay_refund.setRefund_fee(new BigDecimal(response.getRefundFee()));
			t_alipay_refund.setStore_name(response.getStoreName());
			t_alipay_refund.setSend_back_fee(response.getSendBackFee());
//			t_alipay_refund.setPresent_refund_discount_amount(response.getPresentRefundDiscountAmount());
//			t_alipay_refund.setPresent_refund_mdiscount_amount(response.getPresentRefundMdiscountAmount());
			
			refundService.insert(t_alipay_refund);
			
			} catch (Exception e) {
			}
			return true;
		} else {
			return false;
		}
	}

}
