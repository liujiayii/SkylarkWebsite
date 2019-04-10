package com.websit.pay;

/**
 * 
 *
 * @ClassName: WxPayConfig
 *
 * @description 微信支付常量
 *
 * @author HanMeng
 * @createDate 2019年1月23日-上午11:58:04
 */
public class WxPayConfig {

	
	// 正式app
	//public static final String appid = "wx3428aa056dcad137";
	//public static final String appSecret = "3d5a76eb7972eb4dd069df510811d267";
	//pc
	public static final String appid = "wxb7e49e3a0bc42a51";
	public static final String appSecret = "80c58e8cb1deb44708e6f4dad0aa6fc4";
	// 微信支付的商户id ==证书密码

	public static final String mch_id = "1530971811"; //正式

	// 微信支付的商户密钥
	public static final String key = "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ikk";
	// 支付成功后的服务器回调url （测试）
	// public static final String notify_url = "https://www.drinksmallwine.cn/weixin/wxNotify.action";
	 public static final String notify_url ="https://23ce556732.51mypc.cn/wxNotify";
	
	// 签名方式
	public static final String SIGNTYPE = "MD5";
	// 交易类型
	public static final String TRADETYPE = "NATIVE";
	// 微信统一下单接口地址 
	public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 微信查询订单状态地址 没用到
	public static final String pay_state_url = "https://api.mch.weixin.qq.com/pay/orderquery";
	// 小程序退款Api路径
	public static final String refund_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";


}
