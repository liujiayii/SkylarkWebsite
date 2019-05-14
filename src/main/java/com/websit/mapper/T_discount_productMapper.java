package com.websit.mapper;

import com.websit.entity.T_discount_product;
import com.websit.entityvo.Discount;
import com.websit.entityvo.DiscountVo;
import com.websit.entityvo.ProductVo;
import com.websit.entityvo.ProductVos;

import java.math.BigInteger;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商品优惠中间表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public interface T_discount_productMapper extends BaseMapper<T_discount_product> {
	/**
	 * 根据商品id增加满减优惠
	 * @author pangchong
	 * @createDate 2019年3月27日 下午2:00
	 */
	public int saveDiscountById(T_discount_product discount);
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
	
	/**
	 * 修改满减优惠(商品表)
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public int updateDiscount_product(T_discount_product discount_product);
}
