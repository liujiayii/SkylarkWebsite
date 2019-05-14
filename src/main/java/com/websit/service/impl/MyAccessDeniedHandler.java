package com.websit.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 拦截消息处理
 *
 * @ClassName: MyAccessDeniedHandler

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年4月23日-下午5:53:57
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2)
			throws IOException, ServletException {

		//返回json形式的错误信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println("{\"code\":403,\"msg\":\"您没有权限！\",\"data\":\"\"}");
		response.getWriter().flush();

		
	}

}
