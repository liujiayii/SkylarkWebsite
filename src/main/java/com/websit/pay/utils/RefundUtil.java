package com.websit.pay.utils;



import javax.servlet.http.HttpServletRequest;

import com.websit.pay.WxPayConfig;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * 
 *
 * @ClassName: RefundUtil
 *
 * @description 退款工具类
 *
 * @author HanMeng
 * @createDate 2019年1月31日-下午2:19:09
 */

public class RefundUtil {

	private String appid = WxPayConfig.appid; // 微信小程序apid
	private String appsecret = WxPayConfig.appSecret; // 微信小程序appsecret
	public static String mch_id = WxPayConfig.mch_id; // 微信商户id
	private String op_user_id = WxPayConfig.mch_id;// 操作员帐号, 默认为商户号
	private String partnerkey = WxPayConfig.key;// 商户平台上的那个KEY

	/**
	 * 
	 * @Title: wechatRefund
	 * @description: 退款
	 *
	 * @param out_trade_no
	 *            商户订单号
	 * @param transaction_id
	 *            微信订单号
	 * @param total_fee
	 *            总金额
	 * @param refund_fee
	 *            退款金额
	 * @param request
	 * @return
	 * @return Map<String,String>
	 *
	 * @author HanMeng
	 * @createDate 2019年2月2日-下午2:38:49
	 */
	public Map<String, String> wechatRefund(String out_trade_no, String transaction_id, String total_fee,
			String refund_fee, HttpServletRequest request) throws Exception {
	
		String out_refund_no = UUID.randomUUID().toString().substring(0, 32).replace("-", "");
		String nonce_str = StringUtils.getRandomStringByLength(32);// 随机字符串
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("transaction_id", transaction_id);
		packageParams.put("out_refund_no", out_refund_no);
		packageParams.put("total_fee", total_fee);

		packageParams.put("refund_fee", refund_fee);
		packageParams.put("op_user_id", op_user_id);
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>"
				+ nonce_str + "</nonce_str>" + "<sign><![CDATA[" + sign + "]]></sign>" + "<transaction_id>"
				+ transaction_id + "</transaction_id>" + "<out_refund_no>" + out_refund_no + "</out_refund_no>"
				+ "<total_fee>" + total_fee + "</total_fee>" + "<refund_fee>" + refund_fee + "</refund_fee>"
				+ "<op_user_id>" + op_user_id + "</op_user_id>" + "</xml>";
//		System.out.println("退款xml" + xml);
		// 退款请求路径
		String createOrderURL = WxPayConfig.refund_url;
		ClientCustomSSL ccs = new ClientCustomSSL();
		Map<String, String> map = ccs.doRefund(createOrderURL, xml, request);
		map.put("refund_fee", refund_fee);
		map.put("out_refund_no", out_refund_no);
		map.put("total_fee", total_fee);
		map.put("transaction_id", transaction_id);
		map.put("out_trade_no", out_trade_no);
		
//		System.out.println("map:" + map);
		/*Json json = new Json();
		json.setData(map);*/
		return map;
	}

}
