package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.websit.entity.Classification;
import com.websit.entity.T_product;
import com.websit.entity.T_product_type;
import com.websit.entity.Zone;
import com.websit.entityvo.ProductVos;
import com.websit.entityvo.ZoneProductVo;
import com.websit.entityvo.ZoneVo;
import com.websit.entityvo.t_productVo;
import com.websit.mapper.ClassificationMapper;
import com.websit.service.ClassificationService;
import com.websit.service.IT_productService;
import com.websit.service.IT_product_typeService;
import com.websit.service.ZoneService;
import com.websit.until.JsonUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 商品类型表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
public class T_product_typeController {
	@Autowired
	private IT_product_typeService product_typeService;
	@Autowired
	private ClassificationService classificationService;
	@Autowired
	private IT_productService productService;
	@Autowired
	private ZoneService zoneService;
	

	/**
	 * 添加商品类型
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
@RequestMapping(value = "/insertproductType", produces = "application/json; charset=utf-8")
@ResponseBody
	public String insertproductType(T_product_type product_type) {
		try{
		boolean result = product_typeService.insert(product_type);
		
		if (result) {
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
 * 查询商品类型---分页
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/selectAllProductTypeList", produces = "application/json; charset=utf-8")
@ResponseBody
public String selectAllProductTypeList(T_product_type productType,Integer page,Integer limit) {
	try{
		Integer star = (page - 1) * limit;
	List<T_product_type> result = product_typeService.selectAllProductTypeList(star,limit);
	Integer count = product_typeService.findProductTypeCount(productType);
	if (result.size()>=1&& count !=null) {
		return JsonUtil.getResponseJson(1, "查看成功", count, result);
	} else {
		return JsonUtil.getResponseJson(1, "无数据", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}

/**
 * 查询商品类型---不分页
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/selectproductTypeNoPage", produces = "application/json; charset=utf-8")
@ResponseBody
public String selectproductTypeNoPage() {
	try{
	List<T_product_type> result = product_typeService.selectproductTypeNoPage();
	
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
 * 删除商品类型
 * @author pangchong
 * @createDate 2019年3月22日 下午2:00
 */
@RequestMapping(value = "/deleteProductTypeById", produces = "application/json; charset=utf-8")
@ResponseBody
public String deleteProductTypeById(BigInteger id) {
	try{
	int result = product_typeService.deleteProductTypeById(id);
	
	if (result>0) {
		return JsonUtil.getResponseJson(1, "删除成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "删除失败", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 修改商品类型
 * @author pangchong
 * @createDate 2019年3月22日 下午2:00
 */
@RequestMapping(value = "/updateProductType", produces = "application/json; charset=utf-8")
@ResponseBody
public String updateProductType(String name,Long id,String ioc,Long classificationId) {
	T_product_type productType = new T_product_type();
	productType.setId(id);
	productType.setName(name);
	productType.setIoc(ioc);
	productType.setClassificationId(classificationId);
	try{
	int result = product_typeService.updateProductType(productType);
	if (result>0) {
		return JsonUtil.getResponseJson(1, "修改成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "修改失败", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}
/**
 * 增加商品类型
 * @author pangchong
 * @createDate 2019年3月22日 下午2:00
 */
@RequestMapping(value = "/saveProductType", produces = "application/json; charset=utf-8")
@ResponseBody
public String saveProductType(T_product_type productType) {
	try{
	int result = product_typeService.saveProductType(productType);
	
	if (result>0) {
		return JsonUtil.getResponseJson(1, "增加成功", null, result);
	} else {
		return JsonUtil.getResponseJson(1, "修改失败", null, null);
	}
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}

/**
 * 查商品类型
 * @author pangchong
 * @createDate 2019年3月22日 下午2:00
 */
@RequestMapping(value = "/selectAllproductation", produces = "application/json; charset=utf-8")
@ResponseBody
public String selectAllproductation() {
	try{
		Map<String,Object> map=new HashMap<>();
		
		List<Classification>list=classificationService.selectClassification();
		System.out.println(list);
		System.out.println(list.get(0));
		for(int i=0;i<list.size();i++){
			List<T_product_type>lists=product_typeService.selectproduct(list.get(i));
			map.put(list.get(i).getName(), lists);
		}
		 /*String json = JSONObject.toJSONString(map);
		System.out.println("map"+json);*/
		return JsonUtil.getResponseJson(1, "查询成功", null, map);
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}

/**
 * 根据专区查商品
 * @author pangchong
 * @createDate 2019年3月22日 下午2:00
 */

@RequestMapping(value = "/findBpproduc", produces = "application/json; charset=utf-8")
@ResponseBody
public String findBpproduc(Integer page,Integer limit) {
	try{
		Integer star = (page - 1) * limit;
		Map<String,Object> map=new HashMap<>();
		
		List<Zone>list=zoneService.selectZoneNoPage();
		List<ZoneVo>lista=new ArrayList<>();
	
		for(int i=0;i<list.size();i++){
			
			BigInteger big = new BigInteger(list.get(i).getId().toString());
				ZoneVo result = zoneService.listZoneByTypeIds(big,star,limit);
				Integer productTotal = zoneService.findBpiListByZoneId(big);
				
				if (result == null) {
					continue;
				}
				result.setProductTotal(productTotal);
				
				if(result!=null){
					System.out.println("result"+result);
					lista.add(result);
				}
				
		}
	
	System.out.println("lista"+lista);
		return JsonUtil.getResponseJson(1, "查询成功", list.size(), lista);
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
	
}



@RequestMapping(value = "/findBpproducs", produces = "application/json; charset=utf-8")
@ResponseBody
public String findBpproduc(Long id) {
	System.out.println("id"+id);
	try{
		T_product_type t=new T_product_type();
		t.setId(id);
		System.out.println("t"+t);
		List<T_product> listone=productService.findBpproduc(t);
		System.out.println("listone"+listone);
	 /*String json = JSONObject.toJSONString(map);
		System.out.println("map"+json);*/
		return JsonUtil.getResponseJson(1, "查询成功", null, listone);
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}

@RequestMapping(value = "/selectbyDESC", produces = "application/json; charset=utf-8")
@ResponseBody
public String selectbyDESC(Integer page,Integer limit) {
	
	try{
		Integer star = (page - 1) * limit;
		List<T_product>list=product_typeService.selectbyDESC(star, limit);
		
		
	 /*String json = JSONObject.toJSONString(map);
		System.out.println("map"+json);*/
		return JsonUtil.getResponseJson(1, "查询成功", null, list);
} catch (Exception e) {
	e.printStackTrace();
	return JsonUtil.getResponseJson(-1, "程序异常", null, null);
}
}

}



