package com.websit.service.impl;


import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.websit.online.utils.EncryptUtil;
import com.websit.online.utils.MessageHttpClient;
import com.websit.online.utils.OnlineConfig;
import com.websit.service.OnlineService;


@Service
public class OnlineServiceImpl implements OnlineService{
	 
	   @Override
		 public  JSONObject sendMessage(String userId, String content) throws Exception {
			 	System.out.println("userId:"+userId);
			 	System.out.println("content:"+content);
			 	JSONObject json = new JSONObject();
		        //拿到当前的 毫秒 时间戳
		        long timestamp = System.currentTimeMillis();
		        System.out.println("时间戳："+timestamp);
		        //构造一个文本消息 消息的字段参考文档
		        JSONObject message = new JSONObject();
		        message.put("userId", userId);
		        message.put("msgType", "text");
		        message.put("content", content);
		        message.put("timestamp", timestamp);
		        //messageStr 就是发送请求的post body内容, 也是计算摘要的内容. 一定要保持一致, 否则digest计算失败
		        String messageStr = message.toJSONString();
		        System.out.println("messageStr:"+messageStr);
		        //计算安全摘要, 计算的传入内容请参考文档
		        //如果想要知道自己计算的摘要是否正确
		        //校验网址: https://1024tools.com/hmac
		        //选择算法: sha1
		        //密钥填写: key的内容
		        //内容就是hmac_sha1的value内容
		        String digest = EncryptUtil.hmac_sha1(messageStr + timestamp, OnlineConfig.key);
		        System.out.println("digest:"+digest);
		        //拼接URL
		        String messageUrl = OnlineConfig.HOST_URL  + OnlineConfig.MESSAGE_PATH + "?tntInstId=" + OnlineConfig.tntInstId + "&scene=" + OnlineConfig.scene + "&digest=" + digest
		                + "&timestamp=" + timestamp + "&src=" + OnlineConfig.src;
		        System.out.println("messagUrl:"+messageUrl);
		        //发送消息
		        //成功返回内容为:
		        //{
		        //    "code": "200",
		        //    "msg": "success"
		        //}
		        //失败情况下, 请查看返回code, 参考文档
		        MessageHttpClient httpClient = new MessageHttpClient();
		        System.out.println("我走这了");
		       
		        json.put("messageUrl", messageUrl);
		        json.put("messageStr", messageStr);
		        
		        return httpClient.sendMessage(messageStr, messageUrl);
		    }

}
