package com.websit.service;

import com.websit.entity.T_product_specification;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品详情表(pc) 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-20
 */
public interface IT_product_specificationService extends IService<T_product_specification> {

	
	public T_product_specification selectAllspecification(T_product_specification t);
	public T_product_specification specification(String product_id,String specifications);
	
	/**
	 * description   根据id删除商品规格
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int deleteProductSpecificationById(@Param("id") BigInteger id);
	/**
	 * 修改商品规格
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int updateProductSpecification(T_product_specification product_specification);
}
