package com.websit.service;

import com.websit.entity.T_product;
import com.websit.entity.T_product_type;
import com.websit.entity.Zone;
import com.websit.entityvo.ProductDetails;
import com.websit.entityvo.ProductTypeVo;
import com.websit.entityvo.ProductVo;
import com.websit.entityvo.t_productVo;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface IT_productService extends IService<T_product> {
	
	/**
	 * @description 根据类型id查询当前商品种类及每个种类下所有商品
	 * @param shopId
	 * @return 商品种类及每个商品种类下所有商品
	 * @author pagchong
	 * @createDate 2019年3月21日
	 */
	public String listProductByTypeId(Long productTypeId,Integer page,Integer limit);

	/**
	 * @description 查询商品
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	public List<ProductVo> listAllProductById(ProductVo productVo);

	/**
	 * 增加商品
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public int saveProduct(ProductVo productVo);
	/**
	 * 修改商品
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public int updateProduct(ProductVo productVo);
	/**
	 * 查询商品数量app
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public Integer findBpiList(Long productTypeId);
	/**
	 * 修改状态(上架/下架)
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public int updateProductState(ProductVo productVo);
	/**
	 * @description 根据商品id查询商品详情
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	public List<ProductDetails> listProductByProductId(BigInteger productId);
	/**
	 * @description 首页模糊查询
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月24日
	 */
	public List<ProductVo> listProductByProductTypeId(String productName);
	/**
	 * @description 根据商品名称查询颜色
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月26日
	 */
	public List<ProductVo> listProductByColor(String productName);
	/**
	 * @description 根据商品名称查询规格
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月26日
	 */
	public List<ProductVo> listProductBySpecifications(String productName);
	/**
	 * 查询商品数量
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public ProductVo findBpiLists(ProductVo productVo);
	/**
	 * 根据商品类型查商品
	 * @param product
	 * @return
	 */
	public List<T_product>findBpproduc(T_product_type product);
	/**
	 * 根据专区id查询商品
	 * @param zone
	 * @return
	 */
	public List<T_product>findBpproducbyZone(Zone zone);
	/**
	 * 根据状态分页查询上架商品
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<ProductVo> pageOfProductState(@Param("page")Integer page, @Param("limit")Integer limit);
	/**
	 * 查询上架商品总数
	 * @return
	 */
	public Integer selectCountByState();
	
}
