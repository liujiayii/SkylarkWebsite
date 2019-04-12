package com.websit.service.impl;

import com.websit.entity.T_wxpay_refund;

import com.websit.mapper.T_wxpay_refundMapper;
import com.websit.service.IT_wxpay_refundService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 退款记录表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
@Service
public class T_wxpay_refundServiceImpl extends ServiceImpl<T_wxpay_refundMapper, T_wxpay_refund>
		implements IT_wxpay_refundService {
	@Autowired
	public T_wxpay_refundMapper wxpayRefundMapper;

	/**
	 * 
	 * 
	 * @Title: T_wxpay_refundServiceImpl.java
	 * 
	 * @Package com.websit.service.impl
	 * 
	 * @Description: 根据订单表号查找退款记录表
	 * 
	 * @author HanMeng
	 * 
	 * @date 2019年3月26日-下午3:25:26
	 */
	@Override
	public T_wxpay_refundMapper findByOrderIds(String out_trade_no) {
		return wxpayRefundMapper.findByOrderIds(out_trade_no);

	}

	@Override
	public int insertSome(Map<String, String> record) {
		
		
		
			// 改变支付数据库中的是否退款状态

			// 新增退款数据库数据
			String refund_id = (String) record.get("refund_id");
			// String refund_channel = (String) map.get("refund_channel");
			String return_msg = (String) record.get("return_msg");
			String out_trade_no = (String) record.get("out_trade_no");
			// String out_refund_no = (String) map.get("refund_id");
			// String transaction_id = (String) map.get("refund_id");
			String total_fee = record.get("total_fee");
			String refund_fee = record.get("refund_fee");
			String out_refund_no = record.get("out_refund_no");
			String transaction_id = record.get("transaction_id");
			String result_code = (String) record.get("result_code");

			Integer total_fees = Integer.parseInt(total_fee);
			String return_code = (String) record.get("return_code");
			T_wxpay_refund wxpayRefund = new T_wxpay_refund();
			if (refund_id != null) {
				wxpayRefund.setRefund_id(refund_id);
			}
			if (refund_fee != null) {
				wxpayRefund.setRefund_fee(refund_fee);
			}
			if (return_msg != null) {
				wxpayRefund.setReturn_msg(return_msg);
			}
			if (out_trade_no != null) {
				wxpayRefund.setOut_trade_no(out_trade_no);
			}
			if (out_refund_no != null) {
				wxpayRefund.setOut_refund_no(out_refund_no);
			}
			if (transaction_id != null) {
				wxpayRefund.setTransaction_id(transaction_id);
			}
			if (result_code != null) {
				wxpayRefund.setResult_code(result_code);

			}
			if (total_fees != null) {
				wxpayRefund.setTotal_fee(total_fees);
			}
			if (return_code != null) {
				wxpayRefund.setReturn_code(return_code);
			}

			// wxpayRefund.setRefund_channel(refund_channel);

			wxpayRefund.setTime(new Date());

			int i = wxpayRefundMapper.insert(wxpayRefund);
			
			return i;

		
	}

	

}
