package com.websit.mapper;

import com.websit.entity.T_product_specification;
import com.websit.entity.T_product_type;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商品详情表(pc) Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-20
 */
public interface T_product_specificationMapper extends BaseMapper<T_product_specification> {

	
	public T_product_specification selectAllspecification(T_product_specification t);
	/**
	 * 查询商品的价格信息的方法
	 */
	public List<T_product_specification> selectlstspecification(String product_id);
	
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
