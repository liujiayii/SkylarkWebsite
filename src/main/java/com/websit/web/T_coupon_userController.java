package com.websit.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.T_coupon;
import com.websit.entity.T_coupon_user;
import com.websit.entity.T_product;
import com.websit.entityvo.CouponUserFind;
import com.websit.service.IT_couponService;
import com.websit.service.IT_coupon_userService;
import com.websit.service.IT_productService;
import com.websit.until.JsonUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户优惠券关联表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-19
 */
@Controller
@RequestMapping("/t_coupon_user")
public class T_coupon_userController {

	@Autowired
	private IT_coupon_userService coupon_userService;

	@Autowired
	private IT_couponService couponService;

	@Autowired
	private IT_productService productService;

	/**
	 * 
	 *
	 * @Title: insert
	 * 
	 * @description 领取优惠券
	 *
	 * @param @param
	 *            coupon_user
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月20日
	 */
	@RequestMapping("insert")
	@ResponseBody
	public synchronized String insert(T_coupon_user coupon_user) {

		try {

			// 获取要绑定的优惠券的id
			Long coupon_id = coupon_user.getCoupon_id();
			// 根据优惠券id查询到优惠券
			T_coupon coupon = couponService.selectById(coupon_id);

			// 放券开始时间
			Date start_time = coupon.getStart_time();
			// 放券结束时间
			Date end_time = coupon.getEnd_time();
			// 当前时间
			Date date = new Date();

			// 如果在此优惠券发放时间段内
			if (start_time.getTime() <= date.getTime() && date.getTime() <= end_time.getTime()) {
				
				//判断该用户拥有此优惠券数量是否已达个人上限
				int selectCount = couponService.selectCount(new EntityWrapper<T_coupon>().eq("coupon_id", coupon_id).eq("user_id", coupon_user.getUser_id()));

				if(selectCount >= coupon.getGet_number()){
					
					return JsonUtil.getResponseJson(1, "每人限领"+coupon.getGet_number()+"张", null, null);
				}
				
				// 判断该优惠券领取数量是否已达上限

				if (coupon.getTake_count() >= coupon.getQuota()) {
					// 以达到上限 将此优惠券状态修改为 4 已发完 返回信息

					couponService.updateStatusById(coupon.getId(), 4);
					return JsonUtil.getResponseJson(1, "已经被抢光了", null, null);
				}

				// 获取该优惠券的过期形式
				// valid_type 过期形式 1 绝对日期 2相对日期
				Integer valid_type = coupon.getValid_type();
				// 未达到上限量发放优惠券

				coupon_user.setCreat_time(date);
				Date star_time = coupon.getStart_time();
				if (null == coupon.getValid_start_time()) {
					star_time = date;
				}
				coupon_user.setStar_time(star_time);

				// 填入过期时间
				if (valid_type == 1) {
					// 绝对日期直接设置
					coupon_user.setExpiration_time(coupon.getValid_end_time());
				}
				if (valid_type == 2) {
					// 相对日期

					// 获取过期天数
					Integer valid_days = coupon.getValid_days();
					// 计算出过期时间
					Date expiration_time = new Date(date.getTime() + (valid_days * 1000l * 60 * 60 * 60 * 24));
					// 设置上
					coupon_user.setExpiration_time(expiration_time);

				}

				coupon_user.setState(1);
				// 保存
				coupon_userService.insert(coupon_user);

				return JsonUtil.getResponseJson(1, "领取成功", null, null);

			} else {
				// 不在发放时间段内

				// 判断是否是还未到达开始领取的时间段
				if (date.getTime() < start_time.getTime()) {
					return JsonUtil.getResponseJson(1, "尚未开始", null, null);
				}
				// 如果当前时间超过了领取时间 将优惠券状态设置为三 已结束
				if (date.getTime() > end_time.getTime()) {
					couponService.updateStatusById(coupon_id, 3);
					return JsonUtil.getResponseJson(1, "你来晚了发放已结束", null, null);
				}

			}
		} catch (Exception e) {
			// 异常 打印
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

		// 应该不会走到这里
		return JsonUtil.getResponseJson(-1, "理论上程序不应该走到这里", null, null);

	}

	/**
	 * 
	 *
	 * @Title: availableOffers
	 * 
	 * @description 根据用户id和他要购买的商品id查询该用户有没有可用的优惠券
	 *
	 * @param @param
	 *            userid
	 * @param @param
	 *            productid
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月20日
	 */
	@RequestMapping("availableOffers")
	@ResponseBody
	public String availableOffers(Long userid, Long productid) {

		try {

			/* coupon_userService */

			// 创建集合保存可用优惠券
			List<CouponUserFind> listCouponUserFind = new ArrayList<>();

			// 获取所有该用户没有过期没有用过的当前时间可以使用的优惠券
			// 获取当前时间
			Date nowDate = new Date();
			//
			List<T_coupon_user> listCoupon_user = coupon_userService.selectList(new EntityWrapper<T_coupon_user>()
					.eq("state", 1).le("expiration_time", nowDate).ge("star_time", nowDate));

			// 遍历所有当前未过期优惠券
			for (T_coupon_user coupon_user : listCoupon_user) {

				// 获取优惠券id根据优惠券id找到相应优惠券然后找到优惠券适用范围根据范围不同做不同操作
				T_coupon coupon = couponService.selectById(coupon_user.getCoupon_id());

				// '适用范围 （10 商品优惠券，20 类目优惠券，30全平台）
				Integer used = coupon.getUsed();
				// 如果是全平台的
				if (30 == used) {
					// 设置返回类
					CouponUserFind couponUserFind = new CouponUserFind();
					couponUserFind.setCoupon_user_id(coupon_user.getId());
					couponUserFind.setExpiration_time(coupon_user.getExpiration_time());
					couponUserFind.setIcon(coupon.getIcon());
					couponUserFind.setTitle(coupon.getTitle());
					// 将信息加入集合
					listCouponUserFind.add(couponUserFind);
				}

				// 如果是类目优惠
				if (20 == used) {
					// 对比商品是否是属于那一类

					// 根据商品id查询商品信息 product_type_id
					T_product product = productService.selectById(productid);
					// 商品所属的类目
					Long product_type_id = product.getProduct_type_id();
					// 优惠券针对的类目
					Long with_sn = coupon.getWith_sn();
					// 如果商品属于优惠的类目
					if (product_type_id == with_sn) {
						// 设置返回类
						CouponUserFind couponUserFind = new CouponUserFind();
						couponUserFind.setCoupon_user_id(coupon_user.getId());
						couponUserFind.setExpiration_time(coupon_user.getExpiration_time());
						couponUserFind.setIcon(coupon.getIcon());
						couponUserFind.setTitle(coupon.getTitle());
						// 将信息加入集合
						listCouponUserFind.add(couponUserFind);
					}

				}

				if (10 == used) {

					// 如果商品是该优惠券指定的商品
					if (productid == coupon.getWith_sn()) {
						// 设置返回类
						CouponUserFind couponUserFind = new CouponUserFind();
						couponUserFind.setCoupon_user_id(coupon_user.getId());
						couponUserFind.setExpiration_time(coupon_user.getExpiration_time());
						couponUserFind.setIcon(coupon.getIcon());
						couponUserFind.setTitle(coupon.getTitle());
						// 将信息加入集合
						listCouponUserFind.add(couponUserFind);
					}

				}
			}
			// 如果为空则无优惠券可用
			if (listCouponUserFind.size() == 0) {
				return JsonUtil.getResponseJson(1, "暂无优惠券可用", null, null);
			}

			return JsonUtil.getResponseJson(1, "", listCouponUserFind.size(), listCouponUserFind);

		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	/**
	 * 
	*
	 * @Title: availableCoupon
	
	 * @description 查询用户目前所有可使用的优惠券
	*
	 * @param @param userid
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年4月20日
	 */
	@RequestMapping("availableCoupon")
	@ResponseBody
	public String availableCoupon(Long userid) {
		
		Date nowDate = new Date();
		//
		List<T_coupon_user> listCoupon_user = coupon_userService.selectList(new EntityWrapper<T_coupon_user>()
				.eq("state", 1).le("expiration_time", nowDate).ge("star_time", nowDate));
		
		if(listCoupon_user.size() <= 0){
			return JsonUtil.getResponseJson(1, "暂无优惠券", null, null);
		}
		
		return JsonUtil.getResponseJson(1, "", listCoupon_user.size(), listCoupon_user);
		
	}
	
	
	

}
