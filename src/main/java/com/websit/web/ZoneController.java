package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.Classification;
import com.websit.entity.Zone;
import com.websit.entityvo.ZoneProductVo;
import com.websit.entityvo.ZoneVo;
import com.websit.service.ZoneService;
import com.websit.until.JsonUtil;

@Controller
public class ZoneController {

	@Autowired
	private ZoneService zoneService;

	/**
	 * 查询商品专区---分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/selectZoneList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectZoneList(Integer page,Integer limit,Zone zone) {
		try{
			Integer star = (page - 1) * limit;
		List<Zone> result = zoneService.selectZoneList(star, limit);
		       Integer count = zoneService.findBpiList(zone);
		if (result.size()>0) {
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
	 * 查询商品专区---不分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/selectZoneNoPage", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectZoneNoPage() {
		try{
		List<Zone> result = zoneService.selectZoneNoPage();
		
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
	 * 根据专区id查询当前商品专区及每个专区下所有商品
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
@RequestMapping(value = "/listZoneByTypeId", produces = "application/json; charset=utf-8")
@ResponseBody
	public String listZoneByTypeId(BigInteger zoneId) {
		try{
		ZoneVo result = zoneService.listZoneByTypeId(zoneId);
		
		if (result!= null ) {
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
 * 增加商品专区
 * @author pangchong
 * @createDate 2019年3月24日 下午2:00
 */
@RequestMapping(value = "/saveZone", produces = "application/json; charset=utf-8")
@ResponseBody
public String saveZone(Zone zone) {
	try{
	int result = zoneService.saveZone(zone);
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
 * 修改商品专区
 * @author pangchong
 * @createDate 2019年3月24日 下午2:00
 */
@RequestMapping(value = "/updateZone", produces = "application/json; charset=utf-8")
@ResponseBody
public String updateZone(String name,Long id,String image) {
	Zone zone = new Zone();
	zone.setId(id);
	zone.setName(name);
	zone.setImage(image);
	try{
	int result = zoneService.updateZone(zone);
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
 * 根据id删除商品专区
 * @author pangchong
 * @createDate 2019年3月24日 下午2:00
 */
@RequestMapping(value = "/deleteZoneById", produces = "application/json; charset=utf-8")
@ResponseBody
public String deleteZoneById(BigInteger id) {
	try{
	int result = zoneService.deleteZoneById(id);
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
 * 查询商品专区---不分页
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@RequestMapping(value = "/selectZoneByProductId", produces = "application/json; charset=utf-8")
@ResponseBody
public String selectZoneByProductId(BigInteger productaid) {
	try{
	List<ZoneProductVo> result = zoneService.selectZoneByProductId(productaid);
	
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
