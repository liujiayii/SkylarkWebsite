package com.websit.service.impl;

import com.websit.entity.T_product_specification;
import com.websit.mapper.T_product_specificationMapper;
import com.websit.service.IT_product_specificationService;
import com.websit.until.specificationsuntil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品详情表(pc) 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-20
 */
@Service
public class T_product_specificationServiceImpl extends ServiceImpl<T_product_specificationMapper, T_product_specification> implements IT_product_specificationService {

	
	@Autowired
	private T_product_specificationMapper specificationMapper;
	@Override
	public T_product_specification selectAllspecification(T_product_specification t) {
	
		return specificationMapper.selectAllspecification(t);
	}
	/**
	 * 查询价格、库存
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@Override
	public T_product_specification specification(String product_id, String specifications) {
		T_product_specification specification=null;
		
//		System.out.println("**********"+specifications);
		try {
		List<T_product_specification> T_product_specification=specificationMapper.selectlstspecification(product_id);
//		System.out.println(T_product_specification.size());
		
		for(int i=0;i<T_product_specification.size();i++) {
			
			boolean fig=specificationsuntil.specification(specifications, T_product_specification.get(i).getSpecificationName());
			if(fig) {
				specification=T_product_specification.get(i);
//				System.out.println("///////"+specification);
				break;
			}
		}
//		System.out.println("specification++++++++++++"+specification);
		return specification;
		} catch (Exception e) {
			return null;
		}
}
	/**
	 * description   根据id删除商品规格
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int deleteProductSpecificationById(BigInteger id) {
		
		return specificationMapper.deleteProductSpecificationById(id);
	}
	/**
	 * 修改商品规格
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int updateProductSpecification(T_product_specification product_specification) {
	
		return specificationMapper.updateProductSpecification(product_specification);
	}
}
