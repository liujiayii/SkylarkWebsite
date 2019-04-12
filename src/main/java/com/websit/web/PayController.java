package com.websit.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_wxpay_notify;
import com.websit.mapper.T_wxpay_refundMapper;
import com.websit.pay.Json;
import com.websit.pay.utils.RefundUtil;
import com.websit.service.IT_wxpay_notifyService;
import com.websit.service.IT_wxpay_refundService;
import com.websit.service.IT_wxpay_unified_orderService;
import com.websit.until.JsonUtil;

/**
 * 
 *
 * @ClassName: PayController
 *
 * @description 微信支付控制器
 *
 * @author HanMeng
 * @createDate 2019年3月24日-下午5:52:17
 */
@Controller
public class PayController {

	@Autowired
	private IT_wxpay_unified_orderService wxpayUnifiedOrderService;

	@Autowired
	private IT_wxpay_notifyService wxpayNotifyService;
	@Autowired
	private IT_wxpay_refundService wxpayRefundService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 * @Title: wxPay
	 * @description: 发起微信支付
	 *
	 * @param out_trade_no
	 *            订单编号
	 * @param total_money
	 *            总金额
	 * @param status
	 *            订单状态
	 * @param request
	 * @return
	 * @return Json
	 *
	 * @author HanMeng
	 * @createDate 2019年3月25日-上午11:14:53
	 */
	@RequestMapping(value = "/wxPay")
	@ResponseBody
	public Json wxPay(String user_id, String out_trade_no, String total_money, HttpServletRequest request) {

		Json json = new Json();
		try {
			json = wxpayUnifiedOrderService.wxPay(user_id, out_trade_no, total_money, request);
			json.setSuccess(true);
			json.setMsg("发起成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("发起失败");
			logger.error(e.getMessage(), e);
		}
		return json;
	}

	/**
	 * 
	 * @Title: wxNotify
	 * @description: 微信app回调接口
	 *
	 * @param request
	 * @param response
	 * @return
	 * @return String
	 *
	 * @author HanMeng
	 * @createDate 2019年3月25日-下午3:49:59
	 */
	@RequestMapping(value = "/wxNotify")
	@ResponseBody
	public String wxNotify(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("过来");
		String str;
		try {
			String wxpayNotify = wxpayNotifyService.wxNotify(request, response);
			if (wxpayNotify != null) {
				str = JsonUtil.getResponseJson(1, "回调成功", null, wxpayNotify);
			} else {
				str = JsonUtil.getResponseJson(0, "回调失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "查询失败", null, null);
			logger.error(e.getMessage(), e);
		}
		return str;

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
	@RequestMapping(value = "/refund")
	@ResponseBody
	public String doPost(String out_trade_no, String transaction_id, String total_fee, String refund_fee,
			HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 在回调表中根据商户单号查找出微信单号 T_wxpay_notify findByOrderId()
		T_wxpay_notify wxpayNotify = wxpayNotifyService.findByOrderId(out_trade_no);
		if (wxpayNotify != null) {
			transaction_id = wxpayNotify.getTransaction_id();
		} else {
			System.out.println("微信账单暂未回调");
		}
		Map<String, Object> maps = null;
		try {
			maps = doGet(out_trade_no, transaction_id, total_fee, refund_fee, req, resp);
			maps.put("return_code", maps.get("return_code"));
			if (maps.get("return_code") == "SUCCESS") {
				maps.put("result_code", maps.get("result_code"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}

		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, maps.size(), maps);

	}

	public Map<String, Object> doGet(String out_trade_no, String transaction_id, String total_fee, String refund_fee,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("退款");
		Map<String, Object> map = new HashMap<String, Object>();
		RefundUtil refundUtil = new RefundUtil();
		// 微信支付单号,总金额,退款总金额(可以分期退款)
		Map<String, String> record = null;

		try {
			record = refundUtil.wechatRefund(out_trade_no, transaction_id, total_fee, refund_fee, request);
			System.out.println("退款:" + record);
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
