package com.websit.web;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.WxpaY.MyConfig;
import com.websit.WxpaY.WXPay;
import com.websit.WxpaY.WXPayConfig;
import com.websit.entity.UserUpdateVo;

@Controller
public class wXpayController {
	
	@RequestMapping("/wXpay_pc")
	@ResponseBody
	public String wXpay_pc(String out_trade_no, String total_money) {
		
		 Map<String, String> reqData =new HashMap<>();
		 WXPayConfig myConfig;
		 
		try {
			   String urlSuffix="/pay/unifiedorder";
			 String ip = InetAddress.getLocalHost().getHostAddress(); 
			myConfig = new MyConfig();
			WXPay wxPay = new WXPay(myConfig,null,true, true);
			reqData.put("out_trade_no", "123456789");
			reqData.put("spbill_create_ip", "http://yunque.free.idcfengye.com/");
			
			reqData.put("total_fee", "100.00");
			reqData.put("notify_url", "192.168.1.110:8080/wXpay_pchd");
			 reqData.put("trade_type", "NATIVE");
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
	
	@RequestMapping("/wXpay_pchd")
	@ResponseBody
	public String wXpay_pchd(String out_trade_no) {
		
		 Map<String, String> reqData =new HashMap<>();
		 WXPayConfig myConfig;
		 
		try {
			   String urlSuffix="/pay/orderquery";
			 String ip = InetAddress.getLocalHost().getHostAddress(); 
			myConfig = new MyConfig();
			WXPay wxPay = new WXPay(myConfig,null,true, true);
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
