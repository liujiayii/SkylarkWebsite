package com.websit.service.impl;

import com.websit.entity.T_order;
import com.websit.entity.T_wxpay_notify;
import com.websit.mapper.T_orderMapper;
import com.websit.mapper.T_wxpay_notifyMapper;
import com.websit.pay.WxPayConfig;
import com.websit.pay.utils.PayUtil;
import com.websit.service.IT_orderService;
import com.websit.service.IT_wxpay_notifyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信支付回调表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
@Service
public class T_wxpay_notifyServiceImpl extends ServiceImpl<T_wxpay_notifyMapper, T_wxpay_notify>
		implements IT_wxpay_notifyService {
	@Autowired
	public T_wxpay_notifyMapper wxpayNotifyMapper;
	@Autowired
	public com.websit.service.IT_orderService IT_orderService;

	/**
	 * 
	 * 
	 * @Title: T_wxpay_notifyServiceImpl.java
	 * 
	 * @Package com.websit.service.impl
	 * 
	 * @Description: 微信app回调
	 * 
	 * @author HanMeng
	 * 
	 * @date 2019年3月26日-下午3:38:20
	 */
	@Override
	public String wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		// sb为微信返回的xml
		String notityXml = sb.toString();
		String resXml = "";

		Map map = PayUtil.doXMLParse(notityXml);
		System.out.println("支付成功回调接收到的报文(待确定字段)：" + notityXml);
		String cash_fee = null;
		String openid = null;
		// 订单号
		String out_trade_no = null;

		String result_code = null;
		String returnCode = null;
		String total_fee = null;
		String transaction_id = null;
		if (map != null) {
			cash_fee = (String) map.get("cash_fee");

			openid = (String) map.get("openid");

			// 订单号
			out_trade_no = (String) map.get("out_trade_no");

			result_code = (String) map.get("result_code");
			returnCode = (String) map.get("return_code");
			total_fee = (String) map.get("total_fee");
			transaction_id = (String) map.get("transaction_id");
		}

		// 根据openid查找userid
		// User user = userService.findByOpenId(openid);
		// System.out.println("user回调" + user);

		// T_wxpay_notify record =
		// wxpayNotifyService.getTransaction_id(transaction_id);
		T_wxpay_notify record = wxpayNotifyMapper.findByOrderId(out_trade_no);
		System.out.println("record:" + record);
		if (record == null) {
			record = new T_wxpay_notify();

			record.setUser_id(Integer.parseInt(openid));

			record.setCash_fee(cash_fee);
			record.setOpenid(openid);
			record.setOut_trade_no(out_trade_no);
			record.setResult_code(result_code);
			record.setReturn_code(returnCode);
			record.setCash_fee(cash_fee);
			record.setTotal_fee(total_fee);
			record.setTransaction_id(transaction_id);
			record.setTime(new Date());
			wxpayNotifyMapper.insert(record);

			String result = record.getResult_code();
			// System.out.println("result::::" + result);
			if (result != null) {

				if (result == "SUCCESS" || result_code.equals(result_code)) {
					
					Map<String, Object> columnMap=new HashMap<String,Object>(); 
					columnMap.put("order_no",out_trade_no);
					
					List<T_order> T_order=IT_orderService.selectByMap(columnMap);

					int fig=IT_orderService.ordercancelled(T_order.get(0).getOrder_id().toString(),"1");

					System.out.println("更新订单状态为未配送");

					// // 修改库存
					// repertoryService.reduceRepertory(Long.valueOf(out_trade_no));
				}

				if ("SUCCESS".equals(returnCode)) {
					// 验证签名是否正确
					if (PayUtil.verify(PayUtil.createLinkString(map), (String) map.get("sign"), WxPayConfig.key,
							"UTF8")) {

					}

					/** 此处添加自己的业务逻辑代码end **/

					// 通知微信服务器已经支付成功
					resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
							+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
					System.out.println("微信服务器已经支付成功resXml:" + resXml);
				} else {
					System.out.println("数据库没有result_code");
				}
			}
		} else {
			resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
					+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";

		}

		System.out.println("微信支付回调数据结束");

		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		out.write(resXml.getBytes());
		out.flush();
		out.close();

		return transaction_id;

	}

	/**
	 * 
	 * 
	 * @Title: T_wxpay_notifyServiceImpl.java
	 * 
	 * @Package com.websit.service.impl
	 * 
	 * @Description: 根据订单编号查找回调表
	 * 
	 * @author HanMeng
	 * 
	 * @date 2019年3月26日-下午3:39:19
	 */
	@Override
	public T_wxpay_notify findByOrderId(String out_trade_no) {
		return wxpayNotifyMapper.findByOrderId( out_trade_no);

	}

}
