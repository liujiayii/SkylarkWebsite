package com.websit.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vdurmont.emoji.EmojiParser;
import com.websit.entity.T_order;
import com.websit.entity.T_picture_video;
import com.websit.entity.T_revert;
import com.websit.entity.T_review;
import com.websit.entity.T_shopping;
import com.websit.entityvo.T_orderVo;
import com.websit.entityvo.T_reviewVo;
import com.websit.mapper.T_reviewMapper;
import com.websit.service.IT_orderService;
import com.websit.service.IT_picture_videoService;
import com.websit.service.IT_revertService;
import com.websit.service.IT_reviewService;
import com.websit.service.IT_shoppingService;
import com.websit.until.JsonUtil;
import com.websit.until.Security;
import com.websit.until.UpdateFile;

/**
 * <p>
 * 商品评论表(蔺) 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
@Controller
@RequestMapping("/t_review")
public class T_reviewController {
	@Autowired
	private T_reviewMapper t_reviewMapper;
	@Autowired
	private IT_reviewService it_reviewService;
	@Autowired
	private IT_orderService it_orderService;
	@Autowired
	private IT_revertService it_revertService;
	@Autowired
	private IT_picture_videoService it_picture_videoService;
	@Autowired
	public IT_shoppingService T_shoppingService;
	/**
	 * @Title: insertReview
	 * @description 添加添加评论
	 * @param @param
	 *            t_review
	 * @param @return
	 * @return int
	 * @author linhognyu
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/insertReview", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertReview(T_review t_review, String order_id, HttpServletRequest req, String order_no,
			Integer is_des) {
		try {
			if (is_des != null) {
				t_review.setUser_id((Security.decode(t_review.getUser_id())));
			}
			String product_id = "";
			T_order t_order = new T_order();
			T_picture_video t_picture_video = new T_picture_video();
			Date sdf = new Date();
			t_review.setReview_time(sdf);
			t_review.getReview_content();
			String str = t_review.getReview_content();
			String result = EmojiParser.parseToAliases(str);
			t_review.setReview_content(result);
			int insertReview = it_reviewService.insertReview(t_review);
			if (insertReview != 0) {
				long id = t_review.getId();
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
				List<MultipartFile> files = multipartRequest.getFiles("pic");
				//System.out.println(multipartRequest.getFiles("pic"));
				for (MultipartFile multipartFile : files) {
					Map<String, String> map = UpdateFile.update(multipartFile);
					String urls = map.get("Path");
					t_picture_video.setReview_id(id);
					t_picture_video.setPicture(urls);
					it_picture_videoService.insert(t_picture_video);
				}
				// 修改商品是否评价状态
				//product_id = t_review.getProduct_id().toString();
				T_shopping T_shopping=T_shoppingService.selectById(t_review.getShopping_id());
				T_shopping.setIs_dianpng("2");
				T_shoppingService.updateById(T_shopping);
				System.out.println("order_id" + order_id + "product_id" + product_id);
				//it_orderService.updateState(order_id, product_id);
				Map<String, Object> Map = new HashMap<String, Object>();
				Map.put("order_id", order_id);
				Map.put("is_dianpng", "1");
				List<T_shopping> T_orderVo=T_shoppingService.selectByMap(Map);
				
				//List<T_orderVo> seleceOne = it_reviewService.seleceOne(order_id);
				
				if (T_orderVo == null || T_orderVo.size() == 0) {
					it_reviewService.updateState(order_no);
				}
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
	 * @Title: delReviewOne
	 * @description 删除一条评论
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author linhongyui
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/delReviewOne", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delReviewOne(Long id) {
		try {
			boolean num = it_reviewService.deleteById(id);
			// 查询需要删除的图片路径
			List<T_picture_video> picture_video = it_picture_videoService
					.selectList(new EntityWrapper<T_picture_video>().eq("review_id", id));
			// 循环删除阿里图片
			for (int i = 0; i < picture_video.size(); i++) {
				String a = picture_video.get(i).getPicture();
				UpdateFile.deleatFile(a);
			}
			// 删除数据库图片
			boolean delete = it_picture_videoService.delete(new EntityWrapper<T_picture_video>().eq("review_id", id));
			boolean nums = it_revertService.delete(new EntityWrapper<T_revert>().eq("review_id", id));
			if (num == true && nums == true && delete == true) {
				return JsonUtil.getResponseJson(1, "已删除", null, null);
			} else {
				return JsonUtil.getResponseJson(2, "删除失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: updateOnethin
	 * @description 商家回复
	 * @param @param
	 *            t_review
	 * @param @return
	 * @return int
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/updateOnethin", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateOnethin(T_review t_review) {
		try {
			int is = it_reviewService.updateOnethin(t_review);
			if (is != 0) {
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
	 * @Title: selectappraise
	 * @description 过商品id查询评论分数平均分
	 * @param @param
	 *            t_review
	 * @param @return
	 * @return int
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/selectappraise", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectappraise(long id) {
		try {
			int avg = it_reviewService.selectappraise(id);
			if (avg >= 0) {
				return JsonUtil.getResponseJson(1, "查询成功", null, avg);
			} else {
				return JsonUtil.getResponseJson(2, "暂时无评价", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: seleceUserThin
	 * @description 通过用户id查询历史评价
	 * @param @param
	 *            id
	 * @param @return
	 * @return T_reviewVo
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/seleceUserThin", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String seleceUserThin(T_reviewVo reviewVo, Integer page, Integer limit, Integer is_des) {
		try {
			//System.out.println(reviewVo.getUser_id());
			if (is_des != null) {
				reviewVo.setUser_id((Security.decode(reviewVo.getUser_id())));
			}
			//System.out.println(page);
			// 如果没有分页的情况直接显示前十条数据
			if (page == null) {
				page = 1;
				limit = 10;
			}
			reviewVo.setPage((page - 1) * limit);
			reviewVo.setLimit(limit);
			// reviewVo.setPage(page);
			// reviewVo.setLimit(limit);
			List<T_reviewVo> post = it_reviewService.seleceUserThin(reviewVo);
			for(int i=0;i<post.size();i++) {
				String str=post.get(i).getReview_content();
				String result = EmojiParser.parseToUnicode(str);
				post.get(i).setReview_content(result);
			}

			if (post != null && !post.isEmpty()) {

				return JsonUtil.getResponseJson(1, "查询成功", post.size(), post);
			} else {
				return JsonUtil.getResponseJson(2, "暂时无评价", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: selectAllSome
	 * @description 通过商品表id查询所有商品评论
	 * @param @param
	 *            id
	 * @param @return
	 * @return List<T_reviewVo>
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/selectAllSome", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllSome(T_reviewVo reviewVo, Integer page, Integer limit) {
		//System.out.println("page" + page + "limit" + limit);
		try {
			System.out.println(page);
			if(page.equals("")||page==null||page==0) {
				return JsonUtil.getResponseJson(-1, "分页page不能为0", null, null);
			}
		
			reviewVo.setPage((page - 1) * limit);
			reviewVo.setLimit(limit);
			// reviewVo.setPage(0);
			// reviewVo.setLimit(10);
			List<T_reviewVo> some = it_reviewService.selectAllSome(reviewVo);
			for(int i=0;i<some.size();i++) {
				String str=some.get(i).getReview_content();
				String result = EmojiParser.parseToUnicode(str);
				some.get(i).setReview_content(result);
			}

			
			long id = reviewVo.getProduct_id();
			int count = t_reviewMapper.selectCounts(id);
			if (some.size() > 0) {
				return JsonUtil.getResponseJson(1, "查询成功", count, some);
			} else {
				return JsonUtil.getResponseJson(1, "暂时无评价", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();

			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: seleceFirstThin
	 * @description 通过评论表id查询评论详情
	 * @param @param
	 *            t_reviewVo
	 * @param @return
	 * @return T_reviewVo
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@RequestMapping(value = "/seleceFirstThin", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String seleceFirstThin(long id) {
		try {
			T_reviewVo some = it_reviewService.seleceFirstThin(id);
			String str=some.getReview_content();
			String result = EmojiParser.parseToUnicode(str);
			some.setReview_content(result);
			
			return JsonUtil.getResponseJson(1, "查询成功", null, some);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * @Title: selecePicture
	 * @description 通过评论id查询评论图片
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author 姓名全拼
	 * @createDate 2019年3月26日
	 */
	@RequestMapping(value = "/selecePicture", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selecePicture(long id) {
		try {
			List<T_picture_video> selectList = it_picture_videoService
					.selectList(new EntityWrapper<T_picture_video>().eq("review_id", id));
			if (selectList.size() > 0) {
				return JsonUtil.getResponseJson(1, "查询成功", null, selectList);
			} else {
				return JsonUtil.getResponseJson(2, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/***
	 * @Title: selectAllEvery
	 * @description PC端查询所有评论
	 * @param @param
	 *            reviewVo
	 * @param @return
	 * @return List<T_reviewVo>
	 * @author 姓名全拼
	 * @createDate 2019年3月26日
	 */
	@RequestMapping(value = "/selectAllEvery", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllEvery(String name, Integer page, Integer limit) {

		T_reviewVo reviewVo = new T_reviewVo();

		try {
			reviewVo.setName(name);
			reviewVo.setPage((page - 1) * limit);
			reviewVo.setLimit(limit);
		
			List<T_reviewVo> review = it_reviewService.selectAllEvery(reviewVo);
			if (review.size() > 0) {
				int count = it_reviewService.selectAllEveryCount(reviewVo);
				return JsonUtil.getResponseJson(1, "查询成功", count, review);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", 0, review);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

}
