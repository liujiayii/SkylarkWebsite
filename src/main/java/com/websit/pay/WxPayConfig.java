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

	// 小程序appid
	// 测试
	// public static final String appid = "wxaf4186136ae510b0";
	// public static final String appSecret =
	// "b7ecf2f7cd7e8fb92f43db5cfa1104d7";
	// 正式
	public static final String appid = "wxd9bc574dd5535a31";
	public static final String appSecret = "19ff66b83c3be127d105b6b5f0533d53";
	// 微信支付的商户id ==证书密码
	//public static final String mch_id = "1501362861"; //测试
	public static final String mch_id = "1528513661"; //正式

	// 微信支付的商户密钥
	public static final String key = "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ikk";
	// 支付成功后的服务器回调url （测试）
	// public static final String notify_url = "https://www.drinksmallwine.cn/weixin/wxNotify.action";
	 public static final String notify_url ="http://23ce556732.51mypc.cn:38461/weixin/wxNotify.action";
	
	// 签名方式
	public static final String SIGNTYPE = "MD5";
	// 交易类型
	public static final String TRADETYPE = "APP";
	// 微信统一下单接口地址 
	public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 微信查询订单状态地址 没用到
	public static final String pay_state_url = "https://api.mch.weixin.qq.com/pay/orderquery";
	// 小程序退款Api路径
	public static final String refund_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";


}
