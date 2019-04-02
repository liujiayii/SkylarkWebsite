package com.websit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.websit.entity.RequestMessage;
import com.websit.entity.ResponseMessage;
import com.websit.entity.T_access;
import com.websit.service.IT_accessService;
import com.websit.service.IT_userService;
import com.websit.service.WebScoketService;




@Controller
/*@RequestMapping("info")*/
public class WsController extends WebMvcConfigurerAdapter {
	

	@Autowired
	private WebScoketService webScoketService;
	@Autowired
	private IT_accessService accessService;
	
  
	@Configuration
	public class WebMvcConfig extends WebMvcConfigurerAdapter {
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/ws").setViewName("/ws");
	    }
	}
	
   
    
   
}
