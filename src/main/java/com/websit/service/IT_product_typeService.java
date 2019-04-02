package com.websit.service;

import com.websit.entity.Classification;
import com.websit.entity.T_product;
import com.websit.entity.T_product_type;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品类型表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface IT_product_typeService extends IService<T_product_type> {

	/**
	 * 查询所有商品类型---分页
	 *
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public List<T_product_type> selectAllProductTypeList(@Param("page") Integer page, @Param("limit") Integer limit);
	
	
	/**
	 * 查询商品类型---不分页
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	List<T_product_type> selectproductTypeNoPage();
	/**
	 * 增加商品类型
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int saveProductType(T_product_type productType);
	/**
	 * 修改商品类型
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int updateProductType(T_product_type productType);
	/**
	 * description   根据id删除商品类型
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int deleteProductTypeById(@Param("id") BigInteger id);

	
	public List<T_product_type> selectproduct(Classification productType);

	/**
	 * 查询商品分类条数
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public Integer findProductTypeCount(T_product_type product_type);
	
	public List<T_product> selectbyDESC(@Param("page")Integer page, @Param("limit")Integer limit);


}
