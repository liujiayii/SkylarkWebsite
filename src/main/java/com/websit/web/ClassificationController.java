package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.Classification;
import com.websit.entityvo.ProductTypeVo;
import com.websit.entityvo.ProductVo;
import com.websit.entityvo.ProductVos;
import com.websit.service.ClassificationService;
import com.websit.until.JsonUtil;

@Controller
public class ClassificationController {
@Autowired
private ClassificationService classificationService;
/**
 * 查询商品一级分类---不分页(app)
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/listClassificationList", produces = "application/json; charset=utf-8")
@ResponseBody
public String listClassificationList() {
	try{
	List<ProductVos> result = classificationService.listClassificationList();

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
 * 根据一级类型id查询当前一级类型及每个一级类型下所有商品类型(app)
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/listClassificationByClassificationId", produces = "application/json; charset=utf-8")
@ResponseBody
public String listClassificationByClassificationId(@RequestParam(value="classificationId", required = false) String classificationId) {
	Long classificationIds = null;
	
	if (StringUtils.isNotEmpty(classificationId)) {
		classificationIds = Long.valueOf(classificationId);
	}
	return classificationService.listClassificationByClassificationId(classificationIds);
}
/**
 * 查询商品一级分类---分页
 * @author pangchong
 * @createDate 2019年3月24日 下午2:00
 */
@RequestMapping(value = "/listAllClassification", produces = "application/json; charset=utf-8")
@ResponseBody
public String listAllClassification(Integer page,Integer limit,Classification classification,String name) {
	try{
		Integer star = (page - 1) * limit;
	List<Classification> result = classificationService.listAllClassification(star,limit,name);
	Integer count = classificationService.findClassificationCount(classification);
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
 * 增加商品一级分类
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/saveClassification", produces = "application/json; charset=utf-8")
@ResponseBody
public String saveClassification(Classification classification) {
	try{
	int result = classificationService.saveClassification(classification);
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
 * 修改商品一级分类
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/updateClassification", produces = "application/json; charset=utf-8")
@ResponseBody
public String updateClassification(String name,Long id,String image) {
	Classification classification=new Classification();
	classification.setName(name);
	classification.setId(id);
	classification.setImage(image);
	//System.out.println(classification+"classification");
	try{
	int result = classificationService.updateClassification(classification);
//System.out.println(classification.getCreate_time());	
	System.out.println("result"+result);
	if (result >0) {
		return JsonUtil.getResponseJson(1, "修改成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 根据id删除商品一级分类
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/deleteClassificationById", produces = "application/json; charset=utf-8")
@ResponseBody
public String deleteClassificationById(BigInteger id) {
	try{
	int result = classificationService.deleteClassificationById(id);
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
