package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.websit.entity.T_picture_video;
import com.websit.service.IT_picture_videoService;
import com.websit.until.JsonUtil;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 图片视频表（蔺） 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/t_picture_video")
public class T_picture_videoController {

	@Autowired
	private IT_picture_videoService it_Service;
	/**
	 * @Title: selectpicture
	 * @description 查询评论图片
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年3月28日
	 */
	@RequestMapping("/selectpicture")
	@ResponseBody
	public String selectpicture(long id){
		HashMap<String, Object> map = new HashMap<>();
		map.put("review_id", id);
		try {
			List<T_picture_video> selectByMap = it_Service.selectByMap(map);
			if (selectByMap.size()>0) {
				return JsonUtil.getResponseJson(1, "查询成功", null, selectByMap);
			} else {
				return JsonUtil.getResponseJson(2, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
}
