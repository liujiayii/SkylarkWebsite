package com.websit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


	
	@Service
	public class WebScoketService {
	    @Autowired
	    private SimpMessagingTemplate simpMessagingTemplate;
	    /**
	     * 
	    *
	     * @Title: sendTopicMessage
	    
	     * @description 将信息推送至订阅 /topic/daojishi 的前端
	     *
	     * @param @param personDO    
	     * @return void    
	     *
	     * @author lishaozhang
	     * @createDate 2018年12月17日
	     */
	    public void sendTopicMessage(String personDO){  
	    	 //参数  目的地 消息
	    	simpMessagingTemplate.convertAndSend("/topic/getResponse", personDO);
	    }
}
