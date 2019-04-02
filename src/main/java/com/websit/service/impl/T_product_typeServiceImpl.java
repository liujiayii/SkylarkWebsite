package com.websit.service.impl;

import com.websit.entity.Classification;
import com.websit.entity.T_product;
import com.websit.entity.T_product_type;
import com.websit.mapper.T_productMapper;
import com.websit.mapper.T_product_typeMapper;
import com.websit.service.IT_product_typeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类型表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_product_typeServiceImpl extends ServiceImpl<T_product_typeMapper, T_product_type> implements IT_product_typeService {

	@Autowired
	private  T_product_typeMapper product_typeMapper; 
	@Autowired
	private T_productMapper productMapper;
	

	
	/**
	 * 查询所有商品类型---分页
	 *
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public List<T_product_type> selectAllProductTypeList(Integer page,Integer limit) {
	
		return product_typeMapper.selectAllProductTypeList(page,limit);
	}
	
	/**
	 * 查询商品类型---不分页
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public List<T_product_type> selectproductTypeNoPage() {
	
		return product_typeMapper.selectproductTypeNoPage();
	}
	/**
	 * 增加商品类型
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int saveProductType(T_product_type productType) {
		
		return product_typeMapper.saveProductType(productType);
	}
	/**
	 * 修改商品类型
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int updateProductType(T_product_type productType) {
		
		return product_typeMapper.updateProductType(productType);
	}
	/**
	 * description   根据id删除商品类型
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int deleteProductTypeById(BigInteger id) {
	
		return product_typeMapper.deleteProductTypeById(id);
	}
	/**
	 * 查询商品分类条数
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	@Override
	public Integer findProductTypeCount(T_product_type product_type) {
	
		return product_typeMapper.findProductTypeCount(product_type);
	}

	@Override
	public List<T_product_type> selectproduct(Classification productType) {
		
		return product_typeMapper.selectproduct(productType);
	}

	@Override
	public List<T_product> selectbyDESC(Integer page, Integer limit) {
		
		return productMapper.selectbyDESC(page, limit);
	}



}
