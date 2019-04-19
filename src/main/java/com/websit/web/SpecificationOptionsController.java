package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.websit.entity.SpecificationOptions;
import com.websit.entityvo.SpecificationsVo;
import com.websit.service.SpecificationOptionsService;
import com.websit.until.JsonUtil;

@Controller
public class SpecificationOptionsController {
@Autowired
private SpecificationOptionsService specificationOptionsService;

/**
 * 规格选项列表---分页
 * @author pangchong
 * @createDate 2019年4月18日 下午2:00
 */
@RequestMapping(value = "/listAllSpecificationOptions", produces = "application/json; charset=utf-8")
@ResponseBody
public String listAllSpecificationOptions(Integer page,Integer limit,SpecificationOptions specificationOptions) {
	try{
		Integer star = (page - 1) * limit;
	List<SpecificationOptions> result = specificationOptionsService.listAllSpecificationOptions(star,limit);
	int count = specificationOptionsService.findSpecificationsOptionsCount(specificationOptions);
	if (result.size() >0) {
		return JsonUtil.getResponseJson(1, "查看成功", count, result);
	} else {
		return JsonUtil.getResponseJson(-1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 根据规格id查询规格选项
 * @author pangchong
 * @createDate 2019年3月24日 下午2:00
 */
@RequestMapping(value = "/listAllSpecificationOptionsBySpecificationId", produces = "application/json; charset=utf-8")
@ResponseBody
public String listAllSpecificationOptionsBySpecificationId(Long specificationsId) {
	try{
	List<SpecificationOptions> result = specificationOptionsService.listAllSpecificationOptionsBySpecificationId(specificationsId);
	if (result.size() >0) {
		return JsonUtil.getResponseJson(1, "查看成功", null, result);
	} else {
		return JsonUtil.getResponseJson(-1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 增加商品规格选项
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/saveSpecificationOptions", produces = "application/json; charset=utf-8")
@ResponseBody
public String saveSpecificationOptions(SpecificationOptions specificationOptions) {
	try{
	int result = specificationOptionsService.saveSpecificationOptions(specificationOptions);
	if (result >0) {
		return JsonUtil.getResponseJson(1, "增加成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 修改商品规格选项
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/updateSpecificationOptions", produces = "application/json; charset=utf-8")
@ResponseBody
public String updateSpecificationOptions(String name,Long id,Long specificationsId) {
	SpecificationOptions specificationOptions = new SpecificationOptions();
	specificationOptions.setName(name);
	specificationOptions.setId(id);
	specificationOptions.setSpecificationsId(specificationsId);
	try{
	int result = specificationOptionsService.updateSpecificationOptions(specificationOptions);
	if (result >0) {
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
 * 根据id删除商品规格选项
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/deleteSpecificationOptionsById", produces = "application/json; charset=utf-8")
@ResponseBody
public String deleteSpecificationOptionsById(BigInteger specificationsId) {
	try{
	int result = specificationOptionsService.deleteSpecificationOptionsById(specificationsId);
	if (result >0) {
		return JsonUtil.getResponseJson(1, "删除成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
}
