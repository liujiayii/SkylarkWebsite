package com.websit.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.websit.entity.T_plate;
import com.websit.entity.T_reply;
import com.websit.service.IT_plateService;
import com.websit.until.JsonUtil;

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
	
	@RequestMapping("/addT_plate")
	@ResponseBody
	public String T_postingController(@RequestBody T_plate T_plate) {
		System.out.println("请求成功"+T_plate.toString());
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
