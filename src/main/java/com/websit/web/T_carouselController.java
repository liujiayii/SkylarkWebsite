package com.websit.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.websit.entity.T_carousel;
import com.websit.pay.Json;
import com.websit.service.IT_carouselService;
import com.websit.until.JsonUtil;
import com.websit.until.UpdateFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 轮播图管理表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-30
 */
@Controller
@RequestMapping("/t_carousel")
public class T_carouselController {
	@Autowired
	IT_carouselService carouselService;
	/**
	 * 
	*
	 * @Title: insert
	
	 * @description 增加图片
	*
	 * @param @param carousel
	 * @param @param file
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月30日
	 */
	@RequestMapping("insert")
	@ResponseBody
	public String insert(T_carousel carousel, MultipartFile file) {

		try {
			Map<String, String> update = UpdateFile.update(file);
			String path = update.get("Path");
			carousel.setCreat_time(new Date());
			carousel.setPath(path);
			carousel.setBelong_to(1);
			carouselService.insert(carousel);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "上传失败", null, null);
		}

		return JsonUtil.getResponseJson(1, "上传成功", null, null);

	}
    /**
     * 
    *
     * @Title: deleatById
    
     * @description 删除图片
    *
     * @param @param id
     * @param @return 
       
     * @return String    
    
     *
     * @author lishaozhang
     * @createDate 2019年3月30日
     */
	@RequestMapping("deleatById")
	@ResponseBody
	public String deleatById(Long id,String path) {

		try {
  
			UpdateFile.deleatFile(path);
			boolean result = carouselService.deleteById(id);

			if (result) {
				return JsonUtil.getResponseJson(1, "删除成功", null, null);
			}

			return JsonUtil.getResponseJson(1, "图片不存在", null, null);

		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "程序错误", null, null);
		}
	}
	
	/**
	 * 
	*
	 * @Title: selectAll
	
	 * @description 查询
	*
	 * @param @param Belongto
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月30日
	 */
	@RequestMapping("selectAll")
	@ResponseBody
	public String selectAll(@RequestParam(defaultValue ="1") Integer Belongto) {

		try {
       
			Map<String,Object> map = new HashMap<>();
			map.put("belong_to", Belongto);
			List<T_carousel> selectByMap = carouselService.selectByMap(map);
			
			return JsonUtil.getResponseJson(1, "查询成功", selectByMap.size(), selectByMap);
			
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "程序错误", null, null);
		}
	}

}
