package com.websit.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.websit.entity.T_product;
import com.websit.entity.T_product_type;
import com.websit.entity.Zone;
import com.websit.entityvo.ProductDetails;
import com.websit.entityvo.ProductSpecificationsVo;
import com.websit.entityvo.ProductTypeVo;
import com.websit.entityvo.ProductVo;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface T_productMapper extends BaseMapper<T_product> {

	/**
	 * @description 根据类型id查询当前商品种类及每个种类下所有商品(app)
	 * @param productTypeId
	 * @return 商品种类及每个商品种类下所有商品
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	public List<ProductTypeVo> listProductByTypeId(@Param("productTypeId") Long productTypeId,
			@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 通过大分类id查询当前商品种类及每个种类下所有商品
	 *
	 * @Title: listProductByClassTypeId
	 * @description 
	 * @param classification_id
	 * @param page
	 * @param limit
	 * @return  
	 * List<ProductTypeVo>    
	 * @author lujinpeng
	 * @createDate 2019年4月17日-下午4:28:22
	 */
	public List<ProductTypeVo> listProductByClassTypeId(@Param("classification_id") Long classification_id,@Param("page") Integer page, @Param("limit") Integer limit);
	
	/**
	 * @description 查询商品
	 * @param
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	public List<ProductVo> listAllProductById(ProductVo productVo);

	/**
	 * 增加商品
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public int saveProduct(ProductVo productVo);

	/**
	 * 修改商品
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public int updateProduct(ProductVo productVo);

	/**
	 * 查询商品数量app
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public Integer findBpiList(Long productTypeId);

	/**
	 * 修改状态(上架/下架)
	 * 
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
	public List<ProductVo> listProductByProductTypeId(@Param("productName") String productName,
			@Param("page") Integer page, @Param("limit") Integer limit);

	
	public List<ProductVo> listProductByCount(@Param("productName") String productName,@Param("page")Integer page,@Param("limit")Integer limit);
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
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public ProductVo findBpiLists(ProductVo productVo);

	/**
	 * 根据商品类型查询商品
	 * 
	 * @param product
	 * @return
	 */
	public List<T_product> findBpproduc(T_product_type product);

	/**
	 * 根据专区id查商品
	 * 
	 * @param zone
	 * @return
	 */
	public List<T_product> findBpproducbyZone(Zone zone);

	/**
	 * 根据状态分页查询上架商品
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<ProductVo> pageOfProductState(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 根据上架状态查询
	 * 
	 * @return
	 */
	public Integer selectCountByState();

	public List<T_product> selectbyDESC(@Param("page") Integer page, @Param("limit") Integer limit);
	
	/**
	 * 根据商品名称查询商品规格及选项
	 * @param productId
	 * @return
	 */
	public List<ProductSpecificationsVo>findSpecificationsByProduct(@Param("productId")Long productId);
	
	public Integer insertSpecificationService(T_product product);
}
