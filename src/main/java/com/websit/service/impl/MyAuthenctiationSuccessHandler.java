package com.websit.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_admin;
import com.websit.mapper.T_adminMapper;
import com.websit.service.IT_permissionService;

/**
 * 登录成功业务处理
 *
 * @ClassName: MyAuthenctiationSuccessHandler
 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年4月15日-上午11:47:10
 */
@Component("MyAuthenctiationSuccessHandler")
public class MyAuthenctiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 
	@Autowired
	private IT_permissionService permissionService;
	
	@Autowired
	private T_adminMapper adminMapper;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        JSONObject res = new JSONObject();
        T_admin admin = adminMapper.findByUserName(authentication.getName());
        
        if (admin.getRoles() != null && admin.getRoles().size() > 0) {
        	res.put("code", ReturnCode.SUCCSEE_CODE);
            res.put("msg", "登录成功");
            res.put("data", permissionService.ListMenusByRoleId(admin.getRoles().get(0).getId()));
            // 下面代码默认左侧导航不受权限影响（显示全部菜单）
            //res.put("data", permissionService.ListMenu());
        } else {
        	res.put("code", ReturnCode.EXCEPTION_CODE);
            res.put("msg", "账号异常");
            res.put("data", null);
        }
        res.put("admin", admin);
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(res.toString());
    }

	
}
