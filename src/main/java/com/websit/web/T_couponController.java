package com.websit.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.T_coupon;
import com.websit.service.IT_couponService;
import com.websit.until.JsonUtil;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 优惠券实体表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-19
 */
@Controller
@RequestMapping("/t_coupon")
@Component
public class T_couponController {

	@Autowired
	private IT_couponService couponService;

	/**
	 * 
	 *
	 * @Title: insert
	 * 
	 * @description 添加新种类优惠券 == 生成优惠券
	 *
	 * @param @param
	 *            coupon
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月19日
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(T_coupon coupon) {
		/*
		 * `start_time` datetime DEFAULT NULL COMMENT '发放开始时间', `end_time`
		 * datetime DEFAULT NULL COMMENT '发放结束时间',
		 */
		try {

			// 保存时判断 现在的时间在 领券开始时间和结束时间之间 设置状态为 1 生效
			if (coupon.getStart_time().getTime() <= new Date().getTime()
					&& new Date().getTime() <= coupon.getEnd_time().getTime()) {
				coupon.setStatus(1);
			}

			// 保存时判断 现在的时间小于 领券开始时间 设置状态为 2 未生效
			if (coupon.getStart_time().getTime() <= new Date().getTime()) {
				coupon.setStatus(2);
			}

			// 保存时判断 现在的时间大于 领券结束时间 设置状态为3 已过期
			if (coupon.getEnd_time().getTime() >= new Date().getTime()) {
				coupon.setStatus(3);
			}

			boolean insert = couponService.insert(coupon);
			Long id = coupon.getId();
			System.out.println(id);
			if (insert) {
				return JsonUtil.getResponseJson(1, "添加成功", null, null);
			}
			return JsonUtil.getResponseJson(1, "失败成功", null, null);

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "", null, null);
		}
	}

	/**
	 * 
	 *
	 * @Title: selectCanShow
	 * 
	 * @description 查询所有未过期的优惠券
	 *
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月20日
	 */
	@RequestMapping(value = "selectCanShow", method = RequestMethod.POST)
	@ResponseBody
	public String selectCanShow() {
		List<T_coupon> selectList = couponService.selectList(new EntityWrapper<T_coupon>().notIn("status", 3));
		if (selectList.size() <= 0) {
			return JsonUtil.getResponseJson(1, "暂无优惠券可以领取", null, null);
		}
		return JsonUtil.getResponseJson(1, "", selectList.size(), selectList);
	}

	/**
	 * 
	 *
	 * @Title: selectById
	 * 
	 * @description 通过id查询
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月20日
	 */
	@RequestMapping(value = "selectById", method = RequestMethod.POST)
	@ResponseBody
	public String selectById(Long id) {
		T_coupon coupon = couponService.selectById(id);

		return JsonUtil.getResponseJson(1, "", null, coupon);
	}

	/**
	 * 
	 *
	 * @Title: updateById
	 * 
	 * @description 修改优惠券
	 *
	 * @param @param
	 *            coupon
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月20日
	 */
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	@ResponseBody
	public String updateById(T_coupon coupon) {

		coupon.setUpdate_time(new Date());
		boolean result = couponService.updateById(coupon);

		if(result){
			return JsonUtil.getResponseJson(1, "修改成功", null, coupon);
		}
		return JsonUtil.getResponseJson(1, "修改失败", null, coupon);
	}

	/**
	 * 
	 *
	 * @Title: a
	 * 
	 * @description
	 *
	 * @param 在每小时的30分钟和正时来更新优惠券状态
	 * 
	 * @return void
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月19日
	 */
	@Scheduled(cron = "3 0,30 * * * ? ")
	public void a() {
		// 查出目前所有可以领取的优惠券
		List<T_coupon> selectList = couponService.selectList(new EntityWrapper<T_coupon>().eq("status", 1));

		// 遍历 将时间过期的标记为 3
		for (T_coupon t_coupon : selectList) {
			if (new Date().getTime() >= t_coupon.getEnd_time().getTime()) {

				couponService.updateStatusById(t_coupon.getId(), 3);
			}
		}
		// 将时间在领券时间和结束时间内的优惠券设置状态为 1
		List<T_coupon> SelectList = couponService.selectList(new EntityWrapper<T_coupon>().eq("status", 2));
		for (T_coupon T_coupon : SelectList) {
			if (T_coupon.getStart_time().getTime() <= new Date().getTime()
					&& new Date().getTime() <= T_coupon.getEnd_time().getTime()) {
				// 将状态设置为可用
				couponService.updateStatusById(T_coupon.getId(), 1);
			}

		}

	}

}
