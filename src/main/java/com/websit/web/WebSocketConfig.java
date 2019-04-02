package com.websit.web;

import org.springframework.context.annotation.Configuration;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
/***
 * 
 *
 * @ClassName: WebSocketConfig

 * @description 用一句话描述这个类的作用
 *
 * @author lishaozhang
 * @createDate 2019年1月21日
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    //注册端点发布消息和订阅都需要连接此端点
	@Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
    //    stompEndpointRegistry.addEndpoint("/endpointSang").setAllowedOrigins("*").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointSang").setAllowedOrigins("*").withSockJS();
    }

    /*@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	//消息代理是/topic 和chat
        registry.enableSimpleBroker("/topic","/chat");
        //目的地头（前缀）
        registry.setApplicationDestinationPrefixes("/app");
    }*/
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
