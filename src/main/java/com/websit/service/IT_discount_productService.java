package com.websit.service;

import com.websit.entity.T_discount_product;
import com.websit.entityvo.Discount;
import com.websit.entityvo.DiscountVo;

import java.math.BigInteger;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品优惠中间表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public interface IT_discount_productService extends IService<T_discount_product> {
	/**
	 * 根据商品id增加满减优惠
	 * @author pangchong
	 * @createDate 2019年3月27日 下午2:00
	 */
	public int saveDiscountById(Discount discount);
	/**
	 * @description 根据商品id查询商品及每个商品下所有的满减金额(app)
	 * @param productId
	 * @author pangchong
	 * @createDate 2019年3月27日
	 */
	public DiscountVo listDiscountByProductId(Long productId);
	/**
	 * @description 根据商品id查询商品满减金额
	 * @param productId
	 * @author pangchong
	 * @createDate 2019年3月27日
	 */
	public Discount selectDiscountListByProductId(BigInteger productId);
	/**
	 * 修改满减优惠
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public int updateDiscount(Discount discount);
	
}
