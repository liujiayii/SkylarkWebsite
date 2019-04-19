package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.Brand;
import com.websit.entity.Classification;
import com.websit.service.BrandService;
import com.websit.until.JsonUtil;

@Controller
public class BrandController {
@Autowired
private BrandService brandService;
/**
 * 查询商品规格---分页
 * @author pangchong
 * @createDate 2019年3月24日 下午2:00
 */
@RequestMapping(value = "/listAllBrand", produces = "application/json; charset=utf-8")
@ResponseBody
public String listAllBrand(Integer page,Integer limit,Brand brand) {
	try{
		Integer star = (page - 1) * limit;
	List<Brand> result = brandService.listAllBrand(star,limit);
	Integer count = brandService.findBrandCount(brand);
	if (result.size() >0) {
		return JsonUtil.getResponseJson(1, "查看成功", count, result);
	} else {
		return JsonUtil.getResponseJson(-1, "无数据", null, result);
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
@RequestMapping(value = "/saveBrand", produces = "application/json; charset=utf-8")
@ResponseBody
public String saveBrand(Brand brand) {
	try{
	int result = brandService.saveBrand(brand);
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
@RequestMapping(value = "/updateBrand", produces = "application/json; charset=utf-8")
@ResponseBody
public String updateBrand(String name,Long id) {
	Brand brand=new Brand();
	brand.setName(name);
	brand.setId(id);
	try{
	int result = brandService.updateBrand(brand);
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
 * 根据id删除商品规格
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/deleteBrandById", produces = "application/json; charset=utf-8")
@ResponseBody
public String deleteBrandById(BigInteger id) {
	try{
	int result = brandService.deleteBrandById(id);
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
