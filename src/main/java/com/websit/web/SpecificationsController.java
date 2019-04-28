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
import com.websit.service.SpecificationsService;
import com.websit.until.JsonUtil;

@Controller
public class SpecificationsController {
@Autowired
private SpecificationsService specificationsService;

/**
 * 根据商品类型id查询规格
 * @author pangchong
 * @createDate 2019年4月11日 下午2:00
 */
@RequestMapping(value = "/listSpecificationsByproducttypeid", produces = "application/json; charset=utf-8")
@ResponseBody
public String listSpecificationsByproducttypeid(Integer page,Integer limit,SpecificationsVo specificationsVo,Long producttypeid) {
	try{
	List<SpecificationsVo> result = specificationsService.listSpecificationsByproducttypeid(producttypeid);
	if (result.size() >0) {
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
 * 规格列表---分页
 * @author pangchong
 * @createDate 2019年3月24日 下午2:00
 */
@RequestMapping(value = "/listAllSpecifications", produces = "application/json; charset=utf-8")
@ResponseBody
public String listAllSpecifications(Integer page,Integer limit,SpecificationsVo specificationsVo) {
	try{
		Integer star = (page - 1) * limit;
	List<SpecificationsVo> result = specificationsService.listAllSpecifications(star,limit);
	int count = specificationsService.findSpecificationsVoCount(specificationsVo);
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
 * 增加商品规格
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/saveSpecificationsVo", produces = "application/json; charset=utf-8")
@ResponseBody
public String saveSpecificationsVo(SpecificationsVo specificationsVo) {
	try{
	int result = specificationsService.saveSpecificationsVo(specificationsVo);
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
 * 修改商品规格
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/updateSpecificationsVo", produces = "application/json; charset=utf-8")
@ResponseBody
public String updateSpecificationsVo(String specificationsName,Long productTypeId,Long specificationsId) {
	SpecificationsVo specificationsVo = new SpecificationsVo();
	specificationsVo.setSpecificationsId(specificationsId);
	specificationsVo.setSpecificationsName(specificationsName);
	specificationsVo.setSpecificationsId(specificationsId);
	try{
	int result = specificationsService.updateSpecificationsVo(specificationsVo);
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
@RequestMapping(value = "/deleteSpecificationsVoById", produces = "application/json; charset=utf-8")
@ResponseBody
public String deleteSpecificationsVoById(BigInteger specificationsId) {
	try{
	int result = specificationsService.deleteSpecificationsVoById(specificationsId);
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

/**
 * 根据规格id查询规格选项(app)
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/listSpecificationsBySpecificationsId", produces = "application/json; charset=utf-8")
@ResponseBody
public String listSpecificationsBySpecificationsId(Long specificationsId) {
	try{
	List<SpecificationsVo> result = specificationsService.listSpecificationsBySpecificationsId(specificationsId);
	if (result != null ) {
		return JsonUtil.getResponseJson(1, "查询成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
}
