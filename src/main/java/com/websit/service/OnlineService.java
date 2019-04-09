package com.websit.service;

import com.alibaba.fastjson.JSONObject;



public interface OnlineService {
		/**
		 * 
		 * @Title: sendMessage
		 * @description: 发送消息
		 *
		 * @param userId
		 * @param content
		 * @return
		 * @throws Exception    
		 * @return JSONObject   
		 *
		 * @author HanMeng
		 * @createDate 2019年3月27日-下午5:04:23
		 */
	    JSONObject sendMessage(String userId, String content) throws Exception ;
	        
}
