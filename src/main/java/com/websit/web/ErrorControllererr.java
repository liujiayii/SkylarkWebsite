package com.websit.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 定义错误页面
 * @author 陈志浩
 *
 */
@Controller
public class ErrorControllererr implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "/home/error.html";
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }
}
