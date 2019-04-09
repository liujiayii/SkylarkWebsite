/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.websit.web;

import com.alipay.fc.csplatform.common.crypto.Base64Util;
import com.alipay.fc.csplatform.common.crypto.CustomerInfoCryptoUtil;
import com.websit.online.utils.OnlinePubKeyUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Map;

/**
 * @author fushan.cfs
 * @version $Id: CustomerInfo.java, v 0.1 2018年11月14日 3:15 PM fushan.cfs Exp $
 */
@Controller
public class CustomerInfo {

    /** 这个密钥请联系云客服获取. 该密钥仅做DEMO展示使用. 拿到公钥后, 不要换行 放到这里即可. */
    //private static String PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtTJ9Oo/gvo6476PYi4zADnCVhtLxI8q9HsN1EkRJfna85p95WrNOxjdH5E3PfDBQolTnvNzdxGeetYA6UFczndXbeWfHeijQQyuBJ57hKYbCtLmG10K8VcpekgDf76NCETmX3HN4HQAYioLojn3MmwzP+95K89lLzB2XdJz4gjNQDcdILS3CIpsj1hjroGnZSIkluwfELjJNDW6sU019lHMJ7OB6KPbFEcEEsahLmtMP2ua/C5rZjbRyP24cAbTc2yrjm3A1M8WoUbcvcIIpRw93BoYfK985vbI4M6WNfYl0/wOpYrhom6oo19dGJRlBBeKnjiW2Wa5MFUvBOHEXTQIDAQAB";

    /**
     * 对访客信息进行加密, 聊天窗埋点的时候, 生成埋点URL中的cinfo和key参数 使用此方法.
     * @param request
     * @param response
     * @return
     */
/*    @ResponseBody
    @RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    public JSONObject  encrypt (HttpServletRequest request, HttpServletResponse response) {
        try {
            // 还原公钥
        	PublicKey publicKey = null;
             publicKey = OnlinePubKeyUtil.getPubKey();
            // 要加密的信息 请使用json格式的字符串.
            String cinfo = "{\"userId\":\"123456\",\"userName\":\"alps\",\"extInfo\":{\"userId\":\"123456\",\"userName\":\"alps\"}}";
            Map<String, String> res =  CustomerInfoCryptoUtil.encryptByPublicKey(cinfo, publicKey);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cinfo", res.get("text"));
            jsonObject.put("key", res.get("key"));

            //样例输出, 由于加密含有随机内容, 每次输入不会相同
            //cinfo=zX8loFKEADhkz4M9jMFHS0vvmf6fx4D4%2B%2BsbMa%2BNVflsLopEWb62DzyXLsTx5tfVWgR7vNHVpjumqdblWt%2BGSuBJCmXXhw7Stzv8Xh%2BrZ3%2FCMEoktoYdXJcQMJOcEGf0
            //key=aKWaVjZazCLmbS4C3mX25Z5tzUoNHIcz7321ATj7J5RDg0NV69lYca8vOh31STwHlI0rSjOyE8sTDi5PumN4bVRvzG7larRxQlgsK8yoWlZ8leMuKAuuvf2KlnPEFXp0AYCdwq1j%2B6AdYniK1EtYK0Gq%2Bn6JsFujW9GQAv%2FttssYZclc6RhstmwJFHKwdfDDLYAtbwiXbF8OvUN6UQBKnxOde4XrZRrFRh9YPg7mIrhI1i7ImPl3MgFYxFkljEWFIvTOi6s4iYMSkmB4CB0KSemUPZSsAciG3PHMRU4RR4kcyhvfPRRQurSblASRkttFKpWbdUXQTZ06%2BVILawuKxQ%3D%3D

            return jsonObject;
        } catch (Exception e) {
            //这里建议使用log记录错误. 减少干扰信息, DEMO里不使用LOG
            e.printStackTrace();
            return null;
        }
    }

    *//**
     * 通过外部接口方式接入访客名片.
     * 工作台显示访客信息, 请使用此方法.
     * note : 本接口必须支持跨域访问.
     * @param request
     * @param response
     * @return
     *//*
    @ResponseBody
    @RequestMapping(value = "/decrypt", method = RequestMethod.POST)
    public JSONObject decrypt(HttpServletRequest request, HttpServletResponse response) {
        try {
            //这两个参数是云客服工作台调用该接口 post body带入的参数.
            String params = request.getParameter("params");
            String key = request.getParameter("key");

            //DEMO 的 样例params 和 key
            if (StringUtils.isEmpty(params) && StringUtils.isEmpty(key)) {
                //这里是样例, 请在正式环境删掉这两行内容, 使用从request中取得的内容
                params = "WaSE34kPAd%2bPBmwyrprHXsSFTIJcmO9k24Eg3E4DjKTjWZDn6B0etM83raFaFwORUpyUr%2bsucVxe9Ec9Bdoe71DeptGjVZKxv0wELBG8"
                        + "%2f9TlQumtjHXNo%2f1LP4I7%2fU640dh%2bvnzmkuppS3DOOCgDgXP0nI%2bB%2fEXAjFxSqc592B5SNflrqBB%2fc6%2bVZGJhqtoxOg8Vmqitmym%2f06Eji0YibA%3d%3d";

                key = "bzQyS7PRQftEugf2QaWPI%2fvFCpbsovf%2bmWjS64hWhSv1gLm%2blbjDZw6tO6NgyFLq1xNobXHvtxV5lCD%2bBh21Qcn9qypFsjKGmXj3"
                        + "%2fmr0wDDY0u3ea4Dmu7YvHiKQ51bqQOJ1SgwqeQUsC07TvN7B45VlVWXm6u3JWKqd4%2f054EtH6qhtR50t"
                        + "%2bOa7PMgCzOjr1H5fiDhTrpxIEePQ7rulVdDorJr1PfBc7WiAcSJ4iEfXOAmwOSzNGF1UJxPLd1yaBme43sveY6cBMKTj5HxWwqkm3wvaaYtdX2a5VYIpdLm0pm1ETDPAUpQQHoTTqE3Mbzryc7OpZf9B%2fYvOHgN07A%3d%3d";
            }

            PublicKey publicKey = getPubKey(PUB_KEY);
            //cinfo是用于客户在自己的后台系统来查询该用户更为详细的其他信息.
            String cinfo = CustomerInfoCryptoUtil.decryptByPublicKey(params, key, publicKey);
            //样例输出
            //{"userId":"1043f16e2ee4185dbfe421ff32bc196e","sourceType":"online","agentId":"0002","extInfo":{"uid":"1043f16e2ee4185dbfe421ff32bc196e","userName":"访客"}}


            //查询到的用户信息按照下面格式拼凑成一个json格式内容, 返回. 请严格按照下面结构形态
            *//**
            {
                "message": "查询成功", //写死
                "result": {
                    "schema": {
                        "properties": {
                            "email": {
                                "name": "邮箱", //自定义参数属性定义
                                "type": "text" //参数类型 可以为: text, string, email, time
                            },
                            "telePhone": {
                                "name": "电话", //自定义参数属性定义
                                "type": "text" //参数类型
                            }
                        }
                    },
                    "telePhone": "11111111111", //自定义参数
                    "email":"xxx.email.com", //自定义参数
                    "userId": "1646818", //userId参数必填
                    "userName": "test" //userName参数必填
                },
                "success": true //写死
            }
             note : 自定义参数要在schema中和result下面一一对应.
             *//*

            String mockResult = "{\"message\":\"查询成功\",\"result\":{\"schema\":{\"properties\":{\"email\":{\"name\":\"邮箱\","
                    + "\"type\":\"text\"},\"telePhone\":{\"name\":\"电话\",\"type\":\"text\"}}},\"telePhone\":\"11111111111\","
                    + "\"email\":\"xxx.email.com\",\"userId\":\"1646818\",\"userName\":\"test\"},\"success\":true}";
            return JSONObject.parseObject(mockResult);
        } catch (Exception e) {
            //这里建议使用log记录错误. 减少干扰信息, DEMO里不使用LOG
            e.printStackTrace();
            return null;
        }
    }*/
	/**
	 * 访客端聊天窗数据埋点
	 * @createDate 2018.7.12
	 * */
	@ResponseBody
    @RequestMapping(value = "/online", method = RequestMethod.POST)
	public static String visitorChatDataPoint (Map<String, String> parameters) throws Exception {
		JSONObject json = new JSONObject();
		
		//还原出RSA公钥对象
		PublicKey publicKey = null;
		try {
			publicKey = OnlinePubKeyUtil.getPubKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String userId = parameters.get("userId");
		
		//long userId = Long.parseLong((String)result.obj);
	//	t_user_info info = t_user_info.findById(userId);
	//	String userInfo = accountAppService.findUserInfomation(userId);
		//JSONObject uInfo = JSONObject.fromObject(userInfo);
		JSONObject cinfo = new JSONObject();
		JSONObject extInfo = new JSONObject();
		
		extInfo.put("uId", "111");
		extInfo.put("userName", "韩大仙");//真实姓名
		extInfo.put("tel", "15227118084");//昵称
	
	
		cinfo.put("extInfo", extInfo);
		cinfo.put("userId", "userId");  //需要userId
		cinfo.put("tel", "199999999");
		cinfo.put("timestamp", new Date().getTime());
		
	
		Map<String,String> map = CustomerInfoCryptoUtil.encryptByPublicKey(cinfo.toString(), publicKey);
		String mainUrl = "https://cschat-ccs.aliyun.com/h5portal.htm?tntInstId=_0rhgRUW&scene=SCE00004278";
		String url = "&cinfo="+map.get("text")+"&key="+map.get("key");
		json.put("code", 1);
		json.put("msg", "获取在线访客名片埋点成功");
		json.put("url", mainUrl + url);
		System.out.println("json::"+json);
		System.out.println("url::"+mainUrl + url);
		return json.toString();
	}
	@ResponseBody
    @RequestMapping(value = "/onlineSend", method = RequestMethod.POST)
	public static String customerInfo(String params ,String key) throws Exception {
//		request.contentType = "application/json";
//		
//		response.setHeader("Content-Type", "application/json");
//		response.setHeader("charset", "utf-8");
//		response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        // 响应类型
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
//        // 响应头设置
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        
        JSONObject json = new JSONObject();
        if (params == null || key == null) {
        	json.put("message", "查询失败 ");
			json.put("success", false);
			json.put("result",null);
			return json.toString();
        }
        
		PublicKey publicKey = OnlinePubKeyUtil.getPubKey();
		String cinfo = CustomerInfoCryptoUtil.decryptByPublicKey(URLEncoder.encode(params, "UTF-8"), URLEncoder.encode(key,"UTF-8"), publicKey);
		JSONObject dataJsonObject = JSONObject.fromObject(cinfo);
System.out.println("dataJsonObject:"+dataJsonObject);

		
		JSONObject result = new JSONObject();
		//JSONObject properties = new JSONObject();
		JSONObject exinfo = JSONObject.fromObject(dataJsonObject.get("extInfo"));
	
		String userId = dataJsonObject.get("userId").toString();
		JSONObject userName = new JSONObject();
		JSONObject customerName = new JSONObject();
		
		
		/*userId.put("name", "用户Id");
		userId.put("type", "text");*/
		userName.put("name", "真实姓名");
		userName.put("type", "text");
		customerName.put("name", "客户名");
		customerName.put("type", "text");
	
		
//		properties.put("userId", userId);
//		properties.put("realName", userName);
//		properties.put("customerName", customerName);
	
		
		
		result.put("userId", userId);
		result.put("userName", exinfo.get("userName"));
		result.put("tel", exinfo.get("tel"));
		result.put("uId", exinfo.get("uId"));
		
		json.put("message", "查询成功");
		json.put("success", true);
		json.put("result", result);
		
		
		
		return json.toString();
		
	}

}