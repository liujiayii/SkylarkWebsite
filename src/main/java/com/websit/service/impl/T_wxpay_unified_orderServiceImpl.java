package com.websit.service.impl;

import com.websit.entity.T_wxpay_unified_order;
import com.websit.mapper.T_wxpay_unified_orderMapper;
import com.websit.pay.Json;
import com.websit.pay.WxPayConfig;
import com.websit.pay.utils.IpUtils;
import com.websit.pay.utils.PayUtil;
import com.websit.pay.utils.StringUtils;
import com.websit.service.IT_wxpay_unified_orderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信统一下单表（预支付） 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
@Service
public class T_wxpay_unified_orderServiceImpl extends ServiceImpl<T_wxpay_unified_orderMapper, T_wxpay_unified_order>
		implements IT_wxpay_unified_orderService {
			@Autowired
			public T_wxpay_unified_orderMapper wxpayUnifiedOrderMapper;
	/**
	 * 
	 * 
	 * @Title: T_wxpay_unified_orderServiceImpl.java
	 * 
	 * @Package com.websit.service.impl
	 * 
	 * @Description: 微信预支付
	 * 
	 * @author HanMeng
	 * 
	 * @date 2019年3月24日-下午7:02:04
	 */
	@Override
	public Json wxPay(String out_trade_no, String total_money, Integer status, HttpServletRequest request)
			throws Exception {
		
		Json json = new Json();
		String money;
		// Order order = orderMapper.selectByPrimaryKey(Long.valueOf(id));

		// money = total_money;

		// 支付金额，单位：分，这边需要转成字符串类型，否则后面的签名会失败
		// 生成的随机字符串
		String nonce_str = StringUtils.getRandomStringByLength(32);
		// 商品名称
		String body = "云阙商城-消费";
		// 获取本机的ip地址
		String spbill_create_ip = IpUtils.getIpAddr(request);
		// 订单编号
		// String orderNo = id;

		Map<String, String> packageParams = new HashMap<String, String>();
		packageParams.put("appid", WxPayConfig.appid);
		packageParams.put("mch_id", WxPayConfig.mch_id);
		packageParams.put("nonce_str", nonce_str); //32位随机字符串 
		packageParams.put("body", body);

		packageParams.put("out_trade_no", out_trade_no);// 商户订单号
		packageParams.put("total_fee", total_money);// 支付金额，这边需要转成字符串类型，否则后面的签名会失败
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", WxPayConfig.notify_url);
		packageParams.put("trade_type", WxPayConfig.TRADETYPE);

		// 除去数组中的空值和签名参数
		packageParams = PayUtil.paraFilter(packageParams);
		String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

		// MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
		String mysign = PayUtil.sign(prestr, WxPayConfig.key, "UTF8").toUpperCase();
		// 拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
		String xml = "<xml>" + "<appid>" + WxPayConfig.appid + "</appid>" + "<body><![CDATA[" + body + "]]></body>"
				+ "<mch_id>" + WxPayConfig.mch_id + "</mch_id>" + "<nonce_str>" + nonce_str + "</nonce_str>"
				+ "<notify_url>" + WxPayConfig.notify_url + "</notify_url>" 
				+ "<out_trade_no>" + out_trade_no + "</out_trade_no>" + "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<total_fee>" + total_money + "</total_fee>" + "<trade_type>"
				+ WxPayConfig.TRADETYPE + "</trade_type>" + "<sign>" + mysign + "</sign>" + "</xml>";
	/*	<xml>
		   <appid>wx2421b1c4370ec43b</appid>
		   <attach>支付测试</attach>
		   <body>APP支付测试</body>
		   <mch_id>10000100</mch_id>
		   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
		   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>
		   <out_trade_no>1415659990</out_trade_no>
		   <spbill_create_ip>14.23.150.211</spbill_create_ip>
		   <total_fee>1</total_fee>
		   <trade_type>APP</trade_type>
		   <sign>0CB01533B8C1EF103065174F50BCA001</sign>
		</xml>*/
		System.out.println("调试模式_统一下单接口 请求XML数据xml：" + xml);

		// 调用统一下单接口，并接受返回的结果
		String result = PayUtil.httpRequest(WxPayConfig.pay_url, "POST", xml);

		System.out.println("调试模式_统一下单接口 返回XML数据result：" + result);

		// 将解析结果存储在HashMap中
		Map map = PayUtil.doXMLParse(result);
		// System.out.println("map:" + map);
		String return_code = (String) map.get("return_code");// 返回状态码
		String return_msg = (String) map.get("return_msg");// 返回文字信息
		String result_code = (String) map.get("result_code");
		// 返回给移动端需要的参数
		Map<String, Object> response = new HashMap<String, Object>();
		if (return_code == "SUCCESS" || return_code.equals(return_code)) {
			// 业务结果
			String prepay_id = (String) map.get("prepay_id");// 返回的预付单信息
			response.put("nonceStr", nonce_str);
			response.put("package", "prepay_id=" + prepay_id);
			Long timeStamp = System.currentTimeMillis() / 1000;

			response.put("timeStamp", timeStamp + "");// 这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误

			String stringSignTemp = "appId=" + WxPayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id="
					+ prepay_id + "&signType=" + WxPayConfig.SIGNTYPE + "&timeStamp=" + timeStamp;
			// 再次签名，这个签名用于小程序端调用wx.requesetPayment方法
			String paySign = PayUtil.sign(stringSignTemp, WxPayConfig.key, "UTF8").toUpperCase();

			response.put("paySign", paySign);

			// 业务逻辑代码
			// 插入到统一下单表
			T_wxpay_unified_order wxpayUnifiedOrder = new T_wxpay_unified_order();
			// 根据openid查找userid
			//User user = userService.findByOpenId(openid);
		//	wxpayUnifiedOrder.setUser_id(Integer.parseInt(String.valueOf(user.getId())));
			wxpayUnifiedOrder.setOut_trade_no(out_trade_no);
			wxpayUnifiedOrder.setSpbill_create_ip(spbill_create_ip);
			wxpayUnifiedOrder.setTotal_fee(total_money);
			wxpayUnifiedOrder.setResult_code(result_code);
			wxpayUnifiedOrder.setReturn_code(return_code);
			wxpayUnifiedOrder.setReturn_msg(return_msg);
			wxpayUnifiedOrder.setTime(new Date());
			wxpayUnifiedOrderMapper.insert(wxpayUnifiedOrder);
		
		}

		response.put("appid", WxPayConfig.appid);

		json.setSuccess(true);
		json.setData(response);
		return json;
	}

}
