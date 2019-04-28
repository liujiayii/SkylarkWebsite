package com.websit.service.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.websit.entity.T_discount_product;
import com.websit.entityvo.Discount;
import com.websit.entityvo.DiscountVo;
import com.websit.mapper.T_discount_productMapper;
import com.websit.service.IT_discount_productService;

/**
 * <p>
 * 商品优惠中间表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
@Service
public class T_discount_productServiceImpl extends ServiceImpl<T_discount_productMapper, T_discount_product> implements IT_discount_productService {
	@Autowired
	private T_discount_productMapper discount_productMapper;
	/**
	 * 根据商品id增加满减优惠
	 * @author pangchong
	 * @createDate 2019年3月27日 下午2:00
	 */
	@Override
	public int saveDiscountById(Discount discount) {
		
		return discount_productMapper.saveDiscountById(discount);
	}
	/**
	 * @description 根据商品id查询商品及每个商品下所有的满减金额(app)
	 * @param productId
	 * @author pangchong
	 * @createDate 2019年3月27日
	 */
	
	@Override
	public DiscountVo listDiscountByProductId(Long productId) {
		
		return discount_productMapper.listDiscountByProductId(productId);
	}
	/**
	 * @description 根据商品id查询商品满减金额
	 * @param productId
	 * @author pangchong
	 * @createDate 2019年3月27日
	 */
	@Override
	public Discount selectDiscountListByProductId(BigInteger productId) {
		
		return discount_productMapper.selectDiscountListByProductId(productId);
	}
	/**
	 * 修改满减优惠
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public int updateDiscount(Discount discount) {
	
		return discount_productMapper.updateDiscount(discount);
	}

}
