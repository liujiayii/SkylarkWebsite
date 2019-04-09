package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.ContactUs;
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
/**
 * 我们的优势展示 分页
 * @author pangchong
 * @createDate 2019年4月2日 下午2:00
 */
@RequestMapping(value = "/selectAllOurAdvantagesPage", produces = "application/json; charset=utf-8")
@ResponseBody
public String selectAllOurAdvantagesPage(Integer page,Integer limit,OurAdvantages ourAdvantages) {
	try{
		Integer star = (page - 1) * limit;
	List<OurAdvantages> result = ourAdvantagesService.selectAllOurAdvantagesPage(star,limit);
    int count =	ourAdvantagesService.findOurAdvantagesCount(ourAdvantages);
	if (result.size()>=1) {
		return JsonUtil.getResponseJson(1, "查看成功", count, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, result);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 我们的优势展示(增加)
 * @author pangchong
 * @createDate 2019年4月2日 下午2:00
 */
@RequestMapping(value = "/saveOurAdvantages", produces = "application/json; charset=utf-8")
@ResponseBody
public String saveOurAdvantages(OurAdvantages ourAdvantages) {
	try{
	int result = ourAdvantagesService.saveOurAdvantages(ourAdvantages);

	if (result>0) {
		return JsonUtil.getResponseJson(1, "增加成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, result);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 我们的优势展示(修改)
 * @author pangchong
 * @createDate 2019年4月2日 下午2:00
 */
@RequestMapping(value = "/updateOurAdvantages", produces = "application/json; charset=utf-8")
@ResponseBody
public String updateOurAdvantages(BigInteger id,String title,String content) {
	OurAdvantages ourAdvantages = new OurAdvantages ();
	ourAdvantages.setId(id);
	ourAdvantages.setTitle(title);
	ourAdvantages.setContent(content);
	try{
	int result = ourAdvantagesService.updateOurAdvantages(ourAdvantages);

	if (result>0) {
		return JsonUtil.getResponseJson(1, "修改成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, result);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 我们的优势展示(删除)
 * @author pangchong
 * @createDate 2019年4月2日 下午2:00
 */
@RequestMapping(value = "/deleteOurAdvantagesById", produces = "application/json; charset=utf-8")
@ResponseBody
public String deleteOurAdvantagesById(BigInteger id) {
	try{
	int result = ourAdvantagesService.deleteOurAdvantagesById(id);

	if (result>0) {
		return JsonUtil.getResponseJson(1, "删除成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, result);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
}
