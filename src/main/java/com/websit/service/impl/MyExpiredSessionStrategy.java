package com.websit.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.websit.constant.ReturnCode;

@Component
public class MyExpiredSessionStrategy implements SessionInformationExpiredStrategy {

	/**
	 * session超时事件处理
	 */
	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		HttpServletResponse response = event.getResponse();
	    JSONObject res = new JSONObject();
        res.put("code", -2);
        res.put("msg", "当前用户在其他地方登录，若非本人操作请及时修改密码");
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(res.toString());
	}

}
