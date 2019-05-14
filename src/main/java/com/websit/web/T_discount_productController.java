package com.websit.web;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entityvo.Discount;
import com.websit.entityvo.DiscountVo;
import com.websit.service.IT_discount_productService;
import com.websit.until.JsonUtil;

/**
 * <p>
 * 商品优惠中间表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
@Controller

public class T_discount_productController {
@Autowired
private IT_discount_productService discount_productService;
	/**
	 * 查询商品一级分类---不分页(app)
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/listDiscountByProductId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listDiscountByProductId(Long productId) {
		try{
		DiscountVo result = discount_productService.listDiscountByProductId(productId);

		if (result != null) {
			return JsonUtil.getResponseJson(1, "查看成功", null, result);
		} else {
			return JsonUtil.getResponseJson(1, "无数据", null, null);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	}
	}
	/**
	 * 根据商品id查询商品满减金额
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/selectDiscountListByProductId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectDiscountListByProductId(BigInteger productId) {
		try{
		Discount result = discount_productService.selectDiscountListByProductId(productId);

		if (result != null) {
			return JsonUtil.getResponseJson(1, "查看成功", null, result);
		} else {
			return JsonUtil.getResponseJson(1, "无数据", null, null);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	}
	}
	
	/**
	 * 修改满减优惠
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	/*@RequestMapping(value = "/updateDiscount", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateDiscount(Long id,BigDecimal price,BigDecimal money) {
		Discount discount = new Discount();
		discount.setDiscountid(id);
		discount.setPrice(price);
		discount.setMoney(money);
		try{
		int result = discount_productService.updateDiscount(discount);

		if (result>0) {
			return JsonUtil.getResponseJson(1, "查看成功", null, result);
		} else {
			return JsonUtil.getResponseJson(1, "无数据", null, null);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	}
	}*/
}
