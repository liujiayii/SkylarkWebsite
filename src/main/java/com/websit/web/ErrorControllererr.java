package com.websit.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *<p> 定义错误页面</p>
 * @author 陈志浩
 *
 */
@Controller
public class ErrorControllererr implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(HttpServletRequest request) {
    	Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");//获取错误码
    	System.out.println(statusCode);
        return "/home/error.html";//返回错误页面
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }
}
