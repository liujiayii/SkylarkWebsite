package com.websit.web;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.websit.entity.T_plate;
import com.websit.entityvo.T_postingVo;
import com.websit.service.IT_postingService;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.T_posting;
import com.websit.service.IT_opinionService;
import com.websit.service.IT_postingService;

import javax.annotation.Resource;

import com.websit.until.JsonUtil;

/**
 * <p>
 * 发帖表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @param <T_postingController>
 * @since 2019-03-13
 */
@RestController
public class T_postingController {

	
	@Autowired
	private IT_postingService t_postingService;
	
	/**
	 * @Title: selecAllSome
	 * @description 查询版主下的话题列表
	 * @return map
	 * @author linhongyu
	 * @createDate 2019年03月14日
	 */
	@RequestMapping(value = "/selecAllSome", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object selecAllSome(T_postingVo postingVo) {
		T_plate plate = new T_plate();
		long id=plate.getId();
		postingVo.setPlate_id(id);
		try{
			List<T_postingVo> post=t_postingService.selecAllSome(postingVo);
			if (post.size() >=1) {
				return JsonUtil.getResponseJson(1, "查看成功", null, null);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 显示热门帖子
	 *
	 * @Title: showHotPostings
	
	 * @description 
	 *
	 * @param row 查询热门帖子条数
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月14日-下午5:28:09
	 */
	@RequestMapping("/showHotPostings")
	public String showHotPostings(Integer row) {
		
		return t_postingService.showHotPostings(row);
	}
	
	/**
	 * 显示最新发表帖子
	 *
	 * @Title: showNewestPostings
	
	 * @description 
	 *
	 * @param row 显示最新帖子数量
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月14日-下午5:42:05
	 */
	public String showNewestPostings(Integer row) {
		
		return t_postingService.showNewestPotings(row);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
