package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;

import com.websit.service.IT_alipayment_orderService;


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

	private Logger logger = Logger.getLogger(T_alipayment_orderController.class);
	@Autowired
	private IT_alipayment_orderService alipayment_orderService;
	
	
}
