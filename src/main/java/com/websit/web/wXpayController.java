package com.websit.web;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.WxpaY.MyConfig;
import com.websit.WxpaY.WXPay;
import com.websit.WxpaY.WXPayConfig;
import com.websit.entity.T_wxpay_unified_order;
import com.websit.entity.UserUpdateVo;
import com.websit.mapper.T_wxpay_unified_orderMapper;
import com.websit.pay.Json;
import com.websit.pay.WxPayConfig;
import com.websit.pay.utils.IpUtils;
import com.websit.pay.utils.PayUtil;

@Controller
public class wXpayController {

	@Autowired
	public T_wxpay_unified_orderMapper wxpayUnifiedOrderMapper;

	@RequestMapping("/wXpay_pc")
	@ResponseBody
	public Json wXpay_pc(String user_id, String out_trade_no, String total_money, HttpServletRequest request) {

		Map<String, String> reqData = new HashMap<>();
		WXPayConfig myConfig;
		Json json = new Json();
		try {
			String urlSuffix = "/pay/unifiedorder";
			String spbill_create_ip = IpUtils.getIpAddr(request);
			myConfig = new MyConfig();
			WXPay wxPay = new WXPay(myConfig, null, true, true);
			reqData.put("out_trade_no", out_trade_no);
			reqData.put("spbill_create_ip", spbill_create_ip);

			reqData.put("total_fee", total_money);
			reqData.put("notify_url", WxPayConfig.notify_url);
			reqData.put("trade_type", "NATIVE");
			reqData = wxPay.fillRequestData(reqData);
			System.out.println("reqData:" + reqData);
			String result = wxPay.requestWithoutCert(urlSuffix, reqData, 5000, 5000);
			System.out.println("result:" + result);

			Map map = PayUtil.doXMLParse(result);
			if (map.get("result_code").equals("SUCCESS")) {
				json.setSuccess(true);
				json.setData(map);
				json.setMsg("请求成功");

				T_wxpay_unified_order wxpayUnifiedOrder = new T_wxpay_unified_order();

				wxpayUnifiedOrder.setUser_id(user_id);
				wxpayUnifiedOrder.setOut_trade_no(out_trade_no);
				wxpayUnifiedOrder.setSpbill_create_ip(IpUtils.getIpAddr(request));
				wxpayUnifiedOrder.setTotal_fee(total_money);
				wxpayUnifiedOrder.setResult_code("SUCCESS");
				wxpayUnifiedOrder.setReturn_code("SUCCESS");
				wxpayUnifiedOrder.setReturn_msg("请求成功");
				wxpayUnifiedOrder.setTime(new Date());
				wxpayUnifiedOrderMapper.insert(wxpayUnifiedOrder);
			} else {
				json.setSuccess(false);

				json.setMsg("请求失败111111");
			}
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("请求失败222");

		}

		return json;

	}

	@RequestMapping("/wXpay_pchd")
	@ResponseBody
	public String wXpay_pchd(String out_trade_no) {

		Map<String, String> reqData = new HashMap<>();
		WXPayConfig myConfig;

		try {
			String urlSuffix = "/pay/orderquery";
			String ip = InetAddress.getLocalHost().getHostAddress();
			myConfig = new MyConfig();
			WXPay wxPay = new WXPay(myConfig, null, true, true);
			reqData.put("out_trade_no", out_trade_no);
			reqData = wxPay.fillRequestData(reqData);
			String result = wxPay.requestWithoutCert(urlSuffix, reqData, 5000, 5000);

			Map<String, String> resultMap = wxPay.processResponseXml(result);
			System.out.println(resultMap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
