package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.constant.AlipayReturnEnum;
import com.websit.constant.ReturnCode;
import com.websit.service.AliPayAppService;
import com.websit.service.IT_alipayment_orderService;
import com.websit.until.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 商户支付宝订单 前端控制器
 * </p>
 *
 * @author lujinpeng
 * @since 2019-03-27
 */
@Controller
@RequestMapping("/t_alipayment_order")
public class T_alipayment_orderController {

	
	
	
}
