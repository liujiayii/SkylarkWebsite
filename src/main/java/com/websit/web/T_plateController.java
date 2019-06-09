package com.websit.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.websit.entity.T_plate;
import com.websit.entityvo.T_postingVo;
import com.websit.service.IT_plateService;
import com.websit.service.IT_postingService;
import com.websit.until.JsonUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 板块表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Controller
@RequestMapping("/t_plate")
public class T_plateController {

	@Autowired
	private IT_plateService t_plateService;
	@Autowired
	public IT_postingService t_postingService;
	
	
	/**
	 * 查询所有论坛分类以及对应版块信息
	 *
	 * @Title: showAllPlates
	 * @description 
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月18日-下午3:14:37
	 */
	@RequestMapping("/showAllPlates")
	@ResponseBody
	public String showAllPlates() {
		
		return t_plateService.selectAllPlates();
	}
	
	/**
	 *
	 * @Title: listCompanyPlate
	 * @description 2.1查询当前公司的所有板块列表
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@RequestMapping("/listCompanyPlate")
	@ResponseBody
	public String listCompanyPlate(@RequestBody Long company_id) {
		
		return t_plateService.listCompanyPlate(company_id);
	}
	
	/**
	 *
	 * @Title: T_postingController
	 * @description 3.新增板块内容
	 * @param T_plate
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@RequestMapping("/addT_plate")
	@ResponseBody
	public String T_postingController(@RequestBody T_plate T_plate) {
		//System.out.println("请求成功"+T_plate.toString());
		String msg = "系统异常，请稍后再试";
		Integer cood = -1;
		Date sdf = new Date();
		
		try {
			//T_plate.setCreate_time(sdf);// 获取当前时间
			boolean fig = t_plateService.insert(T_plate);// 调用T_postingService层
			if (fig) {
				msg = "发帖成功";
				cood = 1;
			} else {
				msg = "发帖失败";
				cood = -1;
			}

			return JsonUtil.getResponseJson(cood, msg, null, null);

		} catch (Exception e) {
			// TODO: handle exception

			return JsonUtil.getResponseJson(cood, msg, null, null);
		}
	}
	
	/**
	 * 
	 * @Title: updatePlate
	 * @description 4.修改板块信息
	 * @param id
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@RequestMapping("/updatePlate")
	@ResponseBody
	public String updatePlate(@RequestBody Long id) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		try {
			T_plate entity = new T_plate();
			entity.setId(id);
			boolean fig = t_plateService.updateById(entity);// 调用T_plate Service层
			if (fig) {
				msg = "修改板块信息成功";
				code = 1;
			} else {
				msg = "修改板块信息失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, null, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	/**
	 *
	 * @Title: deletePlate
	 * @description 5.删除板块信息
	 * @param id
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@RequestMapping("/deletePlate")
	@ResponseBody
	public String deletePlate(@RequestBody Long id) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		try {
			boolean fig = t_plateService.deleteById(id);// 调用T_plate Service层
			if (fig) {
				msg = "删除板块信息成功";
				code = 1;
			} else {
				msg = "删除板块信息失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, null, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	/**
	 *
	 * @Title: countCompanyPlate
	 * @description 查询当前公司的板块数
	 * @param @param company_id
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月4日
	 */
	@RequestMapping("/countCompanyPlate")
	@ResponseBody
	public String countCompanyPlate(@RequestBody Long company_id) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		try {
			int coutPlate = t_plateService.countCompanyPlate(company_id);// 调用T_plate Service层
			if (coutPlate != 0) {
				msg = "查询主题数成功";
				code = 1;
			} else {
				msg = "查询主题数失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, coutPlate, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	/**
	 * 
	 * @Title: countPostingByPlateId
	 * @description 6.1.通过板块id查询当前板块下的帖子的数量（首页的"帖数"使用）
	 * @param @param plate_id
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月4日
	 */
	@RequestMapping("/countPostingByPlateId")
	@ResponseBody
	public String countPostingByPlateId(@RequestBody Long plate_id) {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		try {
			int coutPosting = t_postingService.countPostingByPlateId(plate_id);// 调用t_postingService Service层
			if (coutPosting != 0) {
				msg = "查询当前板块下的帖子数成功";
				code = 1;
			} else {
				msg = "查询当前板块下的帖子数失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, coutPosting, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	/**
	 *
	 * @Title: countTodayPosting
	 * @description 6.2.通过板块id和日期查询当前板块下的今日帖子的数量（首页的"今日"使用）
	 * @param @param postingVo
	 * @return String    
	 * @author dujiawei
	 * @throws ParseException 
	 * @createDate 2019年6月4日
	 */
	@RequestMapping("/countTodayPosting")
	@ResponseBody
	public String countTodayPosting(@RequestBody T_postingVo postingVo) throws ParseException {
		String msg = "系统异常，请稍后再试";
		Integer code = -1;
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nowdayTime = dateFormat.format(d);
		Date nowDate = dateFormat.parse(nowdayTime);
		postingVo.setCreate_time(nowDate);;// 获取当前时间
		try {
			int coutPosting = t_postingService.countTodayPosting(postingVo);// 调用t_postingService Service层
			if (coutPosting != 0) {
				msg = "查询当前板块下的帖子数成功";
				code = 1;
			} else {
				msg = "查询当前板块下的帖子数失败";
				code = -1;
			}

			return JsonUtil.getResponseJson(code, msg, coutPosting, null);

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
	
	
	
	/**
	 * @Title: selectFindId
	 * @description 通过ID查询数据
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author 蔺宏宇
	 * @createDate 2019年3月18日
	 */
	@RequestMapping("/selectFindId")
	@ResponseBody
	public String selectFindId(long id){
			T_plate plate=t_plateService.selectFindId(id);
			if(plate!=null){
				return JsonUtil.getResponseJson(1, "查看成功", null, plate);	
			}else{
				return JsonUtil.getResponseJson(2, "查看失败", null, null);	
			}
		} 
	
}
