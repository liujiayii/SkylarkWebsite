package com.websit.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.websit.entity.T_cooperation;
import com.websit.service.IT_cooperationService;
import com.websit.until.JsonUtil;

/**
 * <p>
 * 首页合作商 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Controller
public class T_cooperationController {
	@Resource
	private IT_cooperationService cooperationService;

	/**
	 * @Title: selectAllcooperation
	 * @description 查询所有合作商
	 * @return result
	 * @author linhongyu
	 * @createDate 2019年03月13日
	 */
	@RequestMapping(value = "/selectAllcooperation", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllcooperation(T_cooperation cooperation, Integer page, Integer limit) {
		try {
			/*
			 * Page<Map<String, Object>> selectMapsPage =
			 * cooperationService.selectMapsPage(new Page<>(), new
			 * EntityWrapper<T_cooperation>());
			 */
//			Page<T_cooperation> selectPage = cooperationService.selectPage(new Page<>(page, limit),
//					new EntityWrapper<T_cooperation>());
			Map<String, Object> columnMap = new HashMap<String, Object>();

			List<T_cooperation> records = cooperationService.selectByMap(columnMap);
			int selectCount = cooperationService.selectCount(null);
			if (records.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", selectCount, records);
			} else {
				return JsonUtil.getResponseJson(2, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: insertSome
	 * @description 新增一条合作商
	 * @return num
	 * @author linhongyu
	 * @createDate 2019年03月13日
	 */
	@RequestMapping("insertSome")
	@ResponseBody
	public String insertSome(T_cooperation cooperation) {
		/*
		 * Map map = new HashMap<String,Object>(); map.put("name",
		 * cooperation.getName()); 查询名称是否重复 map.put("address",
		 * cooperation.getAddress());
		 */
		String name = cooperation.getName();
		String address = cooperation.getAddress();
		boolean num = true;
		cooperation.setName(name);
		T_cooperation coop = cooperationService.selectThink(cooperation);
		if (coop != null) {
			return JsonUtil.getResponseJson(2, "合作商名称重复", null, null);
		}
		cooperation.setAddress(address);
		T_cooperation coops = cooperationService.selectThinkTwo(cooperation);
		if (coops != null) {
			return JsonUtil.getResponseJson(3, "网站链接重复", null, null);
		}
		num = cooperationService.insert(cooperation);
		if (num == true) {
			return JsonUtil.getResponseJson(1, "新增成功", null, null);
		} else {
			return JsonUtil.getResponseJson(-1, "新增失败", null, null);
		}
	}

	/**
	 * @Title: insertSome
	 * @description 删除一条合作商
	 * @return num
	 * @author linhongyu
	 * @createDate 2019年03月13日
	 */
	@RequestMapping("delOne")
	@ResponseBody
	public String delOne(T_cooperation cooperation) {
		try {
			Long ids = cooperation.getId();
			cooperation.setId(ids);
			boolean deleteById = cooperationService.deleteById(cooperation);
			if (deleteById == true) {
				return JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				return JsonUtil.getResponseJson(2, "删除失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: updateCoopera
	 * @description 修改一条合作商
	 * @return result
	 * @author linhongyu
	 * @createDate 2019年03月13日
	 */
	@RequestMapping("updateCoopera")
	@ResponseBody
	public String updateCoopera(T_cooperation cooperation) {
		String name = cooperation.getName();
		String address = cooperation.getAddress();
		cooperation.setName(name);
		cooperation.setAddress(address);
		try {
			boolean updateById = cooperationService.updateById(cooperation);
			if (updateById == true) {
				return JsonUtil.getResponseJson(1, "修改成功", null, null);
			} else {
				return JsonUtil.getResponseJson(2, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: selectByID
	 * @description 通过ID查询合作商数据
	 * @return result
	 * @author linhongyu
	 * @createDate 2019年03月13日
	 */
	@RequestMapping("selectByID")
	@ResponseBody
	public String selectByID(T_cooperation cooperation, long id) {
		try {
			Page<Map<String, Object>> selectMapsPage = cooperationService.selectMapsPage(new Page<>(),
					new EntityWrapper<T_cooperation>().eq("id", id));
			List<Map<String, Object>> records = selectMapsPage.getRecords();
			if (records.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查询成功", null, null);
			} else {
				return JsonUtil.getResponseJson(2, "查询失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
}
