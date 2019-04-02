package com.websit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.OurAdvantages;
import com.websit.service.OurAdvantagesService;
import com.websit.until.JsonUtil;

@Controller
public class OurAdvantagesController {
@Autowired
private OurAdvantagesService ourAdvantagesService;

/**
 * 我们的优势展示
 * @author pangchong
 * @createDate 2019年4月2日 下午2:00
 */
@RequestMapping(value = "/selectAllOurAdvantagesList", produces = "application/json; charset=utf-8")
@ResponseBody
public String selectAllOurAdvantagesList() {
	try{
	List<OurAdvantages> result = ourAdvantagesService.selectAllOurAdvantagesList();

	if (result.size()>=1) {
		return JsonUtil.getResponseJson(1, "查看成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
}
