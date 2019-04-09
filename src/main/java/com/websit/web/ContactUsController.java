package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.ContactUs;
import com.websit.service.ContactUsService;
import com.websit.until.JsonUtil;

@Controller
public class ContactUsController {
	@Autowired
private ContactUsService contactUsService;
	/**
	 * 联系我们展示
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@RequestMapping(value = "/selectAllContactUsList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllContactUsList() {
		try{
		List<ContactUs> result = contactUsService.selectAllContactUsList();

		if (result.size()>=1) {
			return JsonUtil.getResponseJson(1, "查看成功", null, result);
		} else {
			return JsonUtil.getResponseJson(1, "无数据", null, result);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	}
	}
	/**
	 * 联系我们展示 分页
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@RequestMapping(value = "/selectAllContactUsListPage", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllContactUsListPage(Integer page,Integer limit,ContactUs contactUs) {
		try{
			Integer star = (page - 1) * limit;
		List<ContactUs> result = contactUsService.selectAllContactUsListPage(star,limit);
	    int count =	contactUsService.findContactUsCount(contactUs);
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
	 * 联系我们展示(增加)
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@RequestMapping(value = "/saveContactUs", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String saveContactUs(ContactUs contactUs) {
		try{
		int result = contactUsService.saveContactUs(contactUs);

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
	 * 联系我们展示(修改)
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@RequestMapping(value = "/updateContactUs", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateContactUs(BigInteger id,String address,String phone,String enterprise_email,String record) {
		ContactUs contactUs = new ContactUs ();
		contactUs.setId(id);
		contactUs.setAddress(address);
		contactUs.setPhone(phone);
		contactUs.setEnterprise_email(enterprise_email);
		contactUs.setRecord(record);
		try{
		int result = contactUsService.updateContactUs(contactUs);

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
	 * 联系我们展示(删除)
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@RequestMapping(value = "/deleteContactUsById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteContactUsById(BigInteger id) {
		try{
		int result = contactUsService.deleteContactUsById(id);

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
