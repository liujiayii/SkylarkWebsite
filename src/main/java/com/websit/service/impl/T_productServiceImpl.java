package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_product;
import com.websit.entity.T_product_type;
import com.websit.entity.Zone;
import com.websit.entityvo.ProductDetails;
import com.websit.entityvo.ProductSpecificationsVo;
import com.websit.entityvo.ProductTypeVo;
import com.websit.entityvo.ProductVo;
import com.websit.mapper.T_productMapper;
import com.websit.service.IT_productService;
import com.websit.until.JsonUtil;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_productServiceImpl extends ServiceImpl<T_productMapper, T_product> implements IT_productService {

	@Autowired
	private T_productMapper productMapper;
	
	/**
	 * @description 根据类型id查询当前商品种类及每个种类下所有商品
	 * @param shopId
	 * @return 商品种类及每个商品种类下所有商品
	 * @author chenshuxian
	 * @createDate 2019年3月21日
	 */
	@Override
	public String listProductByTypeId(Long productTypeId,Integer page,Integer limit) {
		List<ProductTypeVo> result = null;
		Integer count  = null;
	Integer	star = (page - 1) * limit;
		try {
			 result = productMapper.listProductByTypeId(productTypeId,star,limit);
			System.out.println(result);
			 count =   productMapper.findBpiList(productTypeId);
			 System.out.println("count"+count);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		    return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, count, result);
	}
	/**
	 * @description 查询商品
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	@Override
	public List<ProductVo> listAllProductById(ProductVo productVo) {
	
		return productMapper.listAllProductById(productVo);
	}
	/**
	 * 增加商品
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public int saveProduct(ProductVo productVo) {
		
		return productMapper.saveProduct(productVo);
	}
	/**
	 * 修改商品
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public int updateProduct(ProductVo productVo) {
		
		return productMapper.updateProduct(productVo);
	}
	/**
	 * 查询商品数量
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public Integer findBpiList(Long productTypeId) {
		
		return productMapper.findBpiList(productTypeId);
	}
	/**
	 * 修改状态(上架/下架)
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public int updateProductState(ProductVo productVo) {
		
		return productMapper.updateProductState(productVo);
	}
	/**
	 * @description 根据商品id查询商品详情
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	@Override
	public List<ProductDetails> listProductByProductId(BigInteger productId) {
	
		return productMapper.listProductByProductId(productId);
	}
	/**
	 * @description 首页模糊查询
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月24日
	 */
	@Override
	public List<ProductVo> listProductByProductTypeId(String productName,Integer page,Integer limit) {
		
		return productMapper.listProductByProductTypeId(productName,page,limit);
	}
	/**
	 * @description 根据商品名称查询颜色
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月26日
	 */
	@Override
	public List<ProductVo> listProductByColor(String productName) {
		
		return productMapper.listProductByColor(productName);
	}
	/**
	 * @description 根据商品名称查询规格
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月26日
	 */
	@Override
	public List<ProductVo> listProductBySpecifications(String productName) {
	
		return productMapper.listProductBySpecifications(productName);
	}
	/**
	 * 查询商品数量
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public ProductVo findBpiLists(ProductVo productVo) {
		
		return productMapper.findBpiLists(productVo);
	}
	@Override
	public List<T_product> findBpproduc(T_product_type product) {
		
		return productMapper.findBpproduc(product);
	}
	@Override
	public List<T_product> findBpproducbyZone(Zone zone) {
		
		return productMapper.findBpproducbyZone(zone);
	}
	@Override
	public List<ProductVo> pageOfProductState(Integer page, Integer limit) {
		
		return productMapper.pageOfProductState(page,limit);
	}
	@Override
	public Integer selectCountByState() {
		
		return productMapper.selectCountByState();
	}

	/**
	 * 根据商品名称查询商品规格及选项
	 * @param productId
	 * @return
	 */
	@Override
	public List<ProductSpecificationsVo> findSpecificationsByProduct(Long productId) {
		
		return productMapper.findSpecificationsByProduct(productId);
	}

	@Override
	public List<ProductVo> listProductByCount(String productName, Integer page, Integer limit) {
	
		return productMapper.listProductByCount(productName, page, limit);
	}
	
	/**
	 * 通过大分类id查询所有二级分类下商品信息
	 */
	@Override
	public List<ProductTypeVo> listProductByClassTypeId(Long classification_id, Integer page, Integer limit) {
		
		return productMapper.listProductByClassTypeId(classification_id, page, limit);
	}
	@Override
	public Integer insertSpecificationService(T_product product) {
		// TODO Auto-generated method stub
		return productMapper.insertSpecificationService(product);
	}


}
