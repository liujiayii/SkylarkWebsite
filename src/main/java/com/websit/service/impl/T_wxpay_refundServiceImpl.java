package com.websit.service.impl;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_wxpay_notify;
import com.websit.entity.T_wxpay_refund;

import com.websit.mapper.T_wxpay_refundMapper;
import com.websit.pay.utils.RefundUtil;
import com.websit.service.IT_wxpay_notifyService;
import com.websit.service.IT_wxpay_refundService;
import com.websit.until.JsonUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Autowired
	private IT_wxpay_notifyService wxpayNotifyService;
	@Autowired
	private IT_wxpay_refundService wxpayRefundService;
	private Logger logger = LoggerFactory.getLogger(getClass());


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
	
	/**
	 * 
	 * @Title: doPost
	 * @description: 微信申请退款
	 *
	 * @param out_trade_no
	 *            商户订单编号
	 * @param transaction_id
	 *            微信订单编号
	 * @param total_fee
	 *            支付总金额
	 * @param refund_fee
	 *            退款金额
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @return Map<String,Object>
	 *
	 * @author HanMeng
	 * @createDate 2019年3月26日-上午11:09:13
	 */

	public boolean doPost(String out_trade_no, String total_fee, String refund_fee,
			HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String transaction_id = null;
		// 在回调表中根据商户单号查找出微信单号 T_wxpay_notify findByOrderId()
//		System.out.println("out_trade_no;"+out_trade_no);
		T_wxpay_notify wxpayNotify = wxpayNotifyService.findByOrderId(out_trade_no);
//		System.out.println("wxpayNotify:"+wxpayNotify);
		if (wxpayNotify != null) {
			transaction_id = wxpayNotify.getTransaction_id();
		} else {
//			System.out.println("微信账单暂未回调");
		}
		Map<String, Object> maps = null;
		try {
			maps = doGet(out_trade_no, transaction_id, total_fee, refund_fee, req, resp);
//			System.out.println("maps:"+maps);
//			System.out.println("maps.get(\"return_code\")"+maps.get("return_code"));
			maps.put("return_code", maps.get("return_code"));
			if (maps.get("return_code").equals("SUCCESS")) {
				maps.put("result_code", maps.get("result_code"));
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		

	}

	public Map<String, Object> doGet(String out_trade_no, String transaction_id, String total_fee, String refund_fee,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("退款");
		Map<String, Object> map = new HashMap<String, Object>();
		RefundUtil refundUtil = new RefundUtil();
		// 微信支付单号,总金额,退款总金额(可以分期退款)
		Map<String, String> record = null;

		try {
			// 根据商户单号查找出微信单号
			T_wxpay_notify wxpayNotify = wxpayNotifyService.findByOrderId(out_trade_no);
			record = refundUtil.wechatRefund(out_trade_no, transaction_id, total_fee, refund_fee, request);
//			System.out.println("退款:" + record);
			wxpayRefundService.insertSome(record);
			// wxpayRefundMapper.insert(entity)
			map.put("return_code", record.get("return_code"));
			if (record.get("return_code") == "SUCCESS") {
				map.put("result_code", record.get("result_code"));
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return map;

	}

	

}
