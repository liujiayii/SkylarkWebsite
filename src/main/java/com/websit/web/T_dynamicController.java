package com.websit.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.websit.entity.T_dynamic;
import com.websit.entityvo.T_dynamicVo;
import com.websit.service.IT_dynamicService;
import com.websit.until.JsonUtil;
import com.websit.until.UpdateFile;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 公司动态表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-02
 */
@Controller
@RequestMapping("/t_dynamic")
public class T_dynamicController {

	@Autowired
	private IT_dynamicService it_dynamicService;

	/**
	 * @Title: SelectAllDy
	 * @description 查询所有动态情况
	 * @param @param
	 *            t_dynamic
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月2日
	 */
	@RequestMapping(value = "/SelectAllDy", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String SelectAllDy(T_dynamicVo t_dynamic, Integer page, Integer limit) {
		try {
			t_dynamic.setPage((page-1)*limit);
			t_dynamic.setLimit(limit);
			//t_dynamic.setPage(0);
			//t_dynamic.setLimit(5);
			List<T_dynamicVo> selectMaps = it_dynamicService.SelectAllDy(t_dynamic);
			int count = it_dynamicService.selectCount(null);
			if (selectMaps.size() > 0) {
				return JsonUtil.getResponseJson(1, "查询成功", count, selectMaps);
			} else {
				return JsonUtil.getResponseJson(1, "查询成功", count, selectMaps);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: SelectOneThin
	 * @description 根据id查询详情
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author 姓名全拼
	 * @createDate 2019年4月4日
	 */
	@RequestMapping(value = "/SelectOneThin", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String SelectOneThin(long id) {
		try {
			System.out.println(id + "id");
			T_dynamic selectById = it_dynamicService.selectById(id);
			if (selectById != null) {
				return JsonUtil.getResponseJson(1, "查询成功", null, selectById);
			} else {
				return JsonUtil.getResponseJson(-1, null, null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: insertDynamic
	 * @description 新增一条动态
	 * @param @param
	 *            t_dynamic
	 * @param @param
	 *            req
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月2日
	 */
	@RequestMapping(value = "/insertDynamic", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertDynamic(T_dynamic t_dynamic, HttpServletRequest req) throws Exception {
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
			List<MultipartFile> files = multipartRequest.getFiles("pic");
			MultipartFile file = files.get(0);
			Map<String, String> map = UpdateFile.update(file);
			String urls = map.get("Path");
			t_dynamic.setDynamic_image(urls);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time=df.format(new Date());
			t_dynamic.setDynamic_time(new Timestamp(df.parse(time).getTime()));
			@SuppressWarnings("unused")
			boolean num = it_dynamicService.insert(t_dynamic);
			if (num = true) {
				return JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				return JsonUtil.getResponseJson(-1, "添加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: deleteFirst
	 * @description 删除一条动态
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月2日
	 */
	@RequestMapping(value = "/deleteFirst", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteFirst(long id) {
		try {
			T_dynamic t_dynamic = it_dynamicService.selectById(id);
			String a = t_dynamic.getDynamic_image();
			UpdateFile.deleatFile(a);
			@SuppressWarnings("unused")
			boolean deleteById = it_dynamicService.deleteById(id);
			if (deleteById = true) {
				return JsonUtil.getResponseJson(1, "删除成功", null, null);
			} else {
				return JsonUtil.getResponseJson(-1, "删除失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
}
