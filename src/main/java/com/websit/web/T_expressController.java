package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.websit.constant.ReturnCode;
import com.websit.service.IT_expressService;
import com.websit.until.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 快递公司表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/t_express")
public class T_expressController {
	@Autowired
	private IT_expressService it_expressService;
	
	/**
	 * 获取快递信息
	 *
	 * @Title: getExpressInfo
	 * @description 
	 * @param number 快递单号
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月26日-下午9:00:10
	 */
	@RequestMapping("/getExpressInfo")
	@ResponseBody
	public String getExpressInfo(String number) {
		
		if (StringUtils.isEmpty(number)) {
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, "参数缺失", null, null);
		}
		Map<String, String> map = new HashMap<> ();
		map.put("number", number);
		
		return it_expressService.selectExpressDetails(map);
	}
	
	
	
}
