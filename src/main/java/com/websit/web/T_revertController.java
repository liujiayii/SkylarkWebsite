package com.websit.web;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.T_revert;
import com.websit.entityvo.T_revertVo;
import com.websit.service.IT_revertService;
import com.websit.until.JsonUtil;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 商品评论回复表（蔺） 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
@RequestMapping("/t_revert")
public class T_revertController {

	@Autowired
	private IT_revertService it_revertService;

	/**
	 * @Title: insertRevert
	 * @description 添加用户对于评论的回复
	 * @param @param
	 *            t_revert
	 * @param @return
	 * @return String
	 * @author linhognyu
	 * @createDate 2019年3月21日
	 */
	@RequestMapping(value = "/insertRevert", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertRevert(T_revert t_revert) {
		Date sdf = new Date();
		try {
			t_revert.setRevert_time(sdf);
			boolean insert = it_revertService.insert(t_revert);
			if (insert == true) {
				return JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				return JsonUtil.getResponseJson(2, "添加失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: deleteRevert
	 * @description 删除一条短评
	 * @param @param id
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年3月21日
	 */
	@RequestMapping("/deleteRevert")
	@ResponseBody
	public String deleteRevert(Long id) {
		try {
			boolean del = it_revertService.deleteById(id);
			if (del) {
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
	 * @Title: seleceFirstRevert
	 * @description 通过评论表id查询回复评论
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/seleceFirstRevert", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String seleceFirstRevert(long id,Integer page,Integer limit) {
		try {
			List<T_revertVo> revert = it_revertService.seleceFirstRevert(id,page,limit);
			int count = it_revertService.selectCount(new EntityWrapper<T_revert>().eq("review_id", id));
			if (revert!=null) {
				return JsonUtil.getResponseJson(1, "查询成功", count, revert);
			} else {
				return JsonUtil.getResponseJson(2, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
}
